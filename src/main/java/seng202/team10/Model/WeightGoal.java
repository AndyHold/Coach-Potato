package seng202.team10.Model;

import seng202.team10.Model.ActivitiesData.DateTime;

public class WeightGoal extends Goal {

    public WeightGoal(DateTime start, DateTime target, double weight) {


        super(start, target, "Weight", false, 0.0, 0, 0.0, weight, 0.0);
    }

}
