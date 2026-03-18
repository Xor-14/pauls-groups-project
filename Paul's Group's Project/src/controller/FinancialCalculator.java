/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

public class FinancialCalculator {

    public static double calculateTCP(double basePrice) {
        return basePrice + (basePrice * FinanceManager.getInstance().getRate("Misc"));
    }

    public static double calculateDownPayment(double tcp) {
        return tcp * FinanceManager.getInstance().getRate("DP");
    }

    public static double calculateLoanableAmount(double tcp, double grossDownPayment) {
        return tcp - grossDownPayment;
    }

    public static double calculateMonthlyAmortization(double principal, int years, String financingType, String bankName) {
        double annualRate;
        
        if (financingType.toLowerCase().contains("pag-ibig") || financingType.toLowerCase().contains("hdmf")) {
            annualRate = FinanceManager.getInstance().getRate("PagIbig");
        } else if (financingType.toLowerCase().contains("in-house")) {
            annualRate = FinanceManager.getInstance().getRate("BDO"); // Mirrors default bank rate
        } else {
            annualRate = FinanceManager.getInstance().getRate(bankName.toUpperCase());
            if (annualRate == 0.0) annualRate = FinanceManager.getInstance().getRate("BDO");
        }
        
        double monthlyRate = annualRate / 12.0;
        int totalPayments = years * 12;
        
        if (monthlyRate == 0) return principal / totalPayments;
        
        // Standard formula
        double rawFactor = (monthlyRate * Math.pow(1 + monthlyRate, totalPayments)) / (Math.pow(1 + monthlyRate, totalPayments) - 1);
        
        // Real Estate Standard: Truncate factor rate to 6 decimal places
        double truncatedFactor = Math.floor(rawFactor * 1000000.0) / 1000000.0;
        
        return principal * truncatedFactor;
    }
}