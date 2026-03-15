/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import models.Lot;
import controller.EstateManager;
import javax.swing.JOptionPane;

/**
 *
 * @author xor
 */

public class LotDetailsDialog extends javax.swing.JDialog {

    /**
     * Creates new form LotDetailsDialog
     */
    private Lot currentLot;

    public LotDetailsDialog(java.awt.Frame parent, boolean modal, models.Lot lot) {
        super(parent, modal);
        this.currentLot = lot;
        initComponents();
        
        jLabel1.setText("LOT DETAILS - " + currentLot.getLotType().toUpperCase());
        Info1.setText(String.format("Block: %d | Lot ID: %d | Lot Area: %.2f sqm | Floor Area: %.2f sqm", 
                currentLot.getBlockID(), currentLot.getLotID(), currentLot.getLotArea(), currentLot.getFloorArea()));
        Info2.setText("Status: " + currentLot.getStatus());
        Info3.setText(String.format("Total Contract Price: PHP %,.2f", currentLot.getTcp()));
        
        models.User currentUser = controller.UserManager.getInstance().getCurrentUser();
        if (currentUser instanceof models.Agent) {
            ActionButton1.setVisible(false); 
            ActionButton2.setVisible(false); 
            ActionButton3.setVisible(false); 
        } else {
            ActionButton3.setVisible(false); 
        }

        updateFinancingTable(); 
        
        // FIX: Utilize ItemListener for robust dropdown event detection
        financingComboBox.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                updateFinancingTable();
            }
        });

        ActionButton1.addActionListener(e -> {
            if (currentLot.getStatus().equalsIgnoreCase("Available")) {
                boolean success = controller.EstateManager.getInstance().requestTransaction(
                        currentLot.getLotID(), currentUser.getId(), "Reservation", "None", currentLot.getReservationFee(), 0.0);
                if(success) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Reservation Request Sent to Agent!");
                    this.dispose();
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Lot is not available.");
            }
        });

        ActionButton2.addActionListener(e -> {
             if (currentLot.getStatus().equalsIgnoreCase("Available")) {
                String financingType = financingComboBox.getSelectedItem() != null ? financingComboBox.getSelectedItem().toString() : "Cash";
                double monthlyAmortization = 0.0;
                double amountToPay = currentLot.getTcp();

                if (financingType.contains("Bank")) {
                    amountToPay = controller.FinancialCalculator.getBankNetDP(currentLot.getTcp(), currentLot.getReservationFee());
                    monthlyAmortization = controller.FinancialCalculator.getBankMonthlyAmortization(currentLot.getTcp(), 20); 
                } else if (financingType.contains("Pag-IBIG")) {
                    amountToPay = controller.FinancialCalculator.getPagIbigNetDP(currentLot.getTcp(), currentLot.getHdmfMaxLoan(), currentLot.getReservationFee());
                    monthlyAmortization = controller.FinancialCalculator.getPagIbigMonthlyAmortization(currentLot.getTcp(), currentLot.getHdmfMaxLoan(), 30); 
                }

                int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
                    String.format("Selected: %s\nInitial Payment: PHP %,.2f\nProceed?", financingType, amountToPay), 
                    "Confirm Purchase Request", javax.swing.JOptionPane.YES_NO_OPTION);

                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    boolean success = controller.EstateManager.getInstance().requestTransaction(
                        currentLot.getLotID(), currentUser.getId(), "Purchase", financingType, amountToPay, monthlyAmortization);
                    if(success) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Purchase Request Sent to Agent!");
                        this.dispose();
                    }
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Lot is not available.");
            }
        });
    }

    private void updateFinancingTable() {
        String selected = financingComboBox.getSelectedItem() != null ? financingComboBox.getSelectedItem().toString() : "Cash";
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Description", "Amount"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        if (selected.contains("Bank")) {
            buildBankModel(model);
        } else if (selected.contains("Pag-IBIG")) {
            buildPagIbigModel(model);
        } else {
            buildCashModel(model);
        }
        
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        
        // FIX: Force UI repaint on the specific component
        jTable1.revalidate();
        jTable1.repaint();
    }

    // Helper Methods extracted from updateFinancingTable()
    
    private void addRow(javax.swing.table.DefaultTableModel model, String description, double amount) {
        model.addRow(new Object[]{description, String.format("PHP %,.2f", amount)});
    }

    private void addTextRow(javax.swing.table.DefaultTableModel model, String col1, String col2) {
        model.addRow(new Object[]{col1, col2});
    }

    private void buildCashModel(javax.swing.table.DefaultTableModel model) {
        double tcp = currentLot.getTcp();
        double rf = currentLot.getReservationFee();
        addRow(model, "Total Contract Price (TCP)", tcp);
        addRow(model, "Reservation Fee", rf);
        addRow(model, "Net Cash Payment", tcp - rf);
        addTextRow(model, "", "");
        addTextRow(model, "Select a financing option above", "to view complete breakdowns.");
    }

    private void buildBankModel(javax.swing.table.DefaultTableModel model) {
        double tcp = currentLot.getTcp();
        double rf = currentLot.getReservationFee();
        addRow(model, "Total Contract Price (TCP)", tcp);
        addRow(model, "10% Downpayment", controller.FinancialCalculator.getBankGrossDP(tcp));
        addRow(model, "Less: Reservation Fee", rf);
        addRow(model, "Net Downpayment", controller.FinancialCalculator.getBankNetDP(tcp, rf));
        addRow(model, "Loanable Amount", controller.FinancialCalculator.getBankLoanable(tcp));
        addTextRow(model, "-----------------------------------------", "-------------------------");
        addTextRow(model, "MONTHLY AMORTIZATION (@ 6.5%)", "");
        addRow(model, "  - 20 Years", controller.FinancialCalculator.getBankMonthlyAmortization(tcp, 20));
        addRow(model, "  - 15 Years", controller.FinancialCalculator.getBankMonthlyAmortization(tcp, 15));
        addRow(model, "  - 10 Years", controller.FinancialCalculator.getBankMonthlyAmortization(tcp, 10));
        addRow(model, "  - 5 Years", controller.FinancialCalculator.getBankMonthlyAmortization(tcp, 5));
    }

    private void buildPagIbigModel(javax.swing.table.DefaultTableModel model) {
        double tcp = currentLot.getTcp();
        double rf = currentLot.getReservationFee();
        double hdmf = currentLot.getHdmfMaxLoan();
        addRow(model, "Total Contract Price (TCP)", tcp);
        addRow(model, "Loanable Amount (Max)", controller.FinancialCalculator.getPagIbigLoanable(tcp, hdmf));
        addRow(model, "Gross Equity / Downpayment", controller.FinancialCalculator.getPagIbigGrossDP(tcp, hdmf));
        addRow(model, "Less: Reservation Fee", rf);
        addRow(model, "Net Equity", controller.FinancialCalculator.getPagIbigNetDP(tcp, hdmf, rf));
        addTextRow(model, "-----------------------------------------", "-------------------------");
        addTextRow(model, "MONTHLY AMORTIZATION (@ 6.38%)", "");
        addRow(model, "  - 30 Years", controller.FinancialCalculator.getPagIbigMonthlyAmortization(tcp, hdmf, 30));
        addRow(model, "  - 20 Years", controller.FinancialCalculator.getPagIbigMonthlyAmortization(tcp, hdmf, 20));
        addRow(model, "  - 10 Years", controller.FinancialCalculator.getPagIbigMonthlyAmortization(tcp, hdmf, 10));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LotDetails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Info1 = new javax.swing.JLabel();
        Info2 = new javax.swing.JLabel();
        Info3 = new javax.swing.JLabel();
        ActionButton1 = new javax.swing.JButton();
        ActionButton2 = new javax.swing.JButton();
        ActionButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        financingComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(30, 30, 30));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LotDetails.setBackground(new java.awt.Color(30, 30, 30));
        LotDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        LotDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("L O T  D E T A I L S");
        LotDetails.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, -1, -1));

        Info1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Info1.setForeground(new java.awt.Color(255, 255, 255));
        Info1.setText("Enter Lot Information");
        LotDetails.add(Info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 63, -1, -1));

        Info2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Info2.setForeground(new java.awt.Color(255, 255, 255));
        Info2.setText("Enter Lot Information");
        LotDetails.add(Info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 93, -1, -1));

        Info3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Info3.setForeground(new java.awt.Color(255, 255, 255));
        Info3.setText("Enter Lot Information");
        LotDetails.add(Info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 121, -1, -1));

        ActionButton1.setBackground(new java.awt.Color(0, 78, 122));
        ActionButton1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        ActionButton1.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton1.setText("Reserve");
        LotDetails.add(ActionButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, -1, -1));

        ActionButton2.setBackground(new java.awt.Color(0, 153, 0));
        ActionButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        ActionButton2.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton2.setText("Buy");
        ActionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton2ActionPerformed(evt);
            }
        });
        LotDetails.add(ActionButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, -1, -1));

        ActionButton3.setBackground(new java.awt.Color(255, 98, 96));
        ActionButton3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        ActionButton3.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton3.setText("Sell");
        ActionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton3ActionPerformed(evt);
            }
        });
        LotDetails.add(ActionButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        LotDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 660, 320));

        financingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spot Cash", "Bank", "Pag-IBIG" }));
        financingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financingComboBoxActionPerformed(evt);
            }
        });
        LotDetails.add(financingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 130, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Financing:");
        LotDetails.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        getContentPane().add(LotDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActionButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActionButton2ActionPerformed

    private void ActionButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActionButton3ActionPerformed

    private void financingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financingComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_financingComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LotDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LotDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LotDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LotDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                LotDetailsDialog dialog = new LotDetailsDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActionButton1;
    private javax.swing.JButton ActionButton2;
    private javax.swing.JButton ActionButton3;
    private javax.swing.JLabel Info1;
    private javax.swing.JLabel Info2;
    private javax.swing.JLabel Info3;
    private javax.swing.JPanel LotDetails;
    private javax.swing.JComboBox<String> financingComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
