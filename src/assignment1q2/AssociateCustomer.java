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
public class AssociateCustomer extends Customer {

    private PayingCustomer payingCustomer;

    public AssociateCustomer() {
        super();
        //System.out.println("Associate Customer ID: " + getCustomerId());
    }

    public AssociateCustomer(String name, String email) {
        super(name, email);
        //System.out.println("Associate Customer ID: " + getCustomerId());
    }

    //set paying customer
    public void setPayingCustomer(PayingCustomer payingCustomer) {
        this.payingCustomer = payingCustomer;
        payingCustomer.addAssociate(this);
    }

    //get paying customer for associate customer
    public PayingCustomer getPayingCustomer() {
        return payingCustomer;
    }
}
