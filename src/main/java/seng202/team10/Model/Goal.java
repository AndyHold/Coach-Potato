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
     */
    public Goal(String name, DateTime startDate, DateTime targetDate, String type, Boolean achieved) {
        goalName = name;
        goalStartDate = startDate;
        goalTargetDate = targetDate;
        goalType = type;
        goalAchievedStatus = achieved;

    }



    /**
     * Getter method for a goal's start date
     * @return DateTime
     */
    public DateTime getGoalStartDate()
    {
        return this.goalStartDate;
    }

    /**
     * Getter method for a goal's target date
     * @return DateTime
     */
    public DateTime getGoalTargetDate()
    {
        return this.goalTargetDate;
    }

    /**
     * Getter method for a goal's type
     * @return String
     */
    public String getGoalType()
    {
        return this.goalType;
    }

    /**
     * Getter method for the achieved boolean which determines whether a goals has been achieved or not
     * @return Boolean
     */
    public Boolean getGoalAchieved()
    {
        return this.goalAchievedStatus;
    }

    /**
     * Setter method for the achieved boolean which determines whether a goals has been achieved or not
     */
    public void setGoalAchievedStatus(Boolean goalAchievedStatus)
    {
        this.goalAchievedStatus = goalAchievedStatus;
    }



    /**
     * Getter method for the goal name
     * @return String
     */
    public String getGoalName()
    {
        return this.goalName;
    }


}