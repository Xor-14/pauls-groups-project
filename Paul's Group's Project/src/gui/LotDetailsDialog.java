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
    private Lot currentLot;

    public LotDetailsDialog(java.awt.Frame parent, boolean modal, models.Lot lot) {
        super(parent, modal);
        this.currentLot = lot;
        initComponents();
        financingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
        "Spot Cash", "Bank - BDO", "Bank - BPI", "Bank - RCBC", "Pag-IBIG Financing" 
    }));
        
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
        
        // Utilize ItemListener for robust dropdown event detection
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
            // 1. Availability Check
            if (!currentLot.getStatus().equalsIgnoreCase("Available")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Lot is not available for purchase.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            String financingType = financingComboBox.getSelectedItem() != null ? financingComboBox.getSelectedItem().toString() : "Spot Cash";
            double monthlyAmortization = 0.0;
            double amountToPay = currentLot.getTcp();

            // 2. Financing Flow (Bank or Pag-IBIG)
            if (financingType.contains("Bank") || financingType.contains("Pag-IBIG")) {
                
                // --- Term Selection ---
                Integer[] terms;
                Integer defaultTerm;
                
                if (financingType.contains("Bank")) {
                    terms = new Integer[]{5, 10, 15, 20};
                    defaultTerm = 20;
                } else {
                    terms = new Integer[]{5, 10, 15, 20, 25, 30};
                    defaultTerm = 30;
                }

                Integer selectedTerm = (Integer) javax.swing.JOptionPane.showInputDialog(this, 
                        "Select Loan Term (Years):", "Term Selection", 
                        javax.swing.JOptionPane.QUESTION_MESSAGE, null, terms, defaultTerm);
                
                if (selectedTerm == null) return; // User cancelled

                // --- Original Rate Logic + Dynamic Term ---
                if (financingType.equals("Bank - BDO") || financingType.equals("Bank - RCBC")) {
                    amountToPay = controller.FinancialCalculator.getBankNetDP(currentLot.getTcp(), currentLot.getReservationFee());
                    monthlyAmortization = controller.FinancialCalculator.getBankMonthlyAmortization(currentLot.getTcp(), 0.065, selectedTerm); 
                } else if (financingType.equals("Bank - BPI")) {
                    amountToPay = controller.FinancialCalculator.getBankNetDP(currentLot.getTcp(), currentLot.getReservationFee());
                    monthlyAmortization = controller.FinancialCalculator.getBankMonthlyAmortization(currentLot.getTcp(), 0.07, selectedTerm); 
                } else if (financingType.equals("Pag-IBIG Financing")) {
                    amountToPay = controller.FinancialCalculator.getPagIbigNetDP(currentLot.getTcp(), currentLot.getHdmfMaxLoan(), currentLot.getReservationFee());
                    monthlyAmortization = controller.FinancialCalculator.getPagIbigMonthlyAmortization(currentLot.getTcp(), currentLot.getHdmfMaxLoan(), selectedTerm); 
                }

                financingType += " (" + selectedTerm + " Yrs)";

                // --- Income Capture & Validation ---
                javax.swing.JPanel promptPanel = new javax.swing.JPanel(new java.awt.GridLayout(2, 2, 5, 5));
                promptPanel.add(new javax.swing.JLabel("Gross Monthly Income (PHP):"));
                javax.swing.JTextField incomeField = new javax.swing.JTextField();
                promptPanel.add(incomeField);
                
                promptPanel.add(new javax.swing.JLabel("Employment Type:"));
                javax.swing.JComboBox<String> empBox = new javax.swing.JComboBox<>(new String[]{"Locally Employed", "OFW", "Self-Employed"});
                promptPanel.add(empBox);

                int result = javax.swing.JOptionPane.showConfirmDialog(this, promptPanel, 
                        "Financing Requirements", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.PLAIN_MESSAGE);
                        
                if (result != javax.swing.JOptionPane.OK_OPTION) return; // User cancelled

                try {
                    double inputIncome = Double.parseDouble(incomeField.getText().replaceAll(",", ""));
                    double requiredNDI = controller.FinancialCalculator.getRequiredNDI(monthlyAmortization);
                    
                    if (inputIncome < requiredNDI) {
                        javax.swing.JOptionPane.showMessageDialog(this, 
                            String.format("Gross income (PHP %,.2f) does not meet the Required NDI (PHP %,.2f).", inputIncome, requiredNDI), 
                            "Financing Rejected", javax.swing.JOptionPane.ERROR_MESSAGE);
                        return; // Halt if income is insufficient
                    }
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid income format. Use numbers only.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return; // Halt on bad input
                }
            } else {
                // 3. Spot Cash Flow
                amountToPay = currentLot.getTcp() - currentLot.getReservationFee();
            }

            // 4. Final Purchase Confirmation
            int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
                String.format("Financing: %s\nInitial Payment: PHP %,.2f\nMonthly Amortization: PHP %,.2f\n\nProceed with purchase request?", 
                financingType, amountToPay, monthlyAmortization), 
                "Confirm Purchase Request", javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirm == javax.swing.JOptionPane.YES_OPTION) {
//                models.User currentUser = controller.UserManager.getInstance().getCurrentUser();
                boolean success = controller.EstateManager.getInstance().requestTransaction(
                    currentLot.getLotID(), currentUser.getId(), "Purchase", financingType, amountToPay, monthlyAmortization);
                if(success) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Purchase Request Sent to Agent!");
                    this.dispose();
                }
            }
        });
    }

    private void updateFinancingTable() {
        String selected = financingComboBox.getSelectedItem() != null ? financingComboBox.getSelectedItem().toString() : "Spot Cash";
        
        buildLotInfoTable();
        
        if (selected.contains("Bank")) {
            buildRFOTableBank();
            buildLoanTableBank(selected);
        } else if (selected.contains("Pag-IBIG")) {
            buildRFOTablePagIbig();
            buildLoanTablePagIbig();
        } else {
            buildRFOTableCash();
            buildLoanTableCash();
        }
    }

    // --- TABLE 1: LOT INFORMATION ---
    private void buildLotInfoTable() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"Property Details", "Information"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        model.addRow(new Object[]{"Block / Lot", "Block " + currentLot.getBlockID() + " - Lot " + currentLot.getLotID()});
        model.addRow(new Object[]{"Lot Area", String.format("%.2f sqm", currentLot.getLotArea())});
        model.addRow(new Object[]{"Floor Area", String.format("%.2f sqm", currentLot.getFloorArea())});
        model.addRow(new Object[]{"Model Type", currentLot.getLotType()});
        model.addRow(new Object[]{"Status", currentLot.getStatus()});
        
        tableLotInfo.setModel(model);
    }

    // --- TABLE 2: RFO BASIC TURN OVER ---
    private void buildRFOTableCash() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"RFO Basic Turn Over", "Amount"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        double tcp = currentLot.getTcp();
        double rf = currentLot.getReservationFee();
        model.addRow(new Object[]{"Total Contract Price (TCP)", String.format("PHP %,.2f", tcp)});
        model.addRow(new Object[]{"Less: Reservation Fee", String.format("PHP %,.2f", rf)});
        model.addRow(new Object[]{"NET SPOT CASH PAYMENT", String.format("PHP %,.2f", tcp - rf)});
        tableRFO.setModel(model);
    }

    private void buildRFOTableBank() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"RFO Basic Turn Over (Bank)", "Amount"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        double tcp = currentLot.getTcp();
        double rf = currentLot.getReservationFee();
        double grossDp = controller.FinancialCalculator.getBankGrossDP(tcp);
        double netDp = controller.FinancialCalculator.getBankNetDP(tcp, rf);
        int dpMonths = 6; // Standard inferred DP term
        double dpAmort = controller.FinancialCalculator.getDpAmortization(netDp, dpMonths);

        model.addRow(new Object[]{"Total Contract Price (TCP)", String.format("PHP %,.2f", tcp)});
        model.addRow(new Object[]{"Downpayment %", "10%"});
        model.addRow(new Object[]{"Gross Downpayment", String.format("PHP %,.2f", grossDp)});
        model.addRow(new Object[]{"Less: Reservation Fee", String.format("PHP %,.2f", rf)});
        model.addRow(new Object[]{"Balance on DP", String.format("PHP %,.2f", netDp)});
        model.addRow(new Object[]{"DP Payable in (Months)", String.valueOf(dpMonths)});
        model.addRow(new Object[]{"Monthly DP Amortization", String.format("PHP %,.2f", dpAmort)});
        
        tableRFO.setModel(model);
    }

    private void buildRFOTablePagIbig() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"RFO Basic Turn Over (Pag-IBIG)", "Amount"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        double tcp = currentLot.getTcp();
        double rf = currentLot.getReservationFee();
        double hdmf = currentLot.getHdmfMaxLoan();
        double grossDp = controller.FinancialCalculator.getPagIbigGrossDP(tcp, hdmf);
        double netDp = controller.FinancialCalculator.getPagIbigNetDP(tcp, hdmf, rf);
        int dpMonths = 6; 
        double dpAmort = controller.FinancialCalculator.getDpAmortization(netDp, dpMonths);

        model.addRow(new Object[]{"Total Contract Price (TCP)", String.format("PHP %,.2f", tcp)});
        model.addRow(new Object[]{"Loanable Amount (Max)", String.format("PHP %,.2f", controller.FinancialCalculator.getPagIbigLoanable(tcp, hdmf))});
        model.addRow(new Object[]{"Gross Equity / Downpayment", String.format("PHP %,.2f", grossDp)});
        model.addRow(new Object[]{"Less: Reservation Fee", String.format("PHP %,.2f", rf)});
        model.addRow(new Object[]{"Balance on Equity", String.format("PHP %,.2f", netDp)});
        model.addRow(new Object[]{"Equity Payable in (Months)", String.valueOf(dpMonths)});
        model.addRow(new Object[]{"Monthly Equity Amortization", String.format("PHP %,.2f", dpAmort)});
        
        tableRFO.setModel(model);
    }

    // --- TABLE 3: LOANABLE AMOUNT ---
    private void buildLoanTableCash() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"Terms", "Monthly Amortization", "Required NDI"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        model.addRow(new Object[]{"Spot Cash", "N/A", "N/A"});
        model.addRow(new Object[]{"Payable within 30 days", "", ""});
        tableLoan.setModel(model);
    }

    private void buildLoanTableBank(String bankName) {
        double rate = bankName.equals("Bank - BPI") ? 0.07 : 0.065;
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {String.format("Loanable Amount (%s @ %.2f%%)", bankName, rate * 100), "Monthly Amortization", "Required NDI"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        double tcp = currentLot.getTcp();
        int[] terms = {5, 10, 15, 20}; // Bank max is 20 years
        
        for (int years : terms) {
            double ma = controller.FinancialCalculator.getBankMonthlyAmortization(tcp, rate, years);
            double ndi = controller.FinancialCalculator.getRequiredNDI(ma);
            model.addRow(new Object[]{years + " Years", String.format("PHP %,.2f", ma), String.format("PHP %,.2f", ndi)});
        }
        tableLoan.setModel(model);
    }

    private void buildLoanTablePagIbig() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"Loanable Amount (Pag-IBIG @ 6.38%)", "Monthly Amortization", "Required NDI"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        double tcp = currentLot.getTcp();
        double hdmf = currentLot.getHdmfMaxLoan();
        int[] terms = {5, 10, 15, 20, 25, 30}; // Pag-IBIG max is 30 years
        
        for (int years : terms) {
            double ma = controller.FinancialCalculator.getPagIbigMonthlyAmortization(tcp, hdmf, years);
            double ndi = controller.FinancialCalculator.getRequiredNDI(ma);
            model.addRow(new Object[]{years + " Years", String.format("PHP %,.2f", ma), String.format("PHP %,.2f", ndi)});
        }
        tableLoan.setModel(model);
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
        tableRFO = new javax.swing.JTable();
        financingComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLoan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLotInfo = new javax.swing.JTable();

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
        ActionButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ActionButton1.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton1.setText("Reserve");
        ActionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton1ActionPerformed(evt);
            }
        });
        LotDetails.add(ActionButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 680, 120, 35));

        ActionButton2.setBackground(new java.awt.Color(0, 153, 0));
        ActionButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ActionButton2.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton2.setText("Buy");
        ActionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton2ActionPerformed(evt);
            }
        });
        LotDetails.add(ActionButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 680, 120, 35));

        ActionButton3.setBackground(new java.awt.Color(255, 98, 96));
        ActionButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ActionButton3.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton3.setText("Sell");
        ActionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton3ActionPerformed(evt);
            }
        });
        LotDetails.add(ActionButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 120, 35));

        tableRFO.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableRFO);

        LotDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 670, 140));

        financingComboBox.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        financingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spot Cash", "Bank", "Pag-IBIG" }));
        financingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financingComboBoxActionPerformed(evt);
            }
        });
        LotDetails.add(financingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 130, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Financing:");
        LotDetails.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        tableLoan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableLoan);

        LotDetails.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 670, 140));

        tableLotInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tableLotInfo);

        LotDetails.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 670, 140));

        getContentPane().add(LotDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 740));

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

    private void ActionButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActionButton1ActionPerformed

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableLoan;
    private javax.swing.JTable tableLotInfo;
    private javax.swing.JTable tableRFO;
    // End of variables declaration//GEN-END:variables
}
