/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import models.SaleTransaction;
import models.Agent;
import models.Buyer;

public class ReportGenerator {

    public static String buildReportString(List<SaleTransaction> transactions, int agentId) {
        Agent agent = UserManager.getInstance().getAgentById(agentId);
        String agentName = (agent != null) ? agent.getFirstName() + " " + agent.getLastName() : "Unknown Agent";

        StringBuilder sb = new StringBuilder();
        sb.append("ESTATE SALES REPORT\n");
        sb.append("Generated: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
        sb.append("Agent: ").append(agentName).append(" (ID: ").append(agentId).append(")\n");
        sb.append("--------------------------------------------------\n");
        
        double totalSales = 0;
        int count = 0;
        for (SaleTransaction t : transactions) {
            if (t.getAgentID() == agentId && t.getStatus().equals("Approved")) {
                Buyer buyer = UserManager.getInstance().getBuyerById(t.getBuyerID());
                String buyerName = (buyer != null) ? buyer.getFirstName() + " " + buyer.getLastName() : "Unknown Buyer";

                sb.append(String.format("Trans ID: %d | Lot: %d | Buyer: %s (ID: %d) | %s | PHP %,.2f\n", 
                        t.getTransactionID(), t.getLotID(), buyerName, t.getBuyerID(), t.getFinancingType(), t.getAmount()));
                totalSales += t.getAmount();
                count++;
            }
        }
        sb.append("--------------------------------------------------\n");
        sb.append("Total Approved Transactions: ").append(count).append("\n");
        sb.append(String.format("Total Sales Volume: PHP %,.2f\n", totalSales));
        return sb.toString();
    }

    public static String getDownloadsPath(String fileName) {
        String home = System.getProperty("user.home");
        return home + File.separator + "Downloads" + File.separator + fileName;
    }

    public static boolean exportToTXT(String content, String fileName) {
        String filePath = getDownloadsPath(fileName);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            return true;
        } catch (IOException e) { 
            System.err.println("Export Error: " + e.getMessage());
            return false; 
        }
    }
}