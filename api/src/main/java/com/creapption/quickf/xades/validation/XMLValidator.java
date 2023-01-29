package com.creapption.quickf.xades.validation;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {

    public static void validate(String pathXMLFile, String pathXSDFile) throws IOException {
        Source xmlFile = new StreamSource(new File(pathXMLFile));
        File schemaLocation = new File(pathXSDFile);
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " es valido!");
        } catch (SAXParseException var8) {
            System.out.println(xmlFile.getSystemId() + " NO es válido!");
            System.out.println("Razón\t\t: " + var8.getLocalizedMessage());
            System.out.println("Número de linea \t: " + var8.getLineNumber());
            System.out.println("Número de columna\t: " + var8.getColumnNumber());
            System.out.println("Id Público\t: " + var8.getPublicId());
        } catch (SAXException var9) {
            System.out.println(xmlFile.getSystemId() + " NO es válido");
            System.out.println("Razón\t: " + var9.getLocalizedMessage());
        }

    }
}
