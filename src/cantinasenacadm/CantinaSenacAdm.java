/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cantinasenacadm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Category;

/**
 *
 * @author 10156
 */
public class CantinaSenacAdm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        
        String body = """
                        {
                            "name": "%s"
                        }
                       """;
        
        String valor = "aasdfsadfadsfadsf";
        
        body = String.format(body, valor);
        
        System.err.println(body);
        
        httpClient.makePostRequest("http://localhost:8080/category/add", body);
    }
    
}
