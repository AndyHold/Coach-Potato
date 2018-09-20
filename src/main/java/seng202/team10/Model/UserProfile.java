package seng202.team10.Model;


import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import seng202.team10.Model.ActivitiesData.*;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 59668d96... Created Exceptions Package, Wrote tests for Entry and Activity, they are currently both completely tested apart from getters and setters. did some small code style refactors on various other classes. Also deleted redundant Calendar and Event classes as they are never used.
=======


>>>>>>> f5a854f6... Fixing Calculation of total distance and total duration
=======
import seng202.team10.Model.Exceptions.ExistingActivityException;
import seng202.team10.Model.Exceptions.ExistingElementException;
import seng202.team10.Model.Exceptions.InvalidHeightException;
import seng202.team10.Model.Exceptions.InvalidWeightException;

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9253f1d9... Created Exceptions Package, Wrote tests for Entry and Activity, they are currently both completely tested apart from getters and setters. did some small code style refactors on various other classes. Also deleted redundant Calendar and Event classes as they are never used.
=======
>>>>>>> d8e4382... Fixing Calculation of total distance and total duration
=======
import seng202.team10.Model.Exceptions.ExistingActivityException;
import seng202.team10.Model.Exceptions.ExistingElementException;
import seng202.team10.Model.Exceptions.InvalidHeightException;
import seng202.team10.Model.Exceptions.InvalidWeightException;

<<<<<<< HEAD
>>>>>>> 081c071... Created Exceptions Package, Wrote tests for Entry and Activity, they are currently both completely tested apart from getters and setters. did some small code style refactors on various other classes. Also deleted redundant Calendar and Event classes as they are never used.
<<<<<<< HEAD
>>>>>>> 59668d96... Created Exceptions Package, Wrote tests for Entry and Activity, they are currently both completely tested apart from getters and setters. did some small code style refactors on various other classes. Also deleted redundant Calendar and Event classes as they are never used.
=======
import javax.naming.InvalidNameException;
>>>>>>> 0e69f208... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
=======
=======
import javax.naming.InvalidNameException;
>>>>>>> 561798b... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
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


    /**
     * Constructor method for UserProfile class
     */
    public UserProfile() {

    }

    /**
     * Constructor method for UserProfile class
     * @param name: String
     * @param weight: double
     * @param birthdate: DateTime
     * @param gender: String
     */
    public UserProfile(String name, double weight, double height, DateTime birthdate, String gender) throws InvalidNameException, InvalidWeightException, InvalidHeightException, IllegalArgumentException
    {
        this.setName(name);
        this.setWeight(weight);
        this.setHeight(height);
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
<<<<<<< HEAD
=======
>>>>>>> a85d43e... Implementation of UserProfile class getter and setter methods
=======
    public String getName() { return this.name; }
>>>>>>> 35a851d... Implementation of UserProfile class getter and setter methods
=======
    public String getName() {
        return name;
    }
>>>>>>> a40329b... Implementation of UserProfile class getter and setter methods
>>>>>>> 5998348f... Added a ComboBox for User names to be displayed on the profile screen.


    /**
     * Setter method for the name of the user
     * @param newName: String
     */
<<<<<<< HEAD
=======
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
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
    public void setName(String newName) throws InvalidNameException
    {
        if (!(newName.length() > 15 || !newName.matches("[a-zA-Z0-9]+ ?[a-zA-Z0-9]+"))) {
            this.name = newName;
        } else {
            throw new InvalidNameException();
        }
<<<<<<< HEAD
=======
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
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
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
    public void setMaxHeartRate(int maxHeartrate)
    {
        this.maxHeartrate = maxHeartrate;
    }

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
     * @param newWeight double: new weight to be set
     * @throws InvalidWeightException when weight is not in the valid range
     */
<<<<<<< HEAD
=======
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
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
    public void setWeight(double newWeight) throws InvalidWeightException
    {
        if (30 <= newWeight && newWeight <= 250) {
            this.weight = newWeight;
        } else {
            throw new InvalidWeightException();
        }
<<<<<<< HEAD
=======
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
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
    }


    /**
     * Setter method for the height of the user
     * @param newHeight double
     */
<<<<<<< HEAD
=======
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
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
    public void setHeight(double newHeight) throws InvalidHeightException
    {
        if (50 <= newHeight && newHeight <= 260) {
            this.height = newHeight;
        } else {
            throw new InvalidHeightException();
        }
<<<<<<< HEAD
=======
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
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
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
