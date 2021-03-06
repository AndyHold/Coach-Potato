package seng202.team10.Model.Goals;

import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;

import java.time.LocalDateTime;

/**
 * Class that extends the Goal superclass, represents an instance of a goal of the user to reach a certain amount of time exercising.
 */
public class TimeGoal extends Goal {


    private double goalTime;


    /**
     * Constructor method for time goal.
     * @param name A <b>String</b> of the name of the goal.
     * @param start The start <b>DateTime</b> of the goal.
     * @param target The end <b>DateTime</b> of the goal.
     * @param time A <b>Double</b> of the target time.
     * @throws InvalidGoalDateException When invalid dates are entered.
     * @throws BadGoalNameException When an invalid goal name is entered.
     * @throws InvalidGoalTargetException When an invalid goal target is entered.
     */
    public TimeGoal(String name, DateTime start, DateTime target, double time) throws InvalidGoalTargetException, InvalidGoalDateException, BadGoalNameException
    {
        super(name, start, target, "Time");
        setTarget(time);
    }


    /**
     * Setter method for the target value of time goal.
     * @param target A <b>Double</b> of the target time.
     * @throws InvalidGoalTargetException When target is outside the correct values.
     */
    public void setTarget(double target) throws InvalidGoalTargetException
    {
        int possibleMinutes = getGoalTargetDate().subtract(getGoalStartDate()) / 60;
        if (target <= 0 || target > possibleMinutes) {
            throw new InvalidGoalTargetException("Please enter a time of at least 1 minute and less than the time between start and finish of your goal.");
        } else {
            goalTime = target;
        }
    }


    /**
     * Getter method for the goal time.
     * @return A <b>Double</b> of the target time.
     */
    public double getGoalTime()
    {
        return this.goalTime;
    }


    /**
     * Method to review a time goal of the user. Determines whether the user has achieved, failed, or is still working towards a particular time goal.
     * @param time A <b>Double</b> of the time the user has done so far.
     * @return A <b>String</b> of the status of the goal completion.
     */
    public String reviewTimeGoal(double time)
    {
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
