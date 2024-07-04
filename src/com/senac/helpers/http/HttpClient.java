/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.helpers.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author 10156
 */
public class HttpClient {
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
            System.err.println(e.getMessage());
            this.isLoading = false;
            return null;
        }
    }
}
