package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.Goals;

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
    private DateTime birthDate;
    private String gender;
    private int maxHeartRate;
    private int averageHeartRate;
    private double bmi;
    private Goals goals = new Goals(this);


    /**
     * Empty Constructor method for UserProfile class.
     */
    public UserProfile()
    {
    }

    /**
     * Constructor method for UserProfile class
     * @param name: String
     * @param weight: double
     * @param birthDate: DateTime
     * @param gender: String
     */
    public UserProfile(String name, double weight, double height, DateTime birthDate, String gender) throws UserNameException, InvalidWeightException, InvalidHeightException, IllegalArgumentException
    {
        this.setName(name);
        this.setWeight(weight);
        this.setHeight(height);
        this.birthDate = birthDate;
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
    public void setName(String newName) throws UserNameException
    {
        if (!(newName.length() > 15 || !newName.matches("[a-zA-Z0-9]+ ?[a-zA-Z0-9]+"))) {
            this.name = newName;
        } else {
            throw new UserNameException();
        }
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
     * Setter method for the maxHeartRate of the user
     * @param maxHeartrate: int
     */
    public void setMaxHeartRate(int maxHeartrate)
    {
        this.maxHeartRate = maxHeartrate;
    }

    /**
     * Getter method for the maxHeartRate of the user
     * @return int
     */
    public int getMaxHeartRate() { return maxHeartRate; }



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
     * @param newActivities: Arraylist of Activity
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
     * @param newWeight: double
     * @throws InvalidWeightException when weight is not in the valid range
     */
    public void setWeight(double newWeight) throws InvalidWeightException
    {
        if (30 <= newWeight && newWeight <= 250) {
            this.weight = newWeight;
        } else {
            throw new InvalidWeightException();
        }
    }


    /**
     * Setter method for the height of the user
     * @param newHeight: double
     */
    public void setHeight(double newHeight) throws InvalidHeightException
    {
        if (50 <= newHeight && newHeight <= 260) {
            this.height = newHeight;
        } else {
            throw new InvalidHeightException();
        }
    }


    /**
     * Setter method for the birthDate of the user
     * @param newDate: DateTime
     */
    public void setBirthDate(DateTime newDate) {
        this.birthDate = newDate;
    }


    /**
     * Getter method for the birthDate of the user
     * @return Date
     */
    public DateTime getBirthDate() {
        return this.birthDate;
    }

    /**
     * Method to calculate user's Body Mass Index (BMI)
     * @return double
     */
    public double calcBmi() {
        this.bmi = getWeight() / (Math.pow(getHeight() / 100, 2));
        return this.bmi;
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

    /**
     * Override method to get a string representation of an user profile
     * @return String
     */
    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", activities=" + activities +
                ", weight=" + weight +
                ", height=" + height +
                ", birthDate=" + birthDate +
                ", goals=" + goals +
                ", bmi=" + bmi +
                '}';
    }

    /**
     * Getter method to get user's goals.
     * @return Goals
     */
    public Goals getGoals() {
        return goals;
    }

    /**
     * Setter method to set user's goals.
     * @param goals: Goals
     */
    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    /**
     * Method to get the total distance of user's activities within two DateTime objects.
     * @param (startDate, endDate): (DateTime, DateTime)
     * @return totalDistance: double
     */
    public double getActivitiesDistance(DateTime startDate, DateTime endDate) {
        double totalDistance = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                totalDistance += activity.getTotalDistance();
            }
        }

        return totalDistance;
    }

    /**
     * Method to get the average speed of user's activities within two DateTime objects.
     * @param (startDate, endDate): (DateTime, DateTime)
     * @return averageSpeed: double
     */
    public double getActivitiesSpeed(DateTime startDate, DateTime endDate) {
        double averageSpeed = 0;
        int count = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                averageSpeed += activity.getSpeedKMH();
                count++;
            }
        }
        averageSpeed = averageSpeed/count;

        return averageSpeed;
    }

    /**
     * Method to get the number of user's activities within two DateTime objects.
     * @param (startDate, endDate): (DateTime, DateTime)
     * @return frequency: int
     */
    public int getActivitiesFreq(DateTime startDate, DateTime endDate) {
        int frequency = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                frequency ++;
            }
        }
        return frequency;
    }

    /**
     * Method to get the total duration in seconds of user's activities within two DateTime objects.
     * @param (startDate, endDate): (DateTime, DateTime)
     * @return totalTime: int
     */
    public double getActivitiesTime(DateTime startDate, DateTime endDate) {
        double totalTime = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                totalTime += activity.getTotalDuration() / 60.0;
            }
        }
        return totalTime;
    }

    /**
     * Getter method to get user's average heart rate.
     * @return int
     */
    public int getAverageHeartRate() {
        return averageHeartRate;
    }

    /**
     * Setter method to set user's average heart rate.
     * @param averageHeartRate: int
     */
    public void setAverageHeartRate(int averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    /**
     * Method to get the average heart rate of user's activities within two DateTime objects.
     * @param (startDate, endDate): (DateTime, DateTime)
     * @return averageHeartRate: int
     */
    public int getActivitiesHeartRate(DateTime startDate, DateTime endDate) {
        int sum = 0;
        int count = 0;
        int averageHeartRate = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                sum += activity.getAverageHeartRate();
                count++;
            }
        }
        averageHeartRate = sum/count;
        return averageHeartRate;
    }


}
