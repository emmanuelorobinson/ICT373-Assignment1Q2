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
public class Menu {
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

            System.out.println("\nPlease go through 1-6 in order to add customers and supplements");
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
                    //press any key to continue
                    System.out.println("Press any key to continue");
                    sc.nextLine();

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

        while (true) {
            PayingCustomer customer = new PayingCustomer();

            System.out.println("Enter Paying Customer Name: ");
            customer.setName(sc.next());

            System.out.println("Enter Paying Customer Email: ");
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

            System.out.println("Enter Associate Customer Name: ");
            customer.setName(sc.next());

            System.out.println("Enter Associate Customer Email: ");
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

            System.out.println("Do you want to add another supplement? (y/n)");
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
