package seng202.team10.Model;


import java.util.ArrayList;

/**
 * Goals Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Goals {

    private ArrayList<Goal> currentGoals;
    private ArrayList<Goal> achievedGoals;
    private ArrayList<Goal> failedGoals;
    private ArrayList<Goal> availableGoals;



    public Goal createGoal() {
        //prompt user for the goal type they wish to create
        String userAns = "Weight";
        //WeightGoal newGoal = new WeightGoal();
        if (userAns == "Weight") {
            WeightGoal newGoal = new WeightGoal();
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Frequency") {
            FrequencyGoal newGoal = new FrequencyGoal();
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Distance") {
            DistanceGoal newGoal = new DistanceGoal();
            availableGoals.add(newGoal);
            return newGoal;
        } else if (userAns == "Velocity") {
            VelocityGoal newGoal = new VelocityGoal();
            availableGoals.add(newGoal);
            return newGoal;
        } else {
            TimeGoal newGoal = new TimeGoal();
            availableGoals.add(newGoal);
            return newGoal;
        }
    }

    public void addGoal(Goal goal) {
        currentGoals.add(goal);
    }

    public void removeGoal(Goal goal) {
        currentGoals.remove(goal);

    }

    public void checkGoals() {
        String toPrint = "";
        for (Goal goal : currentGoals) {
            toPrint += goal.getGoalType();
        }
        System.out.println("The current goal types you are working towards are: " + toPrint);

    }
}
