/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package models;

public class AlliyahOuterLot extends Lot {
    public AlliyahOuterLot(int lotID, int blockID, double lotArea, double floorArea, double tcp, double reservationFee, double hdmfMaxLoan, String status) {
        super(lotID, blockID, lotArea, floorArea, tcp, reservationFee, hdmfMaxLoan, status);
    }

    @Override
    public String getLotType() {
        return "AlliyahOuter";
    }
}