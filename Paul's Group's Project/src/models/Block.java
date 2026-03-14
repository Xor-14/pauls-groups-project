/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package models;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private int blockID;
    private List<Lot> lots;

    public Block(int blockID) {
        this.blockID = blockID;
        this.lots = new ArrayList<>();
    }

    public void addLot(Lot lot) {
        this.lots.add(lot);
    }

    public int getBlockID() { return blockID; }
    public List<Lot> getLots() { return lots; }
}
