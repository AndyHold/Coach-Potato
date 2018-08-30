package seng202.team10.Model;

import seng202.team10.Model.ActivitiesData.DateTime;

public class DistanceGoal extends Goal {

    public DistanceGoal(String name, DateTime start, DateTime target, double distance) {


        super(name, start, target, "Distance", false, 0, 0.0, 0.0, distance, 0.0);
    }

}
