/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Product;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author caetano.8918
 */
public class ProductsClient {
     public CompletableFuture<List<Product>> getAllProducts(CertManager certManager, HttpClient httpClient) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/products", "");

            Gson gson = new Gson();
            List<Product> Product = gson.fromJson(res.toString(), new TypeToken<List<Product>>() {}.getType());

            return Product;
        }).exceptionally(ex -> {
            System.err.println("Error in Product method: " + ex.getMessage());
            return null; // Handle error gracefully
        });
    }
     
      public CompletableFuture<List<Product>> getProductByName(CertManager certManager, HttpClient httpClient, String name){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/products", "name=" + name);

            Gson gson = new Gson();
            List<Product> product = gson.fromJson(res.toString(), new TypeToken<List<Product>>(){}.getType());

            return product;
        }).exceptionally(ex -> {
            System.err.println("Método: getProductByName" + ex.getMessage());
            return null;
        });
    }
      
      public CompletableFuture<List<Product>> getProductByCategory(CertManager certManager, HttpClient httpClient, String category){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/products/category", "name=" + category);

            Gson gson = new Gson();
            List<Product> product = gson.fromJson(res.toString(), new TypeToken<List<Product>>(){}.getType());

            return product;
        }).exceptionally(ex -> {
            System.err.println("Método: getProductByCategory" + ex.getMessage());
            return null;
        });
    }
}
