package com.creapption.quickf.xades;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class XadesDocumentSigner {

    // #region Properties
    protected String xmlObject;
    protected String keyStorePath;
    protected String keyStorePassword;
    // #endregion

    /**
     * Constructor XAdESSignDoc - Signing documents with XAdES method.
     * Currently, Bes method only supported
     * 
     * @param keyStorePath - path to the key
     * @param keyStorePassword - password to the key
     * @param xmlObjectToSign - xmlObject in memory to sign
     */
    public XadesDocumentSigner(String keyStorePath, String keyStorePassword, String xmlObjectToSign) {
        super();
        xmlObject = xmlObjectToSign;
        this.keyStorePath = keyStorePath;
        this.keyStorePassword = keyStorePassword;
    }

    /**
     * Sign xml documents with XAdESBes method
     *
     */
    public String signBes(String outputPath) {
        Document doc = getDocument();

        //sign the xml
        var signedDocumentPath = outputPath +"signedDocument.xml";
        var signature = new XadesBesSignature(doc, keyStorePath, keyStorePassword);
        var result = signature.execute();

        //save
        saveDocumentToFile(result, signedDocumentPath);
        return signedDocumentPath;
    }

    /**
     * Transforming the xml object string into Document
     * @return Document
     */
    private Document getDocument() {
        Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        try {
            InputSource is = new InputSource(new StringReader(xmlObject));
            doc = factory.newDocumentBuilder().parse(is);
        } catch (ParserConfigurationException | SAXException | IOException | IllegalArgumentException e) {
            String ERROR_DOC_PARSE = "Error al parsear el documento";
            System.err.println(ERROR_DOC_PARSE);
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * Generates an output xml file with a specific pathFileName
     * 
     * @param doc Document
     * @param pathFileName String
     */
    protected static void saveDocumentToFile(Document doc, String pathFileName){
        try (FileOutputStream out = new FileOutputStream(pathFileName)) {
            TransformerFactory tf = TransformerFactory.newInstance();
            tf.newTransformer().transform(
                    new DOMSource(doc),
                    new StreamResult(out));
        }
        catch (Exception e){
            String ERROR_SAVING_DOC = "Error al guardar el documento";
            System.err.println(ERROR_SAVING_DOC);
            e.printStackTrace();
        }
    }
}
