package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.DateTime;


public class Goal {

    private String goalName;
    private DateTime goalStartDate;
    private DateTime goalTargetDate;
    private String goalType;
    private Boolean goalAchievedStatus;
    private double goalVelocity;
    private int goalFrequency;
    private double goalTime;
    private double goalWeight;
    private double goalDistance;
    private double goalBmi;


    public Goal(String name, DateTime startDate, DateTime targetDate, String type, Boolean achieved, double velocity, int frequency, double time, double weight, double distance, double bmi) {
        goalName = name;
        goalStartDate = startDate;
        goalTargetDate = targetDate;
        goalType = type;
        goalAchievedStatus = achieved;
        goalVelocity = velocity;
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

    public double getGoalVelocity() {
        return this.goalVelocity;
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
//        if ()
//    }

}