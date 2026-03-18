/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private User currentUser;

    private UserManager() {
        users = new ArrayList<>();
        loadAllUsers();
        if (getUserById(1, "Admin") == null && users.stream().noneMatch(u -> u instanceof Admin)) {
            register(new Admin(0, "System", "Admin", "admin", "admin"));
        }
    }
    
    private static class InstanceHolder { private static final UserManager INSTANCE = new UserManager(); }
    public static UserManager getInstance() { return InstanceHolder.INSTANCE; }

    private void loadAllUsers() {
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.CLIENTS_FILE)) if(v.length>=5) users.add(new Buyer(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4]));
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.AGENTS_FILE)) if(v.length>=7) users.add(new Agent(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4], Integer.parseInt(v[5]), Double.parseDouble(v[6])));
        for(String[] v : CSVDatabase.readCSV(CSVDatabase.ADMINS_FILE)) if(v.length>=5) users.add(new Admin(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4]));
    }

    public void saveAllUsers() {
        List<String[]> buyers = new ArrayList<>(), agents = new ArrayList<>(), admins = new ArrayList<>();
        for(User u : users) {
            if(u instanceof Buyer) buyers.add(new String[]{String.valueOf(u.getId()), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword()});
            else if(u instanceof Agent) { Agent a = (Agent)u; agents.add(new String[]{String.valueOf(a.getId()), a.getFirstName(), a.getLastName(), a.getEmail(), a.getPassword(), String.valueOf(a.getAssignedBlock()), String.valueOf(a.getTotalSales())}); }
            else if(u instanceof Admin) admins.add(new String[]{String.valueOf(u.getId()), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword()});
        }
        CSVDatabase.writeCSV(CSVDatabase.CLIENTS_FILE, "id,firstName,lastName,email,password", buyers);
        CSVDatabase.writeCSV(CSVDatabase.AGENTS_FILE, "id,firstName,lastName,email,password,assignedBlock,totalSales", agents);
        CSVDatabase.writeCSV(CSVDatabase.ADMINS_FILE, "id,firstName,lastName,email,password", admins);
    }

    public User login(String email, String password) {
        for (User u : users) if (u.getEmail().equals(email) && u.getPassword().equals(password)) { currentUser = u; return u; }
        return null;
    }
    
    public boolean register(User user) {
        if (users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) return false;
        user.setId((int) users.stream().filter(u -> u.getClass().equals(user.getClass())).count() + 1);
        users.add(user);
        saveAllUsers();
        AuditManager.getInstance().logAudit(user.getClass().getSimpleName().toUpperCase() + "_REGISTERED", user.getId(), user.getClass().getSimpleName(), "New account: " + user.getEmail());
        return true;
    }

    public User getUserById(int id, String role) {
        return users.stream().filter(u -> u.getClass().getSimpleName().equalsIgnoreCase(role) && u.getId() == id).findFirst().orElse(null);
    }

    public void deleteUser(int userId, String role) {
        users.removeIf(u -> u.getClass().getSimpleName().equalsIgnoreCase(role) && u.getId() == userId);
        saveAllUsers();
        AuditManager.getInstance().logAudit("ACCOUNT_DELETED", 0, "Admin", "Deleted " + role + " ID " + userId);
    }

    public boolean updateCurrentUser(String f, String l, String e, String p) {
        if (users.stream().anyMatch(u -> u.getEmail().equals(e) && u.getId() != currentUser.getId())) return false;
        currentUser.setFirstName(f); currentUser.setLastName(l); currentUser.setEmail(e); currentUser.setPassword(p);
        saveAllUsers();
        return true;
    }

    public User getCurrentUser() { return currentUser; }
    public void logout() { currentUser = null; }
}