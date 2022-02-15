/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class MagazineService {
    private ArrayList<Magazine> magazines;
    private ArrayList<Customer> customers;
    private ArrayList<Supplement> supplements;

    public MagazineService() {
        this.magazines = new ArrayList<Magazine>();
        this.customers = new ArrayList<Customer>();
        this.supplements = new ArrayList<Supplement>();
    }

    public ArrayList<Magazine> getMagazines() {
        return magazines;
    }

    public void addMagazine(Magazine magazine) {
        this.magazines.add(magazine);
    }
    
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    public void getMonthlyCost(PayingCustomer customer) {
        int weeknum = 4;

        //get supplements for customer
        ArrayList<Supplement> supplements = customer.getSupplements();
        
        //print out supplements details
        System.out.println("\nSupplement Details for : " + customer.getName());
        for (Supplement supplement : supplements) {
            System.out.println("Supplement: " + supplement.getName() + " Cost" + (supplement.getCost() * weeknum));
        }

        //for each associated customer get supplements
        System.out.println("Associated Customers: ");
        for (AssociateCustomer associatedCustomer : customer.getAssociateList()) {
            ArrayList<Supplement> associatedSupplements = associatedCustomer.getSupplements();
            for (Supplement supplement : associatedSupplements) {
                System.out.println("Name: " + associatedCustomer.getName() + " " + supplement.getName() + " Cost" + (supplement.getCost() * weeknum));
            }
        }

    }

    public void getMonthlyCostEmail() {
        for (Customer customer : customers) {
            if (customer instanceof PayingCustomer) {
                getMonthlyCost((PayingCustomer) customer);
            }
        }
    }

    public void getWeeklySuppList(Customer customer) {
        //get supplements for customer
        ArrayList<Supplement> supplements = customer.getSupplements();
        //print out supplements details
        //check if supplements is empty
        if (supplements.isEmpty()) {
            System.out.println("No supplements added");
        } else {
            for (Supplement supplement : supplements) {
                System.out.println("Supplement: " + supplement.getName() + " Cost" + supplement.getCost());
            }
        }
    }
}





