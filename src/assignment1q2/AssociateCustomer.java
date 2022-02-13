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

    private int associateId;

    public AssociateCustomer() {
        super();
        this.associateId = 0;
    }

    public AssociateCustomer(String name, String email, int associateId) {
        super(name, email);
        this.associateId = associateId;
    }

    

    public int getAssociateId() {
        return associateId;
    }

    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }
}
