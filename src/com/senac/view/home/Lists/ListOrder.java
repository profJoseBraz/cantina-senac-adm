/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.senac.view.home.Lists;

import com.senac.consumer.CategoryClient;
import com.senac.consumer.OrderClient;
import com.senac.consumer.ProductionClient;
import com.senac.helpers.cert.CertManager;
import com.senac.helpers.formatters.MyDateFormatter;
import com.senac.helpers.formsRefs.Forms;
import com.senac.helpers.global.Constantes;
import com.senac.helpers.http.HttpClient;
import com.senac.model.Order;
import com.senac.view.home.LoadingDialog;
import com.senac.view.home.cadaster.CadProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 10156
 */
public class ListOrder extends javax.swing.JFrame {

    /**
     * Creates new form ListOrder
     */
    public ListOrder() {
        initComponents();
        setLocationRelativeTo(null);
        
            listAll(
                (DefaultTableModel) tableOrder.getModel(), 
                new OrderClient().getAllOrder(new CertManager(), new HttpClient()), 
                new LoadingDialog((JFrame) SwingUtilities.getWindowAncestor(tableOrder), "Por favor, aguarde."));

            setComponentsInitialState();
        }

        private void setComponentsInitialState(){
            jtfFilterCriteria.setEnabled(false);
        }

        public void listAll(DefaultTableModel tableModel, CompletableFuture<List<Order>> futureOrders, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureOrders.thenAccept(orders -> {
                tableModel.setRowCount(0);

                for (Order order : orders ) {                    
                    tableModel.addRow(new Object[]{
                        order.getId(), 
                        order.getPaymentMethod().getName(), 
                        order.getCustomerName(), 
                        order.getDate(),
                        order.getTime()});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Order: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }
        
        public void listById(DefaultTableModel tableModel, CompletableFuture<List<Order>> futureOrders, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureOrders.thenAccept(orders -> {
                tableModel.setRowCount(0);

                for (Order order : orders ) {                    
                    tableModel.addRow(new Object[]{
                        order.getId(), 
                        order.getPaymentMethod().getName(), 
                        order.getCustomerName(), 
                        order.getDate(),
                        order.getTime()});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Order: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }        
        
        public void listByCustomerName(DefaultTableModel tableModel, CompletableFuture<List<Order>> futureOrders, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureOrders.thenAccept(orders -> {
                tableModel.setRowCount(0);

                for (Order order : orders ) {                    
                    tableModel.addRow(new Object[]{
                        order.getId(), 
                        order.getPaymentMethod().getName(), 
                        order.getCustomerName(), 
                        order.getDate(),
                        order.getTime()});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Order: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        } 
        
                public void listByPaymentMethod(DefaultTableModel tableModel, CompletableFuture<List<Order>> futureOrders, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureOrders.thenAccept(orders -> {
                tableModel.setRowCount(0);

                for (Order order : orders ) {                    
                    tableModel.addRow(new Object[]{
                        order.getId(), 
                        order.getPaymentMethod().getName(), 
                        order.getCustomerName(), 
                        order.getDate(),
                        order.getTime()});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Order: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }
    
                public void listByDateIgualA(DefaultTableModel tableModel, CompletableFuture<List<Order>> futureOrders, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureOrders.thenAccept(orders -> {
                tableModel.setRowCount(0);

                for (Order order : orders ) {                    
                    tableModel.addRow(new Object[]{
                        order.getId(), 
                        order.getPaymentMethod().getName(), 
                        order.getCustomerName(), 
                        order.getDate(),
                        order.getTime()});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Order: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }
                
                public void listByDateMaiorQue(DefaultTableModel tableModel, CompletableFuture<List<Order>> futureOrders, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureOrders.thenAccept(orders -> {
                tableModel.setRowCount(0);

                for (Order order : orders ) {                    
                    tableModel.addRow(new Object[]{
                        order.getId(), 
                        order.getPaymentMethod().getName(), 
                        order.getCustomerName(), 
                        order.getDate(),
                        order.getTime()});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Order: " + ex.getMessage());
                loadingDialog.dispose();
                return null;
            });
        }

                public void listByDateMenorQue(DefaultTableModel tableModel, CompletableFuture<List<Order>> futureOrders, LoadingDialog loadingDialog){
            SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));

            futureOrders.thenAccept(orders -> {
                tableModel.setRowCount(0);

                for (Order order : orders ) {                    
                    tableModel.addRow(new Object[]{
                        order.getId(), 
                        order.getPaymentMethod().getName(), 
                        order.getCustomerName(), 
                        order.getDate(),
                        order.getTime()});
                }

                loadingDialog.dispose();
            }).exceptionally(ex -> {
                System.err.println("Erro ao listar Order: " + ex.getMessage());
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

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jcbFilterType = new javax.swing.JComboBox<>();
        jtfFilterCriteria = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Pedido");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtragem"));

        jcbFilterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "FORMA DE PAGAMENTO", "CLIENTE", "DATA IGUAL A", "DATA MAIOR QUE", "DATA MENOR QUE" }));
        jcbFilterType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFilterTypeItemStateChanged(evt);
            }
        });

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFilterCriteria, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos"));

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Forma de pagamento", "Nome do cliente", "Data", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableOrderMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(0).setMinWidth(50);
            tableOrder.getColumnModel().getColumn(0).setMaxWidth(50);
            tableOrder.getColumnModel().getColumn(1).setMinWidth(150);
            tableOrder.getColumnModel().getColumn(1).setMaxWidth(150);
            tableOrder.getColumnModel().getColumn(3).setMinWidth(100);
            tableOrder.getColumnModel().getColumn(3).setMaxWidth(100);
            tableOrder.getColumnModel().getColumn(4).setMinWidth(100);
            tableOrder.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("* Clique com o botão direiro para ver mais.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
 
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String criteria = jtfFilterCriteria.getText();
        String formattedDate = "";
        
        switch(jcbFilterType.getSelectedIndex()){
            case 0:
                listAll((DefaultTableModel) tableOrder.getModel(), new OrderClient().getAllOrder(new CertManager(), new HttpClient()), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 1:
                String id = jtfFilterCriteria.getText();
                listById((DefaultTableModel) tableOrder.getModel(), new OrderClient().getOrderById(new CertManager(), new HttpClient(),id), new LoadingDialog(this, "Por favor, aguarde..."));
                break;                

            case 2:
                String paymentMethod = jtfFilterCriteria.getText();
                listByCustomerName((DefaultTableModel) tableOrder.getModel(), new OrderClient().getPaymentMethod(new CertManager(), new HttpClient(),paymentMethod), new LoadingDialog(this, "Por favor, aguarde..."));
                break;                
            case 3:
                String nameCostumer = jtfFilterCriteria.getText();
                listByCustomerName((DefaultTableModel) tableOrder.getModel(), new OrderClient().getCostumerNameOrder(new CertManager(), new HttpClient(),nameCostumer), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 4:
                formattedDate = MyDateFormatter.format(criteria, "dd/MM/yyyy", "yyyy-MM-dd");
                String dateIgualA = jtfFilterCriteria.getText();
                listByDateIgualA((DefaultTableModel) tableOrder.getModel(), new OrderClient().getOrderByDateIgualA(new CertManager(), new HttpClient(), formattedDate), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 5:
                formattedDate = MyDateFormatter.format(criteria, "dd/MM/yyyy", "yyyy-MM-dd");
                String dateMaiorQue = jtfFilterCriteria.getText();
                listByDateMaiorQue((DefaultTableModel) tableOrder.getModel(), new OrderClient().getOrderByDateMaior(new CertManager(), new HttpClient(), formattedDate), new LoadingDialog(this, "Por favor, aguarde..."));
                break;
            case 6:
                formattedDate = MyDateFormatter.format(criteria, "dd/MM/yyyy", "yyyy-MM-dd");
                String dateMenorQue = jtfFilterCriteria.getText();
                listByDateMenorQue((DefaultTableModel) tableOrder.getModel(), new OrderClient().getOrderByDateMenor(new CertManager(), new HttpClient(), formattedDate), new LoadingDialog(this, "Por favor, aguarde..."));
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

    private void tableOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrderMouseReleased
        int selectedRow = tableOrder.rowAtPoint(evt.getPoint());
        
        tableOrder.clearSelection();
        tableOrder.addRowSelectionInterval(selectedRow, selectedRow);
        
        if(evt.getButton() == MouseEvent.BUTTON3){
            if (selectedRow >= 0) {
                try{
                    Constantes.selectedOrderId = String.valueOf(tableOrder.getValueAt(selectedRow, 0));
                    Constantes.paymentMethodName = String.valueOf(tableOrder.getValueAt(selectedRow, 1));
                    Constantes.customerName = String.valueOf(tableOrder.getValueAt(selectedRow, 2));
                    Constantes.orderDate = String.valueOf(tableOrder.getValueAt(selectedRow, 3));
                    Constantes.orderTime = String.valueOf(tableOrder.getValueAt(selectedRow, 4));
                    
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem item1 = new JMenuItem("Ver mais...");
                    popupMenu.add(item1);
                    popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());

                    item1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(Forms.ListOrderItems == null){
                                Forms.ListOrderItems = new ListOrdersItems();
                            }else{
                                ((ListOrdersItems) Forms.ListOrderItems).triggeList();
                            }

                            Forms.ListOrderItems.setVisible(true);
                        }
                    });
                }catch(ArrayIndexOutOfBoundsException e){
                    System.err.println("Método: tableOrderMouseReleased() | Motivo: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_tableOrderMouseReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Forms.ListOrder = null;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ListOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox<String> jcbFilterType;
    private javax.swing.JTextField jtfFilterCriteria;
    private javax.swing.JTable tableOrder;
    // End of variables declaration//GEN-END:variables
}