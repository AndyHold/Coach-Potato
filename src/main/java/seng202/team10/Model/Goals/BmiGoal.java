package seng202.team10.Model.Goals;

import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;

/**
 * BMI Goals Class for Coach Potato SENG202 2018S2
 */
public class BmiGoal extends Goal {


    private double goalBmi;


    /**
     * Constructor method for bmi goal
     * @param name: String
     * @param start: DateTime
     * @param target: DateTime
     * @throws InvalidGoalDateException When invalid dates are entered
     * @throws BadGoalNameException When invalid name is entered
     */
    public BmiGoal(String name, DateTime start, DateTime target) throws InvalidGoalDateException, BadGoalNameException
    {
        super(name, start, target, "BMI");
    }


    /**
     * Setter method for the target value of bmi goal.
     * @param target: double
     * @throws InvalidGoalTargetException When target is outside the correct values.
     */
    public void setTargetValue(double target, UserProfile user) throws InvalidGoalTargetException
    {
        if (user.calcBmi() <= target || target < 10) {
            throw new InvalidGoalTargetException("Please enter a BMI above 10 that you have not already achieved.");
        } else {
            goalBmi = target;
        }
    }


    /**
     * Getter method for the goal BMI
     * @return double
     */
    public double getGoalBmi()
    {
        return this.goalBmi;
    }

    /**
     * Method to review a BMI goal of the user. Determines whether the user has achieved, failed, or is still working towards a particular BMI goal
     * @param currentBmi: double
     * @return String
     */
    public String reviewBmiGoal(double currentBmi)
    {
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

}
