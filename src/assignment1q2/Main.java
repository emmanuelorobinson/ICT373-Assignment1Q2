/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MagazineService magazineService = new MagazineService();
        
        Magazine mag1 = new Magazine(1, "The Daily Express", 10.0f);
        Magazine mag2 = new Magazine(2, "New York Times", 15.0f);
        Magazine mag3 = new Magazine(3, "The Guardian", 20.0f);
        Magazine mag4 = new Magazine(4, "The Independent", 25.0f);


        magazineService.addMagazine(mag1);
        magazineService.addMagazine(mag2);
        magazineService.addMagazine(mag3);
        magazineService.addMagazine(mag4);

        Supplement supplement1 = new Supplement("Supplement 1", 10.0f);
        Supplement supplement2 = new Supplement("Supplement 2", 20.0f);
        Supplement supplement3 = new Supplement("Supplement 3", 30.0f);
        Supplement supplement4 = new Supplement("Supplement 4", 40.0f);

        magazineService.addSupplement(supplement1);
        magazineService.addSupplement(supplement2);
        magazineService.addSupplement(supplement3);
        magazineService.addSupplement(supplement4);

        PayingCustomer customer1 = new PayingCustomer("Customer 1", "customer1@gmail.com", "credit");
        customer1.addSupplement(supplement1);
        customer1.addSupplement(supplement2);
        PayingCustomer customer2 = new PayingCustomer("Customer 2", "customer2@gmail.com", "credit");
        customer2.addSupplement(supplement3);
        customer2.addSupplement(supplement4);
        AssociateCustomer customer3 = new AssociateCustomer("Customer 3", "customer3@gmail.com");
        customer3.addSupplement(supplement1);
        customer3.addSupplement(supplement2);
        customer3.setPayingCustomer(customer1);
        AssociateCustomer customer4 = new AssociateCustomer("Customer 4", "customer4@gmail.com");
        customer4.addSupplement(supplement1);
        customer4.addSupplement(supplement3);
        customer4.setPayingCustomer(customer2);
        AssociateCustomer customer5 = new AssociateCustomer("Customer 5", "customer5@gmail.com");
        customer5.addSupplement(supplement2);
        customer5.addSupplement(supplement4);
        customer5.setPayingCustomer(customer2);
        
        magazineService.addCustomer(customer1);
        magazineService.addCustomer(customer2);
        magazineService.addCustomer(customer3);
        magazineService.addCustomer(customer4);
        magazineService.addCustomer(customer5);

        magazineService.getMonthlyCostEmail();

    }
}

