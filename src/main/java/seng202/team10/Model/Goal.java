package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.DateTime;

import java.io.Serializable;
import java.time.LocalDateTime;


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

    public void setGoalAchievedStatus(Boolean goalAchievedStatus) {
        this.goalAchievedStatus = goalAchievedStatus;
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
        String progressDescription = "Your target for this goal was to weigh " + goal.getGoalWeight() + " or less by " + goal.getGoalTargetDate();
        if (currentWeight <= goal.getGoalWeight()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth()+2, now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!goal.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = currentWeight - goal.getGoalWeight();
                progressDescription += "\n\nYou need to lose " + String.format("%.1f", difference) + " more kgs to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewBmiGoal(Goal goal, double currentBmi) {
        String progressDescription = "Your target for this goal was to have a BMI less than or equal to " + goal.getGoalBmi() + " by " + goal.getGoalTargetDate();
        if (currentBmi <= goal.getGoalBmi()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth()+2, now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!goal.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = currentBmi - goal.getGoalBmi();
                progressDescription += "\n\nYou need to decrease your BMI by " + String.format("%.1f", difference) + " more to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewDistanceGoal(Goal goal, double dist) {
        String progressDescription = "Your target for this goal was to cover " + goal.getGoalDistance() + " km in distance by " + goal.getGoalTargetDate();
        if (dist >= goal.getGoalDistance()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth()+2, now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!goal.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = goal.getGoalDistance() - dist;
                progressDescription += "\n\nYou need to cover " + String.format("%.0f", difference) + " more metres to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewFrequencyGoal(Goal goal, int freq) {
        String progressDescription = "Your target for this goal was to excersize " + goal.getGoalFrequency() + " times by " + goal.getGoalTargetDate();
        if (freq >= goal.getGoalFrequency()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth()+2, now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!goal.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = goal.getGoalFrequency() - freq;
                progressDescription += "\n\nYou need to complete " + String.format("%.0f", difference) + " more activities to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewTimeGoal(Goal goal, int time) {
        String progressDescription = "Your target for this goal was to excersize for " + goal.getGoalFrequency() + " minutes? by " + goal.getGoalTargetDate();
        if (time >= goal.getGoalTime()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth()+2, now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!goal.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = goal.getGoalTime() - time;
                progressDescription += "\n\nYou need to complete " + String.format("%.0f", difference) + " more minutes / seconds?? of activities to meet your goal.";
            }
        }
        return progressDescription;
    }


}