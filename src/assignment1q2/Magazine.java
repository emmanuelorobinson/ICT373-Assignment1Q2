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
public class Magazine {
    private int month;
    private String title;
    private float weeklyCost;

    public Magazine(int month, String title, float weeklyCost) {
        this.month = month;
        this.title = title;
        this.weeklyCost = weeklyCost;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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
}
