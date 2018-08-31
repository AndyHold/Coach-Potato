package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.DateTime;

import java.util.ArrayList;

/**
 * Goals Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Goals implements java.io.Serializable{

    private UserProfile user;
    private ArrayList<Goal> currentGoals;
    private ArrayList<Goal> achievedGoals;
    private ArrayList<Goal> failedGoals;
    private ArrayList<Goal> availableGoals;

    public Goals(UserProfile user) {
        this.user = user;
    }


    public Goal createGoal() {
        //prompt user for the type of goal they wish to create
        String userAns = "Weight"; //default for now. Will end up being a button or drop down box

        //prompt user for a name for the goal
        String goalName = "FirstGoal"; //default for now. Will be a text input box

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
            WeightGoal newGoal = new WeightGoal(goalName, startDate, targetDate, weight);
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Frequency") {
            //prompt user for target frequency
            int frequency = 7;
            FrequencyGoal newGoal = new FrequencyGoal(goalName, startDate, targetDate, frequency);
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Distance") {
            //prompt user for target distance
            double distance = 45.6; //default for nowc
            DistanceGoal newGoal = new DistanceGoal(goalName, startDate, targetDate, distance);
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "BMI") {
            //prompt user for target BMI
            double targetBmi = 25.8; //default for now
            BmiGoal newGoal = new BmiGoal(goalName, startDate, targetDate, targetBmi);
            availableGoals.add(newGoal);
            return newGoal;
        } else { //goal must be of type Time
            //prompt user for target time
            double time = 347.6; //default for now
            TimeGoal newGoal = new TimeGoal(goalName, startDate, targetDate, time);
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
            toPrint += goal.getGoalName();
        }
        System.out.println("The current goals you are working towards are: " + toPrint);
    }

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

    public ArrayList<Goal> getAvailableGoals() {
        return availableGoals;
    }

    public ArrayList<Goal> getFailedGoals() {
        return failedGoals;
    }

    public UserProfile getUser() {
        return user;
    }
}