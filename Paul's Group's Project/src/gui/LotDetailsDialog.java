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
    private Lot currentLot; // Add class variable

    public LotDetailsDialog(java.awt.Frame parent, boolean modal, Lot lot) {
        super(parent, modal);
        this.currentLot = lot;
        initComponents();
        
        jLabel1.setText("LOT DETAILS - " + currentLot.getLotType().toUpperCase());
        Info1.setText("Block: " + currentLot.getBlockID() + " | Lot ID: " + currentLot.getLotID());
        Info2.setText("Status: " + currentLot.getStatus());
        Info3.setText("TCP: PHP " + String.format("%,.2f", currentLot.getTcp()));
        
        models.User currentUser = controller.UserManager.getInstance().getCurrentUser();
        
        // Hide UI based on Role
        if (currentUser instanceof models.Agent) {
            ActionButton1.setVisible(false); // Hide Reserve
            ActionButton2.setVisible(false); // Hide Buy
            ActionButton3.setVisible(false); // Hide Sell
        } else {
            ActionButton3.setVisible(false); // Buyers can't 'Sell'
        }

        // Reserve Action
        ActionButton1.addActionListener(e -> {
            if (currentLot.getStatus().equalsIgnoreCase("Available")) {
                // Reservation has no financing or amortization
                boolean success = controller.EstateManager.getInstance().requestTransaction(
                        currentLot.getLotID(), currentUser.getId(), "Reservation", "None", currentLot.getReservationFee(), 0.0);
                if(success) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Reservation Request Sent!");
                    this.dispose();
                }
            }
        });

        // Buy Action (Triggers PDF Financing Computations)
        ActionButton2.addActionListener(e -> {
             if (currentLot.getStatus().equalsIgnoreCase("Available")) {
                String[] options = {"Cash", "Bank Financing", "Pag-IBIG"};
                int choice = javax.swing.JOptionPane.showOptionDialog(this, "Select Financing Method:", "Purchase", 
                        javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                if (choice == -1) return; // User closed dialog

                String financingType = options[choice];
                double monthlyAmortization = 0.0;
                double amountToPay = currentLot.getTcp();

                try {
                    if (choice == 1) { // Bank
                        String yearsStr = javax.swing.JOptionPane.showInputDialog(this, "Enter Years to Pay (Max 20):");
                        if (yearsStr == null) return;
                        int years = Integer.parseInt(yearsStr);
                        monthlyAmortization = controller.FinancialCalculator.getBankMonthlyAmortization(currentLot.getTcp(), years);
                        amountToPay = controller.FinancialCalculator.getBankNetDP(currentLot.getTcp(), currentLot.getReservationFee());
                    } else if (choice == 2) { // Pag-IBIG
                        String yearsStr = javax.swing.JOptionPane.showInputDialog(this, "Enter Years to Pay (Max 30):");
                        if (yearsStr == null) return;
                        int years = Integer.parseInt(yearsStr);
                        monthlyAmortization = controller.FinancialCalculator.getPagIbigMonthlyAmortization(currentLot.getTcp(), currentLot.getHdmfMaxLoan(), years);
                        amountToPay = controller.FinancialCalculator.getPagIbigNetDP(currentLot.getTcp(), currentLot.getHdmfMaxLoan(), currentLot.getReservationFee());
                    }
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid term entered. " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
                    String.format("Initial Payment (DP/TCP): PHP %,.2f\nMonthly Amortization: PHP %,.2f\nProceed?", amountToPay, monthlyAmortization), 
                    "Confirm Purchase", javax.swing.JOptionPane.YES_NO_OPTION);

                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    boolean success = controller.EstateManager.getInstance().requestTransaction(
                        currentLot.getLotID(), currentUser.getId(), "Purchase", financingType, amountToPay, monthlyAmortization);
                    if(success) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Purchase Request Sent to Agent!");
                        this.dispose();
                    }
                }
            }
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
        LotDetails.add(ActionButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, -1));

        ActionButton2.setBackground(new java.awt.Color(0, 153, 0));
        ActionButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        ActionButton2.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton2.setText("Buy");
        ActionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton2ActionPerformed(evt);
            }
        });
        LotDetails.add(ActionButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));

        ActionButton3.setBackground(new java.awt.Color(255, 98, 96));
        ActionButton3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        ActionButton3.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton3.setText("Sell");
        ActionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton3ActionPerformed(evt);
            }
        });
        LotDetails.add(ActionButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

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

        LotDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 149, 660, 320));

        getContentPane().add(LotDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActionButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActionButton2ActionPerformed

    private void ActionButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActionButton3ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
