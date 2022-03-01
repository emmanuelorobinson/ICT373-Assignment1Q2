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
public class Supplement {
    
    private String name;
    private float cost;

    public Supplement(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    public Supplement() {
        this.name = "";
        this.cost = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void getSupplementsDetails() {
        if (this.name.equals("")) {
            System.out.println("No supplements added");
        } else {
            System.out.println("Name: " + name + " Cost: " + cost);
        }
        
    }
}
