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
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDatabase {
    private static final String LOTS_FILE = "Mock Data For Later/lots.csv";

    public static List<Lot> loadLots() {
        List<Lot> lots = new ArrayList<>();
        String line;
        
        try (BufferedReader br = new BufferedReader(new FileReader(LOTS_FILE))) {
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());
                int blockId = Integer.parseInt(values[1].trim());
                double size = Double.parseDouble(values[2].trim());
                double price = Double.parseDouble(values[3].trim());
                String type = values[4].trim(); 
                String status = values[5].trim();
                
                lots.add(LotFactory.createLot(type, id, blockId, size, price, status));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Critical IO Error reading lots.csv: " + e.getMessage());
        }
        return lots;
    }

    public static void saveLots(List<Lot> lots) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOTS_FILE))) {
            bw.write("lotID,blockID,sizeSqm,basePrice,type,status\n");
            for (Lot lot : lots) {
                String line = String.format("%d,%d,%.2f,%.2f,%s,%s\n", 
                    lot.getLotID(), lot.getBlockID(), lot.getSizeSqm(), lot.getBasePrice(), lot.getLotType(), lot.getStatus());
                bw.write(line);
            }
        } catch (IOException e) {
            System.err.println("Critical IO Error writing to lots.csv: " + e.getMessage());
        }
    }
}