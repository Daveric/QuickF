package com.creapption.quickf.xades;

import com.creapption.quickf.xades.keyStore.PassStoreKS;
import es.mityc.firmaJava.libreria.utilidades.UtilidadTratarNodo;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.FirmaXML;
import es.mityc.javasign.pkstore.CertStoreException;
import es.mityc.javasign.pkstore.IPKStoreManager;
import es.mityc.javasign.pkstore.keystore.KSStore;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericXMLSignature {
    public static String PKCS12_RESOURCE = "/LOAYZA_BRAYAN.p12";
    public static String PKCS12_PASSWORD = "Loayzaq2022*";
    public static final String OUTPUT_DIRECTORY = ".";

    public GenericXMLSignature(String pkcs12, String pkcs12_password) {
        byte[] decoded_firma = Base64.decodeBase64(pkcs12.getBytes());
        String decodedString_firma = new String(decoded_firma);
        InputStream arch = null;

        try {
            arch = new FileInputStream(decodedString_firma);
        } catch (FileNotFoundException var8) {
            Logger.getLogger(com.creapption.quickf.xades.GenericXMLSignature.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        byte[] decoded = Base64.decodeBase64(pkcs12_password.getBytes());
        String decodedString = new String(decoded);
        //PKCS12_RESOURCE = arch;
        PKCS12_PASSWORD = decodedString;
    }

    public GenericXMLSignature(String key) {
        InputStream arch = null;
        try{
            arch = new FileInputStream(key);
        } catch(FileNotFoundException ex){
            Logger.getLogger(com.creapption.quickf.xades.GenericXMLSignature.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
        //PKCS12_RESOURCE = arch;
    }

    protected Document execute() {
        IPKStoreManager storeManager = this.getPKStoreManager();
        if (storeManager == null) {
            System.err.println("El gestor de claves no se ha obtenido correctamente.");
            return null;
        } else {
            X509Certificate certificate = this.getFirstCertificate(storeManager);
            if (certificate == null) {
                System.err.println("No existe ningún certificado para firmar.");
                return null;
            } else {
                PrivateKey privateKey;
                try {
                    privateKey = storeManager.getPrivateKey(certificate);
                } catch (CertStoreException var10) {
                    System.err.println("Error al acceder al almacén.");
                    return null;
                }

                Provider provider = storeManager.getProvider(certificate);
                DataToSign dataToSign = this.createDataToSign();
                FirmaXML firma = new FirmaXML();
                try {
                    Object[] res = firma.signFile(certificate, dataToSign, privateKey, provider);
                    return (Document)res[0];
                } catch (Exception var9) {
                    System.err.println("Error realizando la firma");
                    var9.printStackTrace();
                    return null;
                }
            }
        }
    }

    protected abstract DataToSign createDataToSign();

    protected abstract String getSignatureFileName();

    private void saveDocumentToFile(Document document, String pathfile) {
        try {
            FileOutputStream fos = new FileOutputStream(pathfile);
            UtilidadTratarNodo.saveDocumentToOutputStream(document, fos, true);
        } catch (FileNotFoundException var4) {
            System.err.println("Error al guardar el documento");
            var4.printStackTrace();
            System.exit(-1);
        }

    }

    private void saveDocumentToFileUnsafeMode(Document document, String pathfile) {
        TransformerFactory tfactory = TransformerFactory.newInstance();

        try {
            Transformer serializer = tfactory.newTransformer();
            serializer.transform(new DOMSource(document), new StreamResult(new File(pathfile)));
        } catch (TransformerException var5) {
            System.err.println("Error al guardar el documento");
            var5.printStackTrace();
            System.exit(-1);
        }

    }

    protected Document getDocument(String resource) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        try {
            doc = dbf.newDocumentBuilder().parse(this.getClass().getResourceAsStream(resource));
        } catch (ParserConfigurationException var5) {
            System.err.println("Error al parsear el documento");
            var5.printStackTrace();
            System.exit(-1);
        } catch (SAXException var6) {
            System.err.println("Error al parsear el documento");
            var6.printStackTrace();
            System.exit(-1);
        } catch (IOException var7) {
            System.err.println("Error al parsear el documento");
            var7.printStackTrace();
            System.exit(-1);
        } catch (IllegalArgumentException var8) {
            System.err.println("Error al parsear el documento");
            var8.printStackTrace();
            System.exit(-1);
        }

        return doc;
    }

    protected String getDocumentAsString(String resource) {
        Document doc = this.getDocument(resource);
        TransformerFactory tfactory = TransformerFactory.newInstance();
        StringWriter stringWriter = new StringWriter();

        try {
            Transformer serializer = tfactory.newTransformer();
            serializer.transform(new DOMSource(doc), new StreamResult(stringWriter));
        } catch (TransformerException var6) {
            System.err.println("Error al imprimir el documento");
            var6.printStackTrace();
            System.exit(-1);
        }

        return stringWriter.toString();
    }

    private IPKStoreManager getPKStoreManager() {
        IPKStoreManager storeManager = null;

        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(this.getClass().getResourceAsStream(PKCS12_RESOURCE), PKCS12_PASSWORD.toCharArray());
            storeManager = new KSStore(ks, new PassStoreKS(PKCS12_PASSWORD));
        } catch (KeyStoreException var3) {
            System.err.println("No se puede generar KeyStore PKCS12");
            var3.printStackTrace();
            System.exit(-1);
        } catch (NoSuchAlgorithmException var4) {
            System.err.println("No se puede generar KeyStore PKCS12");
            var4.printStackTrace();
            System.exit(-1);
        } catch (CertificateException var5) {
            System.err.println("No se puede generar KeyStore PKCS12");
            var5.printStackTrace();
            System.exit(-1);
        } catch (IOException var6) {
            System.err.println("No se puede generar KeyStore PKCS12");
            var6.printStackTrace();
            System.exit(-1);
        }

        return storeManager;
    }

    private X509Certificate getFirstCertificate(IPKStoreManager storeManager) {
        List<X509Certificate> certs = null;

        try {
            certs = storeManager.getSignCertificates();
        } catch (CertStoreException var5) {
            System.err.println("Fallo obteniendo listado de certificados");
            System.exit(-1);
        }

        if (certs == null || certs.size() == 0) {
            System.err.println("Lista de certificados vacía");
            System.exit(-1);
        }

        Iterator i$ = certs.iterator();

        X509Certificate cert;
        do {
            if (!i$.hasNext()) {
                X509Certificate certificate = (X509Certificate)certs.get(0);
                return certificate;
            }

            cert = (X509Certificate)i$.next();
        } while(!cert.getKeyUsage()[0]);

        return cert;
    }
}
