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
    private HashMap<Integer, ArrayList<Supplement>> Subscription = new HashMap<Integer, ArrayList<Supplement>>();

    public Subscription() {
        this.Subscription = new HashMap<Integer, ArrayList<Supplement>>();
    }

    // create method to add supplement to hashmap
    public void addSupplement(int customerId, Supplement supplement, Magazine magazine) {
        if (Subscription.containsKey(customerId)) {

            // check if magazine contains supplement
            if (magazine.getSupplements().contains(supplement)) {
                // check if customer already has this supplement
                if (!Subscription.get(customerId).contains(supplement)) {
                    Subscription.get(customerId).add(supplement);
                } else {
                    System.out.println("Customer already has this supplement");
                }
            } else {
                System.out.println("Magazine does not contain this supplement");
            }
        } else {

            ArrayList<Supplement> supplements = new ArrayList<Supplement>();
            // check if magazine contains supplement
            if (magazine.getSupplements().contains(supplement)) {
                // check if customer already has this supplement
                supplements.add(supplement);
                Subscription.put(customerId, supplements);
            } else {
                System.out.println("Magazine does not contain this supplement");
            }

        }
    }

    // create method to get supplements for customer
    public ArrayList<Supplement> getSupplements(int customerId) {
        return Subscription.get(customerId);
    }
}
