package com.creapption.quickf.controller;

import com.creapption.model.Response;
import com.creapption.model.RegistrationModel;
import com.creapption.quickf.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/register/business")
    public ResponseEntity<Response> registerBusiness(@RequestBody RegistrationModel registrationModel){
        var response = registrationService.registerBusiness(registrationModel);
        return new ResponseEntity<>(response, response.codeStatus);
    }
}
