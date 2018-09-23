package seng202.team10.Visual;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.InvalidHeightException;
import seng202.team10.Model.Exceptions.InvalidWeightException;
import seng202.team10.Model.Exceptions.UserNameException;
import seng202.team10.Model.Goals.UserProfile;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ProfileControllerTest {

    ArrayList<UserProfile> users = new ArrayList<>();

    @Before
    @Test
    public void badName() throws InvalidWeightException, InvalidHeightException {
        try {
            users.add(new UserProfile("Potat ", 60, 60, new DateTime(1998,04,19,0,0,0), "Male"));
        } catch (UserNameException e) {
            assertTrue(e.getMessage().equals("Invalid Username"));
        }
    }

    @Test
    public void goodName() throws InvalidWeightException, InvalidHeightException {
    ArrayList<UserProfile> users = new ArrayList<>();
        try {
            users.add(new UserProfile("Potato", 60, 60, new DateTime(1998,04,19,0,0,0), "Male"));
        } catch (UserNameException | IllegalArgumentException exception) {
            assertTrue(exception.getMessage().equals("Invalid Username"));
        }
        assertTrue(users.size() == 1);
    }

//    @Test
//    public void sameName() throws InvalidWeightException, InvalidHeightException {
//        ArrayList<UserProfile> users = new ArrayList<>();
//        try {
//            try {
//                users.add(new UserProfile("Potato", 60, 60, new DateTime(1998,04,19,0,0,0), "Male"));
//            } catch (UserNameException | IllegalArgumentException exception) {
//                assertTrue(exception.getMessage().equals("Invalid Username"));
//            }
//        } catch (UniqueNameException | IllegalArgumentException exception) {
//            assertTrue(exception.getMessage().equals("This username already exists"));
//        }
//    }
}
