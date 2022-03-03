/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author DELL
 */
public class Subscription {
    // links a customer to its supplements of choice
    private HashMap<Integer, ArrayList<Supplement>> subscription = new HashMap<Integer, ArrayList<Supplement>>();

    public Subscription() {
        this.subscription = new HashMap<Integer, ArrayList<Supplement>>();
    }

    // method adds supplement to hashmap
    public void addSupplement(int customerId, Supplement supplement, Magazine magazine) {
        if (subscription.containsKey(customerId)) {

            // checks if magazine contains supplement trying to be added
            if (magazine.getSupplements().contains(supplement)) {

                // check if customer already has this supplement
                if (!subscription.get(customerId).contains(supplement)) {
                    subscription.get(customerId).add(supplement);
                } else {
                    System.out.println("Customer already has this supplement");
                }

            } else {
                System.out.println("Magazine does not contain this supplement");
            }
        } else {

            ArrayList<Supplement> supplements = new ArrayList<Supplement>();

            // checks if magazine contains supplement
            if (magazine.getSupplements().contains(supplement)) {

                // check if customer already has this supplement
                supplements.add(supplement);
                subscription.put(customerId, supplements);

            } else {
                System.out.println("Magazine does not contain this supplement");
            }

        }
    }

    // method gest supplements for customer by ID
    public ArrayList<Supplement> getSupplements(int customerId) {
        return subscription.get(customerId);
    }
}
