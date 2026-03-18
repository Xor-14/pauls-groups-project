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
        double annualRate = financingType.equalsIgnoreCase("Bank") ? FinanceManager.getInstance().getRate(bankName.toUpperCase()) : FinanceManager.getInstance().getRate("PagIbig");
        double monthlyRate = annualRate / 12;
        int totalPayments = years * 12;
        
        if (monthlyRate == 0) return principal / totalPayments;
        return (principal * monthlyRate * Math.pow(1 + monthlyRate, totalPayments)) / (Math.pow(1 + monthlyRate, totalPayments) - 1);
    }
}