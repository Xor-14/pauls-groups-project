/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.Admin;
import models.Agent;
import models.Buyer;
import models.User;
import java.util.List;

public class UserManager {
    private List<Buyer> buyers;
    private List<Agent> agents;
    private List<Admin> admins;
    private User currentUser;

    private UserManager() {
        buyers = CSVDatabase.loadBuyers();
        agents = CSVDatabase.loadAgents();
        admins = CSVDatabase.loadAdmins();
        
        if (admins.isEmpty()) {
            registerAdmin("System", "Admin", "admin", "admin");
        }
    }
    
    private static class InstanceHolder {
        private static final UserManager INSTANCE = new UserManager();
    }

    public static UserManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public User login(String email, String password) {
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                currentUser = admin; return admin;
            }
        }
        for (Agent a : agents) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                currentUser = a; return a;
            }
        }
        for (Buyer b : buyers) {
            if (b.getEmail().equals(email) && b.getPassword().equals(password)) {
                currentUser = b; return b;
            }
        }
        return null;
    }
    
    public boolean registerAdmin(String firstName, String lastName, String email, String password) {
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email)) return false; 
        }
        int newId = admins.size() + 1;
        admins.add(new Admin(newId, firstName, lastName, email, password));
        CSVDatabase.saveAdmins(admins);
        EstateManager.getInstance().logAudit("ADMIN_REGISTERED", newId, "New admin created: " + email);
        return true;
    }

    public void deleteUser(int userId, String role) {
        if (role.equals("Agent")) {
            agents.removeIf(a -> a.getId() == userId);
            CSVDatabase.saveAgents(agents);
        } else if (role.equals("Buyer")) {
            buyers.removeIf(b -> b.getId() == userId);
            CSVDatabase.saveBuyers(buyers);
        }
        EstateManager.getInstance().logAudit("ACCOUNT_DELETED", 0, "Admin deleted " + role + " ID " + userId);
    }

    public boolean registerBuyer(String firstName, String lastName, String email, String password) {
        for (Buyer b : buyers) {
            if (b.getEmail().equals(email)) return false; 
        }
        int newId = buyers.size() + 1;
        buyers.add(new Buyer(newId, firstName, lastName, email, password));
        CSVDatabase.saveBuyers(buyers);
        EstateManager.getInstance().logAudit("BUYER_REGISTERED", newId, "New buyer created: " + email);
        return true;
    }

    public boolean registerAgent(String firstName, String lastName, String email, String password, int assignedBlock) {
        for (Agent a : agents) {
            if (a.getEmail().equals(email)) return false;
        }
        int newId = agents.size() + 1;
        agents.add(new Agent(newId, firstName, lastName, email, password, assignedBlock, 0.0));
        CSVDatabase.saveAgents(agents);
        EstateManager.getInstance().logAudit("AGENT_REGISTERED", newId, "New agent created: " + email);
        return true;
    }
    
    public Agent getAgentById(int id) {
        return agents.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public Buyer getBuyerById(int id) {
        return buyers.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public User getCurrentUser() { return currentUser; }
    public void logout() { currentUser = null; }
    public List<Agent> getAgents() { return agents; }
}