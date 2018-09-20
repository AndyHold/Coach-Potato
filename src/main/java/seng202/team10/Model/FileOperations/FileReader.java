package seng202.team10.Model.FileOperations;

import seng202.team10.Model.UserProfile;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {

    private UserProfile localProfile;


    /** Method to load an already established profile from file.
     * @param profileName UserProfile: should match what would be returned from UserProfile.getName()
     * @return UserProfile
     * */
    public UserProfile loadExistingProfile(String profileName){
        String filename = "./profiles/" + profileName + ".ser";
        if(checkFileExists(filename)) {
            try {
                FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                localProfile = (UserProfile) in.readObject();
                in.close();
                fileIn.close();
                return localProfile;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
        return localProfile;
    }

    /** opens a csv file and returns its contents as an arraylist of strings of each line
     * @param filename : the string of the filename being opened, eg. blablabla.csv (path is appended in function)
     * @return fileContents : ArrayList of strings, each is a line of the file*/
    public ArrayList openNewFile(String filename) throws FileNotFoundException{
//        filename = "./FilesToLoad/" + filename;
        Scanner localScanner = new Scanner(new File(filename));
        ArrayList<String> fileContents = new ArrayList<>();
        while (localScanner.hasNextLine()){
            fileContents.add(localScanner.nextLine());
        }
        localScanner.close();
        //List<String> lines = FileUtils.readLines(new File("/path/to/file.txt"), "utf-8"); //alternate option
        return fileContents;
    }

    /** checks whether the specified file exists. returns true if file is found, false if not
     * @param filename : the string of the filename/path being checked*/
    public boolean checkFileExists(String filename){
        File tmpDir = new File(filename);
        return tmpDir.exists();
    }

    /**
     * checks which users are saved in the profiles folder, returning their names
     * @return foundUsers: arraylist of filenames of existing profiles (no extensions)
     * TODO find out how to check if directory exists and call create directory if not.
     */
    public ArrayList getExistingUsers() {
        ArrayList<String> foundUsers = new ArrayList<>();
        File folder = new File("./profiles");
        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                if (getFileExtension(listOfFile).equals(".ser")) {
                    foundUsers.add(listOfFile.getName().substring(0, listOfFile.getName().length() - 4));
                }
            }
        }
        return foundUsers;
    }


    /**
     * helper method for getExistingUsers that checks and returns the extension of a file object
     * @param file the file being checked
     * @return string of the . + the extension
     */
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        //System.out.println(name.substring(lastIndexOf));
        return name.substring(lastIndexOf);
    }



    /** sets the local profile for the filereader to use. likely useless */
    public void setLocalProfile(UserProfile activeProfile) {
        localProfile = activeProfile;
    }

    /** returns the  profile the filereader last loaded */
    public UserProfile getLocalProfile(){
        return localProfile;
    }


}
