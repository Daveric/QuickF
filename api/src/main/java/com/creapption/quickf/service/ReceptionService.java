package com.creapption.quickf.service;

import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.util.Common;
import com.creapption.quickf.util.OSValidator;
import com.creapption.quickf.util.UniqueAccessKey;
import com.creapption.quickf.xades.XAdESDocumentSigner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;

@Service("receptionService")
public class ReceptionService {
    private static String pathToFilePlaceholder = OSValidator.isWindows()?"%sapi%ssrc%smain%sresources%s":"%ssrc%smain%sresources%s";
    private static String path = String.format("%s%s", Paths.get("").toAbsolutePath(),
            String.format(pathToFilePlaceholder, File.separator,
                    File.separator, File.separator,
                    File.separator, File.separator));

    @Value("${BILL-ENVIRONMENT-TYPE}")
    private String billEnviromentType;

    @Value("${SIGNATURE-FILENAME}")
    private String signatureFileName;

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

        //initialize the signer XAdESSignDoc
        var xAdESBes = new XAdESDocumentSigner(path + signatureFileName, password, xmlFileToSign);
        try {
            // sign the xml and save into a file
            var signedDocument = xAdESBes.signBes(path);
            System.out.println("fileSigned:" + signedDocument);

            //transforming the file into bytes and base64
            var outputToServer = XAdESDocumentSigner.transformFileToByte(signedDocument);
            return String.format("Document signed and saved! \nBase64 for Server:%s", outputToServer);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
