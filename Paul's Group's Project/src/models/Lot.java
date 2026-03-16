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
    protected double lotArea;
    protected double floorArea;
    protected double tcp; // Total Contract Price
    protected double reservationFee;
    protected double hdmfMaxLoan;
    protected String status;

    public Lot(int lotID, int blockID, double lotArea, double floorArea, double tcp, double reservationFee, double hdmfMaxLoan, String status) {
        this.lotID = lotID;
        this.blockID = blockID;
        this.lotArea = lotArea;
        this.floorArea = floorArea;
        this.tcp = tcp;
        this.reservationFee = reservationFee;
        this.hdmfMaxLoan = hdmfMaxLoan;
        this.status = status;
    }

    public int getLotID() { return lotID; }
    public int getBlockID() { return blockID; }
    public double getLotArea() { return lotArea; }
    public double getFloorArea() { return floorArea; }
    public double getTcp() { return tcp; }
    public double getReservationFee() { return reservationFee; }
    public double getHdmfMaxLoan() { return hdmfMaxLoan; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public abstract String getLotType();
}