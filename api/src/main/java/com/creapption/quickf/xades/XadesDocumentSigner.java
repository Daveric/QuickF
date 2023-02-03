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

    private final String ERROR_DOC_PARSE= "Error al parsear el documento";


    // #region Properties
    protected String xmlObject;
    protected String keyStorePath;
    protected String keyStorePassword;
    // #endregion

    /**
     * Constructor XAdESSignDoc - Signing documents with XAdES method.
     * Currently Bes method only supported
     * 
     * @param keyStorePath - path to the key
     * @param keyStorePassword - password to the key
     * @param xmlObjectToSign - xmlObject in memmory to sign
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
     * @throws Exception ex
     */
    public String signBes(String outputPath) throws Exception {
        Document doc = getDocument();

        //sign the xml
        var signedDocumentPath = outputPath +"signedDocument.xml";
        var signature = new XadesBesSignature(doc, keyStorePath, keyStorePassword);
        var result = signature.execute();

        //create outputFile
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
        } catch (ParserConfigurationException | SAXException | IOException | IllegalArgumentException ex) {
            System.err.println(ERROR_DOC_PARSE);
            ex.printStackTrace();
        }
        return doc;
    }

    /**
     * Generates an output xml file with a specific pathFileName
     * 
     * @param doc Document
     * @param pathFileName String
     * @throws Exception any
     */
    protected static void saveDocumentToFile(Document doc, String pathFileName) throws Exception {
        try (FileOutputStream out = new FileOutputStream(pathFileName)) {
            TransformerFactory tf = TransformerFactory.newInstance();
            tf.newTransformer().transform(
                    new DOMSource(doc),
                    new StreamResult(out));
        }
    }

    /**
     * Transforms a file to Base64Binary
     * @param filePath String
     * @throws Exception ex
     */
    public static String transformFileToByte(String filePath) throws Exception {
        var fileContent = Files.readAllBytes(Path.of(filePath));
        return DatatypeConverter.printBase64Binary(fileContent);
    }
}
