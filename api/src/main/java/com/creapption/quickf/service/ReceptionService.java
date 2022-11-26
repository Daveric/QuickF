package com.creapption.quickf.service;

import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.util.Common;
import com.creapption.quickf.util.Environment;
import com.creapption.quickf.util.UniqueAccessKey;
import com.creapption.quickf.util.XadesSignDoc;
import org.springframework.stereotype.Service;

@Service("receptionService")
public class ReceptionService {

    public String sendBillToReception(Factura bill) {
        try {
            String uniqueAccessKey = getUniqueAccessKey(bill);
            bill.getInfoTributaria().setClaveAcceso(uniqueAccessKey);
            var xmlFile = Common.convertClassToXML(bill);
            XadesSignDoc.signBes(xmlFile);
            return "received";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private String getUniqueAccessKey(Factura bill) throws Exception {
        try {
            var accessKey = new UniqueAccessKey();
            String issueDate = bill.getInfoFactura().getFechaEmision().replace("/","");

            accessKey.setIssueDate(issueDate);
            accessKey.setBillingType(bill.getInfoTributaria().getCodDoc());
            accessKey.setRuc(bill.getInfoTributaria().getRuc());
            accessKey.setEnviromentType(bill.getInfoTributaria().getAmbiente());
            accessKey.setSerie(bill.getInfoTributaria().getEstab() + bill.getInfoTributaria().getPtoEmi());
            accessKey.setBillingSequential(bill.getInfoTributaria().getSecuencial());
            accessKey.setIssueType(Environment.TYPE_ENVIRONMENT);
            return accessKey.generateKey();
        } catch (Exception e) {
            System.out.println("getUniqueAccessKey:" + e.getMessage());
            throw e;
        }
    }

}
