package com.creapption.quickf.sri.authorization;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.4.4
 * Generated source version: 3.4.4
 *
 */
@WebServiceClient(name = "AutorizacionComprobantesOfflineService",
                  wsdlLocation = "wsdl/AuthorizationWebServiceTest.wsdl",
                  targetNamespace = "http://ec.gob.sri.ws.autorizacion")
public class AutorizacionComprobantesOfflineService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflineService");
    public final static QName AutorizacionComprobantesOfflinePort = new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflinePort");
    static {
        URL url = AutorizacionComprobantesOfflineService.class.getResource("wsdl/AuthorizationWebServiceTest.wsdl");
        if (url == null) {
            url = AutorizacionComprobantesOfflineService.class.getClassLoader().getResource("wsdl/AuthorizationWebServiceTest.wsdl");
        }
        if (url == null) {
            java.util.logging.Logger.getLogger(AutorizacionComprobantesOfflineService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "wsdl/AuthorizationWebServiceTest.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AutorizacionComprobantesOfflineService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AutorizacionComprobantesOfflineService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AutorizacionComprobantesOfflineService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public AutorizacionComprobantesOfflineService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public AutorizacionComprobantesOfflineService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public AutorizacionComprobantesOfflineService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns AutorizacionComprobantesOffline
     */
    @WebEndpoint(name = "AutorizacionComprobantesOfflinePort")
    public AutorizacionComprobantesOffline getAutorizacionComprobantesOfflinePort() {
        return super.getPort(AutorizacionComprobantesOfflinePort, AutorizacionComprobantesOffline.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AutorizacionComprobantesOffline
     */
    @WebEndpoint(name = "AutorizacionComprobantesOfflinePort")
    public AutorizacionComprobantesOffline getAutorizacionComprobantesOfflinePort(WebServiceFeature... features) {
        return super.getPort(AutorizacionComprobantesOfflinePort, AutorizacionComprobantesOffline.class, features);
    }

}
