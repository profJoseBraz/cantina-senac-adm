/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.senac.view.home;

import com.senac.consumer.ConfigClient;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.formsRefs.Forms;
import com.senac.helpers.http.HttpClient;
import com.senac.helpers.layouts.CentralizePanel;
import com.senac.model.Config;
import com.senac.view.home.Lists.ListCategory;
import com.senac.view.home.Lists.ListOrder;
import com.senac.view.home.Lists.ListPaymentTypes;
import com.senac.view.home.Lists.ListProduct;
import com.senac.view.home.Lists.ListProduction;
import com.senac.view.home.cadaster.CadProduct;
import com.senac.view.home.cadaster.CadProduction;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author caetano.8918
 */
public class Menu extends javax.swing.JFrame {
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        
        initComponents();
        setLocationRelativeTo(null);
//        GridBagConstraints gbc = new GridBagConstraints();
//        
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.weightx = 1.0;
//        gbc.weighty = 1.0;
//        gbc.fill = GridBagConstraints.CENTER;
        
        getConfigs(
            new ConfigClient().getDdImgsToken(new CertManager(), new HttpClient()), 
            new LoadingDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Carregando configurações do sistema."), ConfigClient.token);
        
        CentralizePanel.centralize(jPanel1, jpButtons);
    }

    public void getConfigs(CompletableFuture<List<Config>> futureConfig, LoadingDialog loadingDialog, List<String> resultToken){
        SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));
        
        futureConfig.thenAccept(configs -> {
            for (Config token : configs) {
                resultToken.add(token.getDbImgsToken());
            }
            
            loadingDialog.dispose();
        }).exceptionally(ex -> {
            System.err.println("Erro ao obter o token do banco de dados de imagens: " + ex.getMessage());
            loadingDialog.dispose();
            return null;
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jpButtons = new javax.swing.JPanel();
        btnAddPedidos = new javax.swing.JButton();
        btnVerPedidos = new javax.swing.JButton();
        btnVisuOrder = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuItemCad = new javax.swing.JMenu();
        miCadProd = new javax.swing.JMenuItem();
        miCadCategoria = new javax.swing.JMenuItem();
        miCadProducao = new javax.swing.JMenuItem();
        miCadRestricao = new javax.swing.JMenuItem();
        miFazerPedido = new javax.swing.JMenuItem();
        miCadFormPagamento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miVisuPedido = new javax.swing.JMenuItem();
        miVisuPedidos = new javax.swing.JMenuItem();
        miVisuCategoria = new javax.swing.JMenuItem();
        miVisuRestricao = new javax.swing.JMenuItem();
        miVisuProducao = new javax.swing.JMenuItem();
        miListFormPagamento = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddPedidos.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        btnAddPedidos.setText("Adicionar Pedidos");
        btnAddPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPedidosActionPerformed(evt);
            }
        });

        btnVerPedidos.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        btnVerPedidos.setText("Ver Produtos");
        btnVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosActionPerformed(evt);
            }
        });

        btnVisuOrder.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        btnVisuOrder.setText("Ver Pedidos");
        btnVisuOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisuOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpButtonsLayout = new javax.swing.GroupLayout(jpButtons);
        jpButtons.setLayout(jpButtonsLayout);
        jpButtonsLayout.setHorizontalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVisuOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpButtonsLayout.setVerticalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVisuOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(468, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
        );

        jmenuItemCad.setText("Cadastro");
        jmenuItemCad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // jmenuItemCadMouseClicked(evt);
            }
        });

        miCadProd.setText("Cadastrar Produto");
        miCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadProdActionPerformed(evt);
            }
        });
        jmenuItemCad.add(miCadProd);

        miCadCategoria.setText("Cadastrar Categoria");
        miCadCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadCategoriaActionPerformed(evt);
            }
        });
        jmenuItemCad.add(miCadCategoria);

        miCadProducao.setText("Cadastrar Produção");
        miCadProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadProducaoActionPerformed(evt);
            }
        });
        jmenuItemCad.add(miCadProducao);

        miCadRestricao.setText("Cadastrar Restrição");
        miCadRestricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadRestricaoActionPerformed(evt);
            }
        });
        jmenuItemCad.add(miCadRestricao);

        miFazerPedido.setText("Fazer Pedido");
        miFazerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFazerPedidoActionPerformed(evt);
            }
        });
        jmenuItemCad.add(miFazerPedido);

        miCadFormPagamento.setText("Formas Pagamentos");
        miCadFormPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadFormPagamentoActionPerformed(evt);
            }
        });
        jmenuItemCad.add(miCadFormPagamento);

        jMenuBar1.add(jmenuItemCad);

        jMenu2.setText("Visualizar");

        miVisuPedido.setText("Produtos");
        miVisuPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVisuPedidoActionPerformed(evt);
            }
        });
        jMenu2.add(miVisuPedido);

        miVisuPedidos.setText("Pedidos");
        miVisuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVisuPedidosActionPerformed(evt);
            }
        });
        jMenu2.add(miVisuPedidos);

        miVisuCategoria.setText("Categoria");
        miVisuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVisuCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(miVisuCategoria);

        miVisuRestricao.setText("Restrições");
        miVisuRestricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVisuRestricaoActionPerformed(evt);
            }
        });
        jMenu2.add(miVisuRestricao);

        miVisuProducao.setText("Produção");
        miVisuProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVisuProducaoActionPerformed(evt);
            }
        });
        jMenu2.add(miVisuProducao);

        miListFormPagamento.setText("Formas Pagamentos");
        miListFormPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListFormPagamentoActionPerformed(evt);
            }
        });
        jMenu2.add(miListFormPagamento);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosActionPerformed
        if (Forms.ListProduct == null)
            Forms.ListProduct = new ListProduct();
        
        Forms.ListProduct.setVisible(true);    }//GEN-LAST:event_btnVerPedidosActionPerformed

    private void miCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadProdActionPerformed
       if(Forms.CadProduct == null)
            Forms.CadProduct = new CadProduct();
        
        Forms.CadProduct.setVisible(true);
    }//GEN-LAST:event_miCadProdActionPerformed

    private void btnAddPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPedidosActionPerformed
        if (Forms.CadOrder == null)
//            Forms.CadOrder = new CadOrder();
        
        Forms.CadOrder.setVisible(true);
    }//GEN-LAST:event_btnAddPedidosActionPerformed

    private void miCadCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadCategoriaActionPerformed
        if (Forms.CadCatergory == null)
//            Forms.CadCatergory = new CadCatergory();
        
        Forms.CadCatergory.setVisible(true);
    }//GEN-LAST:event_miCadCategoriaActionPerformed

    private void miCadProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadProducaoActionPerformed
        if (Forms.CadProduction == null)
            Forms.CadProduction = new CadProduction();

        Forms.CadProduction.setVisible(true);
    }//GEN-LAST:event_miCadProducaoActionPerformed

    private void btnVisuOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisuOrderActionPerformed
        if(Forms.ListOrder == null)
            Forms.ListOrder = new ListOrder();
        
        Forms.ListProduct.setVisible(true);    }//GEN-LAST:event_btnVisuOrderActionPerformed

    private void miVisuPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVisuPedidoActionPerformed
        if (Forms.ListProduct == null)
            Forms.ListProduct = new ListProduct();
        
        Forms.ListProduct.setVisible(true);
    }//GEN-LAST:event_miVisuPedidoActionPerformed

    private void miCadRestricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadRestricaoActionPerformed
    if (Forms.CadRestricao == null)
//        Forms.CadRestricao = new CadRestricao();
    
        Forms.CadRestricao.setVisible(true);
    }//GEN-LAST:event_miCadRestricaoActionPerformed

    private void miFazerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFazerPedidoActionPerformed
        if (Forms.CadOrder == null)
//            Forms.CadOrder = new CadOrder();
        
        Forms.CadOrder.setVisible(true);
    }//GEN-LAST:event_miFazerPedidoActionPerformed

    private void miVisuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVisuCategoriaActionPerformed
        if (Forms.ListCategory == null)
            Forms.ListCategory = new ListCategory();
        
        Forms.ListCategory.setVisible(true);
    }//GEN-LAST:event_miVisuCategoriaActionPerformed

    private void miVisuRestricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVisuRestricaoActionPerformed
        if (Forms.ListRestricao == null)
//            Forms.ListRestricao = new ListRestricao();
        
        Forms.ListRestricao.setVisible(true);
    }//GEN-LAST:event_miVisuRestricaoActionPerformed

    private void miVisuProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVisuProducaoActionPerformed
        if (Forms.listProduction == null)
            Forms.listProduction = new ListProduction();
        
        Forms.listProduction.setVisible(true);
    }//GEN-LAST:event_miVisuProducaoActionPerformed

    private void miListFormPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListFormPagamentoActionPerformed
        if (Forms.ListPaymentTypes == null)
            Forms.ListPaymentTypes = new ListPaymentTypes();
        
        Forms.ListPaymentTypes.setVisible(true);
    }//GEN-LAST:event_miListFormPagamentoActionPerformed

    private void miCadFormPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadFormPagamentoActionPerformed
            if (Forms.CadPaymentTypes == null)
//            Forms.CadPaymentTypes = new CadPaymentTypes();
        
        Forms.CadPaymentTypes.setVisible(true);

    }//GEN-LAST:event_miCadFormPagamentoActionPerformed

    private void miVisuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVisuPedidosActionPerformed
        // TODO add your handling code here:
        if (Forms.ListOrder == null)
            Forms.ListOrder = new ListOrder();
        
        Forms.ListOrder.setVisible(true);
    }//GEN-LAST:event_miVisuPedidosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPedidos;
    private javax.swing.JButton btnVerPedidos;
    private javax.swing.JButton btnVisuOrder;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jmenuItemCad;
    private javax.swing.JPanel jpButtons;
    private javax.swing.JMenuItem miCadCategoria;
    private javax.swing.JMenuItem miCadFormPagamento;
    private javax.swing.JMenuItem miCadProd;
    private javax.swing.JMenuItem miCadProducao;
    private javax.swing.JMenuItem miCadRestricao;
    private javax.swing.JMenuItem miFazerPedido;
    private javax.swing.JMenuItem miListFormPagamento;
    private javax.swing.JMenuItem miVisuCategoria;
    private javax.swing.JMenuItem miVisuPedido;
    private javax.swing.JMenuItem miVisuPedidos;
    private javax.swing.JMenuItem miVisuProducao;
    private javax.swing.JMenuItem miVisuRestricao;
    // End of variables declaration//GEN-END:variables
}
