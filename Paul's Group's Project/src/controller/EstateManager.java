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
import java.util.ArrayList;
import java.util.List;

public class EstateManager {
    private List<Lot> allLots;
    private List<Block> blocks;

    private EstateManager() {
        allLots = loadLots();
        initializeBlocks();
    }
    
    private static class InstanceHolder {
        private static final EstateManager INSTANCE = new EstateManager();
    }

    public static EstateManager getInstance() { return InstanceHolder.INSTANCE; }

    private List<Lot> loadLots() {
        List<Lot> lots = new ArrayList<>();
        LotFactory factory = new ConcreteLotFactory();
        List<String[]> data = CSVDatabase.readCSV(CSVDatabase.LOTS_FILE);
        
        for (String[] v : data) {
            if (v.length < 9) continue;
            try {
                lots.add(factory.createLot(v[7].trim(), Integer.parseInt(v[0].trim()), Integer.parseInt(v[1].trim()), 
                    Double.parseDouble(v[2].trim()), Double.parseDouble(v[3].trim()), Double.parseDouble(v[4].trim()), 
                    Double.parseDouble(v[5].trim()), Double.parseDouble(v[6].trim()), v[8].trim()));
            } catch (Exception e) { System.err.println("Lot parsing error: " + e.getMessage()); }
        }
        return lots;
    }

    public void saveLots() {
        List<String[]> data = new ArrayList<>();
        for (Lot lot : allLots) {
            data.add(new String[]{
                String.valueOf(lot.getLotID()), String.valueOf(lot.getBlockID()), String.valueOf(lot.getLotArea()), 
                String.valueOf(lot.getFloorArea()), String.valueOf(lot.getTcp()), String.valueOf(lot.getReservationFee()), 
                String.valueOf(lot.getHdmfMaxLoan()), lot.getLotType(), lot.getStatus()
            });
        }
        CSVDatabase.writeCSV(CSVDatabase.LOTS_FILE, "lotID,blockID,lotArea,floorArea,tcp,rf,hdmfMax,type,status", data);
    }

    private void initializeBlocks() {
        blocks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) blocks.add(new Block(i));
        for (Lot lot : allLots) {
            for (Block block : blocks) {
                if (block.getBlockID() == lot.getBlockID()) {
                    block.addLot(lot); break;
                }
            }
        }
    }

    public List<Lot> getAllLots() { return allLots; }
    public List<Block> getBlocks() { return blocks; }

    public List<Lot> getAvailableLots() {
        List<Lot> available = new ArrayList<>();
        for (Lot lot : allLots) {
            if ("Available".equalsIgnoreCase(lot.getStatus())) available.add(lot);
        }
        return available;
    }

    public boolean reserveLot(int lotID) {
        for (Lot lot : allLots) {
            if (lot.getLotID() == lotID && "Available".equalsIgnoreCase(lot.getStatus())) {
                lot.setStatus("Reserved");
                saveLots(); 
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
    
    public void refreshData() {
        this.allLots = loadLots();
        initializeBlocks(); 
    }
    
    public void adminOverrideLotStatus(int lotId, String newStatus) {
        Lot lot = findLotById(lotId);
        if (lot != null) {
            String oldStatus = lot.getStatus();
            lot.setStatus(newStatus);
            saveLots();
            AuditManager.getInstance().logAudit("ADMIN_OVERRIDE", 0, "Lot " + lotId + " changed from " + oldStatus + " to " + newStatus);
        }
    }
}