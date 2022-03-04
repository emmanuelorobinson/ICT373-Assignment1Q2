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
public class PayingCustomer extends Customer {

    private String paymentMethod;
    private ArrayList<AssociateCustomer> associateList = new ArrayList<AssociateCustomer>();

    public PayingCustomer(String name, String email, String paymentMethod) {
        super(name, email);
        this.paymentMethod = paymentMethod;
    }

    public PayingCustomer() {
        super();
        this.paymentMethod = "";
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Checks if the payment method is valid c = credit, d = debit
    public void setPaymentMethod(String paymentMethod) {

        // check if payment method is credit or debit
        if (paymentMethod.equals("c".toLowerCase().trim()) || paymentMethod.equals("d".toLowerCase().trim())) {
            this.paymentMethod = paymentMethod;
        } else {
            System.out.println("Invalid payment method");
        }
    }

    // retrns list of associate customers for paying customer
    public ArrayList<AssociateCustomer> getAssociateList() {
        return associateList;
    }

    // adds associate customer to associate list
    public boolean addAssociate(AssociateCustomer associate) {

        // check if associate customer is already in list
        if (!associateList.contains(associate)) {
            associateList.add(associate);
            return true;
        } else {
            return false;
        }
    }
}
