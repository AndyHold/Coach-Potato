package seng202.team10.Model.FileOperations;

import org.junit.*;
import seng202.team10.Model.Exceptions.InvalidWeightException;
import seng202.team10.Model.Exceptions.UserNameException;
import seng202.team10.Model.Goals.UserProfile;

import static org.junit.Assert.*;

public class FileWriterTest {

    private static FileReader testReader = new FileReader();
    private static FileWriter testWriter = new FileWriter();
    private static UserProfile testProfile = new UserProfile();


    @BeforeClass
    public static void setUp() throws UserNameException, InvalidWeightException
    {
        testWriter.createProfileFolder();
        testProfile.setName("jeff");
        testProfile.setWeight(75);
        testWriter.saveProfile(testProfile);
    }

    @Test
    public void saveProfile() {
        testWriter.saveProfile(testProfile);
        assertTrue(testReader.checkFileExists("./profiles/" + testProfile.getName() + ".ser"));
    }

    @Test
    public void createProfileFolder() {
        testWriter.createProfileFolder();
        assertTrue(testReader.checkFileExists("./profiles"));

    }

    @Test
    public void deleteProfile() throws UserNameException
    {
        UserProfile secondTestProfile = new UserProfile();
        secondTestProfile.setName("bill");
        testWriter.saveProfile(secondTestProfile);
        int initialSize = testReader.getExistingUsers().size();
        testWriter.deleteProfile(secondTestProfile.getName());
        assertEquals(initialSize -1, testReader.getExistingUsers().size(), 0);
    }


    @Test
    public void updateExistingProfile() throws InvalidWeightException
    {
        testWriter.saveProfile(testProfile);
        testProfile.setWeight(100);
        testWriter.saveProfile(testProfile);
        assertEquals(100, testReader.loadExistingProfile(testProfile.getName()).getWeight(), 1);
    }

    @AfterClass
    public static void tearDown(){
        testWriter.deleteProfile("jeff");
    }
}