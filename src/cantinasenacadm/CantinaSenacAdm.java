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
            String from = "C:\\Users\\jose_\\OneDrive\\Área de Trabalho\\agua-com-gas.png";
            String to = "src/img/produtos/bebidas/";
            
            HttpGithubUploader.upload(from, to);
        }catch(IOException e){
            
        }
    }
}
