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

public class ConcreteLotFactory implements LotFactory {
    @Override
    public Lot createLot(String type, int lotID, int blockID, double lotArea, double floorArea, double tcp, double rf, double hdmfMax, String status) {
        if (type == null) {
            throw new IllegalArgumentException("Lot type cannot be null");
        }
        
        switch (type.trim().toLowerCase()) {
            case "callista":
                return new CallistaLot(lotID, blockID, lotArea, floorArea, tcp, rf, hdmfMax, status);
            case "alliyahinner":
                return new AlliyahInnerLot(lotID, blockID, lotArea, floorArea, tcp, rf, hdmfMax, status);
            case "alliyahouter":
                return new AlliyahOuterLot(lotID, blockID, lotArea, floorArea, tcp, rf, hdmfMax, status);
            default:
                throw new IllegalArgumentException("Unknown lot type: " + type);
        }
    }
}