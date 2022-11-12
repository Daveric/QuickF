package com.creapption.quickf.util;

import com.creapption.quickf.pojo.Factura;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Define common methods.
 * */
public class Common {

    public static void convertClassToXML(Factura bill) {
        try
        {
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
            System.out.println( xmlContent );

        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
