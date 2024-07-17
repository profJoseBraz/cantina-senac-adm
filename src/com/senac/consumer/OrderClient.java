/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Order;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author 10156
 */
public class OrderClient {
         public CompletableFuture<List<Order>> getAllOrder(CertManager certManager, HttpClient httpClient) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orders", "");

            Gson gson = new Gson();
            List<Order> Order = gson.fromJson(res.toString(), new TypeToken<List<Order>>() {}.getType());

            return Order;
        }).exceptionally(ex -> {
            System.err.println("Error in Order method: " + ex.getMessage());
            return null; // Handle error gracefully
        });
    } 
}
