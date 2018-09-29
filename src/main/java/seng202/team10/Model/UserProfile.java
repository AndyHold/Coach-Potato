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
    private int averageHeartRate;
    private double bmi;
    private Goals goals = new Goals(this);
    private ArrayList<HealthWarning> activeHealthWarnings = new ArrayList<>();


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
     * @param height : double
     * @throws UserNameException When the user name is invalid
     * @throws InvalidWeightException When the weight is invalid
     * @throws InvalidHeightException When the height is invalid
     * @throws IllegalArgumentException When another value is invalid
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
     * @throws  UserNameException when the user name is invalid
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


    public ArrayList<HealthWarning> getWarnings(HealthWarningType healthWarningType)
    {
        ArrayList<HealthWarning> result = new ArrayList<>();
        for (HealthWarning healthWarning: activeHealthWarnings) {
            if (healthWarning.getType() == healthWarningType) {
                result.add(healthWarning);
            }
        }
        return result;
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
     * @param newActivity Activity
     * @throws ExistingActivityException If the activity already exists in the application
     */
    public void addActivity(Activity newActivity) throws ExistingActivityException
    {
        for (Activity existingActivity: activities) {
            if (!newActivity.getStartDateTime().isAfter(existingActivity.getEndDateTime())) { // If the existing activity's end is not before the new activity's start
                if (!newActivity.getEndDateTime().isBefore(existingActivity.getStartDateTime())) { // If the existing activity's start is not after the new activity's end
                    throw new ExistingActivityException("One of the activities you have selected overlaps with an existing activity"); // Throw an exception
                }
            }
        } // Else continue to add the activity.
        newActivity.checkEntriesForWarnings(this);
        addHealthWarnings(newActivity.getHealthWarningTypes(), newActivity);
        activities.add(newActivity);
    }


    /**
     * Method for adding a new list of activities (such as when a new CSV file is loaded)
     * @param newActivities: Arraylist of Activity
     * @throws  ExistingElementException When the activity already exists in the application
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
     * @throws  InvalidHeightException when the height is invalid
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
     *               TODO add exception if age is less than 5 years old.
     */
    public void setBirthDate(DateTime newDate)
    {
        this.birthDate = newDate;
    }


    /**
     * Getter method for the birthDate of the user
     * @return Date
     */
    public DateTime getBirthDate()
    {
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


    /**
     * Calculates the users age based on thier date of birth.
     * @return int: The users age.
     * TODO test this
     */
    public int calculateAge()
    {
        DateTime current = DateTime.now();
        return current.subtractYearsFromDateTime(this.birthDate);
    }


    public String getBmiCategory()
    {
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
    public String toString()
    {
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
    public Goals getGoals()
    {
        return goals;
    }

    /**
     * Setter method to set user's goals.
     * @param goals: Goals
     */
    public void setGoals(Goals goals)
    {
        this.goals = goals;
    }

    /**
     * Method to get the total distance of user's activities within two DateTime objects.
     * @param startDate The start date of the activity
     * @param endDate The end date of the activity
     * @return totalDistance: double
     */
    public double getActivitiesDistance(DateTime startDate, DateTime endDate)
    {
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
     * @param startDate The start date of the activity
     * @param endDate The end date of the activity
     * @return averageSpeed: double
     */
    public double getActivitiesSpeed(DateTime startDate, DateTime endDate)
    {
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
     * @param startDate The start date of the activity
     * @param endDate The end date of the activity
     * @return frequency: int
     */
    public int getActivitiesFreq(DateTime startDate, DateTime endDate)
    {
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
     * @param startDate The start date of the activity
     * @param endDate The end date of the activity
     * @return totalTime: int
     */
    public double getActivitiesTime(DateTime startDate, DateTime endDate)
    {
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
    public int getAverageHeartRate()
    {
        return averageHeartRate;
    }

    /**
     * Setter method to set user's average heart rate.
     * @param averageHeartRate: int
     */
    public void setAverageHeartRate(int averageHeartRate)
    {
        this.averageHeartRate = averageHeartRate;
    }

    /**
     * Method to get the average heart rate of user's activities within two DateTime objects.
     * @param startDate The start date of the activity
     * @param endDate The end date of the activity
     * @return averageHeartRate: int
     */
    public int getActivitiesHeartRate(DateTime startDate, DateTime endDate)
    {
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


    /**
     * Method to add health warnings to the list of active health warnings.
     * @param healthWarningTypes ArrayList: List of the health warning types in the activity.
     * @param activity Activity: The activity the health warnings were detected on.
     */
    public void addHealthWarnings(ArrayList<HealthWarningType> healthWarningTypes, Activity activity)
    {
        for (HealthWarningType healthWarningType: healthWarningTypes) {
            activeHealthWarnings.add(new HealthWarning(healthWarningType, activity.getName(), activity.getStartDateTime()));
        }
    }


    /**
     * Getter method for the current health warnings.
     * @return ArrayList: List of the current health warnings.
     */
    public ArrayList<HealthWarning> getActiveHealthWarnings()
    {
        return activeHealthWarnings;
    }
}
