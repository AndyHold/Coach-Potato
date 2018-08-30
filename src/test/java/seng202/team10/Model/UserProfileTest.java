package seng202.team10.Model;

import org.junit.*;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.FileOperations.FileReader;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;

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
        ArrayList<String> fileContents = testParser.getFileContents("testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        ArrayList<Activity> testResults = testParser.processFile(formattedFile);
        testProfile.addActivities(testResults);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void serializeTest(){
        writer.saveProfile(testProfile);
        UserProfile loadedProfile = reader.loadExistingProfile("dave");
        assertEquals(testProfile.getActivities(), loadedProfile.getActivities());
    }

    @Test
    public void addActivities() {


    }
}