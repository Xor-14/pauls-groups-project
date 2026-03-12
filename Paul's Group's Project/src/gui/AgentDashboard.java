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
public class AgentDashboard extends javax.swing.JFrame {
    
     /**
     * 
     */ 
    private String[] imgslides={"/img/bgimg1.png","/img/bgimg2.png","/img/bgimg3.png"};
    private int imageIndex = 0;
    
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
    
    String[][] lotStatus = new String[5][20];
    String[][] lotType = new String[5][20];
    double[][] lotPrice = new double[5][20];
    
    private void initializeLots(){

    for(int b=0;b<5;b++){
        for(int l=0;l<20;l++){

            lotStatus[b][l] = "Vacant";
            lotType[b][l] = "Standard Lot";
            lotPrice[b][l] = 500000 + (l*10000);

        }
    }

}
    public void updateLotColor(int b,int l){

    JButton btn = lotButtons[b][l];

    btn.setOpaque(true);

    if(lotStatus[b][l].equals("Vacant"))
        btn.setBackground(vacant);

    if(lotStatus[b][l].equals("Reserved"))
        btn.setBackground(reserved);

    if(lotStatus[b][l].equals("Occupied"))
        btn.setBackground(occupied);
    
    btn.setOpaque(true);
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
    public void applyFilters(){

    String status = statusFilter.getSelectedItem().toString();
    String type = lotFilter.getSelectedItem().toString();
    String price = priceFilter.getSelectedItem().toString();
    String block = blockFilter.getSelectedItem().toString();

    for(int b = 0; b < 5; b++){
        for(int l = 0; l < 20; l++){

            boolean show = true;

            // STATUS FILTER
            if(!status.equals("All") && !lotStatus[b][l].equals(status)){
                show = false;
            }

            // TYPE FILTER
            if(!type.equals("All") && !lotType[b][l].equals(type)){
                show = false;
            }

            // PRICE FILTER
            if(price.equals("Max 500000") && lotPrice[b][l] > 500000){
                show = false;
            }

            if(price.equals("Max 750000") && lotPrice[b][l] > 750000){
                show = false;
            }

            if(price.equals("Max 1000000") && lotPrice[b][l] > 1000000){
                show = false;
            }

            // BLOCK FILTER
            if(!block.equals("All") && !block.equals("Block " + (b+1))){
                show = false;
            }

            lotButtons[b][l].setVisible(show);

        }
    }

}

    public AgentDashboard() {
        initComponents();
        imageSlideshow();
        mapButtons();
        initializeLots();
        lotStatus[1][5]="Reserved";
        lotStatus[2][4]="Vacant";
        lotStatus[0][1]="Occupied";
        updateAllLotColors();
        clickedcolor = new Color(0,0,0);
        entered = new Color(110, 110, 110);
        normal = new Color(255,255,255);
 
        
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
        viewReserv = new javax.swing.JButton();
        viewPerformance = new javax.swing.JButton();
        genReport = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
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
        filteringPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        sFilter = new javax.swing.JLabel();
        statusFilter = new javax.swing.JComboBox<>();
        bFilter1 = new javax.swing.JLabel();
        blockFilter = new javax.swing.JComboBox<>();
        lFilter = new javax.swing.JLabel();
        lotFilter = new javax.swing.JComboBox<>();
        pFilter = new javax.swing.JLabel();
        priceFilter = new javax.swing.JComboBox<>();
        applyFilter = new javax.swing.JButton();
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
        reportPlaceholder = new javax.swing.JLabel();
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
        DashboardLabel.setText("<html>Agent's<br>Dashboard</html>");
        AgentSideBar.add(DashboardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 610, 260, 90));

        GroupName.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        GroupName.setForeground(new java.awt.Color(255, 255, 255));
        GroupName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GroupName.setText("Paul's Group");
        AgentSideBar.add(GroupName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 340, 30));

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
        AgentSideBar.add(viewLots, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 340, 40));

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
        AgentSideBar.add(viewReserv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 340, 40));

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
        AgentSideBar.add(viewPerformance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 340, 40));

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
        AgentSideBar.add(genReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 340, 40));

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
        AgentSideBar.add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 340, 40));

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
        lotsView.setSize(new java.awt.Dimension(930, 1058));
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

        filteringPanel.setBackground(new java.awt.Color(30, 30, 30));
        filteringPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("New Peninim MT", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText("Filters:");
        filteringPanel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 30));

        sFilter.setFont(new java.awt.Font("New Peninim MT", 1, 18)); // NOI18N
        sFilter.setForeground(new java.awt.Color(255, 255, 255));
        sFilter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sFilter.setText("Status:");
        filteringPanel.add(sFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, 30));

        statusFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        statusFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Vacant", "Reserved", "Occupied" }));
        statusFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusFilterActionPerformed(evt);
            }
        });
        filteringPanel.add(statusFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 60, 90, -1));

        bFilter1.setFont(new java.awt.Font("New Peninim MT", 1, 18)); // NOI18N
        bFilter1.setForeground(new java.awt.Color(255, 255, 255));
        bFilter1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bFilter1.setText("Block:");
        filteringPanel.add(bFilter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 60, 60, 30));

        blockFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        blockFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Block 1", "Block 2", "Block 3", "Block 4", "Block 5" }));
        blockFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockFilterActionPerformed(evt);
            }
        });
        filteringPanel.add(blockFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 60, -1, -1));

        lFilter.setFont(new java.awt.Font("New Peninim MT", 1, 18)); // NOI18N
        lFilter.setForeground(new java.awt.Color(255, 255, 255));
        lFilter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lFilter.setText("Lot Size:");
        filteringPanel.add(lFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 60, 80, 30));

        lotFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lotFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Standard Lot (~400–500 sqm)", "Premium Lot (~500–650 sqm)", "Corner Lot (~650+ sqm)" }));
        lotFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotFilterActionPerformed(evt);
            }
        });
        filteringPanel.add(lotFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 60, -1, -1));

        pFilter.setFont(new java.awt.Font("New Peninim MT", 1, 18)); // NOI18N
        pFilter.setForeground(new java.awt.Color(255, 255, 255));
        pFilter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pFilter.setText("Max Price:");
        filteringPanel.add(pFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 90, 30));

        priceFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        priceFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Max 500000", "Max 750000", "Max 1000000" }));
        priceFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFilterActionPerformed(evt);
            }
        });
        filteringPanel.add(priceFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, -1, -1));

        applyFilter.setText("Apply Filter");
        applyFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyFilterActionPerformed(evt);
            }
        });
        filteringPanel.add(applyFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, -1));

        Lots.add(filteringPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 130));

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

        reportPlaceholder.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        reportPlaceholder.setForeground(new java.awt.Color(255, 255, 255));
        reportPlaceholder.setText("placeholder");
        reportPlaceholder.setToolTipText("");
        Report.add(reportPlaceholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 980, 630));

        MainContentSeller.addTab("tab4", Report);

        getContentPane().add(MainContentSeller, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -40, 1000, 760));

        bgimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main_bg.png"))); // NOI18N
        getContentPane().add(bgimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewLotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLotsActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(0);
    }//GEN-LAST:event_viewLotsActionPerformed

    private void viewPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPerformanceActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(2);
    }//GEN-LAST:event_viewPerformanceActionPerformed

    private void viewReservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReservActionPerformed
        // TODO add your handling code here:
        MainContentSeller.setSelectedIndex(1);
    }//GEN-LAST:event_viewReservActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        AgentLoginFrame AgentLoginFrame=new AgentLoginFrame();
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

    private void viewReservMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReservMouseClicked
        // TODO add your handling code here:
        viewReserv.setForeground(clickedcolor);
    }//GEN-LAST:event_viewReservMouseClicked

    private void viewReservMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReservMouseEntered
        // TODO add your handling code here:
        viewReserv.setForeground(entered);
    }//GEN-LAST:event_viewReservMouseEntered

    private void viewReservMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReservMouseExited
        // TODO add your handling code here:
        viewReserv.setForeground(normal);
    }//GEN-LAST:event_viewReservMouseExited

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

    private void statusFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusFilterActionPerformed

    private void blockFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blockFilterActionPerformed

    private void lotFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotFilterActionPerformed

    private void priceFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFilterActionPerformed

    private void applyFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyFilterActionPerformed
        // TODO add your handling code here:
        applyFilters();
    }//GEN-LAST:event_applyFilterActionPerformed

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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(AgentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgentSideBar;
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
    private javax.swing.JPanel Lots;
    private javax.swing.JTabbedPane MainContentSeller;
    private javax.swing.JPanel Performance;
    private javax.swing.JPanel Report;
    private javax.swing.JPanel Reservations;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JScrollPane agentPerf;
    private javax.swing.JButton applyFilter;
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
    private javax.swing.JLabel bFilter1;
    private javax.swing.JLabel bgimg;
    private javax.swing.JComboBox<String> blockFilter;
    private javax.swing.JPanel filteringPanel;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lFilter;
    private javax.swing.JButton logOut;
    private javax.swing.JComboBox<String> lotFilter;
    private javax.swing.JScrollPane lotsOverview;
    private javax.swing.JPanel lotsView;
    private javax.swing.JLabel pFilter;
    private javax.swing.JScrollPane perfOverview;
    private javax.swing.JComboBox<String> priceFilter;
    private javax.swing.JLabel reportPlaceholder;
    private javax.swing.JScrollPane reservOverview;
    private javax.swing.JPanel reservation1;
    private javax.swing.JPanel reservation2;
    private javax.swing.JLabel reservationTitle;
    private javax.swing.JLabel reservationTitle1;
    private javax.swing.JPanel reservations;
    private javax.swing.JLabel sFilter;
    private javax.swing.JComboBox<String> statusFilter;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewLots;
    private javax.swing.JButton viewPerformance;
    private javax.swing.JButton viewReserv;
    // End of variables declaration//GEN-END:variables
}
