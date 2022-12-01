package com.creapption.quickf.controller;

import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceptionController {

    @Autowired
    ReceptionService receptionService;

    @PostMapping("/reception")
    public ResponseEntity<String> receptionDocuments(@RequestBody Factura bill) {
        var response = receptionService.sendBillToReception(bill);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
