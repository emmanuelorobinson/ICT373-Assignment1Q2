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
        this.name = "invlaid";
        this.cost = 0;
    }

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

    public float getCost() {
        return cost;
    }

    public boolean setCost(float cost) {
        
        if (cost >= 0) {
            this.cost = cost;
            return true;
        }
        return false;
    }

    // gets supplement name and cost multiplied by numOfWeek
    public String getCostDetails(int numOfWeek) {
        String str = "";

        if (numOfWeek == 1) {
            str = " :: ";
        } else if (numOfWeek == 4) {
            str = " :: Month-";
        }

        if (this.name.equals("")) {
            return ("No supplements added");
        } else {
            return ("--->" + this.name + str + "Sum: $" + (this.cost * numOfWeek));
        }

    }
}
