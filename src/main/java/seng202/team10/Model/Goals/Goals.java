package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.UserProfile;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;


/**
 * Goals Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Goals implements Serializable {

    private UserProfile user;



    private ArrayList<Goal> currentGoals = new ArrayList<Goal>();
    private ArrayList<String> currentGoalNames = new ArrayList<String>();
    private ArrayList<Goal> achievedGoals = new ArrayList<Goal>();
    private ArrayList<String> achievedGoalNames = new ArrayList<String>();
    private ArrayList<Goal> failedGoals = new ArrayList<Goal>();
    private ArrayList<String> failedGoalNames = new ArrayList<String>();
    private ArrayList<Goal> createdGoals = new ArrayList<Goal>();
    private ArrayList<String> createdGoalNames = new ArrayList<String>();
    private ArrayList<Goal> futureGoals = new ArrayList<>();
    private ArrayList<String> futureGoalNames = new ArrayList<String>();

    /**
     * Constructor method for Goals Class
     * @param user: UserProfile
     */
    public Goals(UserProfile user)
    {
        this.user = user;
    }


    /**
     * Method to place the given goal in the correct ArrayList
     * @param newGoal Goal: goal to be placed
     * @param startDate DateTime: Start date of the goal
     * @param today DateTime: Todays Date
     */
    private void placeGoal(Goal newGoal, DateTime startDate, DateTime today)
    {
        if (!startDate.isAfter(today)) {
            currentGoals.add(newGoal);
            currentGoalNames.add(newGoal.getGoalName());
        } else {
            futureGoals.add(newGoal);
            futureGoalNames.add(newGoal.getGoalName());
        }
        createdGoals.add(newGoal);
        createdGoalNames.add(newGoal.getGoalName());
    }

    /**
     * Method to create a frequency goal and place it in the correct ArrayList
     * @param name String: name of the goal
     * @param startDate DateTime: date the goal starts on
     * @param targetDate DateTime: target date for the goal
     * @param type String: String representation of the type of goal
     * @param value double: goal value
     */
    public void createGoal(String name, DateTime startDate, DateTime targetDate, String type, Double value)
    {
        GoalType goalType = GoalType.getTypeFromString(type);
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);
        switch(goalType)
        {
            case WEIGHT:
                WeightGoal newWeightGoal = new WeightGoal(name, startDate, targetDate, value);
                placeGoal(newWeightGoal, startDate, today);
                break;
            case DISTANCE:
                DistanceGoal newDistGoal = new DistanceGoal(name, startDate, targetDate, value);
                placeGoal(newDistGoal, startDate, today);
                break;
            case TIME:
                TimeGoal newTimeGoal = new TimeGoal(name, startDate, targetDate, value);
                placeGoal(newTimeGoal, startDate, today);
                break;
            case BMI:
                BmiGoal newBmiGoal = new BmiGoal(name, startDate, targetDate, value);
                placeGoal(newBmiGoal, startDate, today);
                break;
        }
    }


    /**
     * Method to create a frequency goal and place it in the correct ArrayList
     * @param name String: name of the goal
     * @param startDate DateTime: date the goal starts on
     * @param targetDate DateTime: target date for the goal
     * @param freq int: goal number of activities
     */
    public void createGoal(String name, DateTime startDate, DateTime targetDate, int freq)
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0, 0, 0);
        FrequencyGoal newFrequencyGoal = new FrequencyGoal(name, startDate, targetDate, freq);
        placeGoal(newFrequencyGoal, startDate, today);
    }




    /**
     * Method to remove a current goal from the currentGoals and currentGoalNames array lists
     * @param goalName: String
     */
    public void removeCurrentGoal(String goalName)
    {
        if (currentGoalNames.contains(goalName)) {
            Goal goal = getGoalObject(goalName);
            currentGoalNames.remove(goalName);
            createdGoalNames.remove(goalName);
            currentGoals.remove(goal);
            createdGoals.remove(goal);
        }

    }

    /**
     * Method to check a goal, i.e. review the progress the user is making towards meeting a particular goal
     * @param goalName: String
     * @return String: a textual description of the user progress towards meeting the goal
     */
    public String checkGoal(String goalName)
    {
        LocalDateTime now1 = LocalDateTime.now();
        DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        Goal goal = getGoalObject(goalName);
        String progress = "";
        if (currentGoals.contains(goal)) {
            String type = goal.getGoalType();
            switch (type) {
                case "Weight":
                    progress = ((WeightGoal) goal).reviewWeightGoal(user.getWeight());
                    if (user.getWeight() <= ((WeightGoal) goal).getGoalWeight()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "BMI":
                    progress = ((BmiGoal) goal).reviewBmiGoal(user.calcBmi());
                    if (user.calcBmi() <= ((BmiGoal) goal).getGoalBmi()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "Distance":
                    double totalDistance = user.getActivitiesDistance(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    progress = ((DistanceGoal) goal).reviewDistanceGoal(totalDistance);
                    if (totalDistance >= ((DistanceGoal) goal).getGoalDistance()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "Frequency":
                    int numActivities = user.getActivitiesFreq(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    progress = ((FrequencyGoal) goal).reviewFrequencyGoal(numActivities);
                    if (numActivities >= ((FrequencyGoal) goal).getGoalFrequency()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "Time":
                    double timeSumActivities = user.getActivitiesTime(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    progress = ((TimeGoal) goal).reviewTimeGoal(timeSumActivities);
                    if (timeSumActivities >= ((TimeGoal) goal).getGoalTime()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
            }
        }
        return progress;
    }


    /**
     * Setter method for the currentGoalNames of the user
     */
    public void setCurrentGoals(ArrayList<Goal> currentGoals)
    {
        this.currentGoals = currentGoals;
    }


    /**
     * Setter method for the currentGoalNames of the user
     */
    public void setCurrentGoalNames(ArrayList<String> currentGoalNames)
    {
        this.currentGoalNames = currentGoalNames;
    }


    /**
     * Setter method for the createdGoals of the user
     */
    public void setCreatedGoals(ArrayList<Goal> createdGoals)
    {
        this.createdGoals = createdGoals;
    }


    /**
     * Setter method for the createdGoalNames of the user
     */
    public void setCreatedGoalNames(ArrayList<String> createdGoalNames)
    {
        this.createdGoalNames = createdGoalNames;
    }


    /**
     * Getter method for the currentGoalNames of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getCurrentGoalNames()
    {
        return currentGoalNames;
    }


    /**
     * Getter method for the achieved goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getAchievedGoals()
    {
        return achievedGoals;
    }


    /**
     * Getter method for the current goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getCurrentGoals()
    {
        return currentGoals;
    }


    /**
     * Getter method for the failed goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getFailedGoals()
    {
        return failedGoals;
    }


    /**
     * Getter method for the failed goal names of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getFailedGoalNames()
    {
        return failedGoalNames;
    }


    /**
     * Getter method for the created goals of the user (current, past and future)
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getCreatedGoals()
    {
        return createdGoals;
    }


    /**
     * Getter method for the created goal names of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getCreatedGoalNames()
    {
        return createdGoalNames;
    }


    /**
     * Getter method for the future goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getFutureGoals()
    {
        return futureGoals;
    }


    /**
     * Getter method for the future goal names of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getFutureGoalNames()
    {
        return futureGoalNames;
    }


    /**
     * Getter method for the goal instance of the user
     * @return Goal
     */
    private Goal getGoalObject(String goalName)
    {
        int index = currentGoalNames.indexOf(goalName);
        return currentGoals.get(index);
    }

    /**
     * Getter method for the achieved goal names of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getAchievedGoalNames()
    {
        return achievedGoalNames;
    }


    /**
     * Method to refresh the goals to check whether any future goals have become current goals
     */
    public void refreshGoals()
    {
        LocalDateTime now1 = LocalDateTime.now();
        DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        ArrayList<Goal>futureGoalsCopy = (ArrayList<Goal>) futureGoals.clone();
        for (Goal goal : futureGoalsCopy) {
            if (!goal.getGoalStartDate().isAfter(now2)) {
                futureGoals.remove(goal);
                futureGoalNames.remove(goal.getGoalName());
                currentGoals.add(goal);
                currentGoalNames.add(goal.getGoalName());
            }
        }
    }

}