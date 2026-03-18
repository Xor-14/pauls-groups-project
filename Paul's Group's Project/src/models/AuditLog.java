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
    private String userRole; // NEW ATTRIBUTE
    private String details;

    public AuditLog(int logId, String timestamp, String actionType, int userId, String userRole, String details) {
        this.logId = logId;
        this.timestamp = timestamp;
        this.actionType = actionType;
        this.userId = userId;
        this.userRole = userRole;
        this.details = details;
    }

    public int getLogId() { return logId; }
    public void setLogId(int logId) { this.logId = logId; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public String getUserRole() { return userRole; }
    public void setUserRole(String userRole) { this.userRole = userRole; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}