package seng202.team10.Model;

import seng202.team10.Model.ActivitiesData.DateTime;

public class TimeGoal extends Goal {

    public TimeGoal(String name, DateTime start, DateTime target, double time) {


        super(name, start, target, "Time", false, 0.0, 0, time, 0.0, 0.0, 0.0);
    }
}
