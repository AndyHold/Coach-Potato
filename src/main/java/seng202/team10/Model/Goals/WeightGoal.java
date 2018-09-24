package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

/**
 * Weight Goal Class for Coach Potato SENG202 2018S2
 */
public class WeightGoal extends Goal {
    private double goalWeight;

    public WeightGoal(String name, DateTime start, DateTime target, double weight)
    {
        super(name, start, target, "Weight", false);
        goalWeight = weight;
    }

    /**
     * Getter method for the goal weight
     * @return double
     */
    public double getGoalWeight()
    {
        return this.goalWeight;
    }



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
