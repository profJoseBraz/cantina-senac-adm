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
    
     public CompletableFuture<List<Production>> getAllProduction(CertManager certManager, HttpClient httpClient) {
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
     
    public CompletableFuture<List<Production>> getProductionById(CertManager certManager, HttpClient httpClient, String id){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production", "id=" + id);

            Gson gson = new Gson();
            List<Production> production = gson.fromJson(res.toString(), new TypeToken<List<Production>>(){}.getType());

            return production;
        }).exceptionally(ex -> {
            System.err.println("Método: getProductByCategory" + ex.getMessage());
            return null;
        });
    }     
     
    public CompletableFuture<List<Production>> getProductionByCategory(CertManager certManager, HttpClient httpClient, String category){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production/products/category", "name=" + category);

            Gson gson = new Gson();
            List<Production> production = gson.fromJson(res.toString(), new TypeToken<List<Production>>(){}.getType());

            return production;
        }).exceptionally(ex -> {
            System.err.println("Método: getProductByCategory" + ex.getMessage());
            return null;
        });
    }
     
    public CompletableFuture<List<Production>> getProductionByName(CertManager certManager, HttpClient httpClient, String name){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production/products", "name=" + name);

            Gson gson = new Gson();
            List<Production> production = gson.fromJson(res.toString(), new TypeToken<List<Production>>(){}.getType());

            return production;
        }).exceptionally(ex -> {
            System.err.println("Método: getProductByName" + ex.getMessage());
            return null;
        });
    }
    
    public CompletableFuture<Boolean> postProduction(CertManager certManager, HttpClient httpClient, String body){
        CompletableFuture<Boolean> resultFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                certManager.trustAllCerts();
                boolean res = httpClient.makePostRequest(HttpClient.API_URL + "/production/add", body);
                resultFuture.complete(res);
            } catch (Exception ex) {
                System.err.println("Classe: ProductionClient | Método: postProduction: " + ex.getMessage());
                resultFuture.completeExceptionally(ex);
            }
        });

        return resultFuture;
        }

    public CompletableFuture<List<Production>> getProductionByDateIgualA(CertManager certManager, HttpClient httpClient, String date) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production", "date=" + date + "&operator==");

            Gson gson = new Gson();
            List<Production> production = gson.fromJson(res.toString(), new TypeToken<List<Production>>(){}.getType());

            return production;
        }).exceptionally(ex -> {
            System.err.println("Method: getProductionByDateMaior - " + ex.getMessage());
            return null;
        });
    }    
    
    public CompletableFuture<List<Production>> getProductionByDateMaior(CertManager certManager, HttpClient httpClient, String date) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production", "date=" + date + "&operator=>");

            Gson gson = new Gson();
            List<Production> production = gson.fromJson(res.toString(), new TypeToken<List<Production>>(){}.getType());

            return production;
        }).exceptionally(ex -> {
            System.err.println("Method: getProductionByDateMaior - " + ex.getMessage());
            return null;
        });
    }
    
    public CompletableFuture<List<Production>> getProductionByDateMenor(CertManager certManager, HttpClient httpClient, String date) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/production", "date=" + date + "&operator=<");

            Gson gson = new Gson();
            List<Production> production = gson.fromJson(res.toString(), new TypeToken<List<Production>>(){}.getType());

            return production;
        }).exceptionally(ex -> {
            System.err.println("Method: getProductionByDateMenor - " + ex.getMessage());
            return null;
        });
    }    
    
}
