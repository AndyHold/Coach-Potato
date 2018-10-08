package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;

import java.time.LocalDateTime;

/**
 * Class that extends the Goal superclass, represents an instance of a goal of the user to do a certain number of exercises.
 */
public class FrequencyGoal extends Goal {
    private int goalFrequency;


    /**
     * Constructor method for frequency goal.
     * @param name A <b>String</b> of the name of the goal.
     * @param start The start <b>DateTime</b> of the goal.
     * @param target The end <b>DateTime</b> of the goal.
     * @param frequency An <b>int</b> of the number of exercises to do.
     * @throws InvalidGoalDateException When invalid dates are entered.
     * @throws BadGoalNameException When an invalid goal name is entered.
     * @throws InvalidGoalTargetException When an invalid goal target is entered.
     */
    public FrequencyGoal(String name, DateTime start, DateTime target, int frequency) throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException
    {
        super(name, start, target, "Frequency");
        setTargetValue(frequency);
    }


    /**
     * Setter method for the target value of frequency goal.
     * @param target An <b>int</b> of the target frequency.
     * @throws InvalidGoalTargetException When target is outside the correct values.
     */
    private void setTargetValue(int target) throws InvalidGoalTargetException
    {
        if (target < 1 || target > 1000) {
            throw new InvalidGoalTargetException("Target must be between 1 - 1000");
        } else {
            this.goalFrequency = target;
        }
    }


    /**
     * Getter method for the goal frequency.
     * @return An <b>int</b> of the goals' frequency.
     */
    public int getGoalFrequency()
    {
        return this.goalFrequency;
    }

    /**
     * Method to review a frequency goal of the user. Determines whether the user has achieved, failed, or is still working towards a particular frequency goal.
     * @param freq A <b>Double</b> of the users' current frequency.
     * @return A <b>String</b> of the status of the goal completion.
     */
    public String reviewFrequencyGoal(int freq)
    {
        String progressDescription = "Your target for this goal was to excersize " + this.getGoalFrequency() + " times by " + this.getGoalTargetDate();
        if (freq >= this.getGoalFrequency()) {
            progressDescription += "\nCongratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.";
        } else {
            LocalDateTime now1 = LocalDateTime.now();
            DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
            if (!this.getGoalTargetDate().isAfter(now2)) {
                progressDescription += "\n\nYou have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.";
            } else {
                double difference = this.getGoalFrequency() - freq;
                if (difference == 1) {
                    progressDescription += "\n\nYou need to complete 1 more activity to meet your goal.";
                } else {
                    progressDescription += "\n\nYou need to complete " + String.format("%.0f", difference) + " more activities to meet your goal.";
                }

            }
        }
        return progressDescription;
    }
}
