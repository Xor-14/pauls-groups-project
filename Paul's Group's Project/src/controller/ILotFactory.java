/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.Lot;

public interface ILotFactory {
    Lot createLot(String type, int lotID, int blockID, double lotArea, double floorArea, double tcp, double rf, double hdmfMax, String status);
}