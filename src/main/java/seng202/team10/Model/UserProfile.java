package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.Goals;

import java.util.ArrayList;
import java.util.Calendar;

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
     * @param name: <b>String</b>
     * @param weight: <b>Double</b>
     * @param birthDate: <b>DateTime</b>
     * @param gender: <b>String</b>
     * @param height : <b>Double</b>
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
     * Getter method for the name of the user.
     * @return <b>String</b>
     */
    public String getName() {
        return name;
    }


    /**
     * Setter method for the name of the user
     * @param newName: A <b>String</b> of the name entered for the user.
     * @throws  UserNameException when the user name is invalid
     */
    public void setName(String newName) throws UserNameException
    {
        if (!(newName.length() > 50 || !newName.matches("[a-zA-Z0-9 ]*"))) {
            this.name = newName;
        } else {
            throw new UserNameException();
        }
    }


    /**
     * Setter method for the gender of the user
     * @param gender <b>String:</b> "Male", "Female", or "Other"
     */
    public void setGender(String gender) { this.gender = gender; }


    /**
     * Getter method for the gender of the user
     * @return <b>String</b>
     */
    public String getGender() { return gender; }


    /**
     * Gets a list of health warnings.
     * @param healthWarningType An enum for the health warning type.
     * @return  An <b>ArrayList&gt;HealthWarning&lt;</b>
     */
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
     * @return An <b>ArrayList&gt;Activity&lt;</b>
     */
    public ArrayList<Activity> getActivities() {
        return this.activities;
    }


    /**
     * Method for adding an activity to the list of user's Activities.
     * @param newActivity The <b>Activity</b> being added to the user.
     * @throws ExistingActivityException If the activity already exists in the application.
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
        addHealthWarnings(newActivity.getHealthWarnings());
        activities.add(newActivity);
    }


    /**
     * Method for adding a new list of activities (such as when a new CSV file is loaded)
     * @param newActivities <b>ArrayList&gt;Activity&lt;</b> of activities being added to the user.
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
     * Method to remove a single activity from the profile
     * @param toDelete the activity being deleted
     */
    public void deleteActivity(Activity toDelete)
    {
        removeHealthWarnings(toDelete.getHealthWarnings());
        activities.remove(toDelete);
    }


    /**
     * Getter method for the weight of the user
     * @return <b>Double</b>
     */
    public double getWeight()
    {
        return this.weight;
    }


    /**
     * Getter method for the height of the user
     * @return <b>Double</b>
     */
    public double getHeight()
    {
        return this.height;
    }


    /**
     * Setter method for the weight of the user
     * @param newWeight A double of the weight entered.
     * @throws InvalidWeightException when weight is not in the valid range (30-250)
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
     * @param newHeight A double of the height entered.
     * @throws  InvalidHeightException when the height not in the valid range (50-260)
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
     * Setter method for the birth date of the user
     * @param newDate: DateTime of the date of birth entered
     * @throws  InvalidDateException when the date not in the valid range (age between 5-120)
     */
    public void setBirthDate(DateTime newDate) throws InvalidDateException
    {

        this.birthDate = newDate;
        int userAge  = calculateAge();
        if (userAge < 5 || userAge > 120) {
            this.birthDate = null;
            throw new InvalidDateException();
        }
    }


    /**
     * Getter method for the birth date of the user
     * @return <b>DateTime</b>
     */
    public DateTime getBirthDate()
    {
        return this.birthDate;
    }

    /**
     * Method to calculate user's Body Mass Index (BMI)
     * @return <b>Double</b>
     */
    public double calcBmi()
    {
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


    /**
     * Method to return a string describing the BMI category the user belongs to.
     * @return  <b>String</b>
     */
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
     * @return <b>String</b>
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
     * @return <b>Goals</b>
     */
    public Goals getGoals()
    {
        return goals;
    }

    /**
     * Setter method to set user's goals.
     * @param goals <b>Goals</b>
     */
    public void setGoals(Goals goals)
    {
        this.goals = goals;
    }

    /**
     * Method to get the total distance of user's activities within two DateTime objects.
     * @param startDate The start date of the activity
     * @param endDate The end date of the activity
     * @return A <b>Double</b> describing the total distance
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
     * @return A <b>Double</b> describing the average speed
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
     * @return An <b>Integer</b> describing the frequency of activities
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
     * @return An <b>Integer</b> describing the total time taken of a number of activities.
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
     * Method to get the average heart rate of user's activities within two DateTime objects.
     * @param startDate The start date of the activity
     * @param endDate The end date of the activity
     * @return An <b>Integer</b> describing the average heart rate
     */
    public int getActivitiesHeartRate(DateTime startDate, DateTime endDate)
    {
        int sum = 0;
        int count = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                sum += activity.getAverageHeartRate();
                count++;
            }
        }
        return sum/count;
    }


    /**
     * Method to add health warnings to the list of active health warnings.
     * @param healthWarnings An <b>ArrayList&gt;HealthWarning&lt;</b> of health
     *                           warnings in the activity.
     */
    private void addHealthWarnings(ArrayList<HealthWarning> healthWarnings)
    {
        for (HealthWarning healthWarning: healthWarnings) {
            activeHealthWarnings.add(healthWarning);
        }
    }


    /**
     * Getter method for the current health warnings.
     * @return <b>ArrayList&gt;HealthWarning&lt;</b>
     */
    public ArrayList<HealthWarning> getActiveHealthWarnings()
    {
        return activeHealthWarnings;
    }


    /**
     * Method to remove a health warning from the user.
     * @param healthWarning A <b>HealthWarning</b> cleared by the user.
     */
    public void removeHealthWarning(HealthWarning healthWarning)
    {
        activeHealthWarnings.remove(healthWarning);
    }


    /**
     * Method to remove a list of health warnings from the user.
     * @param healthWarnings an <b>ArrayList&gt;HealthWarning&lt;</b> containing the <b>HealthWarnings</b> to be deleted.
     * Called when deleting an activity from the user.
     */
    public void removeHealthWarnings(ArrayList<HealthWarning> healthWarnings)
    {
        for (HealthWarning healthWarning: healthWarnings) {
            removeHealthWarning(healthWarning);
        }
    }
}
