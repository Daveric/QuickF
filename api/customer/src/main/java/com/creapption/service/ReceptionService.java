package com.creapption.service;

import com.creapption.model.Response;
import com.creapption.pojo.Factura;
import com.creapption.sri.reception.RecepcionComprobantesOfflineService;
import com.creapption.util.Common;
import com.creapption.util.Constants;
import com.creapption.util.UniqueAccessKey;
import com.creapption.xades.XadesDocumentSigner;
import com.creapption.xades.validation.XMLValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Paths;

@Service("receptionService")
public class ReceptionService {
    private static final String schemas = "%scustomer%ssrc%smain%sschema%s";
    private static final String resources = "%scustomer%ssrc%smain%sresources%s";

    @Value("${BILL_ENVIRONMENT_TYPE}")
    private String billEnvironmentType;

    @Value("${SIGNATURE_FILENAME}")
    private String signatureFileName;

    @Value("${KEY_STORE_PASSWORD}")
    private String keyStorePassword;

    /**
     * Sending Bill to Reception
     * @return Response
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
            var message = String.format("State for: %s is %s", uniqueAccessKey, respuestaSolicitud.getEstado());
            return new Response(message, "", HttpStatus.OK);
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
