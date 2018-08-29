package seng202.team10.Model;


public class Goal {

    private int goalStartDate;
    private int goalTargetDate;
    private String goalType;
    private Boolean goalAchievedStatus;
    private double goalVelocity;
    private int goalFrequency;
    private double goalTime;
    private double goalWeight;
    private double goalDistance;


    public Goal(int startDate, int targetDate, String type, Boolean achieved, double velocity, int frequency, double time, double weight, double distance) {
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

    public int getGoalStartDate() {
        return this.goalStartDate;
    }

    public int getGoalTargetDate() {
        return this.goalTargetDate;
    }

    public String getGoalType() {
        return goalType;
    }

    public Boolean getGoalAchieved() {
        return goalAchievedStatus;
    }

    public double getGoalVelocity() {
        return goalVelocity;
    }

    public double getGoalDistance() {
        return goalDistance;
    }

    public double getGoalTime() {
        return goalTime;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public int getGoalFrequency() {
        return goalFrequency;
    }

}
