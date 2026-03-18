/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JScrollBar;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComponent;
import controller.EstateManager;
import models.Lot;
import java.util.List;

/**
 *
 * @author xor
 */
public class BuyerDashboard extends javax.swing.JFrame {
    
     /**
     * 
     */ 
    private LotFilterPanel customFilterPanel;
    
   /** 
    * Colors
     */ 
   Color clickedcolor, entered, normal;
   Color occupied = new Color(255,98,96);
   Color reserved = new Color(0, 78, 122);
   Color vacant = new Color(0,153,0);
        
   /** 
    * Creating Lots Status (Buttons) for future reference
     */ 
   public void setLotStatus(JButton btn, String status){

    btn.setOpaque(true);

    switch(status){

        case "Vacant":
            btn.setBackground(vacant);
            break;

        case "Reserved":
            btn.setBackground(reserved);
            break;

        case "Occupied":
            btn.setBackground(occupied);
            break;

    }

}
      // sample database for testing filters
   
    JButton[][] lotButtons = new JButton[5][20];
    private void mapButtons(){

    // BLOCK 1
    lotButtons[0][0] = b1_l1;
    lotButtons[0][1] = b1_l2;
    lotButtons[0][2] = b1_l3;
    lotButtons[0][3] = b1_l4;
    lotButtons[0][4] = b1_l5;
    lotButtons[0][5] = b1_l6;
    lotButtons[0][6] = b1_l7;
    lotButtons[0][7] = b1_l8;
    lotButtons[0][8] = b1_l9;
    lotButtons[0][9] = b1_l10;
    lotButtons[0][10] = b1_l11;
    lotButtons[0][11] = b1_l12;
    lotButtons[0][12] = b1_l13;
    lotButtons[0][13] = b1_l14;
    lotButtons[0][14] = b1_l15;
    lotButtons[0][15] = b1_l16;
    lotButtons[0][16] = b1_l17;
    lotButtons[0][17] = b1_l18;
    lotButtons[0][18] = b1_l19;
    lotButtons[0][19] = b1_l20;

    // BLOCK 2
    lotButtons[1][0] = b2_l1;
    lotButtons[1][1] = b2_l2;
    lotButtons[1][2] = b2_l3;
    lotButtons[1][3] = b2_l4;
    lotButtons[1][4] = b2_l5;
    lotButtons[1][5] = b2_l6;
    lotButtons[1][6] = b2_l7;
    lotButtons[1][7] = b2_l8;
    lotButtons[1][8] = b2_l9;
    lotButtons[1][9] = b2_l10;
    lotButtons[1][10] = b2_l11;
    lotButtons[1][11] = b2_l12;
    lotButtons[1][12] = b2_l13;
    lotButtons[1][13] = b2_l14;
    lotButtons[1][14] = b2_l15;
    lotButtons[1][15] = b2_l16;
    lotButtons[1][16] = b2_l17;
    lotButtons[1][17] = b2_l18;
    lotButtons[1][18] = b2_l19;
    lotButtons[1][19] = b2_l20;

    // BLOCK 3
    lotButtons[2][0] = b3_l1;
    lotButtons[2][1] = b3_l2;
    lotButtons[2][2] = b3_l3;
    lotButtons[2][3] = b3_l4;
    lotButtons[2][4] = b3_l5;
    lotButtons[2][5] = b3_l6;
    lotButtons[2][6] = b3_l7;
    lotButtons[2][7] = b3_l8;
    lotButtons[2][8] = b3_l9;
    lotButtons[2][9] = b3_l10;
    lotButtons[2][10] = b3_l11;
    lotButtons[2][11] = b3_l12;
    lotButtons[2][12] = b3_l13;
    lotButtons[2][13] = b3_l14;
    lotButtons[2][14] = b3_l15;
    lotButtons[2][15] = b3_l16;
    lotButtons[2][16] = b3_l17;
    lotButtons[2][17] = b3_l18;
    lotButtons[2][18] = b3_l19;
    lotButtons[2][19] = b3_l20;

    // BLOCK 4
    lotButtons[3][0] = b4_l1;
    lotButtons[3][1] = b4_l2;
    lotButtons[3][2] = b4_l3;
    lotButtons[3][3] = b4_l4;
    lotButtons[3][4] = b4_l5;
    lotButtons[3][5] = b4_l6;
    lotButtons[3][6] = b4_l7;
    lotButtons[3][7] = b4_l8;
    lotButtons[3][8] = b4_l9;
    lotButtons[3][9] = b4_l10;
    lotButtons[3][10] = b4_l11;
    lotButtons[3][11] = b4_l12;
    lotButtons[3][12] = b4_l13;
    lotButtons[3][13] = b4_l14;
    lotButtons[3][14] = b4_l15;
    lotButtons[3][15] = b4_l16;
    lotButtons[3][16] = b4_l17;
    lotButtons[3][17] = b4_l18;
    lotButtons[3][18] = b4_l19;
    lotButtons[3][19] = b4_l20;

    // BLOCK 5
    lotButtons[4][0] = b5_l1;
    lotButtons[4][1] = b5_l2;
    lotButtons[4][2] = b5_l3;
    lotButtons[4][3] = b5_l4;
    lotButtons[4][4] = b5_l5;
    lotButtons[4][5] = b5_l6;
    lotButtons[4][6] = b5_l7;
    lotButtons[4][7] = b5_l8;
    lotButtons[4][8] = b5_l9;
    lotButtons[4][9] = b5_l10;
    lotButtons[4][10] = b5_l11;
    lotButtons[4][11] = b5_l12;
    lotButtons[4][12] = b5_l13;
    lotButtons[4][13] = b5_l14;
    lotButtons[4][14] = b5_l15;
    lotButtons[4][15] = b5_l16;
    lotButtons[4][16] = b5_l17;
    lotButtons[4][17] = b5_l18;
    lotButtons[4][18] = b5_l19;
    lotButtons[4][19] = b5_l20;

}
    private void updateAllLotColors() {
        for (int b = 0; b < 5; b++) {
            for (int l = 0; l < 20; l++) {
                updateLotColor(b, l);
            }
        }
    }
    
    public void updateLotColor(int b, int l){
        JButton btn = lotButtons[b][l];
        int lotIndex = (b * 20) + l;
        Lot lot = EstateManager.getInstance().getAllLots().get(lotIndex);

        btn.setOpaque(true);

        String status = lot.getStatus();
        if(status.equalsIgnoreCase("Available")) {
            btn.setBackground(vacant);
        } else if(status.equalsIgnoreCase("Reserved")) {
            btn.setBackground(reserved);
        } else {
            btn.setBackground(occupied);
        }
        
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
    }
    
    public void applyFilters() {
    java.util.List<models.Lot> allLots = controller.EstateManager.getInstance().getAllLots();
    for (int b = 0; b < 5; b++) {
        for (int l = 0; l < 20; l++) {
            int lotIndex = (b * 20) + l;
            if (lotIndex < allLots.size()) 
                {
                    lotButtons[b][l].setVisible(customFilterPanel.evaluateLot(allLots.get(lotIndex)));
                }
            }
        }   
    }
    
    private void loadBuyerHistory() {
        models.Buyer buyer = (models.Buyer) controller.UserManager.getInstance().getCurrentUser();
        java.util.List<models.SaleTransaction> history = controller.TransactionManager.getInstance().getTransactionsByUser(buyer.getId(), "Buyer");
        
        // Prevent cells from being manually edited by the user
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Trans. ID", "Date", "Lot ID", "Type", "Financing", "Amount", "Status"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        for (models.SaleTransaction t : history) {
            model.addRow(new Object[]{
                t.getTransactionID(), t.getDate(), t.getLotID(), 
                t.getType(), t.getFinancingType(), String.format("PHP %,.2f", t.getAmount()), t.getStatus()
            });
        }
        buyerHistoryTable.setModel(model);
    }
    
    public BuyerDashboard() {
        initComponents();
        customFilterPanel = new LotFilterPanel(this::applyFilters);
        Lots.add(customFilterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 130));
        mapButtons();
        
        // Backend integration replacements
        attachButtonListeners();
        updateAllLotColors();
        loadBuyerHistory();
        
        clickedcolor = new Color(0,0,0);
        entered = new Color(110, 110, 110);
        normal = new Color(255,255,255);
        
        loadProfileData();
    }
    
    private void attachButtonListeners() {
        List<Lot> allLots = EstateManager.getInstance().getAllLots();
        
        for(int b = 0; b < 5; b++) {
            for(int l = 0; l < 20; l++) {
                // Calculate the 1D list index (0-99) from the 2D grid coordinates
                int lotIndex = (b * 20) + l;
                if (lotIndex >= allLots.size()) break; // Safety check
                
                Lot lot = allLots.get(lotIndex);
                JButton btn = lotButtons[b][l];
                
                int finalB = b;
                int finalL = l;
                
                // Attach click event
                btn.addActionListener(e -> {
                    // Pass the specific Lot object to the dialog
                    LotDetailsDialog dialog = new LotDetailsDialog(this, true, lot);
                    dialog.setLocationRelativeTo(this);
                    dialog.setVisible(true);
                    
                    // Refresh color when dialog closes in case user reserved it
                    updateLotColor(finalB, finalL);
                });
            }
        }
    }
 
    private void refreshDashboard() {
        controller.EstateManager.getInstance().refreshData();
        updateAllLotColors();
        applyFilters();
        loadBuyerHistory();
    }
    
    private void loadProfileData() {
        models.User currentUser = controller.UserManager.getInstance().getCurrentUser();
        
        if (currentUser != null) {
            FirstName.setText(currentUser.getFirstName());
            LastName.setText(currentUser.getLastName());
            email.setText(currentUser.getEmail());
            password.setText(currentUser.getPassword());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BuyerSideBar = new javax.swing.JPanel();
        DashboardLabel = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        GroupName1 = new javax.swing.JLabel();
        viewLots = new javax.swing.JButton();
        reqComputation = new javax.swing.JButton();
        transaction = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        viewProfile = new javax.swing.JButton();
        MainContentBuyer = new javax.swing.JTabbedPane();
        Lots = new javax.swing.JPanel();
        lotsOverview = new javax.swing.JScrollPane();
        lotsView = new javax.swing.JPanel();
        Block1 = new javax.swing.JLabel();
        Block1Grid = new javax.swing.JPanel();
        b1_l1 = new javax.swing.JButton();
        b1_l2 = new javax.swing.JButton();
        b1_l3 = new javax.swing.JButton();
        b1_l4 = new javax.swing.JButton();
        b1_l5 = new javax.swing.JButton();
        b1_l6 = new javax.swing.JButton();
        b1_l7 = new javax.swing.JButton();
        b1_l8 = new javax.swing.JButton();
        b1_l9 = new javax.swing.JButton();
        b1_l10 = new javax.swing.JButton();
        b1_l11 = new javax.swing.JButton();
        b1_l12 = new javax.swing.JButton();
        b1_l13 = new javax.swing.JButton();
        b1_l14 = new javax.swing.JButton();
        b1_l15 = new javax.swing.JButton();
        b1_l16 = new javax.swing.JButton();
        b1_l17 = new javax.swing.JButton();
        b1_l18 = new javax.swing.JButton();
        b1_l19 = new javax.swing.JButton();
        b1_l20 = new javax.swing.JButton();
        Block2 = new javax.swing.JLabel();
        Block2Grid = new javax.swing.JPanel();
        b2_l1 = new javax.swing.JButton();
        b2_l2 = new javax.swing.JButton();
        b2_l3 = new javax.swing.JButton();
        b2_l4 = new javax.swing.JButton();
        b2_l5 = new javax.swing.JButton();
        b2_l6 = new javax.swing.JButton();
        b2_l7 = new javax.swing.JButton();
        b2_l8 = new javax.swing.JButton();
        b2_l9 = new javax.swing.JButton();
        b2_l10 = new javax.swing.JButton();
        b2_l11 = new javax.swing.JButton();
        b2_l12 = new javax.swing.JButton();
        b2_l13 = new javax.swing.JButton();
        b2_l14 = new javax.swing.JButton();
        b2_l15 = new javax.swing.JButton();
        b2_l16 = new javax.swing.JButton();
        b2_l17 = new javax.swing.JButton();
        b2_l18 = new javax.swing.JButton();
        b2_l19 = new javax.swing.JButton();
        b2_l20 = new javax.swing.JButton();
        Block3 = new javax.swing.JLabel();
        Block3Grid = new javax.swing.JPanel();
        b3_l1 = new javax.swing.JButton();
        b3_l2 = new javax.swing.JButton();
        b3_l3 = new javax.swing.JButton();
        b3_l4 = new javax.swing.JButton();
        b3_l5 = new javax.swing.JButton();
        b3_l6 = new javax.swing.JButton();
        b3_l7 = new javax.swing.JButton();
        b3_l8 = new javax.swing.JButton();
        b3_l9 = new javax.swing.JButton();
        b3_l10 = new javax.swing.JButton();
        b3_l11 = new javax.swing.JButton();
        b3_l12 = new javax.swing.JButton();
        b3_l13 = new javax.swing.JButton();
        b3_l14 = new javax.swing.JButton();
        b3_l15 = new javax.swing.JButton();
        b3_l16 = new javax.swing.JButton();
        b3_l17 = new javax.swing.JButton();
        b3_l18 = new javax.swing.JButton();
        b3_l19 = new javax.swing.JButton();
        b3_l20 = new javax.swing.JButton();
        Block4 = new javax.swing.JLabel();
        Block4Grid = new javax.swing.JPanel();
        b4_l1 = new javax.swing.JButton();
        b4_l2 = new javax.swing.JButton();
        b4_l3 = new javax.swing.JButton();
        b4_l4 = new javax.swing.JButton();
        b4_l5 = new javax.swing.JButton();
        b4_l6 = new javax.swing.JButton();
        b4_l7 = new javax.swing.JButton();
        b4_l8 = new javax.swing.JButton();
        b4_l9 = new javax.swing.JButton();
        b4_l10 = new javax.swing.JButton();
        b4_l11 = new javax.swing.JButton();
        b4_l12 = new javax.swing.JButton();
        b4_l13 = new javax.swing.JButton();
        b4_l14 = new javax.swing.JButton();
        b4_l15 = new javax.swing.JButton();
        b4_l16 = new javax.swing.JButton();
        b4_l17 = new javax.swing.JButton();
        b4_l18 = new javax.swing.JButton();
        b4_l19 = new javax.swing.JButton();
        b4_l20 = new javax.swing.JButton();
        Block5 = new javax.swing.JLabel();
        Block5Grid = new javax.swing.JPanel();
        b5_l1 = new javax.swing.JButton();
        b5_l2 = new javax.swing.JButton();
        b5_l3 = new javax.swing.JButton();
        b5_l4 = new javax.swing.JButton();
        b5_l5 = new javax.swing.JButton();
        b5_l6 = new javax.swing.JButton();
        b5_l7 = new javax.swing.JButton();
        b5_l8 = new javax.swing.JButton();
        b5_l9 = new javax.swing.JButton();
        b5_l10 = new javax.swing.JButton();
        b5_l11 = new javax.swing.JButton();
        b5_l12 = new javax.swing.JButton();
        b5_l13 = new javax.swing.JButton();
        b5_l14 = new javax.swing.JButton();
        b5_l15 = new javax.swing.JButton();
        b5_l16 = new javax.swing.JButton();
        b5_l17 = new javax.swing.JButton();
        b5_l18 = new javax.swing.JButton();
        b5_l19 = new javax.swing.JButton();
        b5_l20 = new javax.swing.JButton();
        Transactions = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        buyerHistoryTable = new javax.swing.JTable();
        Computation = new javax.swing.JPanel();
        Title1 = new javax.swing.JLabel();
        computationOverview = new javax.swing.JScrollPane();
        computation = new javax.swing.JPanel();
        computation1 = new javax.swing.JPanel();
        computationTitle = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        InfoText1 = new javax.swing.JTextField();
        info2 = new javax.swing.JLabel();
        InfoText2 = new javax.swing.JTextField();
        info3 = new javax.swing.JLabel();
        InfoText3 = new javax.swing.JTextField();
        info4 = new javax.swing.JLabel();
        InfoText4 = new javax.swing.JTextField();
        computation3 = new javax.swing.JPanel();
        computationTitle2 = new javax.swing.JLabel();
        info9 = new javax.swing.JLabel();
        InfoText9 = new javax.swing.JTextField();
        info10 = new javax.swing.JLabel();
        InfoText10 = new javax.swing.JTextField();
        info11 = new javax.swing.JLabel();
        InfoText11 = new javax.swing.JTextField();
        info12 = new javax.swing.JLabel();
        InfoText12 = new javax.swing.JTextField();
        computation4 = new javax.swing.JPanel();
        computationTitle3 = new javax.swing.JLabel();
        info13 = new javax.swing.JLabel();
        InfoText13 = new javax.swing.JTextField();
        info14 = new javax.swing.JLabel();
        InfoText14 = new javax.swing.JTextField();
        info15 = new javax.swing.JLabel();
        InfoText15 = new javax.swing.JTextField();
        info16 = new javax.swing.JLabel();
        InfoText16 = new javax.swing.JTextField();
        Profile = new javax.swing.JPanel();
        Title2 = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();
        lastName = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        change = new javax.swing.JButton();
        bgimg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1279, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BuyerSideBar.setBackground(new java.awt.Color(30, 30, 30));
        BuyerSideBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BuyerSideBar.setFocusable(false);
        BuyerSideBar.setMaximumSize(new java.awt.Dimension(1280, 92));
        BuyerSideBar.setMinimumSize(new java.awt.Dimension(1280, 92));
        BuyerSideBar.setPreferredSize(new java.awt.Dimension(1280, 92));
        BuyerSideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashboardLabel.setFont(new java.awt.Font("New Peninim MT", 1, 36)); // NOI18N
        DashboardLabel.setForeground(new java.awt.Color(255, 255, 255));
        DashboardLabel.setText("<html>Buyer's<br>Dashboard</html>");
        BuyerSideBar.add(DashboardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 610, 260, 90));

        Logo.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        Logo.setForeground(new java.awt.Color(255, 255, 255));
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/miniLogo.png"))); // NOI18N
        BuyerSideBar.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 90));

        GroupName1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        GroupName1.setForeground(new java.awt.Color(130, 159, 120));
        GroupName1.setText("C R E A M S");
        BuyerSideBar.add(GroupName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 524, 30));

        viewLots.setBackground(new java.awt.Color(0, 0, 0));
        viewLots.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        viewLots.setForeground(new java.awt.Color(255, 255, 255));
        viewLots.setText("   View Lots");
        viewLots.setAlignmentY(0.0F);
        viewLots.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        viewLots.setBorderPainted(false);
        viewLots.setContentAreaFilled(false);
        viewLots.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        viewLots.setFocusPainted(false);
        viewLots.setFocusable(false);
        viewLots.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        viewLots.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        viewLots.setIconTextGap(0);
        viewLots.setMargin(new java.awt.Insets(14, 14, 14, 14));
        viewLots.setSelected(true);
        viewLots.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewLotsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewLotsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewLotsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                viewLotsMousePressed(evt);
            }
        });
        viewLots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLotsActionPerformed(evt);
            }
        });
        BuyerSideBar.add(viewLots, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 280, 40));

        reqComputation.setBackground(new java.awt.Color(0, 0, 0));
        reqComputation.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        reqComputation.setForeground(new java.awt.Color(255, 255, 255));
        reqComputation.setText("   Computation");
        reqComputation.setAlignmentY(0.0F);
        reqComputation.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        reqComputation.setBorderPainted(false);
        reqComputation.setContentAreaFilled(false);
        reqComputation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        reqComputation.setFocusPainted(false);
        reqComputation.setFocusable(false);
        reqComputation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reqComputation.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        reqComputation.setIconTextGap(0);
        reqComputation.setMargin(new java.awt.Insets(14, 14, 14, 14));
        reqComputation.setSelected(true);
        reqComputation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reqComputationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reqComputationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reqComputationMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reqComputationMousePressed(evt);
            }
        });
        reqComputation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqComputationActionPerformed(evt);
            }
        });
        BuyerSideBar.add(reqComputation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 280, 40));

        transaction.setBackground(new java.awt.Color(0, 0, 0));
        transaction.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        transaction.setForeground(new java.awt.Color(255, 255, 255));
        transaction.setText("   Transactions");
        transaction.setAlignmentY(0.0F);
        transaction.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        transaction.setBorderPainted(false);
        transaction.setContentAreaFilled(false);
        transaction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        transaction.setFocusPainted(false);
        transaction.setFocusable(false);
        transaction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transaction.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        transaction.setIconTextGap(0);
        transaction.setMargin(new java.awt.Insets(14, 14, 14, 14));
        transaction.setSelected(true);
        transaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionMouseExited(evt);
            }
        });
        transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionActionPerformed(evt);
            }
        });
        BuyerSideBar.add(transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 280, 40));

        logOut.setBackground(new java.awt.Color(0, 0, 0));
        logOut.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        logOut.setForeground(new java.awt.Color(255, 255, 255));
        logOut.setText("   Logout");
        logOut.setAlignmentY(0.0F);
        logOut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        logOut.setBorderPainted(false);
        logOut.setContentAreaFilled(false);
        logOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logOut.setFocusPainted(false);
        logOut.setFocusable(false);
        logOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logOut.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        logOut.setIconTextGap(0);
        logOut.setMargin(new java.awt.Insets(14, 14, 14, 14));
        logOut.setSelected(true);
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutMouseExited(evt);
            }
        });
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        BuyerSideBar.add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 280, 40));

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        BuyerSideBar.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, -1));

        viewProfile.setBackground(new java.awt.Color(0, 0, 0));
        viewProfile.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        viewProfile.setForeground(new java.awt.Color(255, 255, 255));
        viewProfile.setText("   View Profile");
        viewProfile.setAlignmentY(0.0F);
        viewProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        viewProfile.setBorderPainted(false);
        viewProfile.setContentAreaFilled(false);
        viewProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        viewProfile.setFocusPainted(false);
        viewProfile.setFocusable(false);
        viewProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        viewProfile.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        viewProfile.setIconTextGap(0);
        viewProfile.setMargin(new java.awt.Insets(14, 14, 14, 14));
        viewProfile.setSelected(true);
        viewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewProfileMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                viewProfileMousePressed(evt);
            }
        });
        viewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfileActionPerformed(evt);
            }
        });
        BuyerSideBar.add(viewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 380, 40));

        getContentPane().add(BuyerSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 720));

        Lots.setBackground(new java.awt.Color(30, 30, 30));
        Lots.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lotsOverview.setBackground(new java.awt.Color(30, 30, 30));
        lotsOverview.setBorder(null);
        javax.swing.JScrollBar verticalBar = lotsOverview.getVerticalScrollBar();
        verticalBar.setPreferredSize(new java.awt.Dimension(8,0));
        verticalBar.setUnitIncrement(24);

        verticalBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                this.trackColor = new java.awt.Color(30,30,30);
                this.thumbColor = new java.awt.Color(120,120,120);
            }

            @Override
            protected javax.swing.JButton createDecreaseButton(int orientation) {
                javax.swing.JButton button = new javax.swing.JButton();
                button.setBackground(new java.awt.Color(30,30,30));
                button.setBorder(null);
                return button;
            }

            @Override
            protected javax.swing.JButton createIncreaseButton(int orientation) {
                javax.swing.JButton button = new javax.swing.JButton();
                button.setBackground(new java.awt.Color(30,30,30));
                button.setBorder(null);
                return button;
            }

        });

        lotsView.setBackground(new java.awt.Color(30, 30, 30));
        lotsView.setMinimumSize(new java.awt.Dimension(930, 1058));
        lotsView.setPreferredSize(new java.awt.Dimension(930, 1058));
        lotsView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Block1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Block1.setForeground(new java.awt.Color(255, 255, 255));
        Block1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Block1.setText("Block 1");
        lotsView.add(Block1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 43, 340, 30));

        Block1Grid.setBackground(new java.awt.Color(51, 51, 51));
        Block1Grid.setForeground(new java.awt.Color(153, 153, 153));
        Block1Grid.setLayout(new java.awt.GridLayout(4, 5));

        b1_l1.setBackground(new java.awt.Color(102, 153, 0));
        b1_l1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l1.setForeground(new java.awt.Color(255, 255, 255));
        b1_l1.setText("L1");
        Block1Grid.add(b1_l1);

        b1_l2.setBackground(new java.awt.Color(102, 153, 0));
        b1_l2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l2.setForeground(new java.awt.Color(255, 255, 255));
        b1_l2.setText("L2");
        Block1Grid.add(b1_l2);

        b1_l3.setBackground(new java.awt.Color(102, 153, 0));
        b1_l3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l3.setForeground(new java.awt.Color(255, 255, 255));
        b1_l3.setText("L3");
        Block1Grid.add(b1_l3);

        b1_l4.setBackground(new java.awt.Color(102, 153, 0));
        b1_l4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l4.setForeground(new java.awt.Color(255, 255, 255));
        b1_l4.setText("L4");
        Block1Grid.add(b1_l4);

        b1_l5.setBackground(new java.awt.Color(102, 153, 0));
        b1_l5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l5.setForeground(new java.awt.Color(255, 255, 255));
        b1_l5.setText("L5");
        Block1Grid.add(b1_l5);

        b1_l6.setBackground(new java.awt.Color(102, 153, 0));
        b1_l6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l6.setForeground(new java.awt.Color(255, 255, 255));
        b1_l6.setText("L6");
        Block1Grid.add(b1_l6);

        b1_l7.setBackground(new java.awt.Color(102, 153, 0));
        b1_l7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l7.setForeground(new java.awt.Color(255, 255, 255));
        b1_l7.setText("L7");
        b1_l7.setToolTipText("");
        Block1Grid.add(b1_l7);

        b1_l8.setBackground(new java.awt.Color(102, 153, 0));
        b1_l8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l8.setForeground(new java.awt.Color(255, 255, 255));
        b1_l8.setText("L8");
        Block1Grid.add(b1_l8);

        b1_l9.setBackground(new java.awt.Color(102, 153, 0));
        b1_l9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l9.setForeground(new java.awt.Color(255, 255, 255));
        b1_l9.setText("L9");
        Block1Grid.add(b1_l9);

        b1_l10.setBackground(new java.awt.Color(102, 153, 0));
        b1_l10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l10.setForeground(new java.awt.Color(255, 255, 255));
        b1_l10.setText("L10");
        Block1Grid.add(b1_l10);

        b1_l11.setBackground(new java.awt.Color(102, 153, 0));
        b1_l11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l11.setForeground(new java.awt.Color(255, 255, 255));
        b1_l11.setText("L11");
        Block1Grid.add(b1_l11);

        b1_l12.setBackground(new java.awt.Color(102, 153, 0));
        b1_l12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l12.setForeground(new java.awt.Color(255, 255, 255));
        b1_l12.setText("L12");
        Block1Grid.add(b1_l12);

        b1_l13.setBackground(new java.awt.Color(102, 153, 0));
        b1_l13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l13.setForeground(new java.awt.Color(255, 255, 255));
        b1_l13.setText("L13");
        Block1Grid.add(b1_l13);

        b1_l14.setBackground(new java.awt.Color(102, 153, 0));
        b1_l14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l14.setForeground(new java.awt.Color(255, 255, 255));
        b1_l14.setText("L14");
        Block1Grid.add(b1_l14);

        b1_l15.setBackground(new java.awt.Color(102, 153, 0));
        b1_l15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l15.setForeground(new java.awt.Color(255, 255, 255));
        b1_l15.setText("L15");
        Block1Grid.add(b1_l15);

        b1_l16.setBackground(new java.awt.Color(102, 153, 0));
        b1_l16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l16.setForeground(new java.awt.Color(255, 255, 255));
        b1_l16.setText("L16");
        Block1Grid.add(b1_l16);

        b1_l17.setBackground(new java.awt.Color(102, 153, 0));
        b1_l17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l17.setForeground(new java.awt.Color(255, 255, 255));
        b1_l17.setText("L17");
        Block1Grid.add(b1_l17);

        b1_l18.setBackground(new java.awt.Color(102, 153, 0));
        b1_l18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l18.setForeground(new java.awt.Color(255, 255, 255));
        b1_l18.setText("L18");
        Block1Grid.add(b1_l18);

        b1_l19.setBackground(new java.awt.Color(102, 153, 0));
        b1_l19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l19.setForeground(new java.awt.Color(255, 255, 255));
        b1_l19.setText("L19");
        Block1Grid.add(b1_l19);

        b1_l20.setBackground(new java.awt.Color(102, 153, 0));
        b1_l20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1_l20.setForeground(new java.awt.Color(255, 255, 255));
        b1_l20.setText("L20");
        Block1Grid.add(b1_l20);

        lotsView.add(Block1Grid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 83, 890, 130));

        Block2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Block2.setForeground(new java.awt.Color(255, 255, 255));
        Block2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Block2.setText("Block 2");
        lotsView.add(Block2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 252, 340, 30));

        Block2Grid.setBackground(new java.awt.Color(51, 51, 51));
        Block2Grid.setLayout(new java.awt.GridLayout(4, 5));

        b2_l1.setBackground(new java.awt.Color(102, 153, 0));
        b2_l1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l1.setForeground(new java.awt.Color(255, 255, 255));
        b2_l1.setText("L1");
        Block2Grid.add(b2_l1);

        b2_l2.setBackground(new java.awt.Color(102, 153, 0));
        b2_l2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l2.setForeground(new java.awt.Color(255, 255, 255));
        b2_l2.setText("L2");
        Block2Grid.add(b2_l2);

        b2_l3.setBackground(new java.awt.Color(102, 153, 0));
        b2_l3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l3.setForeground(new java.awt.Color(255, 255, 255));
        b2_l3.setText("L3");
        Block2Grid.add(b2_l3);

        b2_l4.setBackground(new java.awt.Color(102, 153, 0));
        b2_l4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l4.setForeground(new java.awt.Color(255, 255, 255));
        b2_l4.setText("L4");
        Block2Grid.add(b2_l4);

        b2_l5.setBackground(new java.awt.Color(102, 153, 0));
        b2_l5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l5.setForeground(new java.awt.Color(255, 255, 255));
        b2_l5.setText("L5");
        Block2Grid.add(b2_l5);

        b2_l6.setBackground(new java.awt.Color(102, 153, 0));
        b2_l6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l6.setForeground(new java.awt.Color(255, 255, 255));
        b2_l6.setText("L6");
        Block2Grid.add(b2_l6);

        b2_l7.setBackground(new java.awt.Color(102, 153, 0));
        b2_l7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l7.setForeground(new java.awt.Color(255, 255, 255));
        b2_l7.setText("L7");
        Block2Grid.add(b2_l7);

        b2_l8.setBackground(new java.awt.Color(102, 153, 0));
        b2_l8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l8.setForeground(new java.awt.Color(255, 255, 255));
        b2_l8.setText("L8");
        Block2Grid.add(b2_l8);

        b2_l9.setBackground(new java.awt.Color(102, 153, 0));
        b2_l9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l9.setForeground(new java.awt.Color(255, 255, 255));
        b2_l9.setText("L9");
        Block2Grid.add(b2_l9);

        b2_l10.setBackground(new java.awt.Color(102, 153, 0));
        b2_l10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l10.setForeground(new java.awt.Color(255, 255, 255));
        b2_l10.setText("L10");
        Block2Grid.add(b2_l10);

        b2_l11.setBackground(new java.awt.Color(102, 153, 0));
        b2_l11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l11.setForeground(new java.awt.Color(255, 255, 255));
        b2_l11.setText("L11");
        Block2Grid.add(b2_l11);

        b2_l12.setBackground(new java.awt.Color(102, 153, 0));
        b2_l12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l12.setForeground(new java.awt.Color(255, 255, 255));
        b2_l12.setText("L12");
        Block2Grid.add(b2_l12);

        b2_l13.setBackground(new java.awt.Color(102, 153, 0));
        b2_l13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l13.setForeground(new java.awt.Color(255, 255, 255));
        b2_l13.setText("L13");
        Block2Grid.add(b2_l13);

        b2_l14.setBackground(new java.awt.Color(102, 153, 0));
        b2_l14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l14.setForeground(new java.awt.Color(255, 255, 255));
        b2_l14.setText("L14");
        Block2Grid.add(b2_l14);

        b2_l15.setBackground(new java.awt.Color(102, 153, 0));
        b2_l15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l15.setForeground(new java.awt.Color(255, 255, 255));
        b2_l15.setText("L15");
        Block2Grid.add(b2_l15);

        b2_l16.setBackground(new java.awt.Color(102, 153, 0));
        b2_l16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l16.setForeground(new java.awt.Color(255, 255, 255));
        b2_l16.setText("L16");
        Block2Grid.add(b2_l16);

        b2_l17.setBackground(new java.awt.Color(102, 153, 0));
        b2_l17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l17.setForeground(new java.awt.Color(255, 255, 255));
        b2_l17.setText("L17");
        Block2Grid.add(b2_l17);

        b2_l18.setBackground(new java.awt.Color(102, 153, 0));
        b2_l18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l18.setForeground(new java.awt.Color(255, 255, 255));
        b2_l18.setText("L18");
        Block2Grid.add(b2_l18);

        b2_l19.setBackground(new java.awt.Color(102, 153, 0));
        b2_l19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l19.setForeground(new java.awt.Color(255, 255, 255));
        b2_l19.setText("L19");
        Block2Grid.add(b2_l19);

        b2_l20.setBackground(new java.awt.Color(102, 153, 0));
        b2_l20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2_l20.setForeground(new java.awt.Color(255, 255, 255));
        b2_l20.setText("L20");
        Block2Grid.add(b2_l20);

        lotsView.add(Block2Grid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 292, 890, 130));

        Block3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Block3.setForeground(new java.awt.Color(255, 255, 255));
        Block3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Block3.setText("Block 3");
        lotsView.add(Block3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 451, 340, 30));

        Block3Grid.setBackground(new java.awt.Color(51, 51, 51));
        Block3Grid.setLayout(new java.awt.GridLayout(4, 5));

        b3_l1.setBackground(new java.awt.Color(102, 153, 0));
        b3_l1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l1.setForeground(new java.awt.Color(255, 255, 255));
        b3_l1.setText("L1");
        Block3Grid.add(b3_l1);

        b3_l2.setBackground(new java.awt.Color(102, 153, 0));
        b3_l2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l2.setForeground(new java.awt.Color(255, 255, 255));
        b3_l2.setText("L2");
        Block3Grid.add(b3_l2);

        b3_l3.setBackground(new java.awt.Color(102, 153, 0));
        b3_l3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l3.setForeground(new java.awt.Color(255, 255, 255));
        b3_l3.setText("L3");
        Block3Grid.add(b3_l3);

        b3_l4.setBackground(new java.awt.Color(102, 153, 0));
        b3_l4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l4.setForeground(new java.awt.Color(255, 255, 255));
        b3_l4.setText("L4");
        b3_l4.setToolTipText("");
        Block3Grid.add(b3_l4);

        b3_l5.setBackground(new java.awt.Color(102, 153, 0));
        b3_l5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l5.setForeground(new java.awt.Color(255, 255, 255));
        b3_l5.setText("L5");
        Block3Grid.add(b3_l5);

        b3_l6.setBackground(new java.awt.Color(102, 153, 0));
        b3_l6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l6.setForeground(new java.awt.Color(255, 255, 255));
        b3_l6.setText("L6");
        Block3Grid.add(b3_l6);

        b3_l7.setBackground(new java.awt.Color(102, 153, 0));
        b3_l7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l7.setForeground(new java.awt.Color(255, 255, 255));
        b3_l7.setText("L7");
        Block3Grid.add(b3_l7);

        b3_l8.setBackground(new java.awt.Color(102, 153, 0));
        b3_l8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l8.setForeground(new java.awt.Color(255, 255, 255));
        b3_l8.setText("L8");
        Block3Grid.add(b3_l8);

        b3_l9.setBackground(new java.awt.Color(102, 153, 0));
        b3_l9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l9.setForeground(new java.awt.Color(255, 255, 255));
        b3_l9.setText("L9");
        Block3Grid.add(b3_l9);

        b3_l10.setBackground(new java.awt.Color(102, 153, 0));
        b3_l10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l10.setForeground(new java.awt.Color(255, 255, 255));
        b3_l10.setText("L10");
        Block3Grid.add(b3_l10);

        b3_l11.setBackground(new java.awt.Color(102, 153, 0));
        b3_l11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l11.setForeground(new java.awt.Color(255, 255, 255));
        b3_l11.setText("L11");
        Block3Grid.add(b3_l11);

        b3_l12.setBackground(new java.awt.Color(102, 153, 0));
        b3_l12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l12.setForeground(new java.awt.Color(255, 255, 255));
        b3_l12.setText("L12");
        Block3Grid.add(b3_l12);

        b3_l13.setBackground(new java.awt.Color(102, 153, 0));
        b3_l13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l13.setForeground(new java.awt.Color(255, 255, 255));
        b3_l13.setText("L13");
        Block3Grid.add(b3_l13);

        b3_l14.setBackground(new java.awt.Color(102, 153, 0));
        b3_l14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l14.setForeground(new java.awt.Color(255, 255, 255));
        b3_l14.setText("L14");
        Block3Grid.add(b3_l14);

        b3_l15.setBackground(new java.awt.Color(102, 153, 0));
        b3_l15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l15.setForeground(new java.awt.Color(255, 255, 255));
        b3_l15.setText("L15");
        Block3Grid.add(b3_l15);

        b3_l16.setBackground(new java.awt.Color(102, 153, 0));
        b3_l16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l16.setForeground(new java.awt.Color(255, 255, 255));
        b3_l16.setText("L16");
        Block3Grid.add(b3_l16);

        b3_l17.setBackground(new java.awt.Color(102, 153, 0));
        b3_l17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l17.setForeground(new java.awt.Color(255, 255, 255));
        b3_l17.setText("L17");
        Block3Grid.add(b3_l17);

        b3_l18.setBackground(new java.awt.Color(102, 153, 0));
        b3_l18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l18.setForeground(new java.awt.Color(255, 255, 255));
        b3_l18.setText("L18");
        Block3Grid.add(b3_l18);

        b3_l19.setBackground(new java.awt.Color(102, 153, 0));
        b3_l19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l19.setForeground(new java.awt.Color(255, 255, 255));
        b3_l19.setText("L19");
        Block3Grid.add(b3_l19);

        b3_l20.setBackground(new java.awt.Color(102, 153, 0));
        b3_l20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b3_l20.setForeground(new java.awt.Color(255, 255, 255));
        b3_l20.setText("L20");
        b3_l20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3_l20ActionPerformed(evt);
            }
        });
        Block3Grid.add(b3_l20);

        lotsView.add(Block3Grid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 491, 890, 130));

        Block4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Block4.setForeground(new java.awt.Color(255, 255, 255));
        Block4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Block4.setText("Block 4");
        lotsView.add(Block4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 340, 30));

        Block4Grid.setBackground(new java.awt.Color(51, 51, 51));
        Block4Grid.setLayout(new java.awt.GridLayout(4, 5));

        b4_l1.setBackground(new java.awt.Color(102, 153, 0));
        b4_l1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l1.setForeground(new java.awt.Color(255, 255, 255));
        b4_l1.setText("L1");
        Block4Grid.add(b4_l1);

        b4_l2.setBackground(new java.awt.Color(102, 153, 0));
        b4_l2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l2.setForeground(new java.awt.Color(255, 255, 255));
        b4_l2.setText("L2");
        Block4Grid.add(b4_l2);

        b4_l3.setBackground(new java.awt.Color(102, 153, 0));
        b4_l3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l3.setForeground(new java.awt.Color(255, 255, 255));
        b4_l3.setText("L3");
        Block4Grid.add(b4_l3);

        b4_l4.setBackground(new java.awt.Color(102, 153, 0));
        b4_l4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l4.setForeground(new java.awt.Color(255, 255, 255));
        b4_l4.setText("L4");
        Block4Grid.add(b4_l4);

        b4_l5.setBackground(new java.awt.Color(102, 153, 0));
        b4_l5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l5.setForeground(new java.awt.Color(255, 255, 255));
        b4_l5.setText("L5");
        Block4Grid.add(b4_l5);

        b4_l6.setBackground(new java.awt.Color(102, 153, 0));
        b4_l6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l6.setForeground(new java.awt.Color(255, 255, 255));
        b4_l6.setText("L6");
        Block4Grid.add(b4_l6);

        b4_l7.setBackground(new java.awt.Color(102, 153, 0));
        b4_l7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l7.setForeground(new java.awt.Color(255, 255, 255));
        b4_l7.setText("L7");
        Block4Grid.add(b4_l7);

        b4_l8.setBackground(new java.awt.Color(102, 153, 0));
        b4_l8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l8.setForeground(new java.awt.Color(255, 255, 255));
        b4_l8.setText("L8");
        Block4Grid.add(b4_l8);

        b4_l9.setBackground(new java.awt.Color(102, 153, 0));
        b4_l9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l9.setForeground(new java.awt.Color(255, 255, 255));
        b4_l9.setText("L9");
        Block4Grid.add(b4_l9);

        b4_l10.setBackground(new java.awt.Color(102, 153, 0));
        b4_l10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l10.setForeground(new java.awt.Color(255, 255, 255));
        b4_l10.setText("L10");
        Block4Grid.add(b4_l10);

        b4_l11.setBackground(new java.awt.Color(102, 153, 0));
        b4_l11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l11.setForeground(new java.awt.Color(255, 255, 255));
        b4_l11.setText("L11");
        Block4Grid.add(b4_l11);

        b4_l12.setBackground(new java.awt.Color(102, 153, 0));
        b4_l12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l12.setForeground(new java.awt.Color(255, 255, 255));
        b4_l12.setText("L12");
        Block4Grid.add(b4_l12);

        b4_l13.setBackground(new java.awt.Color(102, 153, 0));
        b4_l13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l13.setForeground(new java.awt.Color(255, 255, 255));
        b4_l13.setText("L13");
        Block4Grid.add(b4_l13);

        b4_l14.setBackground(new java.awt.Color(102, 153, 0));
        b4_l14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l14.setForeground(new java.awt.Color(255, 255, 255));
        b4_l14.setText("L14");
        Block4Grid.add(b4_l14);

        b4_l15.setBackground(new java.awt.Color(102, 153, 0));
        b4_l15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l15.setForeground(new java.awt.Color(255, 255, 255));
        b4_l15.setText("L15");
        Block4Grid.add(b4_l15);

        b4_l16.setBackground(new java.awt.Color(102, 153, 0));
        b4_l16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l16.setForeground(new java.awt.Color(255, 255, 255));
        b4_l16.setText("L16");
        Block4Grid.add(b4_l16);

        b4_l17.setBackground(new java.awt.Color(102, 153, 0));
        b4_l17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l17.setForeground(new java.awt.Color(255, 255, 255));
        b4_l17.setText("L17");
        Block4Grid.add(b4_l17);

        b4_l18.setBackground(new java.awt.Color(102, 153, 0));
        b4_l18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l18.setForeground(new java.awt.Color(255, 255, 255));
        b4_l18.setText("L18");
        Block4Grid.add(b4_l18);

        b4_l19.setBackground(new java.awt.Color(102, 153, 0));
        b4_l19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l19.setForeground(new java.awt.Color(255, 255, 255));
        b4_l19.setText("L19");
        Block4Grid.add(b4_l19);

        b4_l20.setBackground(new java.awt.Color(102, 153, 0));
        b4_l20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b4_l20.setForeground(new java.awt.Color(255, 255, 255));
        b4_l20.setText("L20");
        Block4Grid.add(b4_l20);

        lotsView.add(Block4Grid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 890, 130));

        Block5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Block5.setForeground(new java.awt.Color(255, 255, 255));
        Block5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Block5.setText("Block 5");
        lotsView.add(Block5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 849, 340, 30));

        Block5Grid.setBackground(new java.awt.Color(51, 51, 51));
        Block5Grid.setLayout(new java.awt.GridLayout(4, 5));

        b5_l1.setBackground(new java.awt.Color(102, 153, 0));
        b5_l1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l1.setForeground(new java.awt.Color(255, 255, 255));
        b5_l1.setText("L1");
        Block5Grid.add(b5_l1);

        b5_l2.setBackground(new java.awt.Color(102, 153, 0));
        b5_l2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l2.setForeground(new java.awt.Color(255, 255, 255));
        b5_l2.setText("L2");
        Block5Grid.add(b5_l2);

        b5_l3.setBackground(new java.awt.Color(102, 153, 0));
        b5_l3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l3.setForeground(new java.awt.Color(255, 255, 255));
        b5_l3.setText("L3");
        Block5Grid.add(b5_l3);

        b5_l4.setBackground(new java.awt.Color(102, 153, 0));
        b5_l4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l4.setForeground(new java.awt.Color(255, 255, 255));
        b5_l4.setText("L4");
        Block5Grid.add(b5_l4);

        b5_l5.setBackground(new java.awt.Color(102, 153, 0));
        b5_l5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l5.setForeground(new java.awt.Color(255, 255, 255));
        b5_l5.setText("L5");
        Block5Grid.add(b5_l5);

        b5_l6.setBackground(new java.awt.Color(102, 153, 0));
        b5_l6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l6.setForeground(new java.awt.Color(255, 255, 255));
        b5_l6.setText("L6");
        Block5Grid.add(b5_l6);

        b5_l7.setBackground(new java.awt.Color(102, 153, 0));
        b5_l7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l7.setForeground(new java.awt.Color(255, 255, 255));
        b5_l7.setText("L7");
        Block5Grid.add(b5_l7);

        b5_l8.setBackground(new java.awt.Color(102, 153, 0));
        b5_l8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l8.setForeground(new java.awt.Color(255, 255, 255));
        b5_l8.setText("L8");
        Block5Grid.add(b5_l8);

        b5_l9.setBackground(new java.awt.Color(102, 153, 0));
        b5_l9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l9.setForeground(new java.awt.Color(255, 255, 255));
        b5_l9.setText("L9");
        Block5Grid.add(b5_l9);

        b5_l10.setBackground(new java.awt.Color(102, 153, 0));
        b5_l10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l10.setForeground(new java.awt.Color(255, 255, 255));
        b5_l10.setText("L10");
        Block5Grid.add(b5_l10);

        b5_l11.setBackground(new java.awt.Color(102, 153, 0));
        b5_l11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l11.setForeground(new java.awt.Color(255, 255, 255));
        b5_l11.setText("L11");
        Block5Grid.add(b5_l11);

        b5_l12.setBackground(new java.awt.Color(102, 153, 0));
        b5_l12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l12.setForeground(new java.awt.Color(255, 255, 255));
        b5_l12.setText("L12");
        Block5Grid.add(b5_l12);

        b5_l13.setBackground(new java.awt.Color(102, 153, 0));
        b5_l13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l13.setForeground(new java.awt.Color(255, 255, 255));
        b5_l13.setText("L13");
        b5_l13.setToolTipText("");
        Block5Grid.add(b5_l13);

        b5_l14.setBackground(new java.awt.Color(102, 153, 0));
        b5_l14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l14.setForeground(new java.awt.Color(255, 255, 255));
        b5_l14.setText("L14");
        Block5Grid.add(b5_l14);

        b5_l15.setBackground(new java.awt.Color(102, 153, 0));
        b5_l15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l15.setForeground(new java.awt.Color(255, 255, 255));
        b5_l15.setText("L15");
        b5_l15.setToolTipText("");
        Block5Grid.add(b5_l15);

        b5_l16.setBackground(new java.awt.Color(102, 153, 0));
        b5_l16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l16.setForeground(new java.awt.Color(255, 255, 255));
        b5_l16.setText("L16");
        Block5Grid.add(b5_l16);

        b5_l17.setBackground(new java.awt.Color(102, 153, 0));
        b5_l17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l17.setForeground(new java.awt.Color(255, 255, 255));
        b5_l17.setText("L17");
        Block5Grid.add(b5_l17);

        b5_l18.setBackground(new java.awt.Color(102, 153, 0));
        b5_l18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l18.setForeground(new java.awt.Color(255, 255, 255));
        b5_l18.setText("L18");
        Block5Grid.add(b5_l18);

        b5_l19.setBackground(new java.awt.Color(102, 153, 0));
        b5_l19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l19.setForeground(new java.awt.Color(255, 255, 255));
        b5_l19.setText("L19");
        Block5Grid.add(b5_l19);

        b5_l20.setBackground(new java.awt.Color(102, 153, 0));
        b5_l20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b5_l20.setForeground(new java.awt.Color(255, 255, 255));
        b5_l20.setText("L20");
        Block5Grid.add(b5_l20);

        lotsView.add(Block5Grid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 889, 890, 130));

        lotsOverview.setViewportView(lotsView);

        Lots.add(lotsOverview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1000, 590));

        MainContentBuyer.addTab("tab1", Lots);

        Transactions.setBackground(new java.awt.Color(30, 30, 30));
        Transactions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("New Peninim MT", 1, 35)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title.setText("Transactions");
        Transactions.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 40));

        buyerHistoryTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buyerHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Block", "Lot", "Price"
            }
        ));
        jScrollPane1.setViewportView(buyerHistoryTable);

        Transactions.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 940, -1));

        MainContentBuyer.addTab("tab2", Transactions);

        Computation.setBackground(new java.awt.Color(30, 30, 30));
        Computation.setMinimumSize(new java.awt.Dimension(502, 297));
        Computation.setPreferredSize(new java.awt.Dimension(502, 297));
        Computation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title1.setFont(new java.awt.Font("New Peninim MT", 1, 35)); // NOI18N
        Title1.setForeground(new java.awt.Color(255, 255, 255));
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title1.setText("Computation");
        Computation.add(Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 40));

        computationOverview.setBorder(null);
        javax.swing.JScrollBar computationBar = computationOverview.getVerticalScrollBar();
        computationBar.setPreferredSize(new java.awt.Dimension(8,0));
        computationBar.setUnitIncrement(24);

        computationBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                this.trackColor = new java.awt.Color(30,30,30);
                this.thumbColor = new java.awt.Color(120,120,120);
            }

            @Override
            protected javax.swing.JButton createDecreaseButton(int orientation) {
                javax.swing.JButton button = new javax.swing.JButton();
                button.setBackground(new java.awt.Color(30,30,30));
                button.setBorder(null);
                return button;
            }

            @Override
            protected javax.swing.JButton createIncreaseButton(int orientation) {
                javax.swing.JButton button = new javax.swing.JButton();
                button.setBackground(new java.awt.Color(30,30,30));
                button.setBorder(null);
                return button;
            }

        });

        computation.setBackground(new java.awt.Color(30, 30, 30));
        computation.setMinimumSize(new java.awt.Dimension(930, 1058));
        computation.setPreferredSize(new java.awt.Dimension(930, 1058));
        computation.setLayout(new java.awt.GridLayout(5, 1, 5, 0));

        computation1.setBackground(new java.awt.Color(30, 30, 30));
        computation1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        computationTitle.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        computationTitle.setForeground(new java.awt.Color(255, 255, 255));
        computationTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        computationTitle.setText("Sample Lot Name Here");
        computation1.add(computationTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

        info1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info1.setForeground(new java.awt.Color(255, 255, 255));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info1.setText("Info:");
        computation1.add(info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 20));

        InfoText1.setBackground(new java.awt.Color(30, 30, 30));
        InfoText1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText1.setForeground(new java.awt.Color(255, 255, 255));
        InfoText1.setText("jTextField1");
        InfoText1.setBorder(null);
        computation1.add(InfoText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 20));

        info2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info2.setForeground(new java.awt.Color(255, 255, 255));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info2.setText("Info:");
        computation1.add(info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        InfoText2.setBackground(new java.awt.Color(30, 30, 30));
        InfoText2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText2.setForeground(new java.awt.Color(255, 255, 255));
        InfoText2.setText("jTextField1");
        InfoText2.setBorder(null);
        computation1.add(InfoText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 20));

        info3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info3.setForeground(new java.awt.Color(255, 255, 255));
        info3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info3.setText("Info:");
        computation1.add(info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 20));

        InfoText3.setBackground(new java.awt.Color(30, 30, 30));
        InfoText3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText3.setForeground(new java.awt.Color(255, 255, 255));
        InfoText3.setText("jTextField1");
        InfoText3.setBorder(null);
        computation1.add(InfoText3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, 20));

        info4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info4.setForeground(new java.awt.Color(255, 255, 255));
        info4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info4.setText("Info:");
        computation1.add(info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 20));

        InfoText4.setBackground(new java.awt.Color(30, 30, 30));
        InfoText4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText4.setForeground(new java.awt.Color(255, 255, 255));
        InfoText4.setText("jTextField1");
        InfoText4.setBorder(null);
        computation1.add(InfoText4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 160, 20));

        computation.add(computation1);

        computation3.setBackground(new java.awt.Color(30, 30, 30));
        computation3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        computationTitle2.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        computationTitle2.setForeground(new java.awt.Color(255, 255, 255));
        computationTitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        computationTitle2.setText("Sample Lot Name Here");
        computation3.add(computationTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

        info9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info9.setForeground(new java.awt.Color(255, 255, 255));
        info9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info9.setText("Info:");
        computation3.add(info9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 20));

        InfoText9.setBackground(new java.awt.Color(30, 30, 30));
        InfoText9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText9.setForeground(new java.awt.Color(255, 255, 255));
        InfoText9.setText("jTextField1");
        InfoText9.setBorder(null);
        computation3.add(InfoText9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 20));

        info10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info10.setForeground(new java.awt.Color(255, 255, 255));
        info10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info10.setText("Info:");
        computation3.add(info10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        InfoText10.setBackground(new java.awt.Color(30, 30, 30));
        InfoText10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText10.setForeground(new java.awt.Color(255, 255, 255));
        InfoText10.setText("jTextField1");
        InfoText10.setBorder(null);
        computation3.add(InfoText10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 20));

        info11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info11.setForeground(new java.awt.Color(255, 255, 255));
        info11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info11.setText("Info:");
        computation3.add(info11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 20));

        InfoText11.setBackground(new java.awt.Color(30, 30, 30));
        InfoText11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText11.setForeground(new java.awt.Color(255, 255, 255));
        InfoText11.setText("jTextField1");
        InfoText11.setBorder(null);
        computation3.add(InfoText11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, 20));

        info12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info12.setForeground(new java.awt.Color(255, 255, 255));
        info12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info12.setText("Info:");
        computation3.add(info12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 20));

        InfoText12.setBackground(new java.awt.Color(30, 30, 30));
        InfoText12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText12.setForeground(new java.awt.Color(255, 255, 255));
        InfoText12.setText("jTextField1");
        InfoText12.setBorder(null);
        computation3.add(InfoText12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 160, 20));

        computation.add(computation3);

        computation4.setBackground(new java.awt.Color(30, 30, 30));
        computation4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        computationTitle3.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        computationTitle3.setForeground(new java.awt.Color(255, 255, 255));
        computationTitle3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        computationTitle3.setText("Sample Lot Name Here");
        computation4.add(computationTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

        info13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info13.setForeground(new java.awt.Color(255, 255, 255));
        info13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info13.setText("Info:");
        computation4.add(info13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 20));

        InfoText13.setBackground(new java.awt.Color(30, 30, 30));
        InfoText13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText13.setForeground(new java.awt.Color(255, 255, 255));
        InfoText13.setText("jTextField1");
        InfoText13.setBorder(null);
        computation4.add(InfoText13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 20));

        info14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info14.setForeground(new java.awt.Color(255, 255, 255));
        info14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info14.setText("Info:");
        computation4.add(info14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        InfoText14.setBackground(new java.awt.Color(30, 30, 30));
        InfoText14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText14.setForeground(new java.awt.Color(255, 255, 255));
        InfoText14.setText("jTextField1");
        InfoText14.setBorder(null);
        computation4.add(InfoText14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 20));

        info15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info15.setForeground(new java.awt.Color(255, 255, 255));
        info15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info15.setText("Info:");
        computation4.add(info15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 20));

        InfoText15.setBackground(new java.awt.Color(30, 30, 30));
        InfoText15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText15.setForeground(new java.awt.Color(255, 255, 255));
        InfoText15.setText("jTextField1");
        InfoText15.setBorder(null);
        computation4.add(InfoText15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, 20));

        info16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info16.setForeground(new java.awt.Color(255, 255, 255));
        info16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info16.setText("Info:");
        computation4.add(info16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 20));

        InfoText16.setBackground(new java.awt.Color(30, 30, 30));
        InfoText16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText16.setForeground(new java.awt.Color(255, 255, 255));
        InfoText16.setText("jTextField1");
        InfoText16.setBorder(null);
        computation4.add(InfoText16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 160, 20));

        computation.add(computation4);

        computationOverview.setViewportView(computation);

        Computation.add(computationOverview, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 980, 620));

        MainContentBuyer.addTab("tab3", Computation);

        Profile.setBackground(new java.awt.Color(30, 30, 30));
        Profile.setMinimumSize(new java.awt.Dimension(502, 297));
        Profile.setPreferredSize(new java.awt.Dimension(502, 297));
        Profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title2.setFont(new java.awt.Font("New Peninim MT", 1, 35)); // NOI18N
        Title2.setForeground(new java.awt.Color(255, 255, 255));
        Title2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title2.setText("Account Information");
        Profile.add(Title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 40));

        firstName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        firstName.setForeground(new java.awt.Color(255, 255, 255));
        firstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        firstName.setText("First Name");
        Profile.add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 20));

        FirstName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        FirstName.setForeground(new java.awt.Color(51, 51, 51));
        FirstName.setText("jTextField1");
        FirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });
        Profile.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 20));

        lastName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lastName.setForeground(new java.awt.Color(255, 255, 255));
        lastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lastName.setText("Last Name");
        Profile.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 160, 20));

        LastName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LastName.setForeground(new java.awt.Color(51, 51, 51));
        LastName.setText("jTextField1");
        LastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });
        Profile.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 250, 20));

        Email.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email.setText("Email");
        Profile.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, 20));

        email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(51, 51, 51));
        email.setText("jTextField1");
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        Profile.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 250, 20));

        Password.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Password.setText("Password");
        Profile.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 160, 20));

        password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(51, 51, 51));
        password.setText("jTextField1");
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        Profile.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 250, 20));

        change.setText("Update");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        Profile.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        MainContentBuyer.addTab("tab5", Profile);

        getContentPane().add(MainContentBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -40, 1000, 760));

        bgimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main_bg.png"))); // NOI18N
        getContentPane().add(bgimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewLotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLotsActionPerformed
        // TODO add your handling code here:
        MainContentBuyer.setSelectedIndex(0);
        refreshDashboard();
    }//GEN-LAST:event_viewLotsActionPerformed

    private void reqComputationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqComputationActionPerformed
        // TODO add your handling code here:
        MainContentBuyer.setSelectedIndex(2);
    }//GEN-LAST:event_reqComputationActionPerformed

    private void transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionActionPerformed
        // TODO add your handling code here:
        MainContentBuyer.setSelectedIndex(1);
    }//GEN-LAST:event_transactionActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        BuyerLoginFrame BuyerLoginFrame=new BuyerLoginFrame();
        BuyerLoginFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutActionPerformed

    private void viewLotsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewLotsMouseEntered
        // TODO add your handling code here:
        viewLots.setForeground(entered);
    }//GEN-LAST:event_viewLotsMouseEntered

    private void viewLotsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewLotsMouseExited
        // TODO add your handling code here:
        viewLots.setForeground(normal);
    }//GEN-LAST:event_viewLotsMouseExited

    private void viewLotsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewLotsMousePressed
        // TODO add your handling code here:
        viewLots.setForeground(clickedcolor);
    }//GEN-LAST:event_viewLotsMousePressed

    private void viewLotsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewLotsMouseClicked
        // TODO add your handling code here:
        viewLots.setForeground(clickedcolor);
    }//GEN-LAST:event_viewLotsMouseClicked

    private void b3_l20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3_l20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3_l20ActionPerformed

    private void reqComputationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reqComputationMouseEntered
        // TODO add your handling code here:
         reqComputation.setForeground(entered);
    }//GEN-LAST:event_reqComputationMouseEntered

    private void reqComputationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reqComputationMouseExited
        // TODO add your handling code here:
        reqComputation.setForeground(normal);
    }//GEN-LAST:event_reqComputationMouseExited

    private void reqComputationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reqComputationMousePressed
        // TODO add your handling code here:
        reqComputation.setForeground(clickedcolor);
    }//GEN-LAST:event_reqComputationMousePressed

    private void reqComputationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reqComputationMouseClicked
        // TODO add your handling code here:
        reqComputation.setForeground(clickedcolor);
    }//GEN-LAST:event_reqComputationMouseClicked

    private void transactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionMouseClicked
        // TODO add your handling code here:
        transaction.setForeground(clickedcolor);
    }//GEN-LAST:event_transactionMouseClicked

    private void transactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionMouseEntered
        // TODO add your handling code here:
        transaction.setForeground(entered);
    }//GEN-LAST:event_transactionMouseEntered

    private void transactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionMouseExited
        // TODO add your handling code here:
        transaction.setForeground(normal);
    }//GEN-LAST:event_transactionMouseExited

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        // TODO add your handling code here:
        logOut.setForeground(clickedcolor);
    }//GEN-LAST:event_logOutMouseClicked

    private void logOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseEntered
        // TODO add your handling code here:
        logOut.setForeground(entered);
    }//GEN-LAST:event_logOutMouseEntered

    private void logOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseExited
        // TODO add your handling code here:
        logOut.setForeground(normal);
    }//GEN-LAST:event_logOutMouseExited

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        refreshDashboard();
    }//GEN-LAST:event_RefreshActionPerformed

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void viewProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewProfileMouseClicked

    private void viewProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileMouseEntered
        // TODO add your handling code here:
        viewProfile.setForeground(entered);
    }//GEN-LAST:event_viewProfileMouseEntered

    private void viewProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileMouseExited
        // TODO add your handling code here:
        viewProfile.setForeground(normal);
    }//GEN-LAST:event_viewProfileMouseExited

    private void viewProfileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileMousePressed
        // TODO add your handling code here:
        viewProfile.setForeground(clickedcolor);
    }//GEN-LAST:event_viewProfileMousePressed

    private void viewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProfileActionPerformed
        // TODO add your handling code here:
        MainContentBuyer.setSelectedIndex(3);
    }//GEN-LAST:event_viewProfileActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        String first = FirstName.getText().trim();
        String last = LastName.getText().trim();
        String mail = email.getText().trim();
        String pass = password.getText().trim();

        // Input Sanitation
        if (first.isEmpty() || last.isEmpty() || mail.isEmpty() || pass.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "All fields are required.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (first.contains(",") || last.contains(",") || mail.contains(",") || pass.contains(",")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Commas are not allowed.", "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Execute Update
        boolean success = controller.UserManager.getInstance().updateCurrentUser(first, last, mail, pass);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Profile updated successfully.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Update failed. Email may already be in use.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_changeActionPerformed

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
            java.util.logging.Logger.getLogger(BuyerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Block1;
    private javax.swing.JPanel Block1Grid;
    private javax.swing.JLabel Block2;
    private javax.swing.JPanel Block2Grid;
    private javax.swing.JLabel Block3;
    private javax.swing.JPanel Block3Grid;
    private javax.swing.JLabel Block4;
    private javax.swing.JPanel Block4Grid;
    private javax.swing.JLabel Block5;
    private javax.swing.JPanel Block5Grid;
    private javax.swing.JPanel BuyerSideBar;
    private javax.swing.JPanel Computation;
    private javax.swing.JLabel DashboardLabel;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField FirstName;
    private javax.swing.JLabel GroupName1;
    private javax.swing.JTextField InfoText1;
    private javax.swing.JTextField InfoText10;
    private javax.swing.JTextField InfoText11;
    private javax.swing.JTextField InfoText12;
    private javax.swing.JTextField InfoText13;
    private javax.swing.JTextField InfoText14;
    private javax.swing.JTextField InfoText15;
    private javax.swing.JTextField InfoText16;
    private javax.swing.JTextField InfoText2;
    private javax.swing.JTextField InfoText3;
    private javax.swing.JTextField InfoText4;
    private javax.swing.JTextField InfoText9;
    private javax.swing.JTextField LastName;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Lots;
    private javax.swing.JTabbedPane MainContentBuyer;
    private javax.swing.JLabel Password;
    private javax.swing.JPanel Profile;
    private javax.swing.JButton Refresh;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JPanel Transactions;
    private javax.swing.JButton b1_l1;
    private javax.swing.JButton b1_l10;
    private javax.swing.JButton b1_l11;
    private javax.swing.JButton b1_l12;
    private javax.swing.JButton b1_l13;
    private javax.swing.JButton b1_l14;
    private javax.swing.JButton b1_l15;
    private javax.swing.JButton b1_l16;
    private javax.swing.JButton b1_l17;
    private javax.swing.JButton b1_l18;
    private javax.swing.JButton b1_l19;
    private javax.swing.JButton b1_l2;
    private javax.swing.JButton b1_l20;
    private javax.swing.JButton b1_l3;
    private javax.swing.JButton b1_l4;
    private javax.swing.JButton b1_l5;
    private javax.swing.JButton b1_l6;
    private javax.swing.JButton b1_l7;
    private javax.swing.JButton b1_l8;
    private javax.swing.JButton b1_l9;
    private javax.swing.JButton b2_l1;
    private javax.swing.JButton b2_l10;
    private javax.swing.JButton b2_l11;
    private javax.swing.JButton b2_l12;
    private javax.swing.JButton b2_l13;
    private javax.swing.JButton b2_l14;
    private javax.swing.JButton b2_l15;
    private javax.swing.JButton b2_l16;
    private javax.swing.JButton b2_l17;
    private javax.swing.JButton b2_l18;
    private javax.swing.JButton b2_l19;
    private javax.swing.JButton b2_l2;
    private javax.swing.JButton b2_l20;
    private javax.swing.JButton b2_l3;
    private javax.swing.JButton b2_l4;
    private javax.swing.JButton b2_l5;
    private javax.swing.JButton b2_l6;
    private javax.swing.JButton b2_l7;
    private javax.swing.JButton b2_l8;
    private javax.swing.JButton b2_l9;
    private javax.swing.JButton b3_l1;
    private javax.swing.JButton b3_l10;
    private javax.swing.JButton b3_l11;
    private javax.swing.JButton b3_l12;
    private javax.swing.JButton b3_l13;
    private javax.swing.JButton b3_l14;
    private javax.swing.JButton b3_l15;
    private javax.swing.JButton b3_l16;
    private javax.swing.JButton b3_l17;
    private javax.swing.JButton b3_l18;
    private javax.swing.JButton b3_l19;
    private javax.swing.JButton b3_l2;
    private javax.swing.JButton b3_l20;
    private javax.swing.JButton b3_l3;
    private javax.swing.JButton b3_l4;
    private javax.swing.JButton b3_l5;
    private javax.swing.JButton b3_l6;
    private javax.swing.JButton b3_l7;
    private javax.swing.JButton b3_l8;
    private javax.swing.JButton b3_l9;
    private javax.swing.JButton b4_l1;
    private javax.swing.JButton b4_l10;
    private javax.swing.JButton b4_l11;
    private javax.swing.JButton b4_l12;
    private javax.swing.JButton b4_l13;
    private javax.swing.JButton b4_l14;
    private javax.swing.JButton b4_l15;
    private javax.swing.JButton b4_l16;
    private javax.swing.JButton b4_l17;
    private javax.swing.JButton b4_l18;
    private javax.swing.JButton b4_l19;
    private javax.swing.JButton b4_l2;
    private javax.swing.JButton b4_l20;
    private javax.swing.JButton b4_l3;
    private javax.swing.JButton b4_l4;
    private javax.swing.JButton b4_l5;
    private javax.swing.JButton b4_l6;
    private javax.swing.JButton b4_l7;
    private javax.swing.JButton b4_l8;
    private javax.swing.JButton b4_l9;
    private javax.swing.JButton b5_l1;
    private javax.swing.JButton b5_l10;
    private javax.swing.JButton b5_l11;
    private javax.swing.JButton b5_l12;
    private javax.swing.JButton b5_l13;
    private javax.swing.JButton b5_l14;
    private javax.swing.JButton b5_l15;
    private javax.swing.JButton b5_l16;
    private javax.swing.JButton b5_l17;
    private javax.swing.JButton b5_l18;
    private javax.swing.JButton b5_l19;
    private javax.swing.JButton b5_l2;
    private javax.swing.JButton b5_l20;
    private javax.swing.JButton b5_l3;
    private javax.swing.JButton b5_l4;
    private javax.swing.JButton b5_l5;
    private javax.swing.JButton b5_l6;
    private javax.swing.JButton b5_l7;
    private javax.swing.JButton b5_l8;
    private javax.swing.JButton b5_l9;
    private javax.swing.JLabel bgimg;
    private javax.swing.JTable buyerHistoryTable;
    private javax.swing.JButton change;
    private javax.swing.JPanel computation;
    private javax.swing.JPanel computation1;
    private javax.swing.JPanel computation3;
    private javax.swing.JPanel computation4;
    private javax.swing.JScrollPane computationOverview;
    private javax.swing.JLabel computationTitle;
    private javax.swing.JLabel computationTitle2;
    private javax.swing.JLabel computationTitle3;
    private javax.swing.JTextField email;
    private javax.swing.JLabel firstName;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info10;
    private javax.swing.JLabel info11;
    private javax.swing.JLabel info12;
    private javax.swing.JLabel info13;
    private javax.swing.JLabel info14;
    private javax.swing.JLabel info15;
    private javax.swing.JLabel info16;
    private javax.swing.JLabel info2;
    private javax.swing.JLabel info3;
    private javax.swing.JLabel info4;
    private javax.swing.JLabel info9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastName;
    private javax.swing.JButton logOut;
    private javax.swing.JScrollPane lotsOverview;
    private javax.swing.JPanel lotsView;
    private javax.swing.JTextField password;
    private javax.swing.JButton reqComputation;
    private javax.swing.JButton transaction;
    private javax.swing.JButton viewLots;
    private javax.swing.JButton viewProfile;
    // End of variables declaration//GEN-END:variables
}
