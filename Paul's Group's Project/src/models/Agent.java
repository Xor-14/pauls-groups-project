/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package models;

public class Agent extends User {
    private int assignedBlock;
    private double totalSales;

    public Agent(int id, String firstName, String lastName, String email, String password, int assignedBlock, double totalSales) {
        super(id, firstName, lastName, email, password);
        this.assignedBlock = assignedBlock;
        this.totalSales = totalSales;
    }

    public int getAssignedBlock() { return assignedBlock; }
    public double getTotalSales() { return totalSales; }
    public void addSale(double amount) { this.totalSales += amount; }
}