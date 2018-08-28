package seng202.team10.Model.FileOperations;

import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

public class FileReader {

    private UserProfile localProfile;

    /* loads an already established profile from file */
    public UserProfile loadExistingProfile{

        //

        return localProfile;
    }



    /* opens a csv file for reading */
    public void openNewFile(String filename) {

    }
    /* returns an arraylist of the lines of the csv file, used after openNewFile */
    public ArrayList getFileContents() {

        return fileContents;
    }



    /* checks whether the specified file exists, used as part of the file opening functions */
    private boolean checkFileExists(String filename){

        return exists;
    }

    /* sets the local profile for the filereader to use */
    public void setLocalProfile(UserProfile activeProfile) {
        localProfile = activeProfile;
    }

    /* returns the current profile the filereader is using */
    public UserProfile getLocalProfile(){
        return localProfile;
    }
}
