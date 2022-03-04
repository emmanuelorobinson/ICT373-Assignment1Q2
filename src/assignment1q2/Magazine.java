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
public class Magazine {
    private String title;
    private float weeklyCost;
    private ArrayList<Supplement> supplementList = new ArrayList<Supplement>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public Magazine(String title, float weeklyCost) {
        this.title = title;
        this.weeklyCost = weeklyCost;
    }

    public Magazine() {
        this.title = "";
        this.weeklyCost = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitle(String title) {

        if (title.length() > 0) {
            this.title = title.toLowerCase();
            return true;
        }
        return false;
    }

    public float getWeeklyCost() {
        return weeklyCost;
    }

    public boolean setWeeklyCost(float weeklyCost) {

        if (weeklyCost >= 0) {
            this.weeklyCost = weeklyCost;
            return true;
        }
        return false;

    }

    public ArrayList<Supplement> getSupplements() {
        return supplementList;
    }

    public boolean addSupplement(Supplement supplement) {

        if (supplement != null) {
            if(!supplementList.contains(supplement)) {
                supplementList.add(supplement);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public ArrayList<Supplement> getSuppList() {
        return supplementList;
    }

    // method allows the retrieval of a supplement by its name
    public Supplement getSupplementByName(String name) {
        for (Supplement s : supplementList) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public boolean addCustomer(Customer customer) {

        if (customerList.contains(customer)) {
            return false;
        } else {
            customerList.add(customer);
            return true;
        }
    }

    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
    }

    // method allows the retrieval of a customer by its ID
    public Customer getCustomerById(int id) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == id) {
                return (Customer) customer;
            }
        }
        return null;
    }
}
