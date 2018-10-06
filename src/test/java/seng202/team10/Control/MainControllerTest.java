package seng202.team10.Control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainControllerTest {
//
//    private MainController testMainController;
//    private UserProfile testUser;
//    private DateTime testDOB;
//    private ArrayList<UserProfile> testUsers;
//    private UserProfile badTestUser;
//
//
//    @Before
//    public void setUp() throws Exception
//    {
//        testUsers = new ArrayList<>();
//        testMainController = new MainController();
//        testUser = new UserProfile();
//        testUser.setName("Test User");
//        testUser.setWeight(80.0);
//        testUser.setHeight(180.0);
//        testUser.setGender("Male");
//        testDOB = new DateTime(1990,    1, 1, 0,0,0);
//        testUser.setBirthDate(testDOB);
//        testUser.setMaxHeartRate(200);
//        badTestUser = new UserProfile();
//        testMainController.setUsers(testUsers);
//        for (int i = 0; i < 2; i++) {
//            UserProfile testUser1 = new UserProfile();
//            testUser1.setName("testUsernum" + String.valueOf(i));
//            testUser1.setWeight(80.0);
//            testUser1.setHeight(180.0);
//            testUser1.setGender("Male");
//            testDOB = new DateTime(1990, 1, 1, 0,0,0);
//            testUser1.setBirthDate(testDOB);
//            testUser1.setMaxHeartRate(200);
//            testMainController.createUser(testUser1);
//        }
//    }
//
//
//
//    @Test
//    public void uploadDataToUser() throws Exception
//    {
//        testMainController.uploadDataToUser(testUser, "FilesToLoad/testdata.csv");
//        assertEquals(12, testUser.getActivities().size());
//    }
//
//    @Test
//    public void checkUniqueName()
//    {
//        String message = "Failed Test";
//        try {
//            testMainController.checkUniqueName("testUsernum0");
//        } catch (UniqueNameException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @Test
//    public void createUserPass() throws InvalidUserException
//    {
//        String message = "Failed Test";
//        testMainController.createUser(testUser);
//        try {
//            testMainController.checkUniqueName("Test User");
//        } catch (UniqueNameException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @Test
//    public void createUserFailNoName() throws InvalidWeightException, InvalidHeightException {
//        String message = "Test Failed";
//        badTestUser.setMaxHeartRate(200);
//        badTestUser.setWeight(80.0);
//        badTestUser.setHeight(180.0);
//        badTestUser.setBirthDate(testDOB);
//        badTestUser.setGender("Male");
//        try {
//            testMainController.createUser(badTestUser);
//        } catch (InvalidUserException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @Test
//    public void createUserFailNoWeight() throws UserNameException, InvalidHeightException {
//        String message = "Test Failed";
//        badTestUser.setName("Test User");
//        badTestUser.setMaxHeartRate(200);
//        badTestUser.setHeight(180.0);
//        badTestUser.setBirthDate(testDOB);
//        badTestUser.setGender("Male");
//        try {
//            testMainController.createUser(badTestUser);
//        } catch (InvalidUserException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @Test
//    public void createUserFailNoHeight() throws UserNameException, InvalidWeightException {
//        String message = "Test Failed";
//        badTestUser.setName("Test User");
//        badTestUser.setWeight(80.0);
//        badTestUser.setMaxHeartRate(200);
//        badTestUser.setBirthDate(testDOB);
//        badTestUser.setGender("Male");
//        try {
//            testMainController.createUser(badTestUser);
//        } catch (InvalidUserException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @Test
//    public void createUserFailNoBirthDate() throws InvalidHeightException, InvalidWeightException, UserNameException {
//        String message = "Test Failed";
//        badTestUser.setName("Test User");
//        badTestUser.setWeight(80.0);
//        badTestUser.setHeight(180.0);
//        badTestUser.setMaxHeartRate(200);
//        badTestUser.setGender("Male");
//        try {
//            testMainController.createUser(badTestUser);
//        } catch (InvalidUserException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @Test
//    public void createUserFailNoGender() throws InvalidHeightException, InvalidWeightException, UserNameException {
//        String message = "Test Failed";
//        badTestUser.setName("Test User");
//        badTestUser.setWeight(80.0);
//        badTestUser.setHeight(180.0);
//        badTestUser.setBirthDate(testDOB);
//        badTestUser.setMaxHeartRate(200);
//        try {
//            testMainController.createUser(badTestUser);
//        } catch (InvalidUserException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @Test
//    public void createUserFailNoMaxHeartRate() throws UserNameException, InvalidWeightException, InvalidHeightException {
//        String message = "Test Failed";
//        badTestUser.setName("Test User");
//        badTestUser.setWeight(80.0);
//        badTestUser.setHeight(180.0);
//        badTestUser.setBirthDate(testDOB);
//        badTestUser.setGender("Male");
//        try {
//            testMainController.createUser(badTestUser);
//        } catch (InvalidUserException e) {
//            message = "Passed Test";
//        }
//        assertEquals("Passed Test", message);
//    }
//
//    @After
//    public void tearDown()
//    {
//        testUsers = null;
//        testUser = null;
//        testMainController = null;
//        testDOB = null;
//        badTestUser = null;
//    }
}