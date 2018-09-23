package seng202.team10.Model.Goals;

import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

public class BmiGoal extends Goal {
    private double goalBmi;

    public BmiGoal(String name, DateTime start, DateTime target, double bmi)
    {
        super(name, start, target, "BMI", false);
        goalBmi = bmi;
    }

    /**
     * Getter method for the goal BMI
     * @return double
     */
    public double getGoalBmi()
    {
        return this.goalBmi;
    }

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
