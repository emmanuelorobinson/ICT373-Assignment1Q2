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
    private ArrayList <AssociateCustomer> associateList = new ArrayList<AssociateCustomer>();

    public PayingCustomer(String name, String email, String paymentMethod) {
        super(name, email);
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        //check if payment method is credit or debit

        if(paymentMethod.equals("credit".toLowerCase().trim()) || paymentMethod.equals("debit".toLowerCase().trim())){
            this.paymentMethod = paymentMethod;
        }
        else{
            System.out.println("Invalid payment method");
        }
    }

    public ArrayList<AssociateCustomer> getAssociateList() {
        return associateList;
    }

    public void setAssociateList(ArrayList<AssociateCustomer> associateList) {
        this.associateList = associateList;
    }

    public void addAssociate(AssociateCustomer associate) {
        associateList.add(associate);
    }
}
