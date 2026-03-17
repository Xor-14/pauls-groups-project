/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDatabase {
    public static final String LOTS_FILE = "../Mock Data For Later/lots.csv";
    public static final String CLIENTS_FILE = "../Mock Data For Later/clients.csv";
    public static final String AGENTS_FILE = "../Mock Data For Later/agents.csv";
    public static final String ADMINS_FILE = "../Mock Data For Later/admins.csv";
    public static final String TRANSACTIONS_FILE = "../Mock Data For Later/transactions.csv";
    public static final String AUDIT_FILE = "../Mock Data For Later/audit.csv";
    public static final String FINANCE_FILE = "../Mock Data For Later/finance_settings.csv";

    public static List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return data;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] row = line.split(",");
                    if (row.length > 0 && !row[0].trim().isEmpty()) {
                        data.add(row);
                    }
                }
            }
        } catch (Exception e) { System.err.println("Read Error (" + filePath + "): " + e.getMessage()); }
        return data;
    }

    public static void writeCSV(String filePath, String header, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(header + "\n");
            for (String[] row : data) {
                bw.write(String.join(",", row) + "\n");
            }
        } catch (Exception e) { System.err.println("Write Error (" + filePath + "): " + e.getMessage()); }
    }
}