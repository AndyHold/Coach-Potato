package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;

/**
 * Weight Goal Class for Coach Potato SENG202 2018S2
 */
public class WeightGoal extends Goal {


    private double goalWeight;


    /**
     * Constructor method for weight goal
     * @param name: String
     * @param start: DateTime
     * @param target: DateTime
     * @throws InvalidGoalDateException When invalid dates are entered
     * @throws BadGoalNameException When invalid name is entered
     * @throws InvalidGoalTargetException When invalid target is entered
     */
    public WeightGoal(String name, DateTime start, DateTime target) throws InvalidGoalDateException, BadGoalNameException
    {
        super(name, start, target, "Weight");
    }


    /**
     * Setter method for the target value of weight goal.
     * @param target: double
     * @throws InvalidGoalTargetException When target is outside the correct values.
     */
    public void setTargetValue(double target, UserProfile user) throws InvalidGoalTargetException
    {
        if (user.getWeight() <= target || target <= 30) {
            throw new InvalidGoalTargetException("Please enter a weight 30kg or more and not already achieved.");
        } else {
            goalWeight = target;
        }
    }

    /**
     * Getter method for the goal weight
     * @return double
     */
    public double getGoalWeight()
    {
        return this.goalWeight;
    }


    /**
     * Method to review a weight goal of the user. Determines whether the user has achieved, failed, or is still working towards a particular weight goal
     * @param currentWeight: double
     * @return String
     */
    public String reviewWeightGoal(double currentWeight)
    {
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


}
