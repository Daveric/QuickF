package com.creapption.quickf.xades;

import com.creapption.quickf.xades.keyStore.PassStoreKS;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.FirmaXML;
import es.mityc.javasign.pkstore.CertStoreException;
import es.mityc.javasign.pkstore.IPKStoreManager;
import es.mityc.javasign.pkstore.keystore.KSStore;
import org.w3c.dom.Document;

import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

public abstract class GenericXMLSignature {
    public static String PKCS12_RESOURCE;
    public static String PKCS12_PASSWORD;

    protected abstract DataToSign createDataToSign();

    public GenericXMLSignature(String pkcs12, String pkcs12_password) {
        //direct use
        PKCS12_RESOURCE = pkcs12;
        PKCS12_PASSWORD = pkcs12_password;
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
                } catch (CertStoreException ex) {
                    System.err.println("Error al acceder al almacén.");
                    ex.printStackTrace();
                    return null;
                }

                Provider provider = storeManager.getProvider(certificate);
                DataToSign dataToSign = createDataToSign();
                FirmaXML firma = new FirmaXML();
                try {
                    Object[] res = firma.signFile(certificate, dataToSign, privateKey, provider);
                    return (Document) res[0];
                } catch (Exception ex) {
                    System.err.println("Error realizando la firma");
                    ex.printStackTrace();
                    return null;
                }
            }
        }
    }

    private IPKStoreManager getPKStoreManager() {
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            File pkcs12File = new File(PKCS12_RESOURCE);
            InputStream fis = new FileInputStream(pkcs12File);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ks.load(bis, PKCS12_PASSWORD.toCharArray());
            return new KSStore(ks, new PassStoreKS(PKCS12_PASSWORD));
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException ex) {
            System.err.println("No se puede generar KeyStore PKCS12");
            ex.printStackTrace();
        }

        return null;
    }

    private X509Certificate getFirstCertificate(IPKStoreManager storeManager) {
        List<X509Certificate> certs = null;

        try {
            certs = storeManager.getSignCertificates();
        } catch (CertStoreException ex) {
            System.err.println("Fallo obteniendo listado de certificados");
            ex.printStackTrace();
        }

        if (certs == null || certs.size() == 0) {
            System.err.println("Lista de certificados vacía");
        }

        X509Certificate cert = null;
        try {
            Iterator<X509Certificate> i$ = certs.iterator();
            do {
                if (!i$.hasNext()) {
                    return certs.get(0);
                }

                cert = i$.next();
            } while (!cert.getKeyUsage()[0]);
        } catch (Exception ex) {
            System.err.println("Error al leer certificado");
            ex.printStackTrace();
        }

        return cert;
    }
}
