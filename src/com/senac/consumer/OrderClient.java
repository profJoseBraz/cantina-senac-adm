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
import com.senac.model.Production;
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
    
    public CompletableFuture<List<Order>> getOrderById(CertManager certManager, HttpClient httpClient, String id) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orders", "id=" + id);

            Gson gson = new Gson();
            List<Order> order = gson.fromJson(res.toString(), new TypeToken<List<Order>>(){}.getType());

            return order;
        }).exceptionally(ex -> {
            System.err.println("Method: getOrderByDateMenor - " + ex.getMessage());
            return null;
        });
    }    
    
    public CompletableFuture<List<Order>> getCostumerNameOrder(CertManager certManager, HttpClient httpClient, String nameCostumer) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orders", "customerName=" + nameCostumer);

            Gson gson = new Gson();
            List<Order> Order = gson.fromJson(res.toString(), new TypeToken<List<Order>>() {}.getType());

            return Order;
        }).exceptionally(ex -> {
            System.err.println("Error in Order method: " + ex.getMessage());
            return null; // Handle error gracefully
        });
    } 
    public CompletableFuture<List<Order>> getPaymentMethod(CertManager certManager, HttpClient httpClient, String paymentMethod) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orders/paymentMethod", "name=" + paymentMethod);

            Gson gson = new Gson();
            List<Order> Order = gson.fromJson(res.toString(), new TypeToken<List<Order>>() {}.getType());

            return Order;
        }).exceptionally(ex -> {
            System.err.println("Error in Order method: " + ex.getMessage());
            return null; // Handle error gracefully
        });
    }
    
    public CompletableFuture<List<Order>> getOrderByDateIgualA(CertManager certManager, HttpClient httpClient, String date) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orders", "date=" + date + "&operator==");

            Gson gson = new Gson();
            List<Order> order = gson.fromJson(res.toString(), new TypeToken<List<Order>>(){}.getType());

            return order;
        }).exceptionally(ex -> {
            System.err.println("Method: getOrderByDateMaior - " + ex.getMessage());
            return null;
        });
    }    
    
    public CompletableFuture<List<Order>> getOrderByDateMaior(CertManager certManager, HttpClient httpClient, String date) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orders", "date=" + date + "&operator=>");

            Gson gson = new Gson();
            List<Order> order = gson.fromJson(res.toString(), new TypeToken<List<Order>>(){}.getType());

            return order;
        }).exceptionally(ex -> {
            System.err.println("Method: getOrderByDateMaior - " + ex.getMessage());
            return null;
        });
    }
    
    public CompletableFuture<List<Order>> getOrderByDateMenor(CertManager certManager, HttpClient httpClient, String date) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/orders", "date=" + date + "&operator=<");

            Gson gson = new Gson();
            List<Order> order = gson.fromJson(res.toString(), new TypeToken<List<Order>>(){}.getType());

            return order;
        }).exceptionally(ex -> {
            System.err.println("Method: getOrderByDateMenor - " + ex.getMessage());
            return null;
        });
    }    
    
}
