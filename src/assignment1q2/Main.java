/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2;

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

        // Magazine mag = new Magazine("The Daily Express", 10.0f);
        // Subscription sub = new Subscription();
        menu();

        // // create supplement to be added to magazine
        // Supplement supplement1 = new Supplement("Supplement 1", 10.0f);
        // Supplement supplement2 = new Supplement("Supplement 2", 20.0f);
        // Supplement supplement3 = new Supplement("Supplement 3", 30.0f);
        // Supplement supplement4 = new Supplement("Supplement 4", 40.0f);

        // // add supplements to magazine
        // mag.addSupplement(supplement1);
        // mag.addSupplement(supplement2);
        // mag.addSupplement(supplement3);
        // mag.addSupplement(supplement4);

        // // create a paying customer and an associate customer
        // PayingCustomer customer1 = new PayingCustomer("Customer 1",
        // "customer1@gmail.com", "credit");
        // sub.addSupplement(customer1.getCustomerId(), supplement1, mag);
        // sub.addSupplement(customer1.getCustomerId(), supplement2, mag);

        // AssociateCustomer customer3 = new AssociateCustomer("Customer 3",
        // "customer3@gmail.com");
        // sub.addSupplement(customer3.getCustomerId(), supplement3, mag);
        // sub.addSupplement(customer3.getCustomerId(), supplement4, mag);
        // customer3.setPayingCustomer(customer1);

        // // add customer to magazine
        // mag.addCustomer(customer1);
        // mag.addCustomer(customer3);

        // Calculation.getMonthlyCost(customer1, sub);

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        Magazine mag = new Magazine();
        Subscription sub = new Subscription();
        int option = 0;

        while (option != 9) {

            System.out.println("1. Add magazine");
            System.out.println("2. Add supplement to magazine1");
            System.out.println("3. Add Paying Customer");
            System.out.println("4. Add Associate Customer");
            System.out.println("5. Add Customer Supplement");
            System.out.println("6. Remove Customer from magazine");
            System.out.println("7. Get Monthly Cost");
            System.out.println("8. Get Weekly Supplement Cost");
            System.out.println("9. Exit");

            System.out.println("\n Please go through 1-6 in order to add customers and supplements");
            System.out.println("Last choosen option: " + option);

            System.out.println("Enter your option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    addMagazine(mag);
                    break;

                case 2:
                    addSupplement(mag);
                    break;

                case 3:
                    addPayingCustomer(mag);
                    break;

                case 4:
                    addAssociateCustomer(mag);
                    break;

                case 5:
                    addCustomerSupplement(mag, sub);
                    break;

                case 6:
                    removeCustomer(mag);
                    break;

                case 7:
                    Calculation.getMonthlyCostEmail(mag, sub);
                    break;
                default:
                    break;
            }
        }

        
    }

    public static void addMagazine(Magazine mag) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Magazine Name: ");
        mag.setTitle(sc.next());

        System.out.println("Enter Magazine Cost: ");
        mag.setWeeklyCost(sc.nextFloat());

    }

    public static void addSupplement(Magazine mag) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            Supplement supplement = new Supplement();

            System.out.println("Enter Supplement Name: ");
            supplement.setName(sc.next());

            System.out.println("Enter Supplement Cost: ");
            supplement.setCost(sc.nextFloat());

            mag.addSupplement(supplement);

            System.out.println("Do you want to add another supplement? (y/n)");
            if (sc.next().equals("n")) {
                break;
            }
        }

        //
    }

    public static void addPayingCustomer(Magazine mag) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer Name: ");
        while (true) {
            PayingCustomer customer = new PayingCustomer();

            System.out.println("Enter Customer Name: ");
            customer.setName(sc.next());

            System.out.println("Enter Customer Email: ");
            customer.setEmail(sc.next());

            System.out.println("Enter Customer Payment Method (c/d): ");
            customer.setPaymentMethod(sc.next());

            mag.addCustomer(customer);

            System.out.println("Do you want to add another customer? (y/n)");
            if (sc.next().toLowerCase().equals("n")) {
                break;
            }
        }

        
    }

    public static void addAssociateCustomer(Magazine mag) {
        Scanner sc = new Scanner(System.in);

        // prinout all paying customer in magazine
        mag.getCustomerList().forEach((customer) -> {
            if (customer instanceof PayingCustomer) {
                System.out.println("ID: " + customer.getCustomerId() + " Name: " + customer.getName());
            }
        });

        while (true) {
            AssociateCustomer customer = new AssociateCustomer();

            System.out.println("Enter Customer Name: ");
            customer.setName(sc.next());

            System.out.println("Enter Customer Email: ");
            customer.setEmail(sc.next());

            System.out.println("Please type in the ID of the paying customer: ");
            PayingCustomer payingCustomer = (PayingCustomer) mag.getCustomerById(sc.nextInt());
            customer.setPayingCustomer(payingCustomer);

            mag.addCustomer(customer);

            System.out.println("Do you want to add another customer? (y/n)");
            if (sc.next().equals("n")) {
                break;
            }
        }

        

    }

    public static void addCustomerSupplement(Magazine mag, Subscription sub) {
        Scanner sc = new Scanner(System.in);

        mag.getCustomerList().forEach((customer) -> {
                System.out.println("ID: " + customer.getCustomerId() + " Name: " + customer.getName());
        });

        // prinout all supplement in magazine
        mag.getSuppList().forEach((supplement) -> {
            System.out.println(" Name: " + supplement.getName().toLowerCase());
        });

        while (true) {

            System.out.println("Please type in the ID of the customer to add supplement for: ");
            Customer customer = mag.getCustomerById(sc.nextInt());

            System.out.println("Please type in the name of the supplement to add: ");
            Supplement supplement = mag.getSupplementByName(sc.next());

            sub.addSupplement(customer.getCustomerId(), supplement, mag);

            System.out.println("Do you want to add another customer? (y/n)");
            if (sc.next().equals("n")) {
                break;
            }
        }

        
    }

    public static void removeCustomer(Magazine mag) {
        Scanner sc = new Scanner(System.in);

        // prinout all supplement in magazine
        mag.getCustomerList().forEach((customer) -> {
            System.out.println("ID: " + customer.getCustomerId() + " Name: " + customer.getName());
        });

        System.out.println("Please type in the ID of the customer to remove: ");
        mag.removeCustomer(mag.getCustomerById(sc.nextInt()));

        
    }

}
