/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    
    private double bdoRate = 0.065;
    private double bpiRate = 0.07;
    private double rcbcRate = 0.065;
    private double pagIbigRate = 0.0625;
    private double downPaymentPercent = 0.10;
    private double pagIbigMaxLoan = 6000000.0;
    private double miscFeePercent = 0.05;
    private double reservationFee = 20000.0;

    private FinanceManager() { loadSettings(); }
    
    private static class InstanceHolder {
        private static final FinanceManager INSTANCE = new FinanceManager();
    }
    
    public static FinanceManager getInstance() { return InstanceHolder.INSTANCE; }

    private void loadSettings() {
        List<String[]> data = CSVDatabase.readCSV(CSVDatabase.FINANCE_FILE);
        if (!data.isEmpty() && data.get(0).length >= 8) {
            String[] v = data.get(0);
            bdoRate = Double.parseDouble(v[0]);
            bpiRate = Double.parseDouble(v[1]);
            rcbcRate = Double.parseDouble(v[2]);
            pagIbigRate = Double.parseDouble(v[3]);
            downPaymentPercent = Double.parseDouble(v[4]);
            pagIbigMaxLoan = Double.parseDouble(v[5]);
            miscFeePercent = Double.parseDouble(v[6]);
            reservationFee = Double.parseDouble(v[7]);
        } else {
            saveSettings(); 
        }
    }

    private void saveSettings() {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{
            String.valueOf(bdoRate), String.valueOf(bpiRate), String.valueOf(rcbcRate), 
            String.valueOf(pagIbigRate), String.valueOf(downPaymentPercent), 
            String.valueOf(pagIbigMaxLoan), String.valueOf(miscFeePercent), String.valueOf(reservationFee)
        });
        CSVDatabase.writeCSV(CSVDatabase.FINANCE_FILE, "bdo,bpi,rcbc,pagIbig,dp,pagIbigMax,misc,resFee", data);
    }

    public void updateSettings(double bdo, double bpi, double rcbc, double pagibig, double dp, double maxLoan, double misc, double resFee) {
        this.bdoRate = bdo;
        this.bpiRate = bpi;
        this.rcbcRate = rcbc;
        this.pagIbigRate = pagibig;
        this.downPaymentPercent = dp;
        this.pagIbigMaxLoan = maxLoan;
        this.miscFeePercent = misc;
        this.reservationFee = resFee;
        saveSettings();
    }

    // Getters
    public double getBdoRate() { return bdoRate; }
    public double getBpiRate() { return bpiRate; }
    public double getRcbcRate() { return rcbcRate; }
    public double getPagIbigRate() { return pagIbigRate; }
    public double getDownPaymentPercent() { return downPaymentPercent; }
    public double getPagIbigMaxLoan() { return pagIbigMaxLoan; }
    public double getMiscFeePercent() { return miscFeePercent; }
    public double getReservationFee() { return reservationFee; }
}