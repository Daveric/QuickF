package com.creapption.quickf.service;

import com.creapption.quickf.database.DataBaseManagement;
import com.creapption.model.RegistrationModel;
import com.creapption.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("registrationService")
public class RegistrationService {

    @Value("${AZURE_RESOURCE_GROUP}")
    private String resourceGroup;

    @Value("${AZURE_DB_SERVER_NAME}")
    private String dbServerName;

    public Response registerBusiness(RegistrationModel registrationModel){
        var database= new DataBaseManagement(registrationModel.ruc, resourceGroup, dbServerName);
        var result = database.createBusinessDB();
        return new Response(result, HttpStatus.OK);
    }
}
