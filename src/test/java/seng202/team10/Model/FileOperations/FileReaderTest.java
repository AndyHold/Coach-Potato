package seng202.team10.Model.FileOperations;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import seng202.team10.Model.Exceptions.UserNameException;
import seng202.team10.Model.UserProfile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FileReaderTest {

    private static FileReader testReader = new FileReader();
    private static FileWriter testWriter = new FileWriter();
    private static UserProfile testProfile = new UserProfile();


    @BeforeClass
    public static void setUp() throws Exception
    {
        testWriter.createProfileFolder();
        testProfile.setName("jeff");
        testProfile.setGender("Male");
        testProfile.setWeight(75);
        testWriter.saveProfile(testProfile);
    }


    @Test
    public void loadExistingProfile() throws Exception
    {
        UserProfile loadedProfile = testReader.loadExistingProfile(testProfile.getName() + " - " + testProfile.getGender());
        assertEquals("jeff", loadedProfile.getName());
        assertEquals(75, loadedProfile.getWeight(), 1);
    }

    @Test
    public void openNewFile() throws FileNotFoundException
    {
        assertTrue(testReader.checkFileExists("./FilesToLoad/testdata.csv"));
        ArrayList<String> dataLines = testReader.openNewFile("./FilesToLoad/testdata.csv");
        assertEquals(1147, dataLines.size(), 1);
    }

    @Test
    public void getExistingUsers() throws UserNameException
    {
        UserProfile secondTestProfile = new UserProfile();
        secondTestProfile.setName("bill");
        secondTestProfile.setGender("Male");
        testWriter.saveProfile(secondTestProfile);
        ArrayList<String> testFileNames = new ArrayList<>();
        ArrayList<String> testFileGenders = new ArrayList<>();
        testReader.getExistingUsers(testFileNames, testFileGenders);
        ArrayList<String> expectedNames = new ArrayList<String>(Arrays.asList("bill", "jeff"));
        testWriter.deleteProfile("bill - Male");
        assertTrue(testFileNames.containsAll(expectedNames));
    }


    @Test
    public void checkFileExists()
    {
        assertTrue(testReader.checkFileExists("./profiles/" + testProfile.getName() + " - " + testProfile.getGender() + ".ser"));
    }


    @AfterClass
    public static void tearDown()
    {
        testWriter.deleteProfile("jeff - Male");
    }
}