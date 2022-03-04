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
    public boolean addSupplement(int customerId, Supplement supplement, Magazine magazine) {
        // checks if magazine contains supplement trying to be added
        if (magazine.getSupplements().contains(supplement)) {

            if (subscription.containsKey(customerId)) {

                // check if customer already has this supplement
                if (!subscription.get(customerId).contains(supplement)) {
                    subscription.get(customerId).add(supplement);
                    return true;
                } else {
                    System.out.println("Customer already has this supplement");
                    return false;
                }

            } else {
                ArrayList<Supplement> supplements = new ArrayList<Supplement>();

                // check if customer already has this supplement
                supplements.add(supplement);
                subscription.put(customerId, supplements);
                return true;

            }
        } else {
            System.out.println("Magazine does not contain this supplement");
            return false;
        }
    }

    // method gest supplements for customer by ID
    public ArrayList<Supplement> getSupplements(int customerId) {
        return subscription.get(customerId);
    }
}
