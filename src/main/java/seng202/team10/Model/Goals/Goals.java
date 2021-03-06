package seng202.team10.Model.Goals;


import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.BadGoalNameException;
import seng202.team10.Model.Exceptions.InvalidGoalDateException;
import seng202.team10.Model.Exceptions.InvalidGoalTargetException;
import seng202.team10.Model.UserProfile;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;


/**
 * Class that contains all lists of different goals for a user, as well as methods for interacting with them.
 *
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
     * Constructor method for Goals Class.
     * @param user A <b>UserProfile</b> of the user.
     */
    public Goals(UserProfile user)
    {
        this.user = user;
    }


    /**
     * Method to place the given goal in the correct list.
     * @param newGoal The <b>Goal</b> being placed.
     * @param startDate The start <b>DateTime</b> of the goal.
     * @param today The <b>DateTime</b> of today.
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
     * Method to create a frequency goal and place it in the correct list.
     * @param name A <b>String</b> of the goal name.
     * @param startDate The start <b>DateTime</b> of the goal.
     * @param targetDate The end <b>DateTime</b> of the goal.
     * @param type A <b>String</b> of the goal type.
     * @param value A <b>Double</b> of the target value of the goal.
     * @param user A <b>UserProfile</b> of the currently logged in user.
     * @throws InvalidGoalDateException When invalid dates are entered.
     * @throws BadGoalNameException When an invalid goal name is entered.
     * @throws InvalidGoalTargetException When an invalid goal target is entered.
     */
    public void createGoal(String name, DateTime startDate, DateTime targetDate, String type, Double value, UserProfile user) throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        if (getCreatedGoalNames().contains(name)) {
            throw new BadGoalNameException();
        } else {
            GoalType goalType = GoalType.getTypeFromString(type);
            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear();
            int month = now.getMonthValue();
            int day = now.getDayOfMonth();
            DateTime today = new DateTime(year, month, day, 0, 0, 0);
            switch (goalType) {
                case WEIGHT:
                    WeightGoal newWeightGoal = new WeightGoal(name, startDate, targetDate);
                    newWeightGoal.setTargetValue(value, user);
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
                    BmiGoal newBmiGoal = new BmiGoal(name, startDate, targetDate);
                    newBmiGoal.setTargetValue(value, user);
                    placeGoal(newBmiGoal, startDate, today);
                    break;
            }
        }
    }


     /**
     * Method to create a frequency goal and place it in the correct ArrayList.
     * @param name A <b>String</b> name of the goal.
     * @param startDate The start <b>DateTime</b> of the goal.
     * @param targetDate The end <b>DateTime</b> of the goal.
     * @param freq An <b>int</b> of the number of activities to do to complete the goal.
     * @param type A <b>String</b> of the type of goal.
     * @throws InvalidGoalDateException When invalid dates are entered.
     * @throws BadGoalNameException When an invalid goal name is entered.
     * @throws InvalidGoalTargetException When an invalid goal target is entered.
     */
    public void createGoal(String name, DateTime startDate, DateTime targetDate, int freq, String type) throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException {
        if (getCreatedGoalNames().contains(name)) {
            throw new BadGoalNameException();
        } else {
            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear();
            int month = now.getMonthValue();
            int day = now.getDayOfMonth();
            DateTime today = new DateTime(year, month, day, 0, 0, 0);
            FrequencyGoal newFrequencyGoal = new FrequencyGoal(name, startDate, targetDate, freq);
            placeGoal(newFrequencyGoal, startDate, today);
        }
    }


    /**
     * Method to remove a current goal from the currentGoals and currentGoalNames array lists.
     * @param goalName A <b>String</b> of the goal name.
     */
    public void removeCurrentGoal(String goalName)
    {
        if (currentGoalNames.contains(goalName)) {
            Goal goal = getCurrentGoalObject(goalName);
            currentGoalNames.remove(goalName);
            createdGoalNames.remove(goalName);
            currentGoals.remove(goal);
            createdGoals.remove(goal);
        }
    }


    /**
     * Method to remove a future goal from the currentGoals and currentGoalNames array lists.
     * @param goalName A <b>String</b> of the goal name.
     */
    public void removeFutureGoal(String goalName)
    {
        if (futureGoalNames.contains(goalName)) {
            Goal goal = getFutureGoalObject(goalName);
            futureGoalNames.remove(goalName);
            createdGoalNames.remove(goalName);
            futureGoals.remove(goal);
            createdGoals.remove(goal);
        }
    }

    /**
     * Method to review the progress the user is making towards meeting a particular goal.
     * @param goalName A <b>String</b> of the goal name.
     * @return A <b>String</b> a textual description of the user progress towards meeting the goal.
     */
    public String checkGoal(String goalName)
    {
        LocalDateTime now1 = LocalDateTime.now();
        DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        Goal goal = getCurrentGoalObject(goalName);
        String progress = "in progress";
        if (currentGoals.contains(goal)) {
            String type = goal.getGoalType();
            switch (type) {
                case "Weight":
                    if (user.getWeight() <= ((WeightGoal) goal).getGoalWeight()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                        progress = "achieved";
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                        progress = "failed";
                    }
                    break;
                case "BMI":
                    if (user.calcBmi() <= ((BmiGoal) goal).getGoalBmi()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                        progress = "achieved";
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                        progress = "failed";
                    }
                    break;
                case "Distance":
                    double totalDistance = user.getActivitiesDistance(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    if (totalDistance >= ((DistanceGoal) goal).getGoalDistance()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                        progress = "achieved";
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                        progress = "failed";
                    }
                    break;
                case "Frequency":
                    int numActivities = user.getActivitiesFreq(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    if (numActivities >= ((FrequencyGoal) goal).getGoalFrequency()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                        progress = "achieved";
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                        progress = "failed";
                    }
                    break;
                case "Time":
                    double timeSumActivities = user.getActivitiesTime(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    if (timeSumActivities >= ((TimeGoal) goal).getGoalTime()) {
                        removeCurrentGoal(goalName);
                        goal.setGoalAchievedStatus(true);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                        progress = "achieved";
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                        progress = "failed";
                    }
                    break;
            }
        }
        return progress;
    }


    /**
     * Setter method for the currentGoalNames of the user.
     * @param currentGoals An <b>ArrayList&lt;Goal&gt;</b> of current goals.
     */
    public void setCurrentGoals(ArrayList<Goal> currentGoals)
    {
        this.currentGoals = currentGoals;
    }


    /**
     * Setter method for the currentGoalNames of the user.
     * @param currentGoalNames An <b>ArrayList&lt;String&gt;</b> of current goal names.
     */
    public void setCurrentGoalNames(ArrayList<String> currentGoalNames)
    {
        this.currentGoalNames = currentGoalNames;
    }


    /**
     * Setter method for the createdGoals of the user.
     * @param createdGoals An <b>ArrayList&lt;Goal&gt;</b> of created goals.
     */
    public void setCreatedGoals(ArrayList<Goal> createdGoals)
    {
        this.createdGoals = createdGoals;
    }


    /**
     * Setter method for the createdGoalNames of the user.
     * @param createdGoalNames An <b>ArrayList&lt;String&gt;</b> of created goal names.
     */
    public void setCreatedGoalNames(ArrayList<String> createdGoalNames)
    {
        this.createdGoalNames = createdGoalNames;
    }


    /**
     * Getter method for the currentGoalNames of the user.
     * @return An <b>ArrayList&lt;String&gt;</b> of current goal names.
     */
    public ArrayList<String> getCurrentGoalNames()
    {
        return currentGoalNames;
    }


    /**
     * Getter method for the achieved goals of the user.
     * @return An <b>ArrayList&lt;Goal&gt;</b> of achieved goals.
     */
    public ArrayList<Goal> getAchievedGoals()
    {
        return achievedGoals;
    }


    /**
     * Getter method for the current goals of the user.
     * @return  An <b>ArrayList&lt;Goal&gt;</b> of current goals.
     */
    public ArrayList<Goal> getCurrentGoals()
    {
        return currentGoals;
    }


    /**
     * Getter method for the failed goals of the user.
     * @return  An <b>ArrayList&lt;Goal&gt;</b> of failed goals.
     */
    public ArrayList<Goal> getFailedGoals()
    {
        return failedGoals;
    }


    /**
     * Getter method for the failed goal names of the user.
     * @return An <b>ArrayList&lt;String&gt;</b> of failed goal names.
     */
    public ArrayList<String> getFailedGoalNames()
    {
        return failedGoalNames;
    }


    /**
     * Getter method for the created goals of the user (current, past and future).
     * @return  An <b>ArrayList&lt;Goal&gt;</b> of created goals.
     */
    public ArrayList<Goal> getCreatedGoals()
    {
        return createdGoals;
    }


    /**
     * Getter method for the created goal names of the user.
     * @return An <b>ArrayList&lt;String&gt;</b> of created goal names.
     */
    public ArrayList<String> getCreatedGoalNames()
    {
        return createdGoalNames;
    }


    /**
     * Getter method for the future goals of the user.
     * @return  An <b>ArrayList&lt;Goal&gt;</b> of future goals.
     */
    public ArrayList<Goal> getFutureGoals()
    {
        return futureGoals;
    }


    /**
     * Getter method for the future goal names of the user.
     * @return An <b>ArrayList&lt;String&gt;</b> of future goal names.
     */
    public ArrayList<String> getFutureGoalNames()
    {
        return futureGoalNames;
    }


    /**
     * Getter method for the current goal instance of the user.
     * @return A <b>Goal</b> object.
     */
    private Goal getCurrentGoalObject(String goalName)
    {
        int index = currentGoalNames.indexOf(goalName);
        return currentGoals.get(index);
    }


    /**
     * Getter method for the future goal instance of the user.
     * @return A <b>Goal</b> object.
     */
    private Goal getFutureGoalObject(String goalName)
    {
        int index = futureGoalNames.indexOf(goalName);
        return futureGoals.get(index);
    }

    /**
     * Getter method for the achieved goal names of the user.
     * @return An <b>ArrayList&lt;String&gt;</b> of achieved goal names.
     */
    public ArrayList<String> getAchievedGoalNames()
    {
        return achievedGoalNames;
    }


    /**
     * Method to refresh the goals to check whether any future goals have become current goals.
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