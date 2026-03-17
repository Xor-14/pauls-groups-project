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
            register(new Admin(0, "System", "Admin", "admin", "admin"));
        }
    }
    
    private static class InstanceHolder {
        private static final UserManager INSTANCE = new UserManager();
    }

    public static UserManager getInstance() { return InstanceHolder.INSTANCE; }

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
    
    public boolean register(User user) {
        if (isEmailTaken(user.getEmail())) return false;
        
        if (user instanceof Admin) {
            user.setId(admins.size() + 1);
            admins.add((Admin) user);
            CSVDatabase.saveAdmins(admins);
            AuditManager.getInstance().logAudit("ADMIN_REGISTERED", user.getId(), "New admin created: " + user.getEmail());
        } else if (user instanceof Agent) {
            user.setId(agents.size() + 1);
            agents.add((Agent) user);
            CSVDatabase.saveAgents(agents);
            AuditManager.getInstance().logAudit("AGENT_REGISTERED", user.getId(), "New agent created: " + user.getEmail());
        } else if (user instanceof Buyer) {
            user.setId(buyers.size() + 1);
            buyers.add((Buyer) user);
            CSVDatabase.saveBuyers(buyers);
            AuditManager.getInstance().logAudit("BUYER_REGISTERED", user.getId(), "New buyer created: " + user.getEmail());
        }
        return true;
    }

    private boolean isEmailTaken(String email) {
        return admins.stream().anyMatch(a -> a.getEmail().equals(email)) ||
               agents.stream().anyMatch(a -> a.getEmail().equals(email)) ||
               buyers.stream().anyMatch(b -> b.getEmail().equals(email));
    }

    public User getUserById(int id, String role) {
        if (role.equalsIgnoreCase("Admin")) return admins.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (role.equalsIgnoreCase("Agent")) return agents.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (role.equalsIgnoreCase("Buyer")) return buyers.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        return null;
    }

    public void deleteUser(int userId, String role) {
        if (role.equals("Agent")) {
            agents.removeIf(a -> a.getId() == userId);
            CSVDatabase.saveAgents(agents);
        } else if (role.equals("Buyer")) {
            buyers.removeIf(b -> b.getId() == userId);
            CSVDatabase.saveBuyers(buyers);
        }
        AuditManager.getInstance().logAudit("ACCOUNT_DELETED", 0, "Admin deleted " + role + " ID " + userId);
    }

    public User getCurrentUser() {return currentUser;}
    public void logout() {currentUser = null;}
    public List<Agent> getAgents() {return agents;}
}