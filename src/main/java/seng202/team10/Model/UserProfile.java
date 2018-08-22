package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.Activities;

import java.util.Date;

/**
 * UserProfile Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class UserProfile {


    private String name;
    private Activities activities;
    private double weight;
    private double height;
    private Date birthdate;
    private Goals goals;
    private Calendar calendar;
    private double bmi;


    /**
     * Getter method for the name of the user
     * @return String
     */
    public String getName() {
        return this.name;
    }


    /**
     * Setter method for the name of the user
     * @param newName: String
     */
    public void setName(String newName) {
        this.name = newName;
    }


    /**
     * Getter method for the activities of the user
     * @return Activities
     */
    public Activities getActivities() {
        return this.activities;
    }


    /**
     * Getter method for the weight of the user
     * @return double
     */
    public double getWeight() {
        return this.weight;
    }


    /**
     * Getter method for the height of the user
     * @return double
     */
    public double getHeight() {
        return this.height;
    }


    /**
     * Setter method for the weight of the user
     * @param newWeight
     */
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }


    /**
     * Setter method for the height of the user
     * @param newHeight
     */
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }


    /**
     * Setter method for the birthdate of the user
     * @param newDate
     */

    public void setBirthdate(Date newDate) {
        this.birthdate = newDate;
    }

    /**
     * Getter method for the birthdate of the user
     * @return Date
     */
    public Date getBirthDate() {
        return this.birthdate;
    }


}
