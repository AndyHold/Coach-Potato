package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;

import java.time.LocalDateTime;

<<<<<<< HEAD

=======
/**
 * Class that extends the Goal superclass, represents an instance of a goal of the user to cover a certain amount of distance.
 */
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
public class DistanceGoal extends Goal {


    private double goalDistance;


    /**
     * Constructor method for distance goal.
     * @param name A <b>String</b> of the name of the goal.
     * @param start The start <b>DateTime</b> of the goal.
     * @param target The end <b>DateTime</b> of the goal.
     * @param distance A <b>Double</b> of the distance.
     * @throws InvalidGoalDateException When invalid dates are entered.
     * @throws BadGoalNameException When an invalid goal name is entered.
     * @throws InvalidGoalTargetException When an invalid goal target is entered.
     */
    public DistanceGoal(String name, DateTime start, DateTime target, double distance) throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException
    {
        super(name, start, target, "Distance");
        setTargetValue(distance);
    }


    /**
     * Setter method for the target value of distance goal.
     * @param target A <b>Double</b> of the distance.
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
     * Getter method for the goal distance.
     * @return A <b>Double</b> of the distance.
     */
    public double getGoalDistance()
    {
        return this.goalDistance;
    }


    /**
     * Method to review a distance goal of the user. Determines whether the user has achieved, failed, or is still working towards a particular distance goal.
     * @param dist A <b>Double</b> of the distance the user has travelled so far.
     * @return A <b>String</b> of the status of the goal completion.
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
