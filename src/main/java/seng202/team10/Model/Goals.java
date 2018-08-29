package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.DateTime;

import java.util.ArrayList;

/**
 * Goals Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Goals {

    private ArrayList<Goal> currentGoals;
    private ArrayList<Goal> achievedGoals;
    private ArrayList<Goal> failedGoals;
    private ArrayList<Goal> availableGoals;



    public Goal createGoal() {
        //prompt user for the type of goal they wish to create
        String userAns = "Velocity"; //default for now. Will end up being a button or drop down box

        //prompt user for starting day, month, year, hour, minute, second
        int startDay = 1; //default for now
        int startMonth = 1; //default for now
        int startYear = 1; //default for now
        int startHour = 1; //default for now
        int startMinute = 1; //default for now
        int startSecond = 1; //default for now
        DateTime startDate = new DateTime(startDay, startMonth, startYear, startHour, startMinute, startSecond);

        //prompt user for target day, month, year, hour, minute, second
        int targetDay = 2; //default for now
        int targetMonth = 2; //default for now
        int targetYear = 2; //default for now
        int targetHour = 2; //default for now
        int targetMinute = 2; //default for now
        int targetSecond = 2; //default for now
        DateTime targetDate = new DateTime(targetDay, targetMonth, targetYear, targetHour, targetMinute, targetSecond);


        if (userAns == "Weight") {
            //prompt user for target weight
            double weight = 75.8;
            WeightGoal newGoal = new WeightGoal(startDate, targetDate, weight);
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Frequency") {
            //prompt user for target frequency
            int frequency = 7;
            FrequencyGoal newGoal = new FrequencyGoal(startDate, targetDate, frequency);
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Distance") {
            //prompt user for target distance
            double distance = 45.6; //default for nowc
            DistanceGoal newGoal = new DistanceGoal(startDate, targetDate, distance);
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Velocity") {
            //prompt user for target velocity
            double velocity = 14.9; //default for now
            VelocityGoal newGoal = new VelocityGoal(startDate, targetDate, velocity);
            availableGoals.add(newGoal);
            return newGoal;
        } else {
            //prompt user for target time
            double time = 347.6; //default for now
            TimeGoal newGoal = new TimeGoal(startDate, targetDate, time);
            availableGoals.add(newGoal);
            return newGoal;
        }
    }

    public void addGoal(Goal goal) {
        if (availableGoals.contains(goal)) {
            currentGoals.add(goal);
        }
        else {
            System.out.println("This goal is not available.");
        }
    }

    public void removeGoal(Goal goal) {
        if (currentGoals.contains(goal)) {
            currentGoals.remove(goal);
        }
        else {
            System.out.println("This goal is not one of your current goals");
        }

    }

    public void printGoals() {
        String toPrint = "";
        for (Goal goal : currentGoals) {
            toPrint += goal.getGoalType();
        }
        System.out.println("The current goal types you are working towards are: " + toPrint);
    }

    //TODO function to review the progress of the user towards a certain goal.
    public void checkGoal(String goalName) {
        System.out.println("");
    }
}

