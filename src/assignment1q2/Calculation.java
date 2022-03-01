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
public class Calculation {
    
    public static void getMonthlyCostEmail(Magazine mag, Subscription sub) {
        //for each customer in magazine call getMonthlyCost
        ArrayList<Customer> customers = mag.getCustomerList();

        for (Customer customer : customers) {
            if (customer instanceof PayingCustomer) {
                getMonthlyCost((PayingCustomer) customer, sub);
            }
        }
    }

    public static void getMonthlyCost(PayingCustomer customer, Subscription sub) {
        int weeknum = 4;

        //get supplements for customer
        ArrayList<Supplement> supplements;

        supplements = sub.getSupplements(customer.getCustomerId());
        //print out supplements details
        System.out.println("\nSupplement Details for : " + customer.getName());
        for (Supplement supplement : supplements) {
            System.out.println("Supplement: " + supplement.getName() + " Cost" + (supplement.getCost() * weeknum));
        }

        //for each associated customer get supplements
        System.out.println("Associated Customers: ");
        for (AssociateCustomer associatedCustomer : customer.getAssociateList()) {
            
            ArrayList<Supplement> associatedSupplements;
            associatedSupplements = sub.getSupplements(associatedCustomer.getCustomerId());

            for (Supplement supplement : associatedSupplements) {
                System.out.println("Name: " + associatedCustomer.getName() + " " + supplement.getName() + " Cost" + (supplement.getCost() * weeknum));
            }
        }

    }

    public void getWeeklySuppList(Customer customer, Subscription sub) {
        //get supplements for customer
        ArrayList<Supplement> supplements;
        supplements = sub.getSupplements(customer.getCustomerId());
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