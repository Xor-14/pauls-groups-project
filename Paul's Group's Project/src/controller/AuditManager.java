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
import models.AuditLog;

public class AuditManager {
    
    private static class InstanceHolder {
        private static final AuditManager INSTANCE = new AuditManager();
    }
    
    private AuditManager() {}
    
    public static AuditManager getInstance() { 
        return InstanceHolder.INSTANCE; 
    }

    public List<AuditLog> getLogs() {
        List<AuditLog> logs = new ArrayList<>();
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.AUDIT_FILE)) {
            if(v.length >= 5) {
                // Graceful fallback for older 5-column audit.csv files
                String role = v.length >= 6 ? v[4].trim() : "Unknown";
                String details = v.length >= 6 ? v[5].trim() : v[4].trim();
                logs.add(new AuditLog(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), Integer.parseInt(v[3].trim()), role, details));
            }
        }
        return logs;
    }

    // Updated Signature
    public void logAudit(String actionType, int userId, String userRole, String details) {
        List<AuditLog> logs = getLogs();
        int newId = logs.size() + 1;
        String timestamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logs.add(new AuditLog(newId, timestamp, actionType, userId, userRole, details));

        List<String[]> data = new ArrayList<>();
        for(AuditLog log : logs) {
            data.add(new String[]{String.valueOf(log.getLogId()), log.getTimestamp(), log.getActionType(), String.valueOf(log.getUserId()), log.getUserRole(), log.getDetails().replace(",", ";")});
        }
        CSVDatabase.writeCSV(CSVDatabase.AUDIT_FILE, "logId,timestamp,actionType,userId,userRole,details", data);
    }
}