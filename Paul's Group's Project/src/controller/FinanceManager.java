/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class FinanceManager {
    private Map<String, Double> settings;
    private final String[] KEYS = {"BDO", "BPI", "RCBC", "PagIbig", "DP", "MaxLoan", "Misc", "ResFee", "InHouseDP", "InHouseResFee", "InHouse5", "InHouse10"};
    private final double[] DEFAULTS = {0.065, 0.07, 0.065, 0.0625, 0.10, 6000000.0, 0.05, 20000.0, 0.20, 30000.0, 0.16, 0.18};

    private FinanceManager() {
        settings = new HashMap<>();
        loadSettings();
    }
    
    private static class InstanceHolder { private static final FinanceManager INSTANCE = new FinanceManager(); }
    public static FinanceManager getInstance() { return InstanceHolder.INSTANCE; }

    private void loadSettings() {
        List<String[]> data = CSVDatabase.readCSV(CSVDatabase.FINANCE_FILE);
        if (!data.isEmpty() && data.get(0).length >= KEYS.length) {
            for (int i = 0; i < KEYS.length; i++) settings.put(KEYS[i], Double.parseDouble(data.get(0)[i]));
        } else {
            for (int i = 0; i < KEYS.length; i++) settings.put(KEYS[i], DEFAULTS[i]);
            saveSettings();
        }
    }

    public void saveSettings() {
        List<String[]> data = new ArrayList<>();
        String[] values = new String[KEYS.length];
        for (int i = 0; i < KEYS.length; i++) values[i] = String.valueOf(settings.get(KEYS[i]));
        data.add(values);
        CSVDatabase.writeCSV(CSVDatabase.FINANCE_FILE, String.join(",", KEYS), data);
    }

    public double getRate(String key) { return settings.getOrDefault(key, 0.0); }
    public void updateSetting(String key, double value) { settings.put(key, value); }
}