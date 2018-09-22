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

    /**
     * Constructor method for Goal class
     * @param name: String
     * @param startDate: DateTime
     * @param targetDate: Datetime
     * @param type: String
     * @param achieved: Boolean
     * @param frequency: int
     * @param time: double
     * @param weight: double
     * @param distance: double
     * @param bmi: double
     */
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

    /**
     * Getter method for a goal's start date
     * @return DateTime
     */
    public DateTime getGoalStartDate() {
        return this.goalStartDate;
    }

    /**
     * Getter method for a goal's target date
     * @return DateTime
     */
    public DateTime getGoalTargetDate() {
        return this.goalTargetDate;
    }

    /**
     * Getter method for a goal's type
     * @return String
     */
    public String getGoalType() {
        return this.goalType;
    }

    /**
     * Getter method for the achieved boolean which determines whether a goals has been achieved or not
     * @return Boolean
     */
    public Boolean getGoalAchieved() {
        return this.goalAchievedStatus;
    }

    /**
     * Setter method for the achieved boolean which determines whether a goals has been achieved or not
     */
    public void setGoalAchievedStatus(Boolean goalAchievedStatus) {
        this.goalAchievedStatus = goalAchievedStatus;
    }

    /**
     * Getter method for the goal distance
     * @return double
     */
    public double getGoalDistance() {
        return this.goalDistance;
    }

    /**
     * Getter method for the goal time
     * @return double
     */
    public double getGoalTime() {
        return this.goalTime;
    }

    /**
     * Getter method for the goal weight
     * @return double
     */
    public double getGoalWeight() {
        return this.goalWeight;
    }

    /**
     * Getter method for the goal frequency
     * @return int
     */
    public int getGoalFrequency() {
        return this.goalFrequency;
    }

    /**
     * Getter method for the goal name
     * @return String
     */
    public String getGoalName() {
        return this.goalName;
    }

    /**
     * Getter method for the goal BMI
     * @return double
     */
    public double getGoalBmi() {
        return this.goalBmi;
    }


    public String reviewWeightGoal(double currentWeight) {
        String progressDescription = "Your target for this goal was to weigh " + this.getGoalWeight() + " or less by " + this.getGoalTargetDate();
        if (currentWeight <= this.getGoalWeight()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!this.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = currentWeight - this.getGoalWeight();
                progressDescription += "\n\nYou need to lose " + String.format("%.1f", difference) + " more kgs to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewBmiGoal(double currentBmi) {
        String progressDescription = "Your target for this goal was to have a BMI less than or equal to " + this.getGoalBmi() + " by " + this.getGoalTargetDate();
        if (currentBmi <= this.getGoalBmi()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!this.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = currentBmi - this.getGoalBmi();
                progressDescription += "\n\nYou need to decrease your BMI by " + String.format("%.1f", difference) + " more to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewDistanceGoal(double dist) {
        String progressDescription = "Your target for this goal was to cover " + this.getGoalDistance() + " km in distance by " + this.getGoalTargetDate();
        if (dist >= this.getGoalDistance()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!this.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = this.getGoalDistance() - dist;
                progressDescription += "\n\nYou need to cover " + String.format("%.1f", difference) + " more metres to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewFrequencyGoal(int freq) {
        String progressDescription = "Your target for this goal was to excersize " + this.getGoalFrequency() + " times by " + this.getGoalTargetDate();
        if (freq >= this.getGoalFrequency()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!this.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = this.getGoalFrequency() - freq;
                progressDescription += "\n\nYou need to complete " + String.format("%.0f", difference) + " more activities to meet your goal.";
            }
        }
        return progressDescription;
    }

    public String reviewTimeGoal(double time) {
        String progressDescription = "Your target for this goal was to excersize for " + this.getGoalTime() + " minutes by " + this.getGoalTargetDate();
        if (time >= this.getGoalTime()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!this.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = this.getGoalTime() - time;
                progressDescription += "\n\nYou need to complete " + String.format("%.1f", difference) + " more minutes of activities to meet your goal.";
            }
        }
        return progressDescription;
    }


}