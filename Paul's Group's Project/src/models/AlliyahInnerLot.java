/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package models;

public class AlliyahInnerLot extends Lot {
    public AlliyahInnerLot(int lotID, int blockID, double sizeSqm, double basePrice, String status) {
        super(lotID, blockID, sizeSqm, basePrice, status);
    }

    @Override
    public String getLotType() {
        return "AlliyahInner";
    }
}
