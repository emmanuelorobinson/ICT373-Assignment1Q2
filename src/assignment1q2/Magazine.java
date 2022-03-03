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

    public void setTitle(String title) {
        this.title = title;
    }

    public float getWeeklyCost() {
        return weeklyCost;
    }

    public void setWeeklyCost(float weeklyCost) {
        this.weeklyCost = weeklyCost;
    }

    public ArrayList<Supplement> getSupplements() {
        return supplementList;
    }

    public void addSupplement(Supplement supplement) {
        supplementList.add(supplement);
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

    public void addCustomer(Customer customer) {
        customerList.add(customer);
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
