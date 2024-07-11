/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.helpers.http;

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
public class HttpUploader {
    private static final String GITHUB_USERNAME = "profJoseBraz";
    private static final String GITHUB_REPO = "ExemplosCodigos";
    private static final String GITHUB_BRANCH = "master"; // ou outra branch que desejar
    private static final String GITHUB_TOKEN = "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";

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\10156\\Documents\\exemplo\\teste.txt"); // Substitua pelo caminho do seu arquivo

        System.out.println(file.getPath());
            
        byte[] fileContent = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        String encodedContent = Base64.getEncoder().encodeToString(fileContent);

        String apiEndpoint = "https://api.github.com/repos/" + GITHUB_USERNAME + "/" + GITHUB_REPO + "/contents/" + file.getPath();
        String commitMessage = "Adicionando imagem via API";
        String branch = GITHUB_BRANCH;

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("message", commitMessage)
                .addFormDataPart("content", encodedContent)
                .addFormDataPart("branch", branch)
                .build();

        Request request = new Request.Builder()
                .url(apiEndpoint)
                .header("Authorization", "token " + GITHUB_TOKEN)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Erro ao enviar arquivo para o GitHub: " + response.code() + " " + response.message());
            } else {
                System.out.println("Arquivo enviado com sucesso para o GitHub.");
            }
        }
    }
}
