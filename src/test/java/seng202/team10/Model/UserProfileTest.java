package seng202.team10.Model;

import org.junit.*;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.FileOperations.FileReader;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

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
    public void changeName(){
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
    public void calculateBMI() {
        testProfile.setWeight(100);
        testProfile.setHeight(200);
        assertEquals(25,testProfile.calcBmi(), 0.1);
    }

    @Test
    public void underweightBMI(){
        testProfile.setWeight(50);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Underweight", bmicat);
    }

    @Test
    public void underweighthealthyBMIedge(){
        testProfile.setWeight(74);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Healthy", bmicat);
    }

    @Test
    public void healthyBMI(){
        testProfile.setWeight(90);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Healthy", bmicat);
    }

    @Test
    public void healthyoverweightBMIedge(){
        testProfile.setWeight(100);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Overweight", bmicat);
    }

    @Test
    public void overweightBMI(){
        testProfile.setWeight(110);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Overweight", bmicat);
    }
    @Test
    public void overweightobeseBMIedge(){
        testProfile.setWeight(120);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Obese", bmicat);
    }
    @Test
    public void obeseBMI(){
        testProfile.setWeight(100000);
        testProfile.setHeight(200);
        String bmicat = testProfile.getBmiCategory();
        assertEquals("Obese", bmicat);
    }
}