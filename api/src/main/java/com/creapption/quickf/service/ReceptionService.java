package com.creapption.quickf.service;

import com.creapption.quickf.model.Response;
import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.sri.RecepcionComprobantesOfflineService;
import com.creapption.quickf.util.Common;
import com.creapption.quickf.util.Constants;
import com.creapption.quickf.util.OSValidator;
import com.creapption.quickf.util.UniqueAccessKey;
import com.creapption.quickf.xades.XadesDocumentSigner;
import com.creapption.quickf.xades.validation.XMLValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Paths;

@Service("receptionService")
public class ReceptionService {
    private static final String schemas = OSValidator.isWindows()?"%sapi%ssrc%smain%sschema%s":"%ssrc%smain%sschema%s";
    private static final String resources = OSValidator.isWindows()?"%sapi%ssrc%smain%sresources%s":"%ssrc%smain%sresources%s";

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
        String xmlFileToSign;
        // convert bill to xml
        try {
            xmlFileToSign = Common.convertClassToXML(bill);
        }catch (Exception ex){
            ex.printStackTrace();
            return new Response(Constants.SRI_RECEPTION_ERROR, ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        //validate bill schema
        var schemaPath = getPathTo(schemas)+"factura_V2.1.0.xsd";
        try {
            XMLValidator.validate(xmlFileToSign, schemaPath, true);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new Response(Constants.SRI_RECEPTION_ERROR, ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        //initialize the signer XAdESSignDoc
        var resourcesPath = getPathTo(resources);
        var keyStorePath = resourcesPath + signatureFileName;
        var xAdESBes = new XadesDocumentSigner(keyStorePath, keyStorePassword, xmlFileToSign);

        // sign the xml and save into a file
        var signedDocument = xAdESBes.signBes(resourcesPath);
        System.out.println("Document Signed!, check path:" + signedDocument);
        var xmlBinaryToSend = Common.filePathToByteArray(signedDocument);

        //SRI service
        try {
            var service = new RecepcionComprobantesOfflineService();
            var port = service.getRecepcionComprobantesOfflinePort();
            var respuestaSolicitud = port.validarComprobante(xmlBinaryToSend);
            return new Response(respuestaSolicitud.getEstado(), "", HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new Response(Constants.SRI_RECEPTION_ERROR, ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Gets the path for the place folder string
     * @return String
     */
    private String getPathTo(String pathToFilePlaceHolder){
        return String.format("%s%s", Paths.get("").toAbsolutePath(),
                String.format(pathToFilePlaceHolder, File.separator,
                        File.separator, File.separator,
                        File.separator, File.separator));
    }

}
