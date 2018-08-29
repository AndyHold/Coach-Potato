package seng202.team10.Model;

import seng202.team10.Model.ActivitiesData.*;

public class VelocityGoal extends Goal {

    public VelocityGoal(DateTime start, DateTime target, double velocity) {


        super(start, target, "Velocity", false, velocity, 0, 0.0, 0.0, 0.0);
    }


}
