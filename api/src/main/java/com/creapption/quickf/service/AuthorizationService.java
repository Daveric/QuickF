package com.creapption.quickf.service;

import com.creapption.quickf.model.Response;
import com.creapption.quickf.sri.authorization.AutorizacionComprobantesOfflineService;
import com.creapption.quickf.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("authorizationService")
public class AuthorizationService {

    /**
     * Gets whether a bill is authorized or not
     * @return Response
     */
    public Response getBillAuthorization(String accessKey){
        //SRI service
        try {
            var service = new AutorizacionComprobantesOfflineService();
            service.getAutorizacionComprobantesOfflinePort();
            var port = service.getAutorizacionComprobantesOfflinePort();
            var respuestaComprobante = port.autorizacionComprobante(accessKey);
            if (Integer.parseInt(respuestaComprobante.getNumeroComprobantes()) > 0) {
                var billState = respuestaComprobante.getAutorizaciones().getAutorizacion().get(0).getEstado();
                return new Response(billState, "", HttpStatus.OK);
            }
            return new Response(Constants.SRI_EMPTY_AUTHORIZATIONS, HttpStatus.NOT_FOUND);
        }

        catch (Exception ex) {
            ex.printStackTrace();
            return new Response(Constants.SRI_GENERIC_AUTHORIZATION_ERROR, ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
