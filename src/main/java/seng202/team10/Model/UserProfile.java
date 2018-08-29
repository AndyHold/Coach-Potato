package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;
import seng202.team10.Model.FileOperations.FileWriter;

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public String getName() {
        return this.name;
    }
=======
    public String getName() { return this.name; }
>>>>>>> 7deda61... Implementation of UserProfile class getter and setter methods
=======
    public String getName() {
        return this.name;
    }
>>>>>>> eff27ce... Implementation of UserProfile class getter and setter methods
=======
    public String getName() { return this.name; }
>>>>>>> 90c2806... Implementation of UserProfile class getter and setter methods
=======
    public String getName() {
        return this.name;
    }
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public String getName() { return this.name; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public String getName() {
        return this.name;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods


    /**
     * Setter method for the name of the user
     * @param newName: String
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void setName(String newName) {
        this.name = newName;
    }
=======
    public void setName(String newName) { this.name = newName; }
>>>>>>> 7deda61... Implementation of UserProfile class getter and setter methods
=======
    public void setName(String newName) {
        this.name = newName;
    }
>>>>>>> eff27ce... Implementation of UserProfile class getter and setter methods
=======
    public void setName(String newName) { this.name = newName; }
>>>>>>> 90c2806... Implementation of UserProfile class getter and setter methods
=======
    public void setName(String newName) {
        this.name = newName;
    }
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public void setName(String newName) { this.name = newName; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public void setName(String newName) {
        this.name = newName;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods


    /**
     * Getter method for the activities of the user
     * @return Activities
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public Activities getActivities() {
        return this.activities;
    }
=======
    public Activities getActivities() { return this.activities; }
>>>>>>> 7deda61... Implementation of UserProfile class getter and setter methods
=======
    public Activities getActivities() {
        return this.activities;
    }
>>>>>>> eff27ce... Implementation of UserProfile class getter and setter methods
=======
    public Activities getActivities() { return this.activities; }
>>>>>>> 90c2806... Implementation of UserProfile class getter and setter methods
=======
    public Activities getActivities() {
=======
    public ArrayList<Activity> getActivities() {
>>>>>>> d922119... Fixed DateTimeTest and commented out code that was throwing pipeline off
=======
    public ArrayList<Activity> getActivities() {
>>>>>>> dbb4e11... Fixed DateTimeTest and commented out code that was throwing pipeline off
=======
    public ArrayList<Activity> getActivities() {
>>>>>>> 811edab... Fixed DateTimeTest and commented out code that was throwing pipeline off
=======
    public ArrayList<Activity> getActivities() {
>>>>>>> f805a82... Fixed DateTimeTest and commented out code that was throwing pipeline off
        return this.activities;
    }
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public Activities getActivities() { return this.activities; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public Activities getActivities() {
        return this.activities;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public double getWeight() {
        return this.weight;
    }
=======
    public double getWeight() { return this.weight; }
>>>>>>> 7deda61... Implementation of UserProfile class getter and setter methods
=======
    public double getWeight() {
        return this.weight;
    }
>>>>>>> eff27ce... Implementation of UserProfile class getter and setter methods
=======
    public double getWeight() { return this.weight; }
>>>>>>> 90c2806... Implementation of UserProfile class getter and setter methods
=======
    public double getWeight() {
        return this.weight;
    }
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public double getWeight() { return this.weight; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public double getWeight() {
        return this.weight;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods


    /**
     * Getter method for the height of the user
     * @return double
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public double getHeight() {
        return this.height;
    }
=======
    public double getHeight() { return this.height; }
>>>>>>> 7deda61... Implementation of UserProfile class getter and setter methods
=======
    public double getHeight() {
        return this.height;
    }
>>>>>>> eff27ce... Implementation of UserProfile class getter and setter methods
=======
    public double getHeight() { return this.height; }
>>>>>>> 90c2806... Implementation of UserProfile class getter and setter methods
=======
    public double getHeight() {
        return this.height;
    }
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public double getHeight() { return this.height; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public double getHeight() {
        return this.height;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods


    /**
     * Setter method for the weight of the user
     * @param newWeight double
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }
=======
    public void setWeight(double newWeight) { this.weight = newWeight; }
>>>>>>> 7deda61... Implementation of UserProfile class getter and setter methods
=======
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }
>>>>>>> eff27ce... Implementation of UserProfile class getter and setter methods
=======
    public void setWeight(double newWeight) { this.weight = newWeight; }
>>>>>>> 90c2806... Implementation of UserProfile class getter and setter methods
=======
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public void setWeight(double newWeight) { this.weight = newWeight; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods


    /**
     * Setter method for the height of the user
     * @param newHeight double
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
=======
    public void setHeight(double newHeight) { this.height = newHeight; }
>>>>>>> 7deda61... Implementation of UserProfile class getter and setter methods
=======
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
>>>>>>> eff27ce... Implementation of UserProfile class getter and setter methods
=======
    public void setHeight(double newHeight) { this.height = newHeight; }
>>>>>>> 90c2806... Implementation of UserProfile class getter and setter methods
=======
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public void setHeight(double newHeight) { this.height = newHeight; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods


    /**
     * Setter method for the birthdate of the user
     * @param newDate
     */

    public void setBirthdate(Date newDate) {
        this.birthdate = newDate;
    }

    /**
     * Setter method for the birthdate of the user
     * @param newDate
     */

    public void setBirthdate(Date newDate) {
        this.birthdate = newDate;
    }

    /**
     * Setter method for the birthdate of the user
     * @param newDate
     */

    public void setBirthdate(Date newDate) {
        this.birthdate = newDate;
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
