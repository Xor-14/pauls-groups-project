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
        double miscFee = basePrice * FinanceManager.getInstance().getMiscFeePercent();
        return basePrice + miscFee;
    }

    public static double calculateDownPayment(double tcp) {
        return tcp * FinanceManager.getInstance().getDownPaymentPercent();
    }

    public static double calculateLoanableAmount(double tcp, double grossDownPayment) {
        return tcp - grossDownPayment;
    }

    public static double calculateMonthlyAmortization(double principal, int years, String financingType, String bankName) {
        double annualRate;
        
        if (financingType.equalsIgnoreCase("Pag-IBIG") || financingType.equalsIgnoreCase("HDMF")) {
            annualRate = FinanceManager.getInstance().getPagIbigRate();
        } else {
            switch (bankName.toUpperCase()) {
                case "BPI": annualRate = FinanceManager.getInstance().getBpiRate(); break;
                case "RCBC": annualRate = FinanceManager.getInstance().getRcbcRate(); break;
                case "BDO": 
                default: annualRate = FinanceManager.getInstance().getBdoRate(); break;
            }
        }
            
        double monthlyRate = annualRate / 12;
        int totalPayments = years * 12;
        
        if (monthlyRate == 0) return principal / totalPayments;
        
        return (principal * monthlyRate * Math.pow(1 + monthlyRate, totalPayments)) 
             / (Math.pow(1 + monthlyRate, totalPayments) - 1);
    }
    
    public static boolean isEligibleForPagIbig(double loanableAmount) {
        return loanableAmount <= FinanceManager.getInstance().getPagIbigMaxLoan();
    }
}