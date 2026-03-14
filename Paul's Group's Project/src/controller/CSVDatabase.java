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
import models.Buyer;
import models.Agent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDatabase {
    private static final String LOTS_FILE = "Mock Data For Later/lots.csv";
    private static final String CLIENTS_FILE = "Mock Data For Later/clients.csv";
    private static final String AGENTS_FILE = "Mock Data For Later/agents.csv";

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

    public static List<Buyer> loadBuyers() {
        List<Buyer> buyers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CLIENTS_FILE))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] v = line.split(",");
                buyers.add(new Buyer(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), v[3].trim(), v[4].trim()));
            }
        } catch (Exception e) { System.err.println("Error reading clients.csv: " + e.getMessage()); }
        return buyers;
    }

    public static void saveBuyers(List<Buyer> buyers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CLIENTS_FILE))) {
            bw.write("id,firstName,lastName,email,password\n");
            for (Buyer b : buyers) {
                bw.write(String.format("%d,%s,%s,%s,%s\n", b.getId(), b.getFirstName(), b.getLastName(), b.getEmail(), b.getPassword()));
            }
        } catch (Exception e) { System.err.println("Error writing clients.csv: " + e.getMessage()); }
    }

    public static List<Agent> loadAgents() {
        List<Agent> agents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(AGENTS_FILE))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] v = line.split(","); // Ensure agents.csv is comma-separated, not tab-separated
                agents.add(new Agent(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), v[3].trim(), v[4].trim(), Integer.parseInt(v[5].trim()), Double.parseDouble(v[6].trim())));
            }
        } catch (Exception e) { System.err.println("Error reading agents.csv: " + e.getMessage()); }
        return agents;
    }

    public static void saveAgents(List<Agent> agents) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(AGENTS_FILE))) {
            bw.write("id,firstName,lastName,email,password,assignedBlock,totalSales\n");
            for (Agent a : agents) {
                bw.write(String.format("%d,%s,%s,%s,%s,%d,%.2f\n", a.getId(), a.getFirstName(), a.getLastName(), a.getEmail(), a.getPassword(), a.getAssignedBlock(), a.getTotalSales()));
            }
        } catch (Exception e) { System.err.println("Error writing agents.csv: " + e.getMessage()); }
    }
}