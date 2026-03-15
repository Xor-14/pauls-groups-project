/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package models;

public class SaleTransaction {
    private int transactionID;
    private String date;
    private String type; // "Reservation" or "Purchase"
    private String financingType; // "Cash", "Bank", "Pag-IBIG", or "None"
    private double amount; // DP or TCP
    private double monthlyAmortization; 
    private int lotID;
    private int buyerID;
    private int agentID; 
    private String status; 

    public SaleTransaction(int transactionID, String date, String type, String financingType, double amount, double monthlyAmortization, int lotID, int buyerID, int agentID, String status) {
        this.transactionID = transactionID;
        this.date = date;
        this.type = type;
        this.financingType = financingType;
        this.amount = amount;
        this.monthlyAmortization = monthlyAmortization;
        this.lotID = lotID;
        this.buyerID = buyerID;
        this.agentID = agentID;
        this.status = status;
    }

    // Getters
    public int getTransactionID() { return transactionID; }
    public String getDate() { return date; }
    public String getType() { return type; }
    public String getFinancingType() { return financingType; }
    public double getAmount() { return amount; }
    public double getMonthlyAmortization() { return monthlyAmortization; }
    public int getLotID() { return lotID; }
    public int getBuyerID() { return buyerID; }
    public int getAgentID() { return agentID; }
    public String getStatus() { return status; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setAgentID(int agentID) { this.agentID = agentID; }
}