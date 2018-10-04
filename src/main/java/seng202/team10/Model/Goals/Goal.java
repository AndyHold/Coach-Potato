package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;

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
     * @throws InvalidGoalDateException When invalid dates are entered
     * @throws BadGoalNameException When invalid name is entered
     */
    public Goal(String name, DateTime startDate, DateTime targetDate, String type) throws InvalidGoalDateException, BadGoalNameException
    {
        setName(name);
        setDates(startDate, targetDate);
        this.goalType = type;
        goalAchievedStatus = false;
    }


    /**
     * Setter method for the start and target dates of the goal.
     * @param startDate: DateTime
     * @param targetDate: DateTime
     * @throws InvalidGoalDateException When incorrent dates are given
     */
    private void setDates(DateTime startDate, DateTime targetDate) throws InvalidGoalDateException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);
        if (today.isAfter(startDate)) {
            throw new InvalidGoalDateException("You cannot select a date in the past.");
        } else if (startDate.isAfter(targetDate)) {
            throw new InvalidGoalDateException("Target date must be after start date.");
<<<<<<< HEAD
        } else if (startDate.getYear() > (today.getYear() + 1)) {
            throw new InvalidGoalDateException("Start date must be before the end of next year.");
        } else if (targetDate.getYear() > (today.getYear() + 5)) {
=======
        } else if (startDate.getYear() >= (today.getYear() + 1)) {
            throw new InvalidGoalDateException("Start date must be before the end of next year.");
        } else if (targetDate.getYear() >= (today.getYear() + 5)) {
>>>>>>> fcd658d3... Fixed some JUnit tests after a refactor
            throw new InvalidGoalDateException("Target date must be before the end of the year, five years from now.");
        } else {
            this.goalStartDate = startDate;
            this.goalTargetDate = targetDate;
        }
    }


    /**
     * Setter method for the name of a goal
     * @param name: String
     * @throws BadGoalNameException
     */
    private void setName(String name) throws BadGoalNameException
    {
        if (name.length() <= 20 && name.length() >= 2) {
            this.goalName = name;
        } else throw new BadGoalNameException();
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


    @Override
    public String toString()
    {
        return getGoalName() + ": " + getGoalType();
    }
}