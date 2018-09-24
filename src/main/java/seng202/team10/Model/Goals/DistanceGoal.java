package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

/**
 * Distance Goals Class for Coach Potato SENG202 2018S2
 */
public class DistanceGoal extends Goal {
    private double goalDistance;

    public DistanceGoal(String name, DateTime start, DateTime target, double distance)
    {
        super(name, start, target, "Distance", false);
        goalDistance = distance;
    }


    /**
     * Getter method for the goal distance
     * @return double
     */
    public double getGoalDistance()
    {
        return this.goalDistance;
    }

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
