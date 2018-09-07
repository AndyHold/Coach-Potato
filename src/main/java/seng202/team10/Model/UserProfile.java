package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
=======
=======

>>>>>>> f5a854f... Fixing Calculation of total distance and total duration

>>>>>>> dc93099... Fixing Calculation of total distance and total duration

>>>>>>> 9b15fef... Fixing Calculation of total distance and total duration


>>>>>>> d8e4382... Fixing Calculation of total distance and total duration
import java.util.ArrayList;

/**
 * UserProfile Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class UserProfile implements java.io.Serializable {


    private String name;
    private ArrayList<Activity> activities = new ArrayList<>();
    private double weight;
    private double height;
    private DateTime birthdate;
    private String gender;
    private int maxHeartrate;
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
     * Setter method for the gender of the user
     * @param gender: String: "Male", "Female", or "Other"
     */
    public void setGender(String gender) { this.gender = gender; }


    /**
     * Getter method for the gender of the user
     * @return String
     */
    public String getGender() { return gender; }


    /**
     * Setter method for the maxHeartrate of the user
     * @param maxHeartrate: int
     */
    public void setMaxHeartrate(int maxHeartrate) { this.maxHeartrate = maxHeartrate; }

    /**
     * Getter method for the maxHeartrate of the user
     * @return int
     */
    public int getMaxHeartrate() { return maxHeartrate; }



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
=======

>>>>>>> 345f4af... Added names to goals and getter. Began implementing the checkGoal function that analyses user progress towards a goal. Added a BMI goal class and wrote calcBmi function in userProfile
=======

>>>>>>> 1f6db76... Added names to goals and getter. Began implementing the checkGoal function that analyses user progress towards a goal. Added a BMI goal class and wrote calcBmi function in userProfile
=======
>>>>>>> 21248bb... Implemented Tests for Activity Class, tweaked a few things in user profile and Activity to make them more readable.
    public ArrayList<Activity> getActivities() {
>>>>>>> dbb4e11... Fixed DateTimeTest and commented out code that was throwing pipeline off
=======
    public ArrayList<Activity> getActivities() {
>>>>>>> 811edab... Fixed DateTimeTest and commented out code that was throwing pipeline off
=======
=======

>>>>>>> 06cb652... Added names to goals and getter. Began implementing the checkGoal function that analyses user progress towards a goal. Added a BMI goal class and wrote calcBmi function in userProfile
=======

>>>>>>> 0d0d13c... Added names to goals and getter. Began implementing the checkGoal function that analyses user progress towards a goal. Added a BMI goal class and wrote calcBmi function in userProfile
=======
>>>>>>> a33b861... Implemented Tests for Activity Class, tweaked a few things in user profile and Activity to make them more readable.
=======
>>>>>>> 8200c43... Implemented Tests for Activity Class, tweaked a few things in user profile and Activity to make them more readable.
=======
>>>>>>> 21caf39... Implemented Tests for Activity Class, tweaked a few things in user profile and Activity to make them more readable.
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
     * Method for adding a new list of activities (such as when a new CSV file is loaded)
     * TODO check for duplicates. seems to many already work natuarally??
     * @param newActivities the arraylist of activity objects
     */
    public void addActivities(ArrayList<Activity> newActivities){
        for(Activity newActivity: newActivities){
            addActivity(newActivity);
        }
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
     * @param newDate DateTime
     */
    public void setBirthdate(DateTime newDate) {
        this.birthdate = newDate;
    }


    /**
     * Setter method for the birthdate of the user
     * @param newDate DateTime
     */
    public void setBirthdate(DateTime newDate) {
        this.birthdate = newDate;
    }


    /**
     * Setter method for the birthdate of the user
     * @param newDate DateTime
     */
    public void setBirthdate(DateTime newDate) {
        this.birthdate = newDate;
    }


    /**
     * Setter method for the birthdate of the user
     * @param newDate DateTime
     */
    public void setBirthdate(DateTime newDate) {
        this.birthdate = newDate;
    }


    /**
     * Getter method for the birthdate of the user
     * @return Date
     */
    public DateTime getBirthDate() {
        return this.birthdate;
    }


    public double calcBmi() {
        this.bmi = getWeight() / (Math.pow(getHeight() / 100, 2));
        return this.bmi;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public double getBmi() {
        return bmi;
=======
=======
>>>>>>> c6b8c94... Fixing BMI Calculation and adding BMI category check
=======
>>>>>>> d03ad17... Fixing BMI Calculation and adding BMI category check
=======
>>>>>>> e3fcb71... Fixing BMI Calculation and adding BMI category check
    public String getBmiCategory() {
        calcBmi();
        String category;
        if(this.bmi < 18.5) {
            category = "Underweight";
        } else if (this.bmi < 25){
            category = "Healthy";
        } else if (this.bmi < 30){
            category = "Overweight";
        } else {
            category = "Obese";
        }
        return category;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> f05db62... Fixing BMI Calculation and adding BMI category check
=======
>>>>>>> c6b8c94... Fixing BMI Calculation and adding BMI category check
=======
>>>>>>> d03ad17... Fixing BMI Calculation and adding BMI category check
=======
>>>>>>> e3fcb71... Fixing BMI Calculation and adding BMI category check
    }


    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", activities=" + activities +
                ", weight=" + weight +
                ", height=" + height +
                ", birthdate=" + birthdate +
                ", goals=" + goals +
                ", calendar=" + calendar +
                ", bmi=" + bmi +
                '}';
    }
}
