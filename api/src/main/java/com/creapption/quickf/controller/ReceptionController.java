package com.creapption.quickf.controller;

import com.creapption.quickf.model.Response;
import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceptionController {
    @Autowired
    private ReceptionService receptionService;

    @PostMapping("/reception")
    public ResponseEntity<Response> sendToReception(@RequestBody Factura bill) {
        var response = receptionService.sendBillToReception(bill);
        return new ResponseEntity<>(response, response.getCodeStatus());
    }
}
