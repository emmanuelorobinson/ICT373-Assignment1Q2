/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create arraylist of supplements
        ArrayList<Supplement> magazine = new ArrayList<Supplement>();

        // call method to add supplements to arraylist
        addSupplements(magazine);

        // crear array list of customers
        ArrayList<Customer> customers = new ArrayList<>();

        // call method to display supplements
        magazine.forEach((supplement) -> {
            supplement.getSupplementsDetails();
        });

    }

    // create function to add supplements
    public static void addSupplements(ArrayList<Supplement> magazine) {
        // create new scanner
        Scanner input = new Scanner(System.in);
        // ask user to enter the supplements
        System.out.println("Enter the supplements");
        System.out.println("Enter the name of the supplement: ");
        String name = input.nextLine();
        System.out.println("Enter the cost of the supplement: ");
        float cost = input.nextFloat();
        // add the supplements to the arraylist
        magazine.add(new Supplement(name, cost));

        // close scanner
        input.close();
    }

    // create function to add customers
    public static void addCustomers(ArrayList<Customer> customers) {
        // create new scanner
        Scanner input = new Scanner(System.in);
        // ask user to enter the type of customer
        System.out.println("Enter the type of customer");
        System.out.println("Enter 1 for associate customer");
        System.out.println("Enter 2 for paid customer");
        int userInput = input.nextInt();

        String customerName;
        String customerEmail;

        System.out.println("Enter the name of the customer: ");
        customerName = input.nextLine();

        System.out.println("Enter the email of the customer: ");
        customerEmail = input.nextLine();

        // create switch statement to store associate customer
        switch (userInput) {
            case 1:
                // ask user to enter associate id
                System.out.println("Enter the associate id: ");
                int associateId = input.nextInt();
                // create associate customer
                AssociateCustomer associateCustomer = new AssociateCustomer(customerName, customerEmail, associateId);

                // add associate customer to arraylist
                customers.add(associateCustomer);
                break;
            case 2:
                // create paid customer

                //ask for payment method
                System.out.println("Enter the payment method");
                System.out.println("Enter 1 for credit");
                System.out.println("Enter 2 for debit");

                int userInput2 = input.nextInt();

                String paymentMethod = checkPaymentMethod(userInput2);

                PayingCustomer paidCustomer = new PayingCustomer(customerName, customerEmail, paymentMethod);
                // add paid customer to arraylist
                addAssociateCustomers(paidCustomer);
                customers.add(paidCustomer);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        // close scanner
        input.close();
    }

    public static String checkPaymentMethod(int userInput) {
        String paymentMethod = "";
        switch (userInput) {
            case 1:
                paymentMethod = "credit";
                break;
            case 2:
                paymentMethod = "debit";
                break;
            default:
                System.out.println("Invalid payment method");
                break;
        }
        return paymentMethod;
    }


    // create function to add associate customers to paying customers
    public static void addAssociateCustomers(PayingCustomer customer) {
        // create new scanner
        Scanner input = new Scanner(System.in);
        
        boolean moreAssoicateCustomers = true;

        while (moreAssoicateCustomers) {
            // get associate customer by id
            System.out.println("Enter the associate id: ");
            int associateId = input.nextInt();
            // create variable to store associate customer
            AssociateCustomer associateCustomer = new AssociateCustomer();

            // create for loop to search for associate customer
            for (int i = 0; i < customer.getAssociateList().size(); i++) {
                // check if associate id is equal to associate customer id
                if (associateId == customer.getAssociateList().get(i).getAssociateId()) {
                    // store associate customer
                    associateCustomer = customer.getAssociateList().get(i);
                }
            }

            // add associate customer to arraylist
            customer.getAssociateList().add(associateCustomer);

            // ask user if they want to add more associate customers
            System.out.println("Do you want to add more associate customers? (y/n)");
            String userInput = input.nextLine();

            // create if statement to check if user input is y
            if (userInput.equals("y")) {
                // set more associate customers to true
                moreAssoicateCustomers = true;
            } else {
                // set more associate customers to false
                moreAssoicateCustomers = false;
            }

        }

        // close scanner
        input.close();
    }

}
