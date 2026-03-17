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
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<Buyer> buyers;
    private List<Agent> agents;
    private List<Admin> admins;
    private User currentUser;

    private UserManager() {
        buyers = loadBuyers();
        agents = loadAgents();
        admins = loadAdmins();
        
        if (admins.isEmpty()) {
            register(new Admin(0, "System", "Admin", "admin", "admin"));
        }
    }
    
    private static class InstanceHolder {
        private static final UserManager INSTANCE = new UserManager();
    }

    public static UserManager getInstance() { return InstanceHolder.INSTANCE; }

    // --- PARSERS ---
    private List<Buyer> loadBuyers() {
        List<Buyer> list = new ArrayList<>();
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.CLIENTS_FILE)) {
            if(v.length >= 5) list.add(new Buyer(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), v[3].trim(), v[4].trim()));
        }
        return list;
    }

    private List<Agent> loadAgents() {
        List<Agent> list = new ArrayList<>();
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.AGENTS_FILE)) {
            if(v.length >= 7) list.add(new Agent(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), v[3].trim(), v[4].trim(), Integer.parseInt(v[5].trim()), Double.parseDouble(v[6].trim())));
        }
        return list;
    }

    private List<Admin> loadAdmins() {
        List<Admin> list = new ArrayList<>();
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.ADMINS_FILE)) {
            if(v.length >= 5) list.add(new Admin(Integer.parseInt(v[0].trim()), v[1].trim(), v[2].trim(), v[3].trim(), v[4].trim()));
        }
        return list;
    }

    // --- WRITERS ---
    public void saveBuyers() {
        List<String[]> data = new ArrayList<>();
        for(Buyer b : buyers) data.add(new String[]{String.valueOf(b.getId()), b.getFirstName(), b.getLastName(), b.getEmail(), b.getPassword()});
        CSVDatabase.writeCSV(CSVDatabase.CLIENTS_FILE, "id,firstName,lastName,email,password", data);
    }

    public void saveAgents() {
        List<String[]> data = new ArrayList<>();
        for(Agent a : agents) data.add(new String[]{String.valueOf(a.getId()), a.getFirstName(), a.getLastName(), a.getEmail(), a.getPassword(), String.valueOf(a.getAssignedBlock()), String.valueOf(a.getTotalSales())});
        CSVDatabase.writeCSV(CSVDatabase.AGENTS_FILE, "id,firstName,lastName,email,password,assignedBlock,totalSales", data);
    }

    public void saveAdmins() {
        List<String[]> data = new ArrayList<>();
        for(Admin a : admins) data.add(new String[]{String.valueOf(a.getId()), a.getFirstName(), a.getLastName(), a.getEmail(), a.getPassword()});
        CSVDatabase.writeCSV(CSVDatabase.ADMINS_FILE, "id,firstName,lastName,email,password", data);
    }

    // --- CORE LOGIC ---
    public User login(String email, String password) {
        for (Admin admin : admins) if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) { currentUser = admin; return admin; }
        for (Agent a : agents) if (a.getEmail().equals(email) && a.getPassword().equals(password)) { currentUser = a; return a; }
        for (Buyer b : buyers) if (b.getEmail().equals(email) && b.getPassword().equals(password)) { currentUser = b; return b; }
        return null;
    }
    
    public boolean register(User user) {
        if (isEmailTaken(user.getEmail())) return false;
        
        if (user instanceof Admin) {
            user.setId(admins.size() + 1);
            admins.add((Admin) user);
            saveAdmins();
            AuditManager.getInstance().logAudit("ADMIN_REGISTERED", user.getId(), "New admin created: " + user.getEmail());
        } else if (user instanceof Agent) {
            user.setId(agents.size() + 1);
            agents.add((Agent) user);
            saveAgents();
            AuditManager.getInstance().logAudit("AGENT_REGISTERED", user.getId(), "New agent created: " + user.getEmail());
        } else if (user instanceof Buyer) {
            user.setId(buyers.size() + 1);
            buyers.add((Buyer) user);
            saveBuyers();
            AuditManager.getInstance().logAudit("BUYER_REGISTERED", user.getId(), "New buyer created: " + user.getEmail());
        }
        return true;
    }

    private boolean isEmailTaken(String email) {
        return admins.stream().anyMatch(a -> a.getEmail().equals(email)) || agents.stream().anyMatch(a -> a.getEmail().equals(email)) || buyers.stream().anyMatch(b -> b.getEmail().equals(email));
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
            saveAgents();
        } else if (role.equals("Buyer")) {
            buyers.removeIf(b -> b.getId() == userId);
            saveBuyers();
        }
        AuditManager.getInstance().logAudit("ACCOUNT_DELETED", 0, "Admin deleted " + role + " ID " + userId);
    }

    public User getCurrentUser() { return currentUser; }
    public void logout() { currentUser = null; }
    public List<Agent> getAgents() { return agents; }
}