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
        this.name = "invalid name";
        this.email = "invalidEmail@exmple.com";
    }

    public Customer(String name, String email) {
        this.customerId = id.incrementAndGet();
        this.name = name.toLowerCase();
        this.email = email.toLowerCase();
    }

    public int getCustomerId() {
        return customerId;
    }

    // return customer by id

    public String getName() {
        return name;
    }

    public boolean setName(String name) {

        if (name.length() > 0) {
            this.name = name.toLowerCase();
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {

        if (email.length() > 0) {
            this.email = email.toLowerCase();
            return true;
        }
        return false;
    }

    public boolean equals(Customer customer) {
        if (this.name == customer.getName() && this.email == customer.getEmail()) {
            return true;
        }
        return false;
    }
}
