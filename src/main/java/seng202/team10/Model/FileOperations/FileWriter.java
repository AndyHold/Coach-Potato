package seng202.team10.Model.FileOperations;

import seng202.team10.Model.UserProfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * File Writer Class for Coach Potato
 */
public class FileWriter
{

    private UserProfile activeProfile;


    /**
     *saves the inputted user profile as a serialized file
     *@param profile  the UserProfile being saved.
     */
    public void saveProfile(UserProfile profile)
    {
        createProfileFolder();
        activeProfile = profile;
        String filename = "./profiles/" + activeProfile.getName() + " - " + activeProfile.getGender() + ".ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(activeProfile);
            out.close();
            fileOut.close();
        } catch (IOException exception) {  }


    }

    /** creates the folder for profiles if there isn't one (does nothing if there is already one
     * run at the start of the program*/
    public void createProfileFolder(){
        new File("./profiles").mkdirs();
    }


    /** deletes a specified profile by name
     * @param profileName the name (string) of the profile to be deleted
     * @return true if deletion succeeds, false if deletion fails*/
    public boolean deleteProfile(String profileName){
        File profileToDelete = new File("./profiles/" + profileName + ".ser");
        boolean success = profileToDelete.delete();
        return success;
    }

}

