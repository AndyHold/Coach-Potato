package seng202.team10.Visual;

import org.junit.Test;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Position;
import seng202.team10.Model.ActivitiesData.Route;
import seng202.team10.Model.UserProfile;

import static org.junit.Assert.assertEquals;

public class MapControllerTest {

    @Test
    public void makeRoute() throws Exception {
        MainController mainController = new MainController();
        UserProfile user = new UserProfile();
        user.setHeight(80);
        user.setWeight(80);
        user.setGender("Male");
        DateTime birthday = new DateTime(1996, 12, 04, 0, 0, 0);
        user.setBirthDate(birthday);
        mainController.uploadDataToUser(user, "./FilesToLoad/testdata.csv");
        Activity activity = user.getActivities().get(1);
        Route actualRoute = new Route();
        MapController mapController = new MapController();
        Route route = mapController.makeRoute(activity);
        actualRoute.addPosition(new Position(30.245576, -97.823843, 220.3));
        actualRoute.addPosition(new Position(30.246356, -97.823326, 220.3));
        actualRoute.addPosition(new Position(30.246539, -97.821931, 209.7));
        actualRoute.addPosition(new Position(30.247105, -97.821064, 207.8));
        actualRoute.addPosition(new Position(30.247719, -97.820641, 205.4));
        actualRoute.addPosition(new Position(30.248482, -97.820708, 207.3));
        actualRoute.addPosition(new Position(30.24915, -97.820722, 206.8));
        int i = 0;
        for (Position position : route.getRoute()) {
            assertEquals(position.getLatitude(), actualRoute.getRoute().get(i).getLatitude(), 0.01);
            assertEquals(position.getLongitude(), actualRoute.getRoute().get(i).getLongitude(), 0.01);
            assertEquals(position.getElevation(), actualRoute.getRoute().get(i).getElevation(), 0.01);
            i++;
        }
    }
}