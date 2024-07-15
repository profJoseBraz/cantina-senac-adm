/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.helpers.http;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 *
 * @author 10156
 */

//Adicionar arquivo
public class HttpGithubUploader {
    private static final String GITHUB_USERNAME = "banco-imgs";
    private static final String GITHUB_REPO = "bd-imagens";
    private static final String GITHUB_BRANCH = "main";
    private static final String GITHUB_TOKEN = "";

    public static void upload(String filePath, String gitHubPath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Arquivo não encontrado: " + file.getAbsolutePath());
            return;
        }

        byte[] fileContent = Files.readAllBytes(file.toPath());
        String encodedContent = Base64.getEncoder().encodeToString(fileContent);

        String apiEndpoint = "https://api.github.com/repos/" + GITHUB_USERNAME + "/" + GITHUB_REPO + "/contents/" + gitHubPath + file.getName();
        String commitMessage = "Novo arquivo adicionado (" + file.getName() + ")";
        String branch = GITHUB_BRANCH;

        OkHttpClient client = new OkHttpClient();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", commitMessage);
        jsonObject.addProperty("content", encodedContent);
        jsonObject.addProperty("branch", branch);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());

        Request request = new Request.Builder()
            .url(apiEndpoint)
            .header("Authorization", "Bearer " + GITHUB_TOKEN)
            .put(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            if (!response.isSuccessful()) {
                System.out.println("Erro ao adicionar arquivo ao GitHub: " + response.code() + " " + response.message());
                System.out.println("Detalhes da resposta: " + responseBody);
            } else {
                System.out.println("Arquivo adicionado com sucesso ao GitHub.");
                System.out.println("Detalhes da resposta: " + responseBody);
            }
        }
    }
}