package com.creapption.quickf.xades;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class XAdESDocumentSigner {
    // #region Properties
    protected static String xmlObject;
    protected static String keyStorePath;
    protected static String password;

    // #endregion

    /**
     * Constructor XAdESSignDoc - Signing documents with XAdES method.
     * Currently Bes method only supported
     * 
     * @param signaturePath
     * @param signaturePassword
     * @param xmlObjectToSign
     */
    public XAdESDocumentSigner(String signaturePath, String signaturePassword, String xmlObjectToSign) {
        super();
        xmlObject = xmlObjectToSign;
        keyStorePath = signaturePath;
        password = signaturePassword;
    }

    /**
     * Sign xml documents with XAdESBes method
     * 
     * @throws Exception
     */
    public String signBes(String outputPath) throws Exception {
        // Transforming the xml object string into xmlFile
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlObject));
        Document doc = builder.parse(is);
        // generates the xml
        var documentToSign = outputPath + "documentToSign.xml";
        outputDocument(doc, documentToSign);

        //sign the xml
        var signedDocument = outputPath +"signedDocument.xml";
        var signature = new XAdESBESSignature(documentToSign, keyStorePath, password);
        var result = signature.execute();

        //create outputFile
        outputDocument(result, signedDocument);
        return signedDocument;
    }

    /**
     * Generates an output xml file with a specific pathFileName
     * 
     * @param doc
     * @param pathFileName
     * @throws Exception
     */
    protected static void outputDocument(Document doc, String pathFileName) throws Exception {
        FileOutputStream out = new FileOutputStream(pathFileName);
        try {
            outputDOM(doc, out);
        } finally {
            out.close();
        }
    }

    /**
     * Executes the transformer from doc to OutputStream
     * 
     * @param dom
     * @param os
     * @throws Exception
     */
    protected static void outputDOM(Node dom, OutputStream os) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        tf.newTransformer().transform(
                new DOMSource(dom),
                new StreamResult(os));
    }

    /**
     * Transforms a file to Base64Binary
     * @param filePath
     * @throws Exception
     */
    public static String transformFileToByte(String filePath) throws Exception {
        var fileContent = Files.readAllBytes(Path.of(filePath));
        return DatatypeConverter.printBase64Binary(fileContent);
    }
}
