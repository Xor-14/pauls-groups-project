/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import models.SaleTransaction;

public class ReportGenerator {

    public static String buildReportString(List<SaleTransaction> transactions, int agentId) {
        StringBuilder sb = new StringBuilder();
        sb.append("ESTATE SALES REPORT\n");
        sb.append("Generated: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
        sb.append("Agent ID: ").append(agentId).append("\n");
        sb.append("--------------------------------------------------\n");
        
        double totalSales = 0;
        int count = 0;
        for (SaleTransaction t : transactions) {
            if (t.getAgentID() == agentId && t.getStatus().equals("Approved")) {
                sb.append(String.format("Trans ID: %d | Lot: %d | %s | PHP %,.2f\n", 
                        t.getTransactionID(), t.getLotID(), t.getFinancingType(), t.getAmount()));
                totalSales += t.getAmount();
                count++;
            }
        }
        sb.append("--------------------------------------------------\n");
        sb.append("Total Approved Transactions: ").append(count).append("\n");
        sb.append(String.format("Total Sales Volume: PHP %,.2f\n", totalSales));
        return sb.toString();
    }

    public static boolean exportToTXT(String content, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            return true;
        } catch (IOException e) { return false; }
    }
}