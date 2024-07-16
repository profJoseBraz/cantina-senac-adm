/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author 10156
 */
public class ConfigClient {
    public static List<String> token = new ArrayList();
    
    public CompletableFuture<List<Config>> getDdImgsToken(CertManager certManager, HttpClient httpClient){
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/config/bdImgsToken", "");

            Gson gson = new Gson();
            List<Config> configs = gson.fromJson(res.toString(), new TypeToken<List<Config>>(){}.getType());

            return configs;
        }).exceptionally(ex -> {
            System.err.println("Classe: ConfigClient | Método: getBdImgsToken" + ex.getMessage());
            return null;
        });
    }
}
