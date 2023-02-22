package com.creapption.quickf.xades.validation;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XMLValidator {

    /**
     * Validates the Xml file
     * @param pathXMLFile String
     * @param pathXSDFile String
     * @param isXMLInMemory boolean
     * @throws IOException Exception
     */
    public static void validate(String pathXMLFile, String pathXSDFile, boolean isXMLInMemory) throws IOException {
        Source xmlFile;
        if (isXMLInMemory){
            var reader = new StringReader(pathXMLFile);
            xmlFile = new StreamSource(reader);
            xmlFile.setSystemId("bill currently in memory");
        }
        else {
            xmlFile = new StreamSource(new File(pathXMLFile));
        }
        File schemaLocation = new File(pathXSDFile);
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " es valido!");
        } catch (SAXParseException ex) {
            System.out.println(xmlFile.getSystemId() + " NO es válido!");
            System.out.println("Razón\t\t: " + ex.getLocalizedMessage());
            System.out.println("Número de linea \t: " + ex.getLineNumber());
            System.out.println("Número de columna\t: " + ex.getColumnNumber());
            System.out.println("Id Público\t: " + ex.getPublicId());
        } catch (SAXException ex) {
            System.out.println(xmlFile.getSystemId() + " NO es válido");
            System.out.println("Razón\t: " + ex.getLocalizedMessage());
        }

    }
}
