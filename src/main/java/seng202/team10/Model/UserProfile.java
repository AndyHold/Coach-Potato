package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * UserProfile Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class UserProfile implements java.io.Serializable{


    private String name;
    private ArrayList<Activity> activities;
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
    public ArrayList<Activity> getActivities() {
        return this.activities;
    }

    /**
     * Method for adding an activity to the list of user's Activities.
     * @param activity Activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
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
     * @param newWeight double
     */
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }


    /**
     * Setter method for the height of the user
     * @param newHeight double
     */
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }


    /**
     * Getter method for the birthdate of the user
     * @return Date
     */
    public Date getBirthDate() {
        return this.birthdate;
    }


}
