package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.Activity;
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
    private ArrayList<String> futureGoals = new ArrayList<String>();

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
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "Frequency") {
            FrequencyGoal newGoal = new FrequencyGoal(name, startDate, targetDate, frequency);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "Distance") {
            DistanceGoal newGoal = new DistanceGoal(name, startDate, targetDate, distance);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "BMI") {
            BmiGoal newGoal = new BmiGoal(name, startDate, targetDate, bmi);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else { //goal must be of type Time
            TimeGoal newGoal = new TimeGoal(name, startDate, targetDate, time);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
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

//    public void removeGoal(Goal goal) {
//        if (currentGoals.contains(goal)) {
//            currentGoals.remove(goal);
//            currentGoalNames.remove(goal.getGoalName());
//            createdGoals.remove(goal);
//            createdGoalNames.remove(goal.getGoalName());
//        }
//        else {
//            System.out.println("This goal is not one of your current goals");
//        }
//
//    }
    public void removeCurrentGoal(String goalName) {
        if (currentGoalNames.contains(goalName)) {
            currentGoalNames.remove(goalName);
            createdGoalNames.remove(goalName);
            Goal goal = getGoalObject(goalName);
            currentGoals.remove(goal);
            createdGoals.remove(goal);
        }
        else {
            System.out.println("This goal is not one of your current goals");
        }

    }

//    public ArrayList<String> getAvailableGoalNames() {
//        return availableGoalNames;
//    }

//    public void checkGoal(String goalName) {
//        Goal goal = getGoalObject(goalName);
//        if (currentGoals.contains(goal)) { // is this necessary if combobox will only ever have current goals??
//            System.out.println("" + goalName + "is of type " + goal.getGoalType());
//            String type = goal.getGoalType();
//            switch (type) {
//                case "Weight":
//                    //goal.reviewWeightGoal(goal, user.getWeight());
//                    goal.reviewWeightGoal(goal, 70);
//                    break;
//                case "BMI":
//                    //goal.reviewBmiGoal(goal, user.calcBmi());
//                    goal.reviewBmiGoal(goal, 30);
//                    break;
//                //to do add in the Distance, frequency, and time cases (which need data loaded first)
//            }
//        }
//    }


    public String checkGoal(String goalName) {
        Goal goal = getGoalObject(goalName);
        String progress = "";
        if (currentGoals.contains(goal)) { // is this necessary if combobox will only ever have current goals??
            System.out.println("" + goalName + "is of type " + goal.getGoalType());
            String type = goal.getGoalType();
            switch (type) {
                case "Weight":
                    System.out.println(user);
                    progress = goal.reviewWeightGoal(goal, user.getWeight());
                    if (user.getWeight() <= goal.getGoalWeight()) {
                        removeCurrentGoal(goalName);
                    }
                    break;
                case "BMI":
                    System.out.println(user);
                    progress = goal.reviewBmiGoal(goal, user.getBmi());
                    if (user.getBmi() <= goal.getGoalBmi()) {
                        removeCurrentGoal(goalName);
                    }
                    break;
                case "Distance":
                    System.out.println(user);
                    double totalDistance = user.getActivitiesDistance(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    System.out.println(totalDistance);
                    progress = goal.reviewDistanceGoal(goal, totalDistance);
                    if (totalDistance >= goal.getGoalDistance()) {
                        removeCurrentGoal(goalName);
                    }
                    break;
                case "Frequency":
                    System.out.println(user);
                    int numActivities = user.getActivitiesFreq(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    System.out.println(numActivities);
                    progress = goal.reviewFrequencyGoal(goal, numActivities);
                    if (numActivities >= goal.getGoalFrequency()) {
                        removeCurrentGoal(goalName);
                    }
                    break;
                case "Time":
                    System.out.println(user);
                    int timeSumActivities = user.getActivitiesTime(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    System.out.println(timeSumActivities);
                    progress = goal.reviewTimeGoal(goal, timeSumActivities);
                    if (timeSumActivities >= goal.getGoalTime()) {
                        removeCurrentGoal(goalName);
                    }
                    break;
            }
        }
        return progress;
    }

    public ArrayList<String> getCurrentGoalNames() {
        return currentGoalNames;
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

    public ArrayList<String> getFutureGoals() {
        return futureGoals;
    }


    public Goal getGoalObject(String goalName) {
        for (Goal goal : currentGoals) {
            if (goal.getGoalName() == goalName) {
                return goal;
            }
        }
        return null;
    }

}