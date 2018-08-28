package seng202.team10.Model.FileOperations;

import seng202.team10.Model.UserProfile;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {

    private UserProfile localProfile;

    /** loads an already established profile from file.
     * @profileName should match what would be returned from UserProfile.getName()
     * */
    public UserProfile loadExistingProfile(String profileName){
        String filename = "/profiles/" + profileName + ".ser";
        if(checkFileExists(filename)) {
            try {
                FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                localProfile = (UserProfile) in.readObject();
                in.close();
                fileIn.close();
                return localProfile;
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }
        }
        return localProfile;
    }

//    /** opens a csv file and returns its contents as an arraylist of strings of each line*/
//    public ArrayList openNewFile(String filename) {
//
//        Scanner localScanner = new Scanner(new File(filename));
//        ArrayList<String> fileContents = new ArrayList<String>();
//        while (localScanner.hasNextLine()){
//            fileContents.add(localScanner.nextLine());
//        }
//        localScanner.close();
//
//        //List<String> lines = FileUtils.readLines(new File("/path/to/file.txt"), "utf-8"); //alternate option
//
//        return fileContents;
//    }

    /** checks whether the specified file exists. returns true if file is found, false if not*/
    public boolean checkFileExists(String filename){
        File tmpDir = new File(filename);
        boolean exists = tmpDir.exists();
        return exists;
    }

    /** sets the local profile for the filereader to use */
    public void setLocalProfile(UserProfile activeProfile) {
        localProfile = activeProfile;
    }

    /** returns the current profile the filereader is using */
    public UserProfile getLocalProfile(){
        return localProfile;
    }
}
