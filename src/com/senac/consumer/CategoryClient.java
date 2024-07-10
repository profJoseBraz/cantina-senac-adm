/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Category;
import com.senac.view.home.LoadingDialog;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.SwingUtilities;

/**
 *
 * @author 10156
 */
public class CategoryClient {
    public CompletableFuture<List<Category>> getAllCategories(CertManager certManager, HttpClient httpClient){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest("https://cantina-senac-api-prod.up.railway.app/category", "");

            Gson gson = new Gson();
            List<Category> categories = gson.fromJson(res.toString(), new TypeToken<List<Category>>(){}.getType());

            return categories;
        }).exceptionally(ex -> {
            System.err.println("Método: getAllCategories" + ex.getMessage());
            return null;
        });
    }
    
    public CompletableFuture<List<Category>> getCategoryByName(CertManager certManager, HttpClient httpClient, String name){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest("https://cantina-senac-api-prod.up.railway.app/category", "name=" + name);

            Gson gson = new Gson();
            List<Category> categories = gson.fromJson(res.toString(), new TypeToken<List<Category>>(){}.getType());

            return categories;
        }).exceptionally(ex -> {
            System.err.println("Método: getCategoryByName" + ex.getMessage());
            return null;
        });
    }
    
    public CompletableFuture<Void> postCategory(CertManager certManager, HttpClient httpClient, String body){
        return CompletableFuture.runAsync(() -> {
            certManager.trustAllCerts();
        
            httpClient.makePostRequest("http://localhost:8080/category/add", body);
        }).exceptionally(ex -> {
            System.err.println("Método: postCategory" + ex.getMessage());
            return null;
        });
    }
}
