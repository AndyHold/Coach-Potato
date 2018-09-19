package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;
import seng202.team10.Model.Exceptions.ExistingActivityException;
import seng202.team10.Model.Exceptions.ExistingElementException;

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
    //private Goals goals;
    private double bmi;




    private Goals goals = new Goals(this);


    public UserProfile() {

    }

    /**
     * Constructor method for UserProfile class
     * @param name: String
     * @param weight: double
     * @param birthdate: DateTime
     * @param gender: String
     */
    public UserProfile(String name, double weight, double height, DateTime birthdate, String gender) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.birthdate = birthdate;
        this.gender = gender;
    }



    /**
     * Getter method for the name of the user
     * @return String
     */
    public String getName() {
        return name;
    }


    /**
     * Setter method for the name of the user
     * @param newName: String
     */
    public void setName(String newName) {
        this.name = newName;
    }


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
    public ArrayList<Activity> getActivities() {
        return this.activities;
    }


    /**
     * Method for adding an activity to the list of user's Activities.
     * @param newActivity Activity
     */
    public void addActivity(Activity newActivity) throws ExistingActivityException
    {
        // TODO fix this it is not working!!!
        for (Activity existingActivity: activities) {
            if (!newActivity.getStartDateTime().isAfter(existingActivity.getEndDateTime())) { // If the existing activity's end is not before the new activity's start
                if (!newActivity.getEndDateTime().isBefore(existingActivity.getStartDateTime())) { // If the existing activity's start is not after the new activity's end
                    throw new ExistingActivityException("One of the activities you have selected overlaps with an existing activity"); // Throw an exception
                }
            }
        } // Else continue to add the activity.
        activities.add(newActivity);
    }


    /**
     * Method for adding a new list of activities (such as when a new CSV file is loaded)
     * TODO check for duplicates. seems to many already work natuarally??
     * @param newActivities the arraylist of activity objects
     */
    public void addActivities(ArrayList<Activity> newActivities) throws ExistingElementException
    {
        int numberOfBadActivities = 0;
        for(Activity newActivity: newActivities){
            try {
                addActivity(newActivity);
            } catch(ExistingActivityException exception) {
                numberOfBadActivities++;
            }
        }
        if (numberOfBadActivities > 0) {
            throw new ExistingElementException(String.valueOf(numberOfBadActivities) + " Activities overlapped with existing activities and were not added");
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

    public double getBmi() {
        return bmi;
    }

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
                ", bmi=" + bmi +
                '}';
    }


    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public double getActivitiesDistance(DateTime startDate, DateTime endDate) {
        double sum = 0;
        for (Activity activity : activities) {
            System.out.println((activity.getStartDateTime().isAfter(startDate)));
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                System.out.println(activity.getStartDateTime());
                System.out.println(startDate);
                sum += activity.getTotalDistance();
                System.out.println("Added to sum");
            } else {
                System.out.println("Not added to sum");
            }
        }
        return sum;
    }

    public int getActivitiesFreq(DateTime startDate, DateTime endDate) {
        int sum = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                sum ++;
                System.out.println("Added to sum");
            } else {
                System.out.println("Not added to sum");
            }
        }
        return sum;
    }


    public int getActivitiesTime(DateTime startDate, DateTime endDate) {
        int sum = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                sum += activity.getTotalDuration();
                System.out.println("Added to sum");
            } else {
                System.out.println("Not added to sum");
            }
        }
        return sum;
    }



}
