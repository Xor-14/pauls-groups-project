/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.Block;
import models.Lot;
import models.SaleTransaction;
import java.util.ArrayList;
import java.util.List;

public class EstateManager {
    private List<Lot> allLots;
    private List<Block> blocks;
    private List<SaleTransaction> transactions;

    private EstateManager() {
        allLots = CSVDatabase.loadLots();
        transactions = CSVDatabase.loadTransactions();
        initializeBlocks();
    }
    
    private static class InstanceHolder {
        private static final EstateManager INSTANCE = new EstateManager();
    }

    public static EstateManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void initializeBlocks() {
        blocks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            blocks.add(new Block(i));
        }
        for (Lot lot : allLots) {
            for (Block block : blocks) {
                if (block.getBlockID() == lot.getBlockID()) {
                    block.addLot(lot);
                    break;
                }
            }
        }
    }

    public List<Lot> getAllLots() { return allLots; }
    public List<Block> getBlocks() { return blocks; }

    public List<Lot> getAvailableLots() {
        List<Lot> available = new ArrayList<>();
        for (Lot lot : allLots) {
            if ("Available".equalsIgnoreCase(lot.getStatus())) {
                available.add(lot);
            }
        }
        return available;
    }

    public boolean reserveLot(int lotID) {
        for (Lot lot : allLots) {
            if (lot.getLotID() == lotID && "Available".equalsIgnoreCase(lot.getStatus())) {
                lot.setStatus("Reserved");
                CSVDatabase.saveLots(allLots); 
                return true;
            }
        }
        return false; 
    }
    
    public Lot findLotById(int lotID) {
        for (Lot lot : allLots) {
            if (lot.getLotID() == lotID) return lot;
        }
        return null;
    }
    
    public List<SaleTransaction> getBuyerTransactions(int buyerId) {
        List<SaleTransaction> history = new ArrayList<>();
        for (SaleTransaction t : transactions) {
            if (t.getBuyerID() == buyerId) {
                history.add(t);
            }
        }
        return history;
    }

    public List<SaleTransaction> getAgentTransactions(int agentId) {
        List<SaleTransaction> history = new ArrayList<>();
        for (SaleTransaction t : transactions) {
            if (t.getAgentID() == agentId) {
                history.add(t);
            }
        }
        return history;
    }    
    
    public boolean requestTransaction(int lotID, int buyerID, String type, String financingType, double amount, double amortization) {
        Lot lot = findLotById(lotID);
        if (lot != null && lot.getStatus().equalsIgnoreCase("Available")) {
            lot.setStatus(type.equals("Reservation") ? "Pending Reservation" : "Pending Purchase");
            
            int newId = transactions.size() + 1;
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            
            // Add the new transaction with all 10 fields
            transactions.add(new SaleTransaction(newId, date, type, financingType, amount, amortization, lotID, buyerID, 0, "Pending"));
            
            CSVDatabase.saveLots(allLots);
            CSVDatabase.saveTransactions(transactions);
            return true;
        }
        return false;
    }

    public List<SaleTransaction> getPendingTransactionsForAgent(int blockID) {
        List<SaleTransaction> pending = new ArrayList<>();
        for (SaleTransaction t : transactions) {
            if (t.getStatus().equalsIgnoreCase("Pending")) {
                Lot lot = findLotById(t.getLotID());
                if (lot != null && lot.getBlockID() == blockID) {
                    pending.add(t);
                }
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

        target.setStatus(approve ? "Approved" : "Rejected");
        target.setAgentID(agentId);

        Lot lot = findLotById(target.getLotID());
        if (approve) {
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
        } else {
            lot.setStatus("Available");
        }
        
        CSVDatabase.saveLots(allLots);
        CSVDatabase.saveTransactions(transactions);
    }
    
}