/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package models;

public abstract class Lot {
    protected int lotID;
    protected int blockID;
    protected double sizeSqm;
    protected double basePrice;
    protected String status; // e.g., "Available", "Reserved", "Sold"

    public Lot(int lotID, int blockID, double sizeSqm, double basePrice, String status) {
        this.lotID = lotID;
        this.blockID = blockID;
        this.sizeSqm = sizeSqm;
        this.basePrice = basePrice;
        this.status = status;
    }

    public int getLotID() { return lotID; }
    public int getBlockID() { return blockID; }
    public double getSizeSqm() { return sizeSqm; }
    public double getBasePrice() { return basePrice; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Forces subclasses to define their specific type
    public abstract String getLotType();
}