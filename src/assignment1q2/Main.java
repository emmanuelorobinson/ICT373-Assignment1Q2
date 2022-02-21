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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Magazine mag = new Magazine(1, "The Daily Express", 10.0f);
        Subscription sub = new Subscription();

        //create supplement to be added to magazine
        Supplement supplement1 = new Supplement("Supplement 1", 10.0f);
        Supplement supplement2 = new Supplement("Supplement 2", 20.0f);
        Supplement supplement3 = new Supplement("Supplement 3", 30.0f);
        Supplement supplement4 = new Supplement("Supplement 4", 40.0f);


        //add supplements to magazine
        mag.addSupplement(supplement1);
        mag.addSupplement(supplement2);
        mag.addSupplement(supplement3);
        mag.addSupplement(supplement4);


        //create a paying customer and an associate customer
        PayingCustomer customer1 = new PayingCustomer("Customer 1", "customer1@gmail.com", "credit");
        sub.addSupplement(customer1.getCustomerId(), supplement1, mag);
        sub.addSupplement(customer1.getCustomerId(), supplement2, mag);

        AssociateCustomer customer3 = new AssociateCustomer("Customer 3", "customer3@gmail.com");
        sub.addSupplement(customer3.getCustomerId(), supplement3, mag);
        sub.addSupplement(customer3.getCustomerId(), supplement4, mag);
        customer3.setPayingCustomer(customer1);

        //add customer to magazine
        mag.addCustomer(customer1);
        mag.addCustomer(customer3);

        getMonthlyCost(customer1, sub);
    

    }

    public void getMonthlyCostEmail(Magazine mag, Subscription sub) {
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

