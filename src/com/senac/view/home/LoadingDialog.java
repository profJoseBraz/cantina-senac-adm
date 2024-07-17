/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.view.home;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author 10156
 */
public class LoadingDialog extends JDialog{
    public LoadingDialog(JFrame parent, String title) {
        super(parent, title, true); // Título e modal (bloqueia janela pai)
        
        JPanel contentPane = new JPanel();
        getContentPane().add(contentPane);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Define o modo indeterminado
        progressBar.setPreferredSize(new Dimension(250, 50));
        progressBar.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(progressBar);
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Evita fechar com X
        setSize(300, 100); // Tamanho da janela
        setResizable(false);
//        pack();
        setLocationRelativeTo(parent);
    }
}
