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
/**
 *
 * @author xor
 */
public class AdminDashboard extends javax.swing.JFrame {
    
     /**
     * 
     */ 
    private String[] imgslides={"/img/bgimg1.png","/img/bgimg2.png","/img/bgimg3.png"};
    private int imageIndex = 0;
    private LotFilterPanel customFilterPanel;
    
   private void imageSlideshow() {

    Timer timer = new Timer(8000, e -> {
        imageIndex = (imageIndex + 1) % imgslides.length;

        bgimg.setIcon(
            new ImageIcon(getClass().getResource(imgslides[imageIndex])));
    });
    timer.start();
}
   /** 
    * Colors
     */ 
   Color clickedcolor, entered, normal;
   Color occupied = new Color(255,98,96);
   Color reserved = new Color(0, 78, 122);
   Color vacant = new Color(0,153,0);
        
   /** 
    * Creating Lots Status (Buttons) for future reference
     * @param btn
     * @param status
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

    public void updateLotColor(int b, int l) {
        javax.swing.JButton btn = lotButtons[b][l];
        int lotIndex = (b * 20) + l;
        java.util.List<models.Lot> allLots = controller.EstateManager.getInstance().getAllLots();

        if (lotIndex >= allLots.size()) return;

        models.Lot lot = allLots.get(lotIndex);
        btn.setOpaque(true);

        String status = lot.getStatus();
        if (status.equalsIgnoreCase("Available")) {
            btn.setBackground(vacant); // Green
        } else if (status.equalsIgnoreCase("Reserved") || status.toLowerCase().contains("pending")) {
            btn.setBackground(reserved); // Blue
        } else {
            btn.setBackground(occupied); // Red
        }
        
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
    }
    
    private void updateAllLotColors(){

    for(int b = 0; b < 5; b++){
        for(int l = 0; l < 20; l++){

            updateLotColor(b,l);

            }
        }
    }

    public AdminDashboard() {
        initComponents();
        customFilterPanel = new LotFilterPanel(this::applyFilters);
        Lots.add(customFilterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 130));
        imageSlideshow();
        mapButtons();
        attachButtonListeners();
        
        updateAllLotColors();
        clickedcolor = new Color(0,0,0);
        entered = new Color(110, 110, 110);
        normal = new Color(255,255,255);
        loadPendingTransactions();
        loadAgentHistory();
        loadAuditLogs();
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
 
    private void loadPendingTransactions() {
        reservations.removeAll(); 
        
        models.Agent agent = (models.Agent) controller.UserManager.getInstance().getCurrentUser();
        java.util.List<models.SaleTransaction> pending = controller.EstateManager.getInstance().getPendingTransactionsForAgent(agent.getAssignedBlock());
        
        for (models.SaleTransaction t : pending) {
            reservations.add(createTransactionCard(t, agent.getId()));
        }
        
        reservations.revalidate();
        reservations.repaint();
        // Hard refresh on the parent viewport to ensure the scroll pane updates
        if(reservations.getParent() != null) {
            reservations.getParent().revalidate();
            reservations.getParent().repaint();
        }
    }

    private javax.swing.JPanel createTransactionCard(models.SaleTransaction t, int agentId) {
        javax.swing.JPanel card = new javax.swing.JPanel();
        card.setBackground(new java.awt.Color(45, 45, 45)); // Dark gray match
        card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100), 1, true));
        card.setLayout(new java.awt.GridLayout(1, 5, 10, 10)); // 1 row, 5 columns

        // 1. Type Label
        javax.swing.JLabel typeLabel = new javax.swing.JLabel(t.getType() + " Request");
        typeLabel.setForeground(java.awt.Color.WHITE);
        typeLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        card.add(typeLabel);

        // 2. Buyer ID / Financing
        javax.swing.JLabel buyerLabel = new javax.swing.JLabel("<html>Buyer ID: " + t.getBuyerID() + "<br>Financing: " + t.getFinancingType() + "</html>");
        buyerLabel.setForeground(java.awt.Color.LIGHT_GRAY);
        card.add(buyerLabel);

        // 3. Location Label
        models.Lot lot = controller.EstateManager.getInstance().findLotById(t.getLotID());
        javax.swing.JLabel locLabel = new javax.swing.JLabel("Block " + lot.getBlockID() + " - Lot " + lot.getLotID());
        locLabel.setForeground(java.awt.Color.WHITE);
        card.add(locLabel);

        // 4. Amount Label
        javax.swing.JLabel amtLabel = new javax.swing.JLabel(String.format("PHP %,.2f", t.getAmount()));
        amtLabel.setForeground(java.awt.Color.WHITE);
        card.add(amtLabel);

        // 5. Buttons Panel
        javax.swing.JPanel btnPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        btnPanel.setOpaque(false);
        
        javax.swing.JButton approveBtn = new javax.swing.JButton("✓");
        approveBtn.setBackground(new java.awt.Color(0, 153, 0));
        approveBtn.setForeground(java.awt.Color.WHITE);
        
        javax.swing.JButton rejectBtn = new javax.swing.JButton("X");
        rejectBtn.setBackground(new java.awt.Color(204, 0, 0));
        rejectBtn.setForeground(java.awt.Color.WHITE);

        approveBtn.addActionListener(e -> {
            controller.EstateManager.getInstance().resolveTransaction(t.getTransactionID(), agentId, true);
            javax.swing.JOptionPane.showMessageDialog(this, "Transaction Approved.");
            loadPendingTransactions();
            loadAgentHistory();
        });

        rejectBtn.addActionListener(e -> {
            controller.EstateManager.getInstance().resolveTransaction(t.getTransactionID(), agentId, false);
            javax.swing.JOptionPane.showMessageDialog(this, "Transaction Rejected.");
            loadPendingTransactions();
            loadAgentHistory();
        });

        btnPanel.add(approveBtn);
        btnPanel.add(rejectBtn);
        card.add(btnPanel);

        return card;
    }
    
    private void loadAgentHistory() {
        models.Agent agent = (models.Agent) controller.UserManager.getInstance().getCurrentUser();
        java.util.List<models.SaleTransaction> history = controller.EstateManager.getInstance().getAgentTransactions(agent.getId());
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Trans. ID", "Date", "Lot ID", "Buyer ID", "Type", "Amount", "Status"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        for (models.SaleTransaction t : history) {
            model.addRow(new Object[]{
                t.getTransactionID(), t.getDate(), t.getLotID(), t.getBuyerID(),
                t.getType(), String.format("PHP %,.2f", t.getAmount()), t.getStatus()
            });
        }
        agentHistoryTable.setModel(model);
    }
    
    private void attachButtonListeners() {
        java.util.List<models.Lot> allLots = controller.EstateManager.getInstance().getAllLots();
        models.Admin currentAdmin = (models.Admin) controller.UserManager.getInstance().getCurrentUser();
        
        for (int b = 0; b < 5; b++) {
            for (int l = 0; l < 20; l++) {
                int finalB = b;
                int finalL = l;
                int lotIndex = (b * 20) + l;
                
                if (lotIndex >= allLots.size()) break;
                
                models.Lot lot = allLots.get(lotIndex);
                javax.swing.JButton btn = lotButtons[b][l];
                
                // Clear existing listeners to prevent double-firing
                for(java.awt.event.ActionListener al : btn.getActionListeners()) {
                    btn.removeActionListener(al);
                }
                
                btn.addActionListener(e -> {
                    String[] options = {"Available", "Reserved", "Occupied", "Cancel"};
                    int choice = javax.swing.JOptionPane.showOptionDialog(this,
                        "Override Status for Block " + lot.getBlockID() + " - Lot " + lot.getLotID(),
                        "Admin Override", javax.swing.JOptionPane.DEFAULT_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE, null, options, options[3]);
                        
                    if (choice >= 0 && choice < 3) {
                        String oldStatus = lot.getStatus();
                        String newStatus = options[choice];
                        
                        if (!oldStatus.equals(newStatus)) {
                            lot.setStatus(newStatus);
                            // Persist changes to CSV
                            controller.CSVDatabase.saveLots(controller.EstateManager.getInstance().getAllLots());
                            
                            // Log the override
                            String detail = String.format("Admin overridden Lot %d from %s to %s", lot.getLotID(), oldStatus, newStatus);
                            controller.EstateManager.getInstance().logAudit("LOT_OVERRIDE", currentAdmin.getId(), detail);
                            
                            updateLotColor(finalB, finalL);
                            javax.swing.JOptionPane.showMessageDialog(this, "Lot status updated successfully.");
                        }
                    }
                });
            }
        }
    }
    
    private void refreshDashboard() {
        controller.EstateManager.getInstance().refreshData();
        updateAllLotColors();
        applyFilters();
        loadPendingTransactions();
        loadAgentHistory();
    }
    
    private void loadAuditLogs() {
        // Assuming CSVDatabase has a loadAuditLogs method returning List<AuditLog>
        java.util.List<models.AuditLog> logs = controller.CSVDatabase.loadAuditLogs();
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Log ID", "Timestamp", "Action", "User ID", "Details"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        // Reverse iterate to show newest logs at the top
        for (int i = logs.size() - 1; i >= 0; i--) {
            models.AuditLog log = logs.get(i);
            model.addRow(new Object[]{
                log.getLogId(), log.getTimestamp(), log.getActionType(), log.getUserId(), log.getDetails()
            });
        }
        auditTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AgentSideBar = new javax.swing.JPanel();
        DashboardLabel = new javax.swing.JLabel();
        GroupName = new javax.swing.JLabel();
        viewLots = new javax.swing.JButton();
        viewTransactions = new javax.swing.JButton();
        viewPerformance = new javax.swing.JButton();
        genReport = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        viewReserv = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        viewProfile = new javax.swing.JButton();
        btnAuditLogs = new javax.swing.JButton();
        MainContentSeller = new javax.swing.JTabbedPane();
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
        Reservations = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        reservOverview = new javax.swing.JScrollPane();
        reservations = new javax.swing.JPanel();
        reservation1 = new javax.swing.JPanel();
        reservationTitle = new javax.swing.JLabel();
        info29 = new javax.swing.JLabel();
        InfoText29 = new javax.swing.JTextField();
        info30 = new javax.swing.JLabel();
        InfoText30 = new javax.swing.JTextField();
        info31 = new javax.swing.JLabel();
        InfoText31 = new javax.swing.JTextField();
        info32 = new javax.swing.JLabel();
        InfoText32 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        reservation2 = new javax.swing.JPanel();
        reservationTitle1 = new javax.swing.JLabel();
        info33 = new javax.swing.JLabel();
        InfoText33 = new javax.swing.JTextField();
        info34 = new javax.swing.JLabel();
        InfoText34 = new javax.swing.JTextField();
        info35 = new javax.swing.JLabel();
        InfoText35 = new javax.swing.JTextField();
        info36 = new javax.swing.JLabel();
        InfoText36 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        Performance = new javax.swing.JPanel();
        Title1 = new javax.swing.JLabel();
        agentPerf = new javax.swing.JScrollPane();
        History = new javax.swing.JPanel();
        perfOverview = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Report = new javax.swing.JPanel();
        Title2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportTextArea = new javax.swing.JTextArea();
        btnExportTXT = new javax.swing.JButton();
        btnGenerateReport = new javax.swing.JButton();
        btnExportPDF = new javax.swing.JButton();
        btnExportCSV = new javax.swing.JButton();
        Transactions = new javax.swing.JPanel();
        Title3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        agentHistoryTable = new javax.swing.JTable();
        Profile = new javax.swing.JPanel();
        Title4 = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();
        lastName = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        change = new javax.swing.JButton();
        AuditLogsPanel = new javax.swing.JPanel();
        Title6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        auditTable = new javax.swing.JTable();
        bgimg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1279, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AgentSideBar.setBackground(new java.awt.Color(51, 51, 51));
        AgentSideBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgentSideBar.setFocusable(false);
        AgentSideBar.setMaximumSize(new java.awt.Dimension(1280, 92));
        AgentSideBar.setMinimumSize(new java.awt.Dimension(1280, 92));
        AgentSideBar.setPreferredSize(new java.awt.Dimension(1280, 92));
        AgentSideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashboardLabel.setFont(new java.awt.Font("New Peninim MT", 1, 36)); // NOI18N
        DashboardLabel.setForeground(new java.awt.Color(0, 153, 255));
        DashboardLabel.setText("<html>Admin<br>Dashboard</html>");
        AgentSideBar.add(DashboardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 610, 260, 90));

        GroupName.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        GroupName.setForeground(new java.awt.Color(255, 255, 255));
        GroupName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GroupName.setText("Paul's Group");
        AgentSideBar.add(GroupName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 30));

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
        AgentSideBar.add(viewLots, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 340, 40));

        viewTransactions.setBackground(new java.awt.Color(0, 0, 0));
        viewTransactions.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        viewTransactions.setForeground(new java.awt.Color(255, 255, 255));
        viewTransactions.setText("Transactions");
        viewTransactions.setAlignmentY(0.0F);
        viewTransactions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        viewTransactions.setBorderPainted(false);
        viewTransactions.setContentAreaFilled(false);
        viewTransactions.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        viewTransactions.setFocusPainted(false);
        viewTransactions.setFocusable(false);
        viewTransactions.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        viewTransactions.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        viewTransactions.setIconTextGap(0);
        viewTransactions.setMargin(new java.awt.Insets(14, 14, 14, 14));
        viewTransactions.setSelected(true);
        viewTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTransactionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewTransactionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewTransactionsMouseExited(evt);
            }
        });
        viewTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTransactionsActionPerformed(evt);
            }
        });
        AgentSideBar.add(viewTransactions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 340, 40));

        viewPerformance.setBackground(new java.awt.Color(0, 0, 0));
        viewPerformance.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        viewPerformance.setForeground(new java.awt.Color(255, 255, 255));
        viewPerformance.setText("   Performance");
        viewPerformance.setAlignmentY(0.0F);
        viewPerformance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        viewPerformance.setBorderPainted(false);
        viewPerformance.setContentAreaFilled(false);
        viewPerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        viewPerformance.setFocusPainted(false);
        viewPerformance.setFocusable(false);
        viewPerformance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        viewPerformance.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        viewPerformance.setIconTextGap(0);
        viewPerformance.setMargin(new java.awt.Insets(14, 14, 14, 14));
        viewPerformance.setSelected(true);
        viewPerformance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewPerformanceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewPerformanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewPerformanceMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                viewPerformanceMousePressed(evt);
            }
        });
        viewPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPerformanceActionPerformed(evt);
            }
        });
        AgentSideBar.add(viewPerformance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 340, 40));

        genReport.setBackground(new java.awt.Color(0, 0, 0));
        genReport.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        genReport.setForeground(new java.awt.Color(255, 255, 255));
        genReport.setText("   Generate Report");
        genReport.setAlignmentY(0.0F);
        genReport.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        genReport.setBorderPainted(false);
        genReport.setContentAreaFilled(false);
        genReport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        genReport.setFocusPainted(false);
        genReport.setFocusable(false);
        genReport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        genReport.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        genReport.setIconTextGap(0);
        genReport.setMargin(new java.awt.Insets(14, 14, 14, 14));
        genReport.setSelected(true);
        genReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                genReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                genReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                genReportMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                genReportMousePressed(evt);
            }
        });
        genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReportActionPerformed(evt);
            }
        });
        AgentSideBar.add(genReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 340, 40));

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
        AgentSideBar.add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 340, 40));

        viewReserv.setBackground(new java.awt.Color(0, 0, 0));
        viewReserv.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        viewReserv.setForeground(new java.awt.Color(255, 255, 255));
        viewReserv.setText("   Reservations");
        viewReserv.setAlignmentY(0.0F);
        viewReserv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        viewReserv.setBorderPainted(false);
        viewReserv.setContentAreaFilled(false);
        viewReserv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        viewReserv.setFocusPainted(false);
        viewReserv.setFocusable(false);
        viewReserv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        viewReserv.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        viewReserv.setIconTextGap(0);
        viewReserv.setMargin(new java.awt.Insets(14, 14, 14, 14));
        viewReserv.setSelected(true);
        viewReserv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewReservMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewReservMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewReservMouseExited(evt);
            }
        });
        viewReserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReservActionPerformed(evt);
            }
        });
        AgentSideBar.add(viewReserv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 340, 40));

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        AgentSideBar.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

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
        AgentSideBar.add(viewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 280, 40));

        btnAuditLogs.setBackground(new java.awt.Color(0, 0, 0));
        btnAuditLogs.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        btnAuditLogs.setForeground(new java.awt.Color(255, 255, 255));
        btnAuditLogs.setText("View Audit Logs");
        btnAuditLogs.setAlignmentY(0.0F);
        btnAuditLogs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnAuditLogs.setBorderPainted(false);
        btnAuditLogs.setContentAreaFilled(false);
        btnAuditLogs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAuditLogs.setFocusPainted(false);
        btnAuditLogs.setFocusable(false);
        btnAuditLogs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAuditLogs.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAuditLogs.setIconTextGap(0);
        btnAuditLogs.setMargin(new java.awt.Insets(14, 14, 14, 14));
        btnAuditLogs.setSelected(true);
        btnAuditLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAuditLogsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAuditLogsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAuditLogsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAuditLogsMousePressed(evt);
            }
        });
        btnAuditLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuditLogsActionPerformed(evt);
            }
        });
        AgentSideBar.add(btnAuditLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 340, 50));

        getContentPane().add(AgentSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 720));

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

        MainContentSeller.addTab("tab1", Lots);

        Reservations.setBackground(new java.awt.Color(30, 30, 30));
        Reservations.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title.setText("PENDING RESERVATIONS");
        Reservations.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, 30));

        reservOverview.setBorder(null);
        javax.swing.JScrollBar reservBar = reservOverview.getVerticalScrollBar();
        reservBar.setPreferredSize(new java.awt.Dimension(8,0));
        reservBar.setUnitIncrement(24);

        reservBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {

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

        reservations.setBackground(new java.awt.Color(30, 30, 30));
        reservations.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        reservations.setMinimumSize(new java.awt.Dimension(930, 1058));
        reservations.setPreferredSize(new java.awt.Dimension(930, 1058));
        reservations.setLayout(new java.awt.GridLayout(5, 1, 5, 0));

        reservation1.setBackground(new java.awt.Color(30, 30, 30));
        reservation1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        reservation1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reservationTitle.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        reservationTitle.setForeground(new java.awt.Color(255, 255, 255));
        reservationTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reservationTitle.setText("Sample Lot Name Here");
        reservation1.add(reservationTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

        info29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info29.setForeground(new java.awt.Color(255, 255, 255));
        info29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info29.setText("Info:");
        reservation1.add(info29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 20));

        InfoText29.setBackground(new java.awt.Color(30, 30, 30));
        InfoText29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText29.setForeground(new java.awt.Color(255, 255, 255));
        InfoText29.setText("jTextField1");
        InfoText29.setBorder(null);
        reservation1.add(InfoText29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 20));

        info30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info30.setForeground(new java.awt.Color(255, 255, 255));
        info30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info30.setText("Info:");
        reservation1.add(info30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        InfoText30.setBackground(new java.awt.Color(30, 30, 30));
        InfoText30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText30.setForeground(new java.awt.Color(255, 255, 255));
        InfoText30.setText("jTextField1");
        InfoText30.setBorder(null);
        reservation1.add(InfoText30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 20));

        info31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info31.setForeground(new java.awt.Color(255, 255, 255));
        info31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info31.setText("Info:");
        reservation1.add(info31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 20));

        InfoText31.setBackground(new java.awt.Color(30, 30, 30));
        InfoText31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText31.setForeground(new java.awt.Color(255, 255, 255));
        InfoText31.setText("jTextField1");
        InfoText31.setBorder(null);
        reservation1.add(InfoText31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, 20));

        info32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info32.setForeground(new java.awt.Color(255, 255, 255));
        info32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info32.setText("Info:");
        reservation1.add(info32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 20));

        InfoText32.setBackground(new java.awt.Color(30, 30, 30));
        InfoText32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText32.setForeground(new java.awt.Color(255, 255, 255));
        InfoText32.setText("jTextField1");
        InfoText32.setBorder(null);
        reservation1.add(InfoText32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 160, 20));

        jButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton8.setText("Accept");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        reservation1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton9.setText("Decline");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        reservation1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        reservations.add(reservation1);

        reservation2.setBackground(new java.awt.Color(30, 30, 30));
        reservation2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        reservation2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reservationTitle1.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        reservationTitle1.setForeground(new java.awt.Color(255, 255, 255));
        reservationTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reservationTitle1.setText("Sample Lot Name Here");
        reservation2.add(reservationTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

        info33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info33.setForeground(new java.awt.Color(255, 255, 255));
        info33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info33.setText("Info:");
        reservation2.add(info33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 20));

        InfoText33.setBackground(new java.awt.Color(30, 30, 30));
        InfoText33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText33.setForeground(new java.awt.Color(255, 255, 255));
        InfoText33.setText("jTextField1");
        InfoText33.setBorder(null);
        reservation2.add(InfoText33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 20));

        info34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info34.setForeground(new java.awt.Color(255, 255, 255));
        info34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info34.setText("Info:");
        reservation2.add(info34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        InfoText34.setBackground(new java.awt.Color(30, 30, 30));
        InfoText34.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText34.setForeground(new java.awt.Color(255, 255, 255));
        InfoText34.setText("jTextField1");
        InfoText34.setBorder(null);
        reservation2.add(InfoText34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 20));

        info35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info35.setForeground(new java.awt.Color(255, 255, 255));
        info35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info35.setText("Info:");
        reservation2.add(info35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 20));

        InfoText35.setBackground(new java.awt.Color(30, 30, 30));
        InfoText35.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText35.setForeground(new java.awt.Color(255, 255, 255));
        InfoText35.setText("jTextField1");
        InfoText35.setBorder(null);
        reservation2.add(InfoText35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, 20));

        info36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        info36.setForeground(new java.awt.Color(255, 255, 255));
        info36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info36.setText("Info:");
        reservation2.add(info36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 20));

        InfoText36.setBackground(new java.awt.Color(30, 30, 30));
        InfoText36.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InfoText36.setForeground(new java.awt.Color(255, 255, 255));
        InfoText36.setText("jTextField1");
        InfoText36.setBorder(null);
        reservation2.add(InfoText36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 160, 20));

        jButton10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton10.setText("Accept");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        reservation2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jButton11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton11.setText("Decline");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        reservation2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        reservations.add(reservation2);

        reservOverview.setViewportView(reservations);

        Reservations.add(reservOverview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, 630));

        MainContentSeller.addTab("tab2", Reservations);

        Performance.setBackground(new java.awt.Color(30, 30, 30));
        Performance.setMinimumSize(new java.awt.Dimension(502, 297));
        Performance.setPreferredSize(new java.awt.Dimension(502, 297));
        Performance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title1.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        Title1.setForeground(new java.awt.Color(255, 255, 255));
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title1.setText("PERFORMANCE OVERVIEW");
        Performance.add(Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 340, 30));

        agentPerf.setBorder(null);
        javax.swing.JScrollBar perfBar = agentPerf.getVerticalScrollBar();
        perfBar.setPreferredSize(new java.awt.Dimension(8,0));
        perfBar.setUnitIncrement(24);

        perfBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {

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

        History.setBackground(new java.awt.Color(30, 30, 30));
        History.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153)));
        History.setMinimumSize(new java.awt.Dimension(930, 1058));
        History.setPreferredSize(new java.awt.Dimension(930, 1058));
        History.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer", "Block", "Lot Size", "Price"
            }
        ));
        perfOverview.setViewportView(jTable1);

        History.add(perfOverview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, -1));

        agentPerf.setViewportView(History);

        Performance.add(agentPerf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, 630));

        MainContentSeller.addTab("tab3", Performance);

        Report.setBackground(new java.awt.Color(30, 30, 30));
        Report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title2.setFont(new java.awt.Font("New Peninim MT", 1, 48)); // NOI18N
        Title2.setForeground(new java.awt.Color(255, 255, 255));
        Title2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title2.setText("REPORT");
        Report.add(Title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 340, 60));

        reportTextArea.setColumns(20);
        reportTextArea.setRows(5);
        jScrollPane2.setViewportView(reportTextArea);

        Report.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 960, 560));

        btnExportTXT.setText("Export as Text");
        btnExportTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportTXTActionPerformed(evt);
            }
        });
        Report.add(btnExportTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        btnGenerateReport.setText("Generate");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });
        Report.add(btnGenerateReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        btnExportPDF.setText("Export as PDF");
        btnExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDFActionPerformed(evt);
            }
        });
        Report.add(btnExportPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        btnExportCSV.setText("Export as CSV");
        btnExportCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCSVActionPerformed(evt);
            }
        });
        Report.add(btnExportCSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        MainContentSeller.addTab("tab4", Report);

        Transactions.setBackground(new java.awt.Color(30, 30, 30));
        Transactions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title3.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        Title3.setForeground(new java.awt.Color(255, 255, 255));
        Title3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title3.setText("Transaction History");
        Transactions.add(Title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, 30));

        agentHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(agentHistoryTable);

        Transactions.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        MainContentSeller.addTab("tab2", Transactions);

        Profile.setBackground(new java.awt.Color(30, 30, 30));
        Profile.setMinimumSize(new java.awt.Dimension(502, 297));
        Profile.setPreferredSize(new java.awt.Dimension(502, 297));
        Profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title4.setFont(new java.awt.Font("New Peninim MT", 1, 28)); // NOI18N
        Title4.setForeground(new java.awt.Color(255, 255, 255));
        Title4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title4.setText("Account Information");
        Profile.add(Title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 340, 30));

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
        Profile.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        MainContentSeller.addTab("tab3", Profile);

        AuditLogsPanel.setBackground(new java.awt.Color(30, 30, 30));
        AuditLogsPanel.setMinimumSize(new java.awt.Dimension(502, 297));
        AuditLogsPanel.setPreferredSize(new java.awt.Dimension(502, 297));
        AuditLogsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title6.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        Title6.setForeground(new java.awt.Color(255, 255, 255));
        Title6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title6.setText("Audit Logs");
        AuditLogsPanel.add(Title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 340, 30));

        auditTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(auditTable);

        AuditLogsPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        MainContentSeller.addTab("tab3", AuditLogsPanel);

        getContentPane().add(MainContentSeller, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -40, 1000, 760));

        bgimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main_bg.png"))); // NOI18N
        getContentPane().add(bgimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewLotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLotsActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(0);
        refreshDashboard();
    }//GEN-LAST:event_viewLotsActionPerformed

    private void viewPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPerformanceActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(2);
    }//GEN-LAST:event_viewPerformanceActionPerformed

    private void viewTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTransactionsActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(4);
    }//GEN-LAST:event_viewTransactionsActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        StaffLoginFrame AgentLoginFrame=new StaffLoginFrame();
        AgentLoginFrame.setVisible(true);
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

    private void viewPerformanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPerformanceMouseEntered
        // TODO add your handling code here:
         viewPerformance.setForeground(entered);
    }//GEN-LAST:event_viewPerformanceMouseEntered

    private void viewPerformanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPerformanceMouseExited
        // TODO add your handling code here:
        viewPerformance.setForeground(normal);
    }//GEN-LAST:event_viewPerformanceMouseExited

    private void viewPerformanceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPerformanceMousePressed
        // TODO add your handling code here:
        viewPerformance.setForeground(clickedcolor);
    }//GEN-LAST:event_viewPerformanceMousePressed

    private void viewPerformanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPerformanceMouseClicked
        // TODO add your handling code here:
        viewPerformance.setForeground(clickedcolor);
    }//GEN-LAST:event_viewPerformanceMouseClicked

    private void viewTransactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTransactionsMouseClicked
        // TODO add your handling code here:
        viewTransactions.setForeground(clickedcolor);
    }//GEN-LAST:event_viewTransactionsMouseClicked

    private void viewTransactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTransactionsMouseEntered
        // TODO add your handling code here:
        viewTransactions.setForeground(entered);
    }//GEN-LAST:event_viewTransactionsMouseEntered

    private void viewTransactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTransactionsMouseExited
        // TODO add your handling code here:
        viewTransactions.setForeground(normal);
    }//GEN-LAST:event_viewTransactionsMouseExited

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

    private void genReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genReportMouseClicked
        // TODO add your handling code here:
        genReport.setForeground(clickedcolor);
    }//GEN-LAST:event_genReportMouseClicked

    private void genReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genReportMouseEntered
        // TODO add your handling code here:
        genReport.setForeground(entered);
    }//GEN-LAST:event_genReportMouseEntered

    private void genReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genReportMouseExited
        // TODO add your handling code here:
        genReport.setForeground(normal);
    }//GEN-LAST:event_genReportMouseExited

    private void genReportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genReportMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_genReportMousePressed

    private void genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReportActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(3);
    }//GEN-LAST:event_genReportActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void viewReservMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReservMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReservMouseClicked

    private void viewReservMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReservMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReservMouseEntered

    private void viewReservMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReservMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReservMouseExited

    private void viewReservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReservActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(1);
    }//GEN-LAST:event_viewReservActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        refreshDashboard();
    }//GEN-LAST:event_RefreshActionPerformed

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
        MainContentSeller.setSelectedIndex(5);
    }//GEN-LAST:event_viewProfileActionPerformed

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

    private void btnExportTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportTXTActionPerformed
        // TODO add your handling code here:
        if (reportTextArea.getText().isEmpty()) return;
        models.Agent agent = (models.Agent) controller.UserManager.getInstance().getCurrentUser();
        boolean success = controller.ReportGenerator.exportToTXT(reportTextArea.getText(), agent.getId());
        if (success) javax.swing.JOptionPane.showMessageDialog(this, "Text Report saved to Downloads.");
    }//GEN-LAST:event_btnExportTXTActionPerformed

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        // TODO add your handling code here:
        models.Agent agent = (models.Agent) controller.UserManager.getInstance().getCurrentUser();
        String data = controller.ReportGenerator.buildReportString(controller.EstateManager.getInstance().getAgentTransactions(agent.getId()), agent.getId());
        reportTextArea.setText(data);
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void btnExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDFActionPerformed
        // TODO add your handling code here:
        if (reportTextArea.getText().isEmpty()) return;
        models.Agent agent = (models.Agent) controller.UserManager.getInstance().getCurrentUser();
        boolean success = controller.ReportGenerator.exportToPDF(reportTextArea.getText(), agent.getId());
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "PDF Report saved to Downloads.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "PDF Export Failed. Ensure iText7 libraries are loaded.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportPDFActionPerformed

    private void btnExportCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCSVActionPerformed
        // TODO add your handling code here:
        models.Agent agent = (models.Agent) controller.UserManager.getInstance().getCurrentUser();
        java.util.List<models.SaleTransaction> transactions = controller.EstateManager.getInstance().getAgentTransactions(agent.getId());
        
        boolean success = controller.ReportGenerator.exportToCSV(transactions, agent.getId());
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "CSV Report saved to Downloads.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "CSV Export Failed.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportCSVActionPerformed

    private void btnAuditLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAuditLogsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAuditLogsMouseClicked

    private void btnAuditLogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAuditLogsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAuditLogsMouseEntered

    private void btnAuditLogsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAuditLogsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAuditLogsMouseExited

    private void btnAuditLogsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAuditLogsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAuditLogsMousePressed

    private void btnAuditLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditLogsActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(6); // Adjust index to match the Audit panel
        loadAuditLogs(); // Refresh data on view
    }//GEN-LAST:event_btnAuditLogsActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgentSideBar;
    private javax.swing.JPanel AuditLogsPanel;
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
    private javax.swing.JLabel DashboardLabel;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField FirstName;
    private javax.swing.JLabel GroupName;
    private javax.swing.JPanel History;
    private javax.swing.JTextField InfoText29;
    private javax.swing.JTextField InfoText30;
    private javax.swing.JTextField InfoText31;
    private javax.swing.JTextField InfoText32;
    private javax.swing.JTextField InfoText33;
    private javax.swing.JTextField InfoText34;
    private javax.swing.JTextField InfoText35;
    private javax.swing.JTextField InfoText36;
    private javax.swing.JTextField LastName;
    private javax.swing.JPanel Lots;
    private javax.swing.JTabbedPane MainContentSeller;
    private javax.swing.JLabel Password;
    private javax.swing.JPanel Performance;
    private javax.swing.JPanel Profile;
    private javax.swing.JButton Refresh;
    private javax.swing.JPanel Report;
    private javax.swing.JPanel Reservations;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JLabel Title3;
    private javax.swing.JLabel Title4;
    private javax.swing.JLabel Title6;
    private javax.swing.JPanel Transactions;
    private javax.swing.JTable agentHistoryTable;
    private javax.swing.JScrollPane agentPerf;
    private javax.swing.JTable auditTable;
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
    private javax.swing.JButton btnAuditLogs;
    private javax.swing.JButton btnExportCSV;
    private javax.swing.JButton btnExportPDF;
    private javax.swing.JButton btnExportTXT;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton change;
    private javax.swing.JTextField email;
    private javax.swing.JLabel firstName;
    private javax.swing.JButton genReport;
    private javax.swing.JLabel info29;
    private javax.swing.JLabel info30;
    private javax.swing.JLabel info31;
    private javax.swing.JLabel info32;
    private javax.swing.JLabel info33;
    private javax.swing.JLabel info34;
    private javax.swing.JLabel info35;
    private javax.swing.JLabel info36;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lastName;
    private javax.swing.JButton logOut;
    private javax.swing.JScrollPane lotsOverview;
    private javax.swing.JPanel lotsView;
    private javax.swing.JTextField password;
    private javax.swing.JScrollPane perfOverview;
    private javax.swing.JTextArea reportTextArea;
    private javax.swing.JScrollPane reservOverview;
    private javax.swing.JPanel reservation1;
    private javax.swing.JPanel reservation2;
    private javax.swing.JLabel reservationTitle;
    private javax.swing.JLabel reservationTitle1;
    private javax.swing.JPanel reservations;
    private javax.swing.JButton viewLots;
    private javax.swing.JButton viewPerformance;
    private javax.swing.JButton viewProfile;
    private javax.swing.JButton viewReserv;
    private javax.swing.JButton viewTransactions;
    // End of variables declaration//GEN-END:variables
}
