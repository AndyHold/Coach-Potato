package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class that represents an instance of a goal for the user, super class for different kinds of goal subclasses.
 */
public class Goal implements Serializable {

    private String goalName;
    private DateTime goalStartDate;
    private DateTime goalTargetDate;
    private String goalType;
    private Boolean goalAchievedStatus;


    /**
     * Constructor method for Goal class
     * @param name A <b>String</b> of the name of the goal.
     * @param startDate The start <b>DateTime</b> of the goal.
     * @param targetDate The end <b>DateTime</b> of the goal.
     * @param type A <b>String</b> of the type of goal.
     * @throws InvalidGoalDateException When invalid dates are entered.
     * @throws BadGoalNameException When an invalid goal name is entered.
     */
    public Goal(String name, DateTime startDate, DateTime targetDate, String type) throws InvalidGoalDateException, BadGoalNameException
    {
        String nname = name.replaceAll("\\s+", " ");
        nname = nname.trim();
        setName(nname);
        setDates(startDate, targetDate);
        this.goalType = type;
        goalAchievedStatus = false;
    }


    /**
     * Setter method for the start and target dates of the goal.
     * @param startDate The start <b>DateTime</b> of the goal.
     * @param targetDate The end <b>DateTime</b> of the goal.
     * @throws InvalidGoalDateException When incorrect/invalid dates are given.
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
        } else if (startDate.getYear() > (today.getYear() + 1)) {
            throw new InvalidGoalDateException("Start date must be before the end of next year.");
        } else if (targetDate.getYear() > (today.getYear() + 5)) {
            throw new InvalidGoalDateException("Target date must be before the end of the year, five years from now.");
        } else {
            this.goalStartDate = startDate;
            this.goalTargetDate = targetDate;
        }
    }


    /**
     * Setter method for the name of a goal.
     * @param name A <b>String</b> of the name of the goal.
     * @throws BadGoalNameException when the goal name is invalid.
     */
    private void setName(String name) throws BadGoalNameException
    {
        if (name.length() <= 20 && name.length() >= 2) {
            this.goalName = name;
        } else throw new BadGoalNameException();
    }



    /**
     * Getter method for a goal's start date.
     * @return The start <b>DateTime</b> of the goal.
     */
    public DateTime getGoalStartDate()
    {
        return this.goalStartDate;
    }

    /**
     * Getter method for a goal's target date.
     * @return The target <b>DateTime</b> of the goal.
     */
    public DateTime getGoalTargetDate()
    {
        return this.goalTargetDate;
    }

    /**
     * Getter method for a goal's type.
     * @return A <b>String</b> of the goal type.
     */
    public String getGoalType()
    {
        return this.goalType;
    }

    /**
     * Getter method for the achieved boolean which determines whether a goals has been achieved or not.
     * @return <b>true</b> if the goal is achieved, <b>false</b> otherwise.
     */
    public Boolean isGoalAchieved()
    {
        return this.goalAchievedStatus;
    }

    /**
     * Setter method for the achieved boolean which determines whether a goals has been achieved or not.
     * @param goalAchievedStatus  <b>true</b> if the goal is achieved, <b>false</b> otherwise.
     */
    public void setGoalAchievedStatus(Boolean goalAchievedStatus)
    {
        this.goalAchievedStatus = goalAchievedStatus;
    }



    /**
     * Getter method for the goal name.
     * @return A <b>String</b> of the goal name.
     */
    public String getGoalName()
    {
        return this.goalName;
    }


    /**
     * ToString method for the goal name.
     * @return A <b>String</b> of the goal name.
     */
    @Override
    public String toString()
    {
        return getGoalName() + ": " + getGoalType();
    }
}