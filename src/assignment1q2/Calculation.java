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
        // for each customer in magazine call getMonthlyCost
        ArrayList<Customer> customers = mag.getCustomerList();

        for (Customer customer : customers) {
            if (customer instanceof PayingCustomer) {
                getMonthlyCost((PayingCustomer) customer, sub, mag);
            }
        }
    }

    public static void getWeeklyEmail(Magazine mag, Subscription sub) {
        // for each customer in magazine call getMonthlyCost
        ArrayList<Customer> customers = mag.getCustomerList();

        for (Customer customer : customers) {
            getMonthlyCost((PayingCustomer) customer, sub, mag);
        }
    }

    public static void getMonthlyCost(PayingCustomer customer, Subscription sub, Magazine mag) {
        int weeknum = 4;
        float total = 0;

        // get supplements for customer
        ArrayList<Supplement> supplements;

        System.out.println("END OF THE MONTH ACCOUNT STATEMENT");

        // print out supplements details
        System.out.println("\nPAYING CUSTOMER: " + customer.getName());
        System.out.println("EMAIL: " + customer.getEmail());
        System.out.println("Subscibed to: " + mag.getTitle() + " Monthly Cost: $" + (mag.getWeeklyCost() * weeknum));
        total = mag.getWeeklyCost() * weeknum;
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");

        if (sub.getSupplements(customer.getCustomerId()) != null) {
            supplements = sub.getSupplements(customer.getCustomerId());

            for (Supplement supplement : supplements) {
                System.out.println(
                        "-->" + supplement.getName() + " Month Sum: $" + (supplement.getCost() * weeknum));
                total += supplement.getCost() * weeknum;
            }
        } else {
            System.out.println("No supplements for this customer");
        }

        System.out.println("");

        // for each associated customer get supplements
        System.out.println("PAYING FOR: ");
        System.out.println(
                "###########################################################################################################");
        for (AssociateCustomer associatedCustomer : customer.getAssociateList()) {

            ArrayList<Supplement> associatedSupplements;

            // check if sub.getSupplements is null
            System.out.println("ASSOCIATE CUSTOMER: " + associatedCustomer.getName());

            if (sub.getSupplements(associatedCustomer.getCustomerId()) != null) {
                associatedSupplements = sub.getSupplements(associatedCustomer.getCustomerId());

                for (Supplement supplement : associatedSupplements) {
                    System.out.println(
                            "--->" + supplement.getName() + " Month Sum: $" + (supplement.getCost() * weeknum));
                    total += supplement.getCost() * weeknum;
                }

                System.out.println("");

            } else {
                System.out.println("No supplements for this customer");
                System.out.println("");
            }

        }

        System.out.println("Month Total: $" + total);

    }

    public void getWeeklySuppList(Customer customer, Subscription sub, Magazine mag) {

        // get supplements for customer
        ArrayList<Supplement> supplements;

        System.out.println("WEEKLY MAGAZINE FOR " + mag.getTitle().toUpperCase() + " OUT NOW!");

        // print out supplements details
        System.out.println("\nNAME: " + customer.getName());
        System.out.println("EMAIL: " + customer.getEmail());
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");

        if (sub.getSupplements(customer.getCustomerId()) != null) {
            supplements = sub.getSupplements(customer.getCustomerId());

            for (Supplement supplement : supplements) {
                System.out.println(
                        "-->" + supplement.getName() + " Weekly Cost: $" + supplement.getCost());
            }
        } else {
            System.out.println("No supplements for this customer");
        }

        System.out.println(
                "##############################################################################################");

    }
}
