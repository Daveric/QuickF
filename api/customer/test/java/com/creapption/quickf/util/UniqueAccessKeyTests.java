package com.creapption.quickf.util;

import com.creapption.quickf.pojo.Factura;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
public class UniqueAccessKeyTests {
    private static final String resources = OSValidator.isWindows()?"%sapi%ssrc%smain%sresources%s":"%ssrc%smain%sresources%s";
    private Factura factura;
    @Test
    void givenDigits_whenGetAccessKey_thenReturnCorrectLength(){
        mapBill();
        var accessKey = new UniqueAccessKey(this.factura);
        accessKey.setIssueType("1");
        var key = accessKey.generateKey();
        var digitsLength = key.length();
        var expectedDigitsLength = 49;
        //checking the result length keyAccess
        assertEquals(String.format("The access key length for %s", key), expectedDigitsLength, digitsLength);
    }

    private String readJsonBill(){
        var billTestingPath = String.format("%s%s", Paths.get("").toAbsolutePath(),
            String.format(resources, File.separator,
                    File.separator, File.separator,
                    File.separator, File.separator));
        try {
            var path = Path.of(billTestingPath + "bill_testing.json");
            return Files.readString(path);
        }
        catch (Exception ex){
            System.err.println("There was an error reading bill_testing.json");
            ex.printStackTrace();
            return "";
        }
    }

    @Test
    void mapBill(){
        String bill = readJsonBill();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
             this.factura = objectMapper.readValue(bill, Factura.class);
        }
        catch (Exception ex){
            System.err.println("There was an error mapping the Factura class from .json");
            ex.printStackTrace();
            this.factura = null;
        }
        assertNotNull("The bill object is null", this.factura);
    }
}
