package com.creapption.quickf.util;

import com.creapption.quickf.pojo.Factura;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Define common methods.
 */
public class Common {

    static final int weightedCheckFactor = 2;
    static final int maxWeightedCheckFactor = 7;
    static final int module11 = 11; // the number for the module digit calculation

    /**
     * Converts a java class to XML
     * @param bill Factura class
     * @return String
     */
    public static String convertClassToXML(Factura bill) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(bill, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println(xmlContent);
            return xmlContent;

        } catch (JAXBException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * Retrieve the module 11 digit calculated from the giving digits as string
     * @param digits String
     * @return int
     */
    public static int getModule11(String digits){
        int sum = 0;
        int factor = weightedCheckFactor;
        var key = digits.toCharArray();
        // we start the calculation from the end
        for (var i = key.length - 1; i > -1; i--) {
            var c = key[i];
            sum = sum + Integer.parseInt(String.valueOf(c)) * factor;
            // the limit value is 7 according to spec
            factor = (factor == maxWeightedCheckFactor) ? weightedCheckFactor : factor + 1;
        }
        var result = module11 - (sum % module11);
        // we calculate a different digit result for 11 and 10
        if (result == 11) {
            return 0;
        } else if (result == 10) {
            return 1;
        }
        return result;
    }

    /**
     * Transform the Date into a simple format pattern
     * @param date Date
     * @param pattern String
     * @return String
     */
    public static String dateFormat(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }


    /**
     * Transforms a filePath content to Base64Binary for SoapUI
     * @param filePath String
     */
    public static String filePathToBase64(String filePath) {
        var file = Path.of(filePath);
        if (Files.exists(file)) {
            try{
            var fileContent = Files.readAllBytes(file);
            return DatatypeConverter.printBase64Binary(fileContent);}
            catch (Exception e){
                System.err.println(Constants.ERROR_TRANSFORM_FILE);
                e.printStackTrace();
            }
        }
        else {
            String ERROR_FILE_DOESNT_EXIST = String.format("El archivo %s no existe", filePath);
            System.err.println(ERROR_FILE_DOESNT_EXIST);
        }
        return "";
    }

    /**
     * Transforms the filePath content into byte array
     * @param filePath String
     * @return byte[]
     */
    public static byte[] filePathToByteArray(String filePath){
        var file = Path.of(filePath);
        if (Files.exists(file)){
            try{
                return Files.readAllBytes(file);
            }
            catch (Exception e){
                System.err.println(Constants.ERROR_TRANSFORM_FILE);
                e.printStackTrace();
            }
        }
        return null;
    }
}
