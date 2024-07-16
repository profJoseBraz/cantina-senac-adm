/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cantinasenacadm;

import com.senac.helpers.http.HttpGithubUploader;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author 10156
 */
public class CantinaSenacAdm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException {
        try{
            String file = "Novo(a) Documento de Texto.txt";
            String filePath = "C:\\Users\\10156\\Desktop\\" + file;
            String gitHubPath = "src/img/produtos/bebidas/";
            
            HttpGithubUploader.upload(filePath, gitHubPath);
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
