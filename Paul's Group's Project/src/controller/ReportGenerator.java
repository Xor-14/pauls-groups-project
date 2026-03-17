/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

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

    private static String getDynamicFileName(int agentId, String extension) {
        Agent agent = UserManager.getInstance().getAgentById(agentId);
        String name = (agent != null) ? agent.getFirstName() + "_" + agent.getLastName() : "Unknown_Agent";
        // Remove spaces to ensure safe filenames
        return name.replaceAll("\\s+", "_") + "_Report" + extension;
    }

    public static String getDownloadsPath(String fileName) {
        String home = System.getProperty("user.home");
        return home + File.separator + "Downloads" + File.separator + fileName;
    }

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

    public static boolean exportToTXT(String content, int agentId) {
        String fileName = getDynamicFileName(agentId, ".txt");
        String filePath = getDownloadsPath(fileName);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            return true;
        } catch (IOException e) { 
            System.err.println("TXT Export Error: " + e.getMessage());
            return false; 
        }
    }

    public static boolean exportToPDF(String content, int agentId) {
        String fileName = getDynamicFileName(agentId, ".pdf");
        String filePath = getDownloadsPath(fileName);
        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(content));
            document.close();
            return true;
        } catch (Exception e) {
            System.err.println("PDF Export Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean exportToCSV(List<SaleTransaction> transactions, int agentId) {
        String fileName = getDynamicFileName(agentId, ".csv");
        String filePath = getDownloadsPath(fileName);
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write CSV Headers
            writer.write("Transaction ID,Date,Lot ID,Buyer Name,Buyer ID,Financing Type,Amount\n");
            
            for (SaleTransaction t : transactions) {
                if (t.getAgentID() == agentId && t.getStatus().equals("Approved")) {
                    Buyer buyer = UserManager.getInstance().getBuyerById(t.getBuyerID());
                    String buyerName = (buyer != null) ? buyer.getFirstName() + " " + buyer.getLastName() : "Unknown Buyer";
                    
                    // Format row data
                    writer.write(String.format("%d,%s,%d,%s,%d,%s,%.2f\n",
                        t.getTransactionID(), t.getDate(), t.getLotID(), buyerName, 
                        t.getBuyerID(), t.getFinancingType(), t.getAmount()));
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("CSV Export Error: " + e.getMessage());
            return false;
        }
    }
}