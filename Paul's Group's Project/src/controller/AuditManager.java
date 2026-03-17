/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import java.util.List;
import models.AuditLog;

public class AuditManager {
    
    private AuditManager() {}
    
    private static class InstanceHolder {
        private static final AuditManager INSTANCE = new AuditManager();
    }
    
    public static AuditManager getInstance() { 
        return InstanceHolder.INSTANCE; 
    }

    public void logAudit(String actionType, int userId, String details) {
        List<AuditLog> logs = CSVDatabase.loadAuditLogs();
        int newId = logs.size() + 1;
        String timestamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logs.add(new AuditLog(newId, timestamp, actionType, userId, details));
        CSVDatabase.saveAuditLogs(logs);
    }
    
    public List<AuditLog> getLogs() {
        return CSVDatabase.loadAuditLogs();
    }
}