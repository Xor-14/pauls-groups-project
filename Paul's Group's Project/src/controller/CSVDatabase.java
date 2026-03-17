/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.Agent;
import models.Buyer;
import models.Lot;
import models.SaleTransaction;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDatabase {
    private static final String LOTS_FILE = "../Mock Data For Later/lots.csv";
    private static final String CLIENTS_FILE = "../Mock Data For Later/clients.csv";
    private static final String AGENTS_FILE = "../Mock Data For Later/agents.csv";
    private static final String TRANSACTIONS_FILE = "../Mock Data For Later/transactions.csv";
    private static final String AUDIT_FILE = "../Mock Data For Later/audit.csv";

    public static List<Lot> loadLots() {
        List<Lot> lots = new ArrayList<>();
        LotFactory factory = new ConcreteLotFactory(); // Instantiate the concrete factory
        
        try (BufferedReader br = new BufferedReader(new FileReader(LOTS_FILE))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] v = line.split(",");
                int id = Integer.parseInt(v[0].trim());
                int blockId = Integer.parseInt(v[1].trim());
                double lotArea = Double.parseDouble(v[2].trim());
                double floorArea = Double.parseDouble(v[3].trim());
                double tcp = Double.parseDouble(v[4].trim());
                double rf = Double.parseDouble(v[5].trim());
                double hdmfMax = Double.parseDouble(v[6].trim());
                String type = v[7].trim(); 
                String status = v[8].trim();
                
                // Use the interface method for factory design pattern
                lots.add(factory.createLot(type, id, blockId, lotArea, floorArea, tcp, rf, hdmfMax, status));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Critical IO Error reading lots.csv: " + e.getMessage());
        }
        return lots;
    }

    public static void saveLots(List<Lot> lots) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOTS_FILE))) {
            bw.write("lotID,blockID,lotArea,floorArea,tcp,rf,hdmfMax,type,status\n");
            for (Lot lot : lots) {
                String line = String.format("%d,%d,%.2f,%.2f,%.2f,%.2f,%.2f,%s,%s\n", 
                    lot.getLotID(), lot.getBlockID(), lot.getLotArea(), lot.getFloorArea(), 
                    lot.getTcp(), lot.getReservationFee(), lot.getHdmfMaxLoan(), 
                    lot.getLotType(), lot.getStatus());
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
                String[] v = line.split(",");
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
    
    public static List<SaleTransaction> loadTransactions() {
        List<SaleTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TRANSACTIONS_FILE))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] v = line.split(",");
                transactions.add(new SaleTransaction(
                    Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), v[3].trim(), 
                    Double.parseDouble(v[4].trim()), Double.parseDouble(v[5].trim()), 
                    Integer.parseInt(v[6].trim()), Integer.parseInt(v[7].trim()), Integer.parseInt(v[8].trim()), v[9].trim()
                ));
            }
        } catch (Exception e) { System.err.println("Error reading transactions.csv: " + e.getMessage()); }
        return transactions;
    }

    public static void saveTransactions(List<SaleTransaction> transactions) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE))) {
            bw.write("transactionID,date,type,financingType,amount,monthlyAmortization,lotID,buyerID,agentID,status\n");
            for (SaleTransaction t : transactions) {
                bw.write(String.format("%d,%s,%s,%s,%.2f,%.2f,%d,%d,%d,%s\n", 
                    t.getTransactionID(), t.getDate(), t.getType(), t.getFinancingType(), 
                    t.getAmount(), t.getMonthlyAmortization(), t.getLotID(), 
                    t.getBuyerID(), t.getAgentID(), t.getStatus()));
            }
        } catch (Exception e) { System.err.println("Error writing transactions.csv: " + e.getMessage()); }
    }
 
    public static java.util.List<models.AuditLog> loadAuditLogs() {
        java.util.List<models.AuditLog> logs = new java.util.ArrayList<>();
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(AUDIT_FILE))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] v = line.split(",", 5);
                logs.add(new models.AuditLog(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), Integer.parseInt(v[3].trim()), v[4].trim()));
            }
        } catch (Exception e) { System.err.println("Error reading audit.csv: " + e.getMessage()); }
        return logs;
    }

    public static void saveAuditLogs(java.util.List<models.AuditLog> logs) {
        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(AUDIT_FILE))) {
            bw.write("logId,timestamp,actionType,userId,details\n");
            for (models.AuditLog log : logs) {
                bw.write(String.format("%d,%s,%s,%d,%s\n", log.getLogId(), log.getTimestamp(), log.getActionType(), log.getUserId(), log.getDetails().replace(",", ";")));
            }
        } catch (Exception e) { System.err.println("Error writing audit.csv: " + e.getMessage()); }
    }
    
}