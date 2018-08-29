package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.DateTime;

public class Goal {

    private DateTime goalStartDate;
    private DateTime goalTargetDate;
    private String goalType;
    private Boolean goalAchievedStatus;
    private double goalVelocity;
    private int goalFrequency;
    private double goalTime;
    private double goalWeight;
    private double goalDistance;


    public Goal(DateTime startDate, DateTime targetDate, String type, Boolean achieved, double velocity, int frequency, double time, double weight, double distance) {
        goalStartDate = startDate;
        goalTargetDate = targetDate;
        goalType = type;
        goalAchievedStatus = achieved;
        goalVelocity = velocity;
        goalFrequency = frequency;
        goalTime = time;
        goalWeight = weight;
        goalDistance = distance;

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

}
