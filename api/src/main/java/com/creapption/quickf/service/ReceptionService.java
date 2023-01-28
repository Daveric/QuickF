package com.creapption.quickf.service;

import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.util.Common;
import com.creapption.quickf.util.OSValidator;
import com.creapption.quickf.util.UniqueAccessKey;
import com.creapption.quickf.util.XadesSignDoc;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("receptionService")
public class ReceptionService {
    private static String pathToFilePlaceholder = OSValidator.isWindows()?"%sapi%ssrc%smain%sresources%s":"%ssrc%smain%sresources%s";
    private static String path = String.format("%s%s", Paths.get("").toAbsolutePath(),
            String.format(pathToFilePlaceholder, File.separator,
                    File.separator, File.separator,
                    File.separator, File.separator));

    @Value("${BILL_ENVIROMENT_TYPE}")
    private String billEnviromentType;

    @Value("${SIGNFILENAME}")
    private String signFileName;

    /**
     * Sending Bill to Reception
     */
    public String sendBillToReception(Factura bill, String password) {
        // calculating Unique access key from bill
        var accessKey = new UniqueAccessKey(bill);
        accessKey.setIssueType(billEnviromentType);
        String uniqueAccessKey = accessKey.generateKey();

        // setting the unique access key to the bill itself
        bill.getInfoTributaria().setClaveAcceso(uniqueAccessKey);

        // convert bill to xml
        var xmlFileToSign = Common.convertClassToXML(bill);

        //initiliaze the signer XadesSignDoc
        var xadesBes = new XadesSignDoc(path + signFileName, password, xmlFileToSign);
        try {
            // sign the xml and save into a file
            // xadesBes.signBes(path + "document.xml");
            String fileSigned = xadesBes.signBes(path + "document1.xml");
            System.out.println("fileSigned:" + fileSigned);

            return "Document signed and saved!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
