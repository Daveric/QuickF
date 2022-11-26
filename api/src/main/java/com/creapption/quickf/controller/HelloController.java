package com.creapption.quickf.controller;

import com.creapption.quickf.util.UniqueAccessKey;
import com.creapption.quickf.util.XadesSignDoc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
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
        try {
            XadesSignDoc.signBes("");
            return "Success";
        } catch (Exception e) {
            System.out.println("Exception:" + e);
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
            accessKey.setBillingSequential("123456789");
            accessKey.setBillingType("01");
            accessKey.setEnviromentType("1");
            accessKey.setIssueDate("11232022");
            accessKey.setIssueType("1");
            accessKey.setRuc("0704437664001");
            accessKey.setSerie("000010");

            return accessKey.generateKey();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
