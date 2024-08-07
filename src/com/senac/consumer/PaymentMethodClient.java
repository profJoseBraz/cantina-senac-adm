package com.senac.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.http.HttpClient;
import com.senac.model.PaymentMethod;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PaymentMethodClient {
    public CompletableFuture<List<PaymentMethod>> getAllPaymentMethods(CertManager certManager, HttpClient httpClient) {
        return CompletableFuture.supplyAsync(() -> {
            certManager.trustAllCerts();
            StringBuffer res = httpClient.makeGetRequest(HttpClient.API_URL + "/paymentMethod", "");

            Gson gson = new Gson();
            List<PaymentMethod> paymentMethods = gson.fromJson(res.toString(), new TypeToken<List<PaymentMethod>>() {}.getType());

            return paymentMethods;
        }).exceptionally(ex -> {
            System.err.println("Error in getAllPayments method: " + ex.getMessage());
            return null; // Handle error gracefully
        });
    }
    
    public CompletableFuture<Boolean> postPaymentMethods(CertManager certManager, HttpClient httpClient, String body){
        CompletableFuture<Boolean> resultFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                certManager.trustAllCerts();
                boolean res = httpClient.makePostRequest(HttpClient.API_URL + "/paymentMethod/add", body);
                resultFuture.complete(res);
            } catch (Exception ex) {
                System.err.println("Classe: PaymentMethodClient | Método: postPaymentMethod: " + ex.getMessage());
                resultFuture.completeExceptionally(ex);
            }
        });

        return resultFuture;
    }
}
