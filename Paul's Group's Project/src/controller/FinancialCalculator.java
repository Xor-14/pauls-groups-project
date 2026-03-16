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

    public static double calculateAmortization(double principal, double annualRate, int years) {
        if (principal <= 0 || years <= 0) return 0.0;
        double r = annualRate / 12.0;
        int n = years * 12;
        if (r == 0) return principal / n;
        
        // Emulates standard bank factor table rounding (6 decimal places) to match developer sheets
        double exactFactor = (r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        double roundedFactor = Math.round(exactFactor * 1000000.0) / 1000000.0; 
        
        return principal * roundedFactor;
    }

    public static double getRequiredNDI(double monthlyAmortization) {
        return monthlyAmortization / 0.30;
    }

    public static double getDpAmortization(double netDp, int months) {
        if (months <= 0) return netDp;
        return netDp / months;
    }

    // --- BANK FINANCING ---
    public static double getBankGrossDP(double tcp) { return tcp * 0.10; }
    public static double getBankLoanable(double tcp) { return tcp - getBankGrossDP(tcp); }
    public static double getBankNetDP(double tcp, double reservationFee) { return getBankGrossDP(tcp) - reservationFee; }
    
    public static double getBankMonthlyAmortization(double tcp, double annualRate, int years) {
        if (years > 20) throw new IllegalArgumentException("Bank max term is 20 years");
        double loanable = getBankLoanable(tcp);
        return calculateAmortization(loanable, annualRate, years); 
    }

    // --- PAG-IBIG FINANCING ---
    public static double getPagIbigLoanable(double tcp, double hdmfMaxLoanLimit) { return Math.min(tcp, hdmfMaxLoanLimit); }
    public static double getPagIbigGrossDP(double tcp, double hdmfMaxLoanLimit) { return tcp - getPagIbigLoanable(tcp, hdmfMaxLoanLimit); }
    public static double getPagIbigNetDP(double tcp, double hdmfMaxLoanLimit, double reservationFee) { return getPagIbigGrossDP(tcp, hdmfMaxLoanLimit) - reservationFee; }
    
    public static double getPagIbigMonthlyAmortization(double tcp, double hdmfMaxLoanLimit, int years) {
        if (years > 30) throw new IllegalArgumentException("Pag-IBIG max term is 30 years");
        double loanable = getPagIbigLoanable(tcp, hdmfMaxLoanLimit);
        return calculateAmortization(loanable, 0.0638, years); 
    }
}