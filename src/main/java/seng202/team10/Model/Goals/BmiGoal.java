package seng202.team10.Model.Goals;

import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;

<<<<<<< HEAD
=======
/**
 * Class that extends the Goal superclass, represents an instance of a goal of the user to reach a certain BMI.
 */
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
public class BmiGoal extends Goal {


    private double goalBmi;


    /**
     * Constructor method for bmi goal.
     * @param name A <b>String</b> of the name of the goal.
     * @param start The start <b>DateTime</b> of the goal.
     * @param target The end <b>DateTime</b> of the goal.
     * @throws InvalidGoalDateException When invalid dates are entered.
     * @throws BadGoalNameException When an invalid goal name is entered.
     */
    public BmiGoal(String name, DateTime start, DateTime target) throws InvalidGoalDateException, BadGoalNameException
    {
        super(name, start, target, "BMI");
    }


    /**
     * Setter method for the target value of bmi goal.
     * @param target A <b>Double</b> of the target value of the bmi goal.
     * @param user The <b>UserProfile</b> the target is being set for.
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
     * Getter method for the goal BMI.
     * @return A <b>Double</b> of the BMI.
     */
    public double getGoalBmi()
    {
        return this.goalBmi;
    }

    /**
     * Method to review a BMI goal of the user. Determines whether the user has achieved, failed, or is still working towards a particular BMI goal
     * @param currentBmi A <b>Double</b> of the users' current BMI.
     * @return A <b>String</b> of the status of the goal completion.
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
