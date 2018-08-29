package seng202.team10.Model.FileOperations;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import seng202.team10.Model.UserProfile;

import static org.junit.Assert.*;

public class FileWriterTest {

    private static FileReader testReader = new FileReader();
    private static FileWriter testWriter = new FileWriter();
    private static UserProfile testProfile = new UserProfile();


    @BeforeClass
    public static void setUp() throws Exception {
        testWriter.createProfileFolder();
        testProfile.setName("jeff");
        testProfile.setWeight(75);
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
    public void updateExistingProfile() {
        testWriter.saveProfile(testProfile);
        testProfile.setWeight(100);
        testWriter.saveProfile(testProfile);
        assertEquals(100, testReader.loadExistingProfile(testProfile.getName()).getWeight(), 1);
    }
}