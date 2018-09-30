package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;

import java.time.LocalDateTime;

/**
 * Distance Goals Class for Coach Potato SENG202 2018S2
 */
public class DistanceGoal extends Goal {


    private double goalDistance;


    /**
     * Constructor method for distance goal
     * @param name: String
     * @param start: DateTime
     * @param target: DateTime
     * @param distance: double
     * @throws InvalidGoalDateException When invalid dates are entered
     * @throws BadGoalNameException When invalid name is entered
     * @throws InvalidGoalTargetException When invalid target is entered
     */
    public DistanceGoal(String name, DateTime start, DateTime target, double distance) throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException
    {
        super(name, start, target, "Distance");
        setTargetValue(distance);
    }


    /**
     * Setter method for the target value of distance goal.
     * @param target: double
     * @throws InvalidGoalTargetException When target is outside the correct values.
     */
    private void setTargetValue(double target) throws InvalidGoalTargetException
    {
        if (target < 100) {
            throw new InvalidGoalTargetException("Target must be greater than 100m");
        } else {
            this.goalDistance = target;
        }
    }


    /**
     * Getter method for the goal distance
     * @return double
     */
    public double getGoalDistance()
    {
        return this.goalDistance;
    }


    /**
     * Method to review a distance goal of the user. Determines whether the user has achieved, failed, or is still working towards a particular distance goal
     * @param dist: double
     * @return String
     */
    public String reviewDistanceGoal(double dist)
    {
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


}
