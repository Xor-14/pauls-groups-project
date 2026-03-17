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
        transactions = CSVDatabase.loadTransactions();
    }
    
    private static class InstanceHolder {
        private static final TransactionManager INSTANCE = new TransactionManager();
    }

    public static TransactionManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public List<SaleTransaction> getAllTransactions() { return transactions; }

    public List<SaleTransaction> getBuyerTransactions(int buyerId) {
        List<SaleTransaction> history = new ArrayList<>();
        for (SaleTransaction t : transactions) {
            if (t.getBuyerID() == buyerId) history.add(t);
        }
        return history;
    }

    public List<SaleTransaction> getAgentTransactions(int agentId) {
        List<SaleTransaction> history = new ArrayList<>();
        for (SaleTransaction t : transactions) {
            if (t.getAgentID() == agentId) history.add(t);
        }
        return history;
    }    
    
    public boolean requestTransaction(int lotID, int buyerID, String type, String financingType, double amount, double amortization) {
        Lot lot = EstateManager.getInstance().findLotById(lotID);
        if (lot != null && lot.getStatus().equalsIgnoreCase("Available")) {
            lot.setStatus(type.equals("Reservation") ? "Pending Reservation" : "Pending Purchase");
            
            int newId = transactions.size() + 1;
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            
            transactions.add(new SaleTransaction(newId, date, type, financingType, amount, amortization, lotID, buyerID, 0, "Pending"));
            
            CSVDatabase.saveLots(EstateManager.getInstance().getAllLots());
            CSVDatabase.saveTransactions(transactions);
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
        for (SaleTransaction t : transactions) {
            if (t.getTransactionID() == transactionId) target = t;
        }
        if (target == null) return;

        Lot lot = EstateManager.getInstance().findLotById(target.getLotID());
        
        if (approve) {
            target.setStatus("Approved");
            target.setAgentID(agentId);
            lot.setStatus(target.getType().equals("Reservation") ? "Reserved" : "Sold");
            if (target.getType().equals("Purchase")) {
                for (models.Agent a : UserManager.getInstance().getAgents()) {
                    if (a.getId() == agentId) {
                        a.addSale(target.getAmount());
                        CSVDatabase.saveAgents(UserManager.getInstance().getAgents());
                        break;
                    }
                }
            }
            AuditManager.getInstance().logAudit("TRANSACTION_APPROVED", agentId, "Approved TransID " + transactionId + " for Lot " + lot.getLotID());
        } else {
            transactions.remove(target);
            lot.setStatus("Available");
            AuditManager.getInstance().logAudit("TRANSACTION_REJECTED", agentId, "Rejected TransID " + transactionId + " for Lot " + lot.getLotID());
        }
        
        CSVDatabase.saveLots(EstateManager.getInstance().getAllLots());
        CSVDatabase.saveTransactions(transactions);
    }
    
    public void refreshData() {
        this.transactions = CSVDatabase.loadTransactions();
    }
}