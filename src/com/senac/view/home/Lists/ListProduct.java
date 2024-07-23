/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.senac.view.home.Lists;

import com.senac.consumer.ProductsClient;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.formatters.MyCurrencyFormatter;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Product;
import com.senac.view.home.LoadingDialog;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grander.3993
 */
public class ListProduct extends javax.swing.JFrame {

    /**
     * Creates new form ListProduct
     */
    public ListProduct() {
            initComponents();

            listAll(
                (DefaultTableModel) tableProduct.getModel(), 
                new ProductsClient().getAllProducts(new CertManager(), new HttpClient()), 
                new LoadingDialog((JFrame) SwingUtilities.getWindowAncestor(tableProduct), "Por favor, aguarde..."));

            setComponentsInitialState();

            setLocationRelativeTo(null);
        }

        private void setComponentsInitialState(){
            jtfFilterCriteria.setEnabled(false);
        }

        public void listAll(DefaultTableModel tableModel, CompletableFuture<List<Product>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(products -> {
                tableModel.setRowCount(0);

                for (Product product : products ) {
                    String formattedValue = MyCurrencyFormatter.format(product.getValue(), new Locale("pr", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        product.getId(),
                        product.getName(),
                        product.getCategory().getName(),
                        product.getDescription(),
                        formattedValue});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar produtos: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }
        
        public void listByName(DefaultTableModel tableModel, CompletableFuture<List<Product>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(products -> {
                tableModel.setRowCount(0);

                for (Product product : products) {
                    String formattedValue = MyCurrencyFormatter.format(product.getValue(), new Locale("pr", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        product.getId(),
                        product.getName(),
                        product.getCategory().getName(),
                        product.getDescription(),
                        formattedValue});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Produtos por Nome" + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }

        public void listById(DefaultTableModel tableModel, CompletableFuture<List<Product>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(products -> {
                tableModel.setRowCount(0);

                for (Product product : products) {
                    String formattedValue = MyCurrencyFormatter.format(product.getValue(), new Locale("pr", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        product.getId(),
                        product.getName(),
                        product.getCategory().getName(),
                        product.getDescription(),
                        formattedValue});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Produtos por Id" + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }
        
        
        public void listByCategory(DefaultTableModel tableModel, CompletableFuture<List<Product>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(products -> {
                tableModel.setRowCount(0);

                for (Product product : products) {
                    String formattedValue = MyCurrencyFormatter.format(product.getValue(), new Locale("pr", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        product.getId(),
                        product.getName(),
                        product.getCategory().getName(),
                        product.getDescription(),
                        formattedValue});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar produtos: " + ex.getMessage());
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

        jPanel = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        jtfFilterCriteria = new javax.swing.JTextField();
        jcbFilterType = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de produtos");

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtragem"));

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jtfFilterCriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFilterCriteriaActionPerformed(evt);
            }
        });

        jcbFilterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "CATEGORIA", "NOME", " ", " " }));
        jcbFilterType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFilterTypeItemStateChanged(evt);
            }
        });
        jcbFilterType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFilterTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFilterCriteria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jtfFilterCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Categoria", "Descrição", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tableProduct);
        if (tableProduct.getColumnModel().getColumnCount() > 0) {
            tableProduct.getColumnModel().getColumn(0).setMinWidth(0);
            tableProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableProduct.getColumnModel().getColumn(0).setMaxWidth(0);
            tableProduct.getColumnModel().getColumn(1).setMinWidth(300);
            tableProduct.getColumnModel().getColumn(1).setMaxWidth(300);
            tableProduct.getColumnModel().getColumn(2).setMinWidth(200);
            tableProduct.getColumnModel().getColumn(2).setMaxWidth(200);
            tableProduct.getColumnModel().getColumn(4).setMinWidth(60);
            tableProduct.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//    private void jcbFilterTypeItemStateChanged(java.awt.event.ItemEvent evt) {                                               
//        if(jcbFilterType.getSelectedIndex() == 0){
//            jtfFilterCriteria.setText("");
//            jtfFilterCriteria.setEnabled(false);
//        }else{
//            jtfFilterCriteria.setEnabled(true);
//        }
//    }               
    private void jcbFilterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFilterTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFilterTypeActionPerformed

    private void jtfFilterCriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFilterCriteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFilterCriteriaActionPerformed

    private void jcbFilterTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFilterTypeItemStateChanged
        if(jcbFilterType.getSelectedIndex() == 0){
            jtfFilterCriteria.setText("");
            jtfFilterCriteria.setEnabled(false);
        }else{
            jtfFilterCriteria.setEnabled(true);
        }
    }//GEN-LAST:event_jcbFilterTypeItemStateChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       switch(jcbFilterType.getSelectedIndex()){
            case 0:
                listAll((DefaultTableModel) tableProduct.getModel(), new ProductsClient().getAllProducts(new CertManager(), new HttpClient()), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 1:
                String id = jtfFilterCriteria.getText();
                listById((DefaultTableModel) tableProduct.getModel(), new ProductsClient().getProductsById(new CertManager(), new HttpClient(),id), new LoadingDialog(this, "Por favor, aguarde..."));
                break;                          
            case 2:
                String category = jtfFilterCriteria.getText();
                listByCategory((DefaultTableModel) tableProduct.getModel(), new ProductsClient().getProductByCategory(new CertManager(), new HttpClient(), category), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
                
            case 3:
                String name = jtfFilterCriteria.getText();
                listByName((DefaultTableModel) tableProduct.getModel(), new ProductsClient().getProductByName(new CertManager(), new HttpClient(), name), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbFilterType;
    private javax.swing.JTextField jtfFilterCriteria;
    private javax.swing.JTable tableProduct;
    // End of variables declaration//GEN-END:variables
}
