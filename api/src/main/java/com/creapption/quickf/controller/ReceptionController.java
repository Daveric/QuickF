package com.creapption.quickf.controller;

import com.creapption.quickf.pojo.Factura;
import com.creapption.quickf.util.Common;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReceptionController {

    @PostMapping("/reception")
    public ResponseEntity<String> receptionDocuments(@RequestBody Factura bill) {
        Common.convertClassToXML(bill);
        return new ResponseEntity<>("Received", HttpStatus.OK);
    }
}
