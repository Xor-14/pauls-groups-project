/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.AlliyahInnerLot;
import models.AlliyahOuterLot;
import models.CallistaLot;
import models.Lot;

public class LotFactory {
    public static Lot createLot(String type, int lotID, int blockID, double sizeSqm, double basePrice, String status) {
        if (type == null) {
            throw new IllegalArgumentException("Lot type cannot be null");
        }
        
        switch (type.trim().toLowerCase()) {
            case "callista":
                return new CallistaLot(lotID, blockID, sizeSqm, basePrice, status);
            case "alliyahinner":
                return new AlliyahInnerLot(lotID, blockID, sizeSqm, basePrice, status);
            case "alliyahouter":
                return new AlliyahOuterLot(lotID, blockID, sizeSqm, basePrice, status);
            default:
                throw new IllegalArgumentException("Unknown lot type: " + type);
        }
    }
}
