package seng202.team10.Model;

import seng202.team10.Model.ActivitiesData.DateTime;

public class BmiGoal extends Goal {


    public BmiGoal(String name, DateTime start, DateTime target, double targetBmi)
    {
        super(name, start, target, "BMI", false, 0, 0.0, 0.0, 0.0, targetBmi);
    }


}
