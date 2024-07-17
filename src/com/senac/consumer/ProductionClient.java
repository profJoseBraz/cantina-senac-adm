/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Production;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author grander.3993
 */
public class ProductionClient {
    
     public CompletableFuture<List<Production>> getAllProductions(CertManager certManager, HttpClient httpClient) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production", "");

            Gson gson = new Gson();
            List<Production> Production = gson.fromJson(res.toString(), new TypeToken<List<Production>>() {}.getType());

            return Production;
        }).exceptionally(ex -> {
            System.err.println("Error in Production method: " + ex.getMessage());
            return null; // Handle error gracefully
        });
    }
     
      public CompletableFuture<List<Production>> getProductionsByName(CertManager certManager, HttpClient httpClient, String name){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production", "name=" + name);

            Gson gson = new Gson();
            List<Production> production = gson.fromJson(res.toString(), new TypeToken<List<Production>>(){}.getType());

            return production;
        }).exceptionally(ex -> {
            System.err.println("Método: getProductByName" + ex.getMessage());
            return null;
        });
    }
}
