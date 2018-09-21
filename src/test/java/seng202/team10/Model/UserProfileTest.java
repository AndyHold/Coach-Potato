package seng202.team10.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.Exceptions.InvalidHeightException;
import seng202.team10.Model.Exceptions.InvalidWeightException;
import seng202.team10.Model.Exceptions.UserNameException;
import seng202.team10.Model.FileOperations.FileReader;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserProfileTest {

    private UserProfile testProfile = new UserProfile();
    private Parser testParser = new Parser();
    private FileReader reader= new FileReader();
    private FileWriter writer = new FileWriter();


    @Before
    public void setUp() throws Exception {
        testProfile.setName("dave");
        testProfile.setWeight(80);
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        ArrayList<Activity> testResults = testParser.processFile(formattedFile);
        testProfile.addActivities(testResults);
    }

    @After
    public void tearDown() throws Exception {
        writer.deleteProfile("dave");
    }

    @Test
    public void serializeTest(){
        writer.saveProfile(testProfile);
        UserProfile loadedProfile = reader.loadExistingProfile("dave");
        boolean sameActivities = true;
        for(int i = 0; i < testProfile.getActivities().size(); i++) {
            if(!testProfile.getActivities().get(i).getName().equals(loadedProfile.getActivities().get(i).getName())){
//                System.out.println(testProfile.getActivities().get(i).getName());
//                System.out.println(loadedProfile.getActivities().get(i).getName());
                sameActivities = false;
            }
        }
        assertEquals(true, sameActivities);
    }

    @Test
    public void changeName() throws UserNameException
    {
        testProfile.setName("Steve");
        assertEquals("Steve", testProfile.getName());
    }

//    @Test
//    public void addDupeActivities() throws FileNotFoundException {
//        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
//        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
//        ArrayList<Activity> testResults = testParser.processFile(formattedFile);
//        testProfile.addActivities(testResults);
//        testProfile.addActivities(testResults);
//        testProfile.addActivities(testResults);
//        assertEquals(12, testProfile.getActivities().size());
//    }

    @Test
    public void calculateBMI() throws InvalidWeightException, InvalidHeightException {
        testProfile.setWeight(100);
        testProfile.setHeight(200);
        assertEquals(25,testProfile.calcBmi(), 0.1);
    }

    @Test
    public void underweightBMI() throws InvalidWeightException, InvalidHeightException
    {
        testProfile.setWeight(50);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Underweight", bmicat);
    }

    @Test
    public void underweighthealthyBMIedge() throws InvalidWeightException, InvalidHeightException
    {
        testProfile.setWeight(74);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Healthy", bmicat);
    }

    @Test
    public void healthyBMI() throws InvalidWeightException, InvalidHeightException
    {
        testProfile.setWeight(90);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Healthy", bmicat);
    }

    @Test
    public void healthyoverweightBMIedge() throws InvalidWeightException, InvalidHeightException
    {
        testProfile.setWeight(100);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Overweight", bmicat);
    }

    @Test
    public void overweightBMI() throws InvalidWeightException, InvalidHeightException
    {
        testProfile.setWeight(110);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Overweight", bmicat);
    }
    @Test
    public void overweightobeseBMIedge() throws InvalidWeightException, InvalidHeightException
    {
        testProfile.setWeight(120);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Obese", bmicat);
    }
    @Test
    public void obeseBMI() throws InvalidWeightException, InvalidHeightException
    {
<<<<<<< HEAD
        testProfile.setWeight(250);
        testProfile.setHeight(200);
=======
        testProfile.setWeight(180);
        testProfile.setHeight(100);
<<<<<<< HEAD
>>>>>>> a30807bb... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
=======
>>>>>>> ff79906... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
>>>>>>> 9bd0c9a0... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Obese", bmicat);
    }
}