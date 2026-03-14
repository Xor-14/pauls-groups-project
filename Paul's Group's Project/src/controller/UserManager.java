/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package controller;

import models.Agent;
import models.Buyer;
import models.User;
import java.util.List;

public class UserManager {
    private List<Buyer> buyers;
    private List<Agent> agents;
    private User currentUser;

    private UserManager() {
        buyers = CSVDatabase.loadBuyers();
        agents = CSVDatabase.loadAgents();
    }
    
    private static class InstanceHolder {
        private static final UserManager INSTANCE = new UserManager();
    }

    public static UserManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public User login(String email, String password) {
        for (Agent a : agents) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                currentUser = a;
                return a;
            }
        }
        for (Buyer b : buyers) {
            if (b.getEmail().equals(email) && b.getPassword().equals(password)) {
                currentUser = b;
                return b;
            }
        }
        return null;
    }

    public boolean registerBuyer(String firstName, String lastName, String email, String password) {
        for (Buyer b : buyers) {
            if (b.getEmail().equals(email)) return false; // Email exists
        }
        int newId = buyers.size() + 1;
        buyers.add(new Buyer(newId, firstName, lastName, email, password));
        CSVDatabase.saveBuyers(buyers);
        return true;
    }

    public User getCurrentUser() { return currentUser; }
    public void logout() { currentUser = null; }
    public List<Agent> getAgents() { return agents; }
}