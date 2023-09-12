package com.creapption.quickf.database;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.sql.models.*;

public class DataBaseManagement {
    private final String ruc;
    private final String resourceGroup;
    private final AzureResourceManager azureResourceManager;
    private final String dbServerName;

    public DataBaseManagement(String ruc, String resourceGroup, String dbServerName){
        this.ruc = ruc;
        this.resourceGroup = resourceGroup;
        this.dbServerName = dbServerName;

        final AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE);
        final TokenCredential credential = new DefaultAzureCredentialBuilder()
                .authorityHost(profile.getEnvironment().getActiveDirectoryEndpoint())
                .build();

        this.azureResourceManager = AzureResourceManager
                .configure()
                .withLogLevel(HttpLogDetailLevel.BASIC)
                .authenticate(credential, profile)
                .withDefaultSubscription();
    }

    public String createBusinessDB(){
        var dbName = String.format("%s-db", ruc);
        try {
            SqlServer sqlServer = azureResourceManager.sqlServers().getByResourceGroup(resourceGroup, dbServerName);
            sqlServer.databases().define(dbName).withSku(DatabaseSku.FREE_FREE).create();
            // 1. set application properties
            // 2. Hibernate run their process
            return dbName + " successfully created!";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return dbName + " failed to create!";
        }
    }

}
