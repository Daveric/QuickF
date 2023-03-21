package com.creapption.quickf.controller;

import com.creapption.quickf.model.Response;
import com.creapption.quickf.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping("/authorization/{id}")
    public ResponseEntity<Response> getBillAuthorization(@PathVariable String id){
        var response = authorizationService.getBillAuthorization(id);
        return new ResponseEntity<>(response, response.codeStatus);
    }
}
