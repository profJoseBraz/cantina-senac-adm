/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.helpers.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author 10156
 */
public class HttpClient {
    public static final String API_URL = "https://cantina-senac-api-prod.up.railway.app";
    
    private boolean isLoading;
    
    public boolean isLoading(){
        return this.isLoading;
    }
    
    public StringBuffer makeGetRequest(String _url, String params){
        try{
            this.isLoading = true;
            
            // Especifica o endpoint
            URL url = new URL(_url + (!params.isEmpty() ? "?" : "") + params);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Lê a resposta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            this.isLoading = false;
            
            return response;
        }catch(IOException e){
            System.err.println("Classe: HttpClient | Método: makeGetRequest: " + e.getMessage());
            this.isLoading = false;
            return null;
        }
    }
    
    public boolean makePostRequest(String url, String body){
        try{
            this.isLoading = true;
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Configurações da requisição
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            // Dados do body
            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Ler a resposta da requisição
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            
            System.out.println(response.toString());
            
            this.isLoading = false;
            
            return true;
        }catch(IOException e){
            System.err.println("Classe: HttpClient | Método: makePostRequest: " + e.getMessage());
            this.isLoading = false;
            
            return false;
        }
    }
}
