package com.creapption.quickf.service;

import com.creapption.quickf.model.Response;
import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.sri.RecepcionComprobantesOfflineService;
import com.creapption.quickf.util.Common;
import com.creapption.quickf.util.Constants;
import com.creapption.quickf.util.OSValidator;
import com.creapption.quickf.util.UniqueAccessKey;
import com.creapption.quickf.xades.XadesDocumentSigner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;

@Service("receptionService")
public class ReceptionService {
    private static final String pathToFilePlaceholder = OSValidator.isWindows()?"%sapi%ssrc%smain%sresources%s":"%ssrc%smain%sresources%s";
    private static final String path = String.format("%s%s", Paths.get("").toAbsolutePath(),
            String.format(pathToFilePlaceholder, File.separator,
                    File.separator, File.separator,
                    File.separator, File.separator));

    @Value("${BILL_ENVIRONMENT_TYPE}")
    private String billEnvironmentType;

    @Value("${SIGNATURE_FILENAME}")
    private String signatureFileName;

    @Value("${KEY_STORE_PASSWORD}")
    private String keyStorePassword;

    /**
     * Sending Bill to Reception
     */
    public Response sendBillToReception(Factura bill) {
        // calculating Unique access key from bill
        var accessKey = new UniqueAccessKey(bill);
        accessKey.setIssueType(billEnvironmentType);
        String uniqueAccessKey = accessKey.generateKey();

        // setting the unique access key to the bill itself
        bill.getInfoTributaria().setClaveAcceso(uniqueAccessKey);

        // convert bill to xml
        var xmlFileToSign = Common.convertClassToXML(bill);
        var keyStorePath = path + signatureFileName;

        //initialize the signer XAdESSignDoc
        var xAdESBes = new XadesDocumentSigner(keyStorePath, keyStorePassword, xmlFileToSign);
        // sign the xml and save into a file
        var signedDocument = xAdESBes.signBes(path);
        System.out.println("Document Signed!, check path:" + signedDocument);

        var xmlBinaryToSend = Common.filePathToByteArray(signedDocument);

        //SRI service
        try {
            var service = new RecepcionComprobantesOfflineService();
            var port = service.getRecepcionComprobantesOfflinePort();
            var respuestaSolicitud = port.validarComprobante(xmlBinaryToSend);
            return new Response(respuestaSolicitud.getEstado());
        }
        catch (Exception ex){
            return new Response(Constants.SRI_RECEPTION_ERROR);
        }
    }

    /**
     * Gets the authorization response from the backend service from SRI
     * @return String
     */
    private String getAuthorization(String accessKey){
        return "";
    }

}
