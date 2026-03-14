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
    private static EstateManager instance;
    private List<Lot> allLots;
    private List<Block> blocks;

    private EstateManager() {
        allLots = CSVDatabase.loadLots();
        initializeBlocks();
    }

    public static EstateManager getInstance() {
        if (instance == null) {
            instance = new EstateManager();
        }
        return instance;
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
}