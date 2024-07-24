/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.http.HttpClient;
import com.senac.model.OrderItems;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author 10156
 */
public class OrderItemsClient {
    public CompletableFuture<List<OrderItems>> getAllOrderItemsByOrderId(CertManager certManager, HttpClient httpClient, String id) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orderItems", "orderId=" + id);

            Gson gson = new Gson();
            List<OrderItems> orderItems = gson.fromJson(res.toString(), new TypeToken<List<OrderItems>>() {}.getType());

            return orderItems;
        }).exceptionally(ex -> {
            System.err.println("Method: getAllOrderItemsByOrderId - " + ex.getMessage());
            return null; // Handle error gracefully
        });
    }
}
