/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cantinasenacadm;

import com.senac.helpers.http.HttpGithubUploader;
import java.io.IOException;

/**
 *
 * @author 10156
 */
public class CantinaSenacAdm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String file = "agua-com-gas.png";
            String filePath = "C:\\Users\\jose_\\OneDrive\\Área de Trabalho\\" + file;
            String gitHubPath = "src/img/produtos/bebidas/";
            
            HttpGithubUploader.upload(filePath, gitHubPath);
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
