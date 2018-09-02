package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Goals Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Goals implements java.io.Serializable{

    private UserProfile user;
    private ArrayList<Goal> currentGoals = new ArrayList<Goal>();;
    ArrayList<String> currentGoalNames = new ArrayList<String>();
    private ArrayList<Goal> achievedGoals = new ArrayList<Goal>();
    private ArrayList<Goal> failedGoals = new ArrayList<Goal>();;
    private ArrayList<Goal> createdGoals = new ArrayList<Goal>();
    ArrayList<String> createdGoalNames = new ArrayList<String>();
    //private ArrayList<Goal> availableGoals = new ArrayList<Goal>();
    //ArrayList<String> availableGoalNames = new ArrayList<String>();

    public Goals(UserProfile user) {
        this.user = user;
    }


    public Goal createGoal(String name, DateTime startDate, DateTime targetDate, String type, Boolean achieved, int frequency, double time, double weight, double distance, double bmi) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);
        if (type == "Weight") {
            WeightGoal newGoal = new WeightGoal(name, startDate, targetDate, weight);
//            availableGoals.add(newGoal);
//            availableGoalNames.add(newGoal.getGoalName());
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal; //TODO complete this kind of implementation for the other types of goals.
        } else if (type == "Frequency") {
            FrequencyGoal newGoal = new FrequencyGoal(name, startDate, targetDate, frequency);
//            availableGoals.add(newGoal);
//            availableGoalNames.add(newGoal.getGoalName());
            currentGoals.add(newGoal);
            currentGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "Distance") {
            DistanceGoal newGoal = new DistanceGoal(name, startDate, targetDate, distance);
//            availableGoals.add(newGoal);
//            availableGoalNames.add(newGoal.getGoalName());
            currentGoals.add(newGoal);
            currentGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "BMI") {
            BmiGoal newGoal = new BmiGoal(name, startDate, targetDate, bmi);
//            availableGoals.add(newGoal);
//            availableGoalNames.add(newGoal.getGoalName());
            currentGoals.add(newGoal);
            currentGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else { //goal must be of type Time
            TimeGoal newGoal = new TimeGoal(name, startDate, targetDate, time);
//            availableGoals.add(newGoal);
//            availableGoalNames.add(newGoal.getGoalName());
            currentGoals.add(newGoal);
            currentGoalNames.add(newGoal.getGoalName());
            return newGoal;
        }
    }

//    public void addGoal(Goal goal) {
//        if (availableGoals.contains(goal)) {
//            currentGoals.add(goal);
//            currentGoalNames.add(goal.getGoalName());
//        }
//        else {
//            System.out.println("This goal is not available.");
//        }
//    }

    public void removeGoal(Goal goal) {
        if (currentGoals.contains(goal)) {
            currentGoals.remove(goal);
        }
        else {
            System.out.println("This goal is not one of your current goals");
        }

    }

    public ArrayList<String> getCurrentGoalNames() {
        return currentGoalNames;
    }

//    public ArrayList<String> getAvailableGoalNames() {
//        return availableGoalNames;
//    }

    public void checkGoal(Goal goal) {
        if (currentGoals.contains(goal)) {
            System.out.println("" + goal.getGoalName() + "is of type " + goal.getGoalType());

            String type = goal.getGoalType();
            switch (type) {
                case "Weight":
                    goal.reviewWeightGoal(goal, user.getWeight());
                    break;
                case "BMI":
                    goal.reviewBmiGoal(goal, user.calcBmi());
                    break;
                //TODO add in the Distance, frequency, and time cases (which need data loaded first)
            }
        }
    }

    public ArrayList<Goal> getAchievedGoals() {
        return achievedGoals;
    }

    public ArrayList<Goal> getCurrentGoals() {
        return currentGoals;
    }

//    public ArrayList<Goal> getAvailableGoals() {
//        return availableGoals;
//    }

    public ArrayList<Goal> getFailedGoals() {
        return failedGoals;
    }

    public ArrayList<Goal> getCreatedGoals() {
        return createdGoals;
    }

    public ArrayList<String> getCreatedGoalNames() {
        return createdGoalNames;
    }

    public UserProfile getUser() {
        return user;
    }

}