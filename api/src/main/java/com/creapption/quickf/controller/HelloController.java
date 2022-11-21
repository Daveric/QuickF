package com.creapption.quickf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creapption.quickf.util.UniqueAccessKey;
import com.creapption.quickf.util.XadesSignDoc;

@RestController
public class HelloController {
    /**
     * 
     * @return
     */
    @RequestMapping("/")
    public String hello() {
        var result = String.format("%s   %s", TestingXadesSignDoc(), TestingUniqueAccessKey());
        return result;
    }

    /**
     * Testing Doc signning
     * 
     * @return
     */
    private String TestingXadesSignDoc() {
        var signDoc = new XadesSignDoc();
        try {
            signDoc.signBes();
            return "Success";
        } catch (Exception e) {
            return "Exception while signing";
        }
    }

    /**
     * Testing UniqueAccessKey, with this examples the result is always an exception
     * 
     * @return
     */
    private String TestingUniqueAccessKey() {
        var accessKey = new UniqueAccessKey();
        try {
            accessKey.setBillingNumber("");
            accessKey.setBillingType("1");
            accessKey.setEnviromentType("2");
            accessKey.setIssueDate("");
            accessKey.setIssueType("");
            accessKey.setRuc("");
            accessKey.setSerie("");

            return accessKey.GenerateKey();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
