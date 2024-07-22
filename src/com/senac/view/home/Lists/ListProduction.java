/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.senac.view.home.Lists;

import com.senac.consumer.ProductionClient;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.formatters.MyCurrencyFormatter;
import com.senac.helpers.formatters.MyDateFormatter;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Production;
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
public class ListProduction extends javax.swing.JFrame {

    /**
     * Creates new form ListProduction
     */
    public ListProduction() {
        initComponents();
        listAllProduction(
                (DefaultTableModel) tableProduction.getModel(), 
                new ProductionClient().getAllProduction(new CertManager(), new HttpClient()), 
                new LoadingDialog((JFrame) SwingUtilities.getWindowAncestor(tableProduction), "Por favor, aguarde..."));

            setComponentsInitialState();

            setLocationRelativeTo(null);
        }

        private void setComponentsInitialState(){
            jtfFilterCriteria.setEnabled(false);
        }

        public void listAllProduction(DefaultTableModel tableModel, CompletableFuture<List<Production>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(productions -> {
                tableModel.setRowCount(0);

                for (Production production : productions) {
                    String formatteDate = MyDateFormatter.format(production.getDate(), "yyyy-MM-dd'T'HH:mm:ss.SSSX", "dd/MM/yyyy");
                    String formattedValue = MyCurrencyFormatter.format(production.getProduct().getValue(), new Locale("pt", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        production.getId(),
                        production.getProduct().getId(),
                        production.getProduct().getName(),
                        production.getProduct().getCategory().getName(),
                        production.getProduct().getDescription(),
                        production.getObservation(),
                        formattedValue,
                        production.getAmount(),
                        formatteDate});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar a produção: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }
            
            public void listByCategory(DefaultTableModel tableModel, CompletableFuture<List<Production>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(productions -> {
                tableModel.setRowCount(0);

                for (Production production : productions) {
                    String formatteDate = MyDateFormatter.format(production.getDate(), "yyyy-MM-dd'T'HH:mm:ss.SSSX", "dd/MM/yyyy");
                    String formattedValue = MyCurrencyFormatter.format(production.getProduct().getValue(), new Locale("pt", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        production.getId(),
                        production.getProduct().getId(),
                        production.getProduct().getName(),
                        production.getProduct().getCategory().getName(),
                        production.getProduct().getDescription(),
                        production.getObservation(),
                        formattedValue,
                        production.getAmount(),
                        formatteDate});               
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar produção: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
            }
    
            public void listByNameProd(DefaultTableModel tableModel, CompletableFuture<List<Production>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(productions -> {
                tableModel.setRowCount(0);

                for (Production production : productions) {
                    String formatteDate = MyDateFormatter.format(production.getDate(), "yyyy-MM-dd'T'HH:mm:ss.SSSX", "dd/MM/yyyy");
                    String formattedValue = MyCurrencyFormatter.format(production.getProduct().getValue(), new Locale("pt", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        production.getId(),
                        production.getProduct().getId(),
                        production.getProduct().getName(),
                        production.getProduct().getCategory().getName(),
                        production.getProduct().getDescription(),
                        production.getObservation(),
                        formattedValue,
                        production.getAmount(),
                        formatteDate});                
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar produção: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
            }
           
            public void listByDateIgualA(DefaultTableModel tableModel, CompletableFuture<List<Production>> futureProducts, LoadingDialog loadingDialog){
                SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

                futureProducts.thenAccept(productions -> {
                    tableModel.setRowCount(0);

                    for (Production production : productions) {
                        String formatteDate = MyDateFormatter.format(production.getDate(), "yyyy-MM-dd'T'HH:mm:ss.SSSX", "dd/MM/yyyy");
                        String formattedValue = MyCurrencyFormatter.format(production.getProduct().getValue(), new Locale("pt", "BR"));

                        tableModel.addRow(new Object[]{
                            production.getId(),
                            production.getProduct().getId(),
                            production.getProduct().getName(),
                            production.getProduct().getCategory().getName(),
                            production.getProduct().getDescription(),
                            production.getObservation(),
                            formattedValue,
                            production.getAmount(),
                            formatteDate});                
                    }

                    loadingDialog.dispose();
                }).exceptionally(ex -> {
                    System.err.println("Erro ao listar produção: " + ex.getMessage());
                    loadingDialog.dispose();
                    return null;
                });
            }            
            
            
            public void listByDateMaior(DefaultTableModel tableModel, CompletableFuture<List<Production>> futureProducts, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureProducts.thenAccept(productions -> {
                tableModel.setRowCount(0);

                for (Production production : productions) {
                    String formatteDate = MyDateFormatter.format(production.getDate(), "yyyy-MM-dd'T'HH:mm:ss.SSSX", "dd/MM/yyyy");
                    String formattedValue = MyCurrencyFormatter.format(production.getProduct().getValue(), new Locale("pt", "BR"));
                    
                    tableModel.addRow(new Object[]{
                        production.getId(),
                        production.getProduct().getId(),
                        production.getProduct().getName(),
                        production.getProduct().getCategory().getName(),
                        production.getProduct().getDescription(),
                        production.getObservation(),
                        formattedValue,
                        production.getAmount(),
                        formatteDate});                
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar produção: " + ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        jcbFilterType = new javax.swing.JComboBox<>();
        jtfFilterCriteria = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduction = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtragem"));

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jcbFilterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME DO PRODUTO", "CATEGORIA", "DATA", "DATA MAIOR QUE", "DATA MENOR QUE" }));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFilterCriteria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFilterCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produção"));

        tableProduction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Id do Produto", "Nome do produto", "Categoria", "Descrição do produto", "Observação", "Valor do Produto", "Quantidade", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProduction);
        if (tableProduction.getColumnModel().getColumnCount() > 0) {
            tableProduction.getColumnModel().getColumn(0).setMinWidth(0);
            tableProduction.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableProduction.getColumnModel().getColumn(0).setMaxWidth(0);
            tableProduction.getColumnModel().getColumn(1).setMinWidth(0);
            tableProduction.getColumnModel().getColumn(1).setPreferredWidth(0);
            tableProduction.getColumnModel().getColumn(1).setMaxWidth(0);
            tableProduction.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbFilterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFilterTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFilterTypeActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String criteria = jtfFilterCriteria.getText();
        String formattedDate = "";
        
        switch(jcbFilterType.getSelectedIndex()){
            case 0:
                listAllProduction((DefaultTableModel) tableProduction.getModel(), new ProductionClient().getAllProduction(new CertManager(), new HttpClient()), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 2:
//                String nameProd = jtfFilterCriteria.getText();
                listByNameProd((DefaultTableModel) tableProduction.getModel(), new ProductionClient().getProductionByName(new CertManager(), new HttpClient(), criteria), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 3:
//                String category = jtfFilterCriteria.getText();;
                listByCategory((DefaultTableModel) tableProduction.getModel(), new ProductionClient().getProductionByCategory(new CertManager(), new HttpClient(), criteria), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 4:
//                String date = jtfFilterCriteria.getText();;
                
                formattedDate = MyDateFormatter.format(criteria, "dd/MM/yyyy", "yyyy-MM-dd");
                listByDateIgualA((DefaultTableModel) tableProduction.getModel(), new ProductionClient().getProductionByDateIgualA(new CertManager(), new HttpClient(), formattedDate), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 5:
                formattedDate = MyDateFormatter.format(criteria, "dd/MM/yyyy", "yyyy-MM-dd");
                listByDateMaior((DefaultTableModel) tableProduction.getModel(),new ProductionClient().getProductionByDateMaior(new CertManager(), new HttpClient(), formattedDate), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
        }
            }//GEN-LAST:event_btnSearchActionPerformed

    private void jcbFilterTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFilterTypeItemStateChanged
        if(jcbFilterType.getSelectedIndex() == 0){
            jtfFilterCriteria.setText("");
            jtfFilterCriteria.setEnabled(false);
        }else{
            jtfFilterCriteria.setEnabled(true);
        }    }//GEN-LAST:event_jcbFilterTypeItemStateChanged

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
            java.util.logging.Logger.getLogger(ListProduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProduction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbFilterType;
    private javax.swing.JTextField jtfFilterCriteria;
    private javax.swing.JTable tableProduction;
    // End of variables declaration//GEN-END:variables
}
