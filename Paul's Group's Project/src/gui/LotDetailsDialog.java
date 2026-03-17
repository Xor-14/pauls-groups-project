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
            btnReserve.setVisible(false); 
            btnBuy.setVisible(false); 
            btnSell.setVisible(false); 
        } else {
            btnSell.setVisible(false); 
        }

        updateFinancingTable(); 
        
        // Utilize ItemListener for robust dropdown event detection
        financingComboBox.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                updateFinancingTable();
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
        double rf = controller.FinanceManager.getInstance().getReservationFee();
        double grossDp = controller.FinancialCalculator.calculateDownPayment(tcp);
        double netDp = grossDp - rf;
        int dpMonths = 6; 
        double dpAmort = netDp / dpMonths;

        model.addRow(new Object[]{"Total Contract Price (TCP)", String.format("PHP %,.2f", tcp)});
        model.addRow(new Object[]{"Downpayment %", String.format("%.0f%%", controller.FinanceManager.getInstance().getDownPaymentPercent() * 100)});
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
        double rf = controller.FinanceManager.getInstance().getReservationFee();
        double grossDp = controller.FinancialCalculator.calculateDownPayment(tcp);
        
        double tempLoanable = tcp - grossDp;
        double maxLoan = controller.FinanceManager.getInstance().getPagIbigMaxLoan();
        if (tempLoanable > maxLoan) {
            grossDp += (tempLoanable - maxLoan);
        }
        
        double netDp = grossDp - rf;
        int dpMonths = 6; 
        double dpAmort = netDp / dpMonths;

        model.addRow(new Object[]{"Total Contract Price (TCP)", String.format("PHP %,.2f", tcp)});
        model.addRow(new Object[]{"Loanable Amount (Max)", String.format("PHP %,.2f", Math.min(tempLoanable, maxLoan))});
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

    private void buildLoanTableBank(String selectedFinancing) {
        String bankName = "BDO";
        if (selectedFinancing.contains("BPI")) bankName = "BPI";
        else if (selectedFinancing.contains("RCBC")) bankName = "RCBC";
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"Loanable Amount (" + bankName + ")", "Monthly Amortization", "Required NDI"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        double tcp = currentLot.getTcp();
        double grossDp = controller.FinancialCalculator.calculateDownPayment(tcp);
        double loanable = controller.FinancialCalculator.calculateLoanableAmount(tcp, grossDp);
        int[] terms = {5, 10, 15, 20}; 
        
        for (int years : terms) {
            double ma = controller.FinancialCalculator.calculateMonthlyAmortization(loanable, years, "Bank", bankName);
            double ndi = ma / 0.30; 
            model.addRow(new Object[]{years + " Years", String.format("PHP %,.2f", ma), String.format("PHP %,.2f", ndi)});
        }
        tableLoan.setModel(model);
    }

    private void buildLoanTablePagIbig() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"Loanable Amount (Pag-IBIG)", "Monthly Amortization", "Required NDI"}
        ) { @Override public boolean isCellEditable(int row, int column) { return false; } };
        
        double tcp = currentLot.getTcp();
        double grossDp = controller.FinancialCalculator.calculateDownPayment(tcp);
        double loanable = controller.FinancialCalculator.calculateLoanableAmount(tcp, grossDp);
        
        double maxLoan = controller.FinanceManager.getInstance().getPagIbigMaxLoan();
        if (loanable > maxLoan) loanable = maxLoan;

        int[] terms = {5, 10, 15, 20, 25, 30}; 
        
        for (int years : terms) {
            double ma = controller.FinancialCalculator.calculateMonthlyAmortization(loanable, years, "Pag-IBIG", "N/A");
            double ndi = ma / 0.30; 
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
        btnReserve = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
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

        btnReserve.setBackground(new java.awt.Color(0, 78, 122));
        btnReserve.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnReserve.setText("Reserve");
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });
        LotDetails.add(btnReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 630, 120, 35));

        btnBuy.setBackground(new java.awt.Color(0, 153, 0));
        btnBuy.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });
        LotDetails.add(btnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, 120, 35));

        btnSell.setBackground(new java.awt.Color(255, 98, 96));
        btnSell.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSell.setForeground(new java.awt.Color(255, 255, 255));
        btnSell.setText("Sell");
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });
        LotDetails.add(btnSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 120, 35));

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

        LotDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 610, 140));

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

        LotDetails.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 610, 150));

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

        LotDetails.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 610, 110));

        getContentPane().add(LotDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
        if (currentLot == null) return;
        if (!currentLot.getStatus().equalsIgnoreCase("Available")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lot is not available for purchase.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedFinancing = financingComboBox.getSelectedItem() != null ? financingComboBox.getSelectedItem().toString() : "Spot Cash";
        
        double tcp = currentLot.getTcp();
        double reservationFee = controller.FinanceManager.getInstance().getReservationFee();
        double grossDp = controller.FinancialCalculator.calculateDownPayment(tcp);
        double loanableAmount = controller.FinancialCalculator.calculateLoanableAmount(tcp, grossDp);
        
        double amountToPay;
        double monthlyAmortization = 0.0;
        String financingTypeForTransaction = selectedFinancing;

        // Execute complex flow if financing is required
        if (selectedFinancing.contains("Bank") || selectedFinancing.contains("Pag-IBIG")) {
            Integer[] terms = selectedFinancing.contains("Bank") ? new Integer[]{5, 10, 15, 20} : new Integer[]{5, 10, 15, 20, 25, 30};
            Integer defaultTerm = selectedFinancing.contains("Bank") ? 20 : 30;

            Integer selectedTerm = (Integer) javax.swing.JOptionPane.showInputDialog(this, 
                    "Select Loan Term (Years):", "Term Selection", 
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null, terms, defaultTerm);
            
            if (selectedTerm == null) return;

            String bankName = "N/A";
            String baseFinancing = "Pag-IBIG";
            
            if (selectedFinancing.contains("Bank")) {
                baseFinancing = "Bank";
                if (selectedFinancing.contains("BDO")) bankName = "BDO";
                else if (selectedFinancing.contains("BPI")) bankName = "BPI";
                else if (selectedFinancing.contains("RCBC")) bankName = "RCBC";
            } else {
                double maxLoan = controller.FinanceManager.getInstance().getPagIbigMaxLoan();
                if (loanableAmount > maxLoan) loanableAmount = maxLoan;
            }

            amountToPay = grossDp - reservationFee;
            monthlyAmortization = controller.FinancialCalculator.calculateMonthlyAmortization(loanableAmount, selectedTerm, baseFinancing, bankName);
            financingTypeForTransaction = selectedFinancing + " (" + selectedTerm + " Yrs)";

            // Income Validation UI
            javax.swing.JPanel promptPanel = new javax.swing.JPanel(new java.awt.GridLayout(2, 2, 5, 5));
            promptPanel.add(new javax.swing.JLabel("Gross Monthly Income (PHP):"));
            javax.swing.JTextField incomeField = new javax.swing.JTextField();
            promptPanel.add(incomeField);
            promptPanel.add(new javax.swing.JLabel("Employment Type:"));
            javax.swing.JComboBox<String> empBox = new javax.swing.JComboBox<>(new String[]{"Locally Employed", "OFW", "Self-Employed"});
            promptPanel.add(empBox);

            if (javax.swing.JOptionPane.showConfirmDialog(this, promptPanel, "Financing Requirements", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.PLAIN_MESSAGE) != javax.swing.JOptionPane.OK_OPTION) return;

            try {
                double inputIncome = Double.parseDouble(incomeField.getText().replaceAll(",", ""));
                double requiredNDI = monthlyAmortization / 0.30; 

                if (inputIncome < requiredNDI) {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        String.format("Gross income (PHP %,.2f) does not meet the Required NDI (PHP %,.2f).", inputIncome, requiredNDI), 
                        "Financing Rejected", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid income format.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            amountToPay = tcp - reservationFee;
        }

        // Final Submission
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
            String.format("Financing: %s\nInitial Payment: PHP %,.2f\nMonthly Amortization: PHP %,.2f\n\nProceed with purchase request?", 
            financingTypeForTransaction, amountToPay, monthlyAmortization), 
            "Confirm Purchase Request", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            models.User currentUser = controller.UserManager.getInstance().getCurrentUser();
            boolean success = controller.TransactionManager.getInstance().requestTransaction(
                currentLot.getLotID(), currentUser.getId(), "Purchase", financingTypeForTransaction, amountToPay, monthlyAmortization);
            if(success) {
                javax.swing.JOptionPane.showMessageDialog(this, "Purchase Request Sent to Agent!");
                this.dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Transaction failed. Lot may be unavailable.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSellActionPerformed

    private void financingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financingComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_financingComboBoxActionPerformed

    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveActionPerformed
        // TODO add your handling code here:
        if (currentLot == null) return;
        
        if (currentLot.getStatus().equalsIgnoreCase("Available")) {
            models.User currentUser = controller.UserManager.getInstance().getCurrentUser();
            double reservationFee = controller.FinanceManager.getInstance().getReservationFee();
            
            boolean success = controller.TransactionManager.getInstance().requestTransaction(
                    currentLot.getLotID(), currentUser.getId(), "Reservation", "None", reservationFee, 0.0);
            
            if(success) {
                javax.swing.JOptionPane.showMessageDialog(this, "Reservation Request Sent to Agent!");
                this.dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Reservation failed. Lot may be unavailable.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Lot is not available for reservation.");
        }
    }//GEN-LAST:event_btnReserveActionPerformed

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
    private javax.swing.JLabel Info1;
    private javax.swing.JLabel Info2;
    private javax.swing.JLabel Info3;
    private javax.swing.JPanel LotDetails;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnReserve;
    private javax.swing.JButton btnSell;
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
