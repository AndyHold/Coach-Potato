package seng202.team10.Model;

import seng202.team10.Model.ActivitiesData.DateTime;

public class FrequencyGoal extends Goal {

    public FrequencyGoal(String name, DateTime start, DateTime target, int frequency) {


        super(name, start, target, "Frequency", false, 0.0, frequency, 0.0, 0.0, 0.0, 0.0);
    }
}
