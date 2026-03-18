/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.SaleTransaction;
import models.Lot;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<SaleTransaction> transactions;

    private TransactionManager() {
        transactions = loadTransactions();
    }
    
    private static class InstanceHolder {
        private static final TransactionManager INSTANCE = new TransactionManager();
    }

    public static TransactionManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private List<SaleTransaction> loadTransactions() {
        List<SaleTransaction> list = new ArrayList<>();
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.TRANSACTIONS_FILE)) {
            if(v.length >= 10) {
                list.add(new SaleTransaction(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), v[3].trim(), 
                    Double.parseDouble(v[4].trim()), Double.parseDouble(v[5].trim()), Integer.parseInt(v[6].trim()), 
                    Integer.parseInt(v[7].trim()), Integer.parseInt(v[8].trim()), v[9].trim()));
            }
        }
        return list;
    }

    public void saveTransactions() {
        List<String[]> data = new ArrayList<>();
        for(SaleTransaction t : transactions) {
            data.add(new String[]{String.valueOf(t.getTransactionID()), t.getDate(), t.getType(), t.getFinancingType(), 
                String.valueOf(t.getAmount()), String.valueOf(t.getMonthlyAmortization()), String.valueOf(t.getLotID()), 
                String.valueOf(t.getBuyerID()), String.valueOf(t.getAgentID()), t.getStatus()});
        }
        CSVDatabase.writeCSV(CSVDatabase.TRANSACTIONS_FILE, "transactionID,date,type,financingType,amount,monthlyAmortization,lotID,buyerID,agentID,status", data);
    }

    public List<SaleTransaction> getAllTransactions() { return transactions; }

    public List<SaleTransaction> getTransactionsByUser(int userId, String role) {
        return transactions.stream().filter(t ->
            (role.equalsIgnoreCase("Buyer") && t.getBuyerID() == userId) ||
            (role.equalsIgnoreCase("Agent") && t.getAgentID() == userId)
        ).collect(java.util.stream.Collectors.toList());
    }   
    
    public boolean requestTransaction(int lotID, int buyerID, String type, String financingType, double amount, double amortization) {
        Lot lot = EstateManager.getInstance().findLotById(lotID);
        if (lot != null && lot.getStatus().equalsIgnoreCase("Available")) {
            lot.setStatus(type.equals("Reservation") ? "Pending Reservation" : "Pending Purchase");
            
            int newId = transactions.size() + 1;
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            
            transactions.add(new SaleTransaction(newId, date, type, financingType, amount, amortization, lotID, buyerID, 0, "Pending"));
            
            EstateManager.getInstance().saveLots();
            saveTransactions();
            return true;
        }
        return false;
    }

    public List<SaleTransaction> getPendingTransactionsForAgent(int blockID) {
        List<SaleTransaction> pending = new ArrayList<>();
        for (SaleTransaction t : transactions) {
            if (t.getStatus().equalsIgnoreCase("Pending")) {
                Lot lot = EstateManager.getInstance().findLotById(t.getLotID());
                if (lot != null && lot.getBlockID() == blockID) pending.add(t);
            }
        }
        return pending;
    }

    public void resolveTransaction(int transactionId, int agentId, boolean approve) {
        SaleTransaction target = null;
        for (SaleTransaction t : transactions) if (t.getTransactionID() == transactionId) target = t;
        if (target == null) return;

        Lot lot = EstateManager.getInstance().findLotById(target.getLotID());
        
        if (approve) {
            target.setStatus("Approved");
            target.setAgentID(agentId);
            lot.setStatus(target.getType().equals("Reservation") ? "Reserved" : "Sold");
            if (target.getType().equals("Purchase")) {
                models.Agent a = (models.Agent) UserManager.getInstance().getUserById(agentId, "Agent");
                if (a != null) {
                    a.addSale(target.getAmount());
                    UserManager.getInstance().saveAllUsers();
                }
            }
            AuditManager.getInstance().logAudit("TRANSACTION_APPROVED", agentId, "Agent", "Approved TransID " + transactionId + " for Lot " + lot.getLotID());
        } else {
            transactions.remove(target);
            lot.setStatus("Available");
            AuditManager.getInstance().logAudit("TRANSACTION_REJECTED", agentId, "Agent", "Rejected TransID " + transactionId + " for Lot " + lot.getLotID());
        }
        
        EstateManager.getInstance().saveLots();
        saveTransactions();
    }
    
    public void refreshData() {
        this.transactions = loadTransactions();
    }
}