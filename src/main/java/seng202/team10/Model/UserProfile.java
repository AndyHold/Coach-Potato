package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.*;
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
import seng202.team10.Model.Exceptions.ExistingActivityException;
import seng202.team10.Model.Exceptions.ExistingElementException;
import seng202.team10.Model.Exceptions.InvalidHeightException;
import seng202.team10.Model.Exceptions.InvalidWeightException;
=======
import seng202.team10.Model.Exceptions.*;
>>>>>>> 798a1f8... fixed invalidNameException bug

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 081c071... Created Exceptions Package, Wrote tests for Entry and Activity, they are currently both completely tested apart from getters and setters. did some small code style refactors on various other classes. Also deleted redundant Calendar and Event classes as they are never used.
=======
import javax.naming.InvalidNameException;
>>>>>>> 561798b... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
=======
>>>>>>> 4d39bd8... Wrote some more tests for Activity, Entry, Position classes and JavaDocs for those classes.
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
        return name;
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
<<<<<<< HEAD
<<<<<<< HEAD
    public void setName(String newName) {
        this.name = newName;
=======
    public void setName(String newName) throws InvalidNameException
=======
    public void setName(String newName) throws UserNameException
>>>>>>> 798a1f8... fixed invalidNameException bug
    {
        if (!(newName.length() > 15 || !newName.matches("[a-zA-Z0-9]+ ?[a-zA-Z0-9]+"))) {
            this.name = newName;
        } else {
            throw new UserNameException();
        }
>>>>>>> 561798b... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
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
     * @param newWeight: double
     * @throws InvalidWeightException when weight is not in the valid range
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void setWeight(double newWeight) {
        this.weight = newWeight;
=======
    public void setWeight(double newWeight) throws InvalidWeightException
    {
        if (30 <= newWeight && newWeight <= 250) {
            this.weight = newWeight;
        } else {
            throw new InvalidWeightException();
        }
>>>>>>> 561798b... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
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
     * @param newHeight: double
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void setHeight(double newHeight) {
        this.height = newHeight;
=======
    public void setHeight(double newHeight) throws InvalidHeightException
    {
        if (50 <= newHeight && newHeight <= 260) {
            this.height = newHeight;
        } else {
            throw new InvalidHeightException();
        }
>>>>>>> 561798b... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    /**
     * Getter method to get user's Body Mass Index (BMI)
     * @return double
     */
>>>>>>> 4d39bd8... Wrote some more tests for Activity, Entry, Position classes and JavaDocs for those classes.
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
            System.out.println((activity.getStartDateTime().isAfter(startDate)));
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                System.out.println(activity.getStartDateTime());
                System.out.println(startDate);
                totalDistance += activity.getTotalDistance();
                System.out.println("Added to totalDistance");
            } else {
                System.out.println("Not added to totalDistance");
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
        System.out.println(averageSpeed);
        System.out.println(count);

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
                System.out.println("Added to frequency");
            } else {
                System.out.println("Not added to frequency");
            }
        }
        return frequency;
    }

    /**
     * Method to get the total duration in seconds of user's activities within two DateTime objects.
     * @param (startDate, endDate): (DateTime, DateTime)
     * @return totalTime: int
     */
    public int getActivitiesTime(DateTime startDate, DateTime endDate) {
        int totalTime = 0;
        for (Activity activity : activities) {
            if (activity.getStartDateTime().isAfter(startDate) && activity.getEndDateTime().isBefore(endDate)) {
                totalTime += activity.getTotalDuration();
                System.out.println("Added to totalTime");
            } else {
                System.out.println("Not added to totalTime");
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
