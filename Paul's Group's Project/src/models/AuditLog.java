/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package models;

public class AuditLog {
    private int logId;
    private String timestamp;
    private String actionType; 
    private int userId; 
    private String details;

    public AuditLog(int logId, String timestamp, String actionType, int userId, String details) {
        this.logId = logId;
        this.timestamp = timestamp;
        this.actionType = actionType;
        this.userId = userId;
        this.details = details;
    }
    
    public int getLogId() { return logId; }
    public String getTimestamp() { return timestamp; }
    public String getActionType() { return actionType; }
    public int getUserId() { return userId; }
    public String getDetails() { return details; }
}