package com.creapption.controller;

import com.creapption.model.Response;
import com.creapption.pojo.Factura;
import com.creapption.service.ReceptionService;
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
        return new ResponseEntity<>(response, response.codeStatus);
    }
}
