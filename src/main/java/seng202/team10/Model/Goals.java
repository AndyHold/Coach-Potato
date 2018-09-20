package seng202.team10.Model;


import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;

import java.io.Serializable;
import java.time.LocalDate;
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
    ArrayList<String> currentGoalNames = new ArrayList<String>();
    private ArrayList<Goal> achievedGoals = new ArrayList<Goal>();
    ArrayList<String> achievedGoalNames = new ArrayList<String>();
    private ArrayList<Goal> failedGoals = new ArrayList<Goal>();
    ArrayList<String> failedGoalNames = new ArrayList<String>();
    private ArrayList<Goal> createdGoals = new ArrayList<Goal>();
    ArrayList<String> createdGoalNames = new ArrayList<String>();
    private ArrayList<Goal> futureGoals = new ArrayList<>();
    ArrayList<String> futureGoalNames = new ArrayList<String>();

    //private ArrayList<Goal> availableGoals = new ArrayList<Goal>();
    //ArrayList<String> availableGoalNames = new ArrayList<String>();

    /**
     * Constructor method for Goals Class
     * @param user: UserProfile
     */
    public Goals(UserProfile user) {
        this.user = user;
    }

    /**
     * Method to create a goal for a user to work towards.
     * @param name: String
     * @param startDate: DateTime
     * @param targetDate: DateTime
     * @param type: String
     * @param achieved: Boolean
     * @param frequency: int
     * @param time: double
     * @param weight: double
     * @param distance: double
     * @param bmi: double
     * @return Goal
     */
    public Goal createGoal(String name, DateTime startDate, DateTime targetDate, String type, Boolean achieved, int frequency, double time, double weight, double distance, double bmi) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);

        if (type == "Weight") {
            WeightGoal newGoal = new WeightGoal(name, startDate, targetDate, weight);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            } else {
                futureGoals.add(newGoal);
                futureGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "Frequency") {
            FrequencyGoal newGoal = new FrequencyGoal(name, startDate, targetDate, frequency);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            } else {
                futureGoals.add(newGoal);
                futureGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "Distance") {
            DistanceGoal newGoal = new DistanceGoal(name, startDate, targetDate, distance);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            } else {
                futureGoals.add(newGoal);
                futureGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else if (type == "BMI") {
            BmiGoal newGoal = new BmiGoal(name, startDate, targetDate, bmi);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            } else {
                futureGoals.add(newGoal);
                futureGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        } else { //goal must be of type Time
            TimeGoal newGoal = new TimeGoal(name, startDate, targetDate, time);
            if (!startDate.isAfter(today)) {
                currentGoals.add(newGoal);
                currentGoalNames.add(newGoal.getGoalName());
            } else {
                futureGoals.add(newGoal);
                futureGoalNames.add(newGoal.getGoalName());
            }
            createdGoals.add(newGoal);
            createdGoalNames.add(newGoal.getGoalName());
            return newGoal;
        }
    }

//    public void addGoal(Goal goal) {
//        if (availableGoals.contains(goal)) {
//            currentGoals.add(goal);
//            currentGoalNames.add(goal.getGoalName());
//        }
//        else {
//            System.out.println("This goal is not available.");
//        }
//    }

//    public void removeGoal(Goal goal) {
//        if (currentGoals.contains(goal)) {
//            currentGoals.remove(goal);
//            currentGoalNames.remove(goal.getGoalName());
//            createdGoals.remove(goal);
//            createdGoalNames.remove(goal.getGoalName());
//        }
//        else {
//            System.out.println("This goal is not one of your current goals");
//        }
//
//    }

    /**
     * Method to remove a current goal from the currentGoals and currentGoalNames array lists
     * @param goalName: String
     */
    public void removeCurrentGoal(String goalName) {
        if (currentGoalNames.contains(goalName)) {
            currentGoalNames.remove(goalName);
            createdGoalNames.remove(goalName);
            Goal goal = getGoalObject(goalName);
            currentGoals.remove(goal);
            createdGoals.remove(goal);
        }
        else {
            System.out.println("This goal is not one of your current goals");
        }

    }

//    public ArrayList<String> getAvailableGoalNames() {
//        return availableGoalNames;
//    }

//    public void checkGoal(String goalName) {
//        Goal goal = getGoalObject(goalName);
//        if (currentGoals.contains(goal)) { // is this necessary if combobox will only ever have current goals??
//            System.out.println("" + goalName + "is of type " + goal.getGoalType());
//            String type = goal.getGoalType();
//            switch (type) {
//                case "Weight":
//                    //goal.reviewWeightGoal(goal, user.getWeight());
//                    goal.reviewWeightGoal(goal, 70);
//                    break;
//                case "BMI":
//                    //goal.reviewBmiGoal(goal, user.calcBmi());
//                    goal.reviewBmiGoal(goal, 30);
//                    break;
//                //to do add in the Distance, frequency, and time cases (which need data loaded first)
//            }
//        }
//    }

    /**
     * Method to check a goal, i.e. review the progress the user is making towards meeting a particular goal
     * @param goalName: String
     * @return String: a textual description of the user progress towards meeting the goal
     */
    public String checkGoal(String goalName) {
        LocalDateTime now1 = LocalDateTime.now();
        DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth()+2, now1.getHour(), now1.getMinute(), now1.getSecond());
        Goal goal = getGoalObject(goalName);
        String progress = "";
        if (currentGoals.contains(goal)) { // is this necessary if combobox will only ever have current goals??
            System.out.println("" + goalName + "is of type " + goal.getGoalType());
            String type = goal.getGoalType();
            switch (type) {
                case "Weight":
                    System.out.println(user);
                    progress = goal.reviewWeightGoal(goal, user.getWeight());
                    if (user.getWeight() <= goal.getGoalWeight()) {
                        removeCurrentGoal(goalName);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "BMI":
                    System.out.println(user);
                    progress = goal.reviewBmiGoal(goal, user.getBmi());
                    if (user.getBmi() <= goal.getGoalBmi()) {
                        removeCurrentGoal(goalName);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "Distance":
                    System.out.println(user);
                    double totalDistance = user.getActivitiesDistance(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    System.out.println(totalDistance);
                    progress = goal.reviewDistanceGoal(goal, totalDistance);
                    if (totalDistance >= goal.getGoalDistance()) {
                        removeCurrentGoal(goalName);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "Frequency":
                    System.out.println(user);
                    int numActivities = user.getActivitiesFreq(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    System.out.println(numActivities);
                    progress = goal.reviewFrequencyGoal(goal, numActivities);
                    if (numActivities >= goal.getGoalFrequency()) {
                        removeCurrentGoal(goalName);
                        achievedGoals.add(goal);
                        achievedGoalNames.add(goalName);
                    } else if (!goal.getGoalTargetDate().isAfter(now2)) {
                        removeCurrentGoal(goalName);
                        failedGoals.add(goal);
                        failedGoalNames.add(goalName);
                    }
                    break;
                case "Time":
                    System.out.println(user);
                    int timeSumActivities = user.getActivitiesTime(goal.getGoalStartDate(), goal.getGoalTargetDate());
                    System.out.println(timeSumActivities);
                    progress = goal.reviewTimeGoal(goal, timeSumActivities);
                    if (timeSumActivities >= goal.getGoalTime()) {
                        removeCurrentGoal(goalName);
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
     * Getter method for the currentGoalNames of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getCurrentGoalNames() {
        return currentGoalNames;
    }

    /**
     * Getter method for the achieved goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getAchievedGoals() {
        return achievedGoals;
    }

    /**
     * Getter method for the current goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getCurrentGoals() {
        return currentGoals;
    }

//    public ArrayList<Goal> getAvailableGoals() {
//        return availableGoals;
//    }

    /**
     * Getter method for the failed goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getFailedGoals() {
        return failedGoals;
    }


    public ArrayList<String> getFailedGoalNames() {
        return failedGoalNames;
    }


    /**
     * Getter method for the created goals of the user (current, past and future)
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getCreatedGoals() {
        return createdGoals;
    }

    /**
     * Getter method for the created goal names of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getCreatedGoalNames() {
        return createdGoalNames;
    }

    /**
     * Getter method for the future goals of the user
     * @return ArrayList<Goal>
     */
    public ArrayList<Goal> getFutureGoals() {
        return futureGoals;
    }

    /**
     * Getter method for the future goal names of the user
     * @return ArrayList<String>
     */
    public ArrayList<String> getFutureGoalNames() {
        return futureGoalNames;
    }

    /**
     * Getter method for the goal instance of the user
     * @return Goal
     */
    public Goal getGoalObject(String goalName) {
        for (Goal goal : currentGoals) {
            if (goal.getGoalName() == goalName) {
                return goal;
            }
        }
        return null;
    }

    public ArrayList<String> getAchievedGoalNames() {
        return achievedGoalNames;
    }


    public void refreshGoals() {
        System.out.println("eeeeeeeeeeek");
        LocalDateTime now1 = LocalDateTime.now();
        //DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        DateTime now2 = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth()+2, now1.getHour(), now1.getMinute(), now1.getSecond());
        ArrayList<Goal>futureGoalsCopy = (ArrayList<Goal>) futureGoals.clone();
        for (Goal goal : futureGoalsCopy) {
            if (!goal.getGoalStartDate().isAfter(now2)) {
                futureGoals.remove(goal);
                futureGoalNames.remove(goal.getGoalName());
                currentGoals.add(goal);
                currentGoalNames.add(goal.getGoalName());
                System.out.println("Future goal changed to current");
            }
        }

        //TODO atm user must review their current goals before they can become past goals. Possibly implement something here that checks if the current goal has become a past goal
    }

}