/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author DELL
 */
public class Customer {

    private static AtomicInteger id = new AtomicInteger(0);
    private int customerId;
    private String name;
    private String email;

    public Customer() {
        this.customerId = id.incrementAndGet();
        this.name = "";
        this.email = "";
    }

    public Customer(String name, String email) {
        this.customerId = id.incrementAndGet();
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Object otherCustomer) {
        if (otherCustomer == null) {
            return false;
        }
        if (this.getClass() != otherCustomer.getClass()) {
            return false;
        }
        Customer other = (Customer) otherCustomer;
        if (this.name.equals(other.name) && this.email.equals(other.email)) {
            return true;
        }
        return false;
    }

    public boolean equals(Customer otherCustomer) {
        if (otherCustomer == null) {
            return false;
        }
        if (this.getClass() != otherCustomer.getClass()) {
            return false;
        }
        if (this.name.equals(otherCustomer.name) && this.email.equals(otherCustomer.email)) {
            return true;
        }
        return false;
    }
}
