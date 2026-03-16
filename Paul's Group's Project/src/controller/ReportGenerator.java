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
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportGenerator {

    public static void generateTextReport() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "Inventory_Report_" + timestamp + ".txt";
        
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("REAL ESTATE INVENTORY REPORT\n");
            writer.write("Generated: " + new Date().toString() + "\n\n");
            writer.write(String.format("%-8s %-8s %-12s %-12s %-15s %-15s %-12s\n", 
                "Lot ID", "Block ID", "Lot Area", "Floor Area", "TCP (PHP)", "Type", "Status"));
            writer.write("----------------------------------------------------------------------------------------\n");
            
            List<Lot> lots = EstateManager.getInstance().getAllLots();
            for (Lot lot : lots) {
                writer.write(String.format("%-8d %-8d %-12.2f %-12.2f %-15.2f %-15s %-12s\n", 
                    lot.getLotID(), lot.getBlockID(), lot.getLotArea(), lot.getFloorArea(), 
                    lot.getTcp(), lot.getLotType(), lot.getStatus()));
            }
            System.out.println("Report successfully generated: " + filename);
        } catch (IOException e) {
            System.err.println("Failed to generate report: " + e.getMessage());
        }
    }
}