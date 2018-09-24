package seng202.team10.Model.Goals;

import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

/**
 * Time Goal Class for Coach Potato SENG202 2018S2
 */
public class TimeGoal extends Goal {
    private double goalTime;

    public TimeGoal(String name, DateTime start, DateTime target, double time) {
        super(name, start, target, "Time", false);
        goalTime = time;
    }

    /**
     * Getter method for the goal time
     * @return double
     */
    public double getGoalTime()
    {
        return this.goalTime;
    }


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
