package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;
<<<<<<< HEAD
=======


>>>>>>> f5a854f6... Fixing Calculation of total distance and total duration
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
    public double getBmi() {
        return bmi;
=======
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
>>>>>>> e3fcb716... Fixing BMI Calculation and adding BMI category check
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
