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

// Import these ONLY if you use the PDF method below. Requires iText jar.
// import com.itextpdf.text.Document;
// import com.itextpdf.text.Paragraph;
// import com.itextpdf.text.pdf.PdfWriter;
// import java.io.FileOutputStream;

public class ReportGenerator {

    // SAFE METHOD: Generates a text file report instantly. Fulfills project requirements.
    public static void generateTextReport() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "Inventory_Report_" + timestamp + ".txt";
        
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("REAL ESTATE INVENTORY REPORT\n");
            writer.write("Generated: " + new Date().toString() + "\n\n");
            writer.write(String.format("%-10s %-10s %-15s %-15s %-15s %-15s\n", "Lot ID", "Block ID", "Size (SQM)", "Base Price", "Type", "Status"));
            writer.write("--------------------------------------------------------------------------------\n");
            
            List<Lot> lots = EstateManager.getInstance().getAllLots();
            for (Lot lot : lots) {
                writer.write(String.format("%-10d %-10d %-15.2f %-15.2f %-15s %-15s\n", 
                    lot.getLotID(), lot.getBlockID(), lot.getSizeSqm(), lot.getBasePrice(), lot.getLotType(), lot.getStatus()));
            }
            System.out.println("Report successfully generated: " + filename);
        } catch (IOException e) {
            System.err.println("Failed to generate report: " + e.getMessage());
        }
    }

    /* RISKY METHOD: Requires adding itextpdf-5.5.13.3.jar to Netbeans Libraries.
    Uncomment to use.
    
    public static void generatePDFReport() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "Inventory_Report_" + timestamp + ".pdf";
        Document document = new Document();
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            document.add(new Paragraph("REAL ESTATE INVENTORY REPORT"));
            document.add(new Paragraph("Generated: " + new Date().toString() + "\n\n"));
            
            List<Lot> lots = EstateManager.getInstance().getAllLots();
            for (Lot lot : lots) {
                String line = String.format("Lot ID: %d | Block: %d | Size: %.2f SQM | Price: %.2f | Type: %s | Status: %s", 
                    lot.getLotID(), lot.getBlockID(), lot.getSizeSqm(), lot.getBasePrice(), lot.getLotType(), lot.getStatus());
                document.add(new Paragraph(line));
            }
            System.out.println("PDF Report successfully generated: " + filename);
        } catch (Exception e) {
            System.err.println("Failed to generate PDF: " + e.getMessage());
        } finally {
            document.close();
        }
    }
    */
}