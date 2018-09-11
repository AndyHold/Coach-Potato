package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.DateTime;

import java.io.Serializable;


public class Goal implements Serializable {

    private String goalName;
    private DateTime goalStartDate;
    private DateTime goalTargetDate;
    private String goalType;
    private Boolean goalAchievedStatus;
    private int goalFrequency;
    private double goalTime;
    private double goalWeight;
    private double goalDistance;
    private double goalBmi;


    public Goal(String name, DateTime startDate, DateTime targetDate, String type, Boolean achieved, int frequency, double time, double weight, double distance, double bmi) {
        goalName = name;
        goalStartDate = startDate;
        goalTargetDate = targetDate;
        goalType = type;
        goalAchievedStatus = achieved;
        goalFrequency = frequency;
        goalTime = time;
        goalWeight = weight;
        goalDistance = distance;
        goalBmi = bmi;

    }

    public DateTime getGoalStartDate() {
        return this.goalStartDate;
    }

    public DateTime getGoalTargetDate() {
        return this.goalTargetDate;
    }

    public String getGoalType() {
        return this.goalType;
    }

    public Boolean getGoalAchieved() {
        return this.goalAchievedStatus;
    }

    public double getGoalDistance() {
        return this.goalDistance;
    }

    public double getGoalTime() {
        return this.goalTime;
    }

    public double getGoalWeight() {
        return this.goalWeight;
    }

    public int getGoalFrequency() {
        return this.goalFrequency;
    }

    public String getGoalName() {
        return this.goalName;
    }

    public double getGoalBmi() {
        return this.goalBmi;
    }


//    public void reviewWeightGoal(Goal goal, double currentWeight) {
//        System.out.println("Your target for this goal is to weigh " + goal.getGoalWeight() + " by " + goal.getGoalTargetDate());
//        if (currentWeight <= goal.getGoalWeight()) {
//            System.out.println("Congratulations you have completed this goal! It has been removed from your current goals.");
//        } else {
//            double difference = currentWeight - goal.getGoalWeight();
//            System.out.println("You need to lose " + difference + " more kgs to meet your goal.");
//        }
//    }

    public String reviewWeightGoal(Goal goal, double currentWeight) {
        String progressDescription = "";
        progressDescription += "Your target for this goal was to weigh less than" + goal.getGoalWeight() + " by " + goal.getGoalTargetDate();
        if (currentWeight <= goal.getGoalWeight()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals.";
        } else {
            //progressDescription += "Your target for this goal is to weigh " + goal.getGoalWeight() + " by " + goal.getGoalTargetDate();
            double difference = currentWeight - goal.getGoalWeight();
            progressDescription += "\nYou need to lose " + difference + " more kgs to meet your goal.";
        }
        return progressDescription;
    }

//    public void reviewBmiGoal(Goal goal, double currentBmi) {
//        System.out.println("Your target for this goal is to have a BMI of " + goal.getGoalBmi() + " by " + goal.getGoalTargetDate());
//        if (currentBmi <= goal.getGoalBmi()) {
//            System.out.println("Congratulations you have completed this goal! It has been removed from your current goals.");
//        } else {
//            double difference = currentBmi - goal.getGoalBmi();
//            System.out.println("You need to decrease your BMI by " + difference + " more to meet your goal.");
//        }
//    }

    public String reviewBmiGoal(Goal goal, double currentBmi) {
        String progressDescription = "";
        if (currentBmi <= goal.getGoalBmi()) {
            progressDescription += "Your target for this goal was to have a BMI less than or equal to " + goal.getGoalBmi() + " by " + goal.getGoalTargetDate();
            progressDescription += "Congratulations you have completed this goal! It has been removed from your current goals.";

        } else {
            progressDescription += "Your target for this goal is to have a BMI of " + goal.getGoalBmi() + " by " + goal.getGoalTargetDate();
            double difference = currentBmi - goal.getGoalBmi();
            progressDescription += "You need to decrease your BMI by " + difference + " more to meet your goal.";
        }
        return progressDescription;
    }

    public void reviewDistanceGoal(Goal goal, double dist) {
        System.out.println("Your target for this goal is to have covered a distance of " + goal.getGoalDistance() + " by " + goal.getGoalTargetDate());
        //TODO calculate here whether or not the user has completed the goal
        //for-loop over data entries within the goal period (start time - present) and sum up total distance covered. Then compare this to the target distance
    }

    public void reviewFrequencyGoal(Goal goal, double freq) {
        System.out.println("Your target for this goal is to have completed " + goal.getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
        //TODO calculate here whether or not the user has completed the goal
        //Determine the number of activities entered from the goal start to present. Then compare this to the target frequency / quantity
    }

    public void reviewTimeGoal(Goal goal, double time) {
        System.out.println("Your target for this goal is to have completed " + goal.getGoalTime() + " mins of activities by " + goal.getGoalTargetDate());
        //TODO calculate here whether or not the user has completed the goal
        //for-loop over data entries within the goal period (start time - present) and sum up total time across the activities. Then compare this to the target time

    }


}