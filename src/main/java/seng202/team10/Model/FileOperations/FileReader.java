package seng202.team10.Model.FileOperations;

import seng202.team10.Model.UserProfile;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.apache.commons.lang3.ArrayUtils.contains;

/**
 * Class that contains methods for reading from files and some validation of data. This class is used by
 */
public class FileReader {

    private UserProfile localProfile;


    /** Method to load an already established profile from file.
     * @param profileName UserProfile: should match what would be returned from UserProfile.getName().
     * @throws IOException when there is a failed I/O operation.
     * @throws ClassNotFoundException when the class cannot be found.
     * @return UserProfile
     * */
    public UserProfile loadExistingProfile(String profileName) throws IOException, ClassNotFoundException
    {
        localProfile = null;
        String filename = "./profiles/" + profileName + ".ser";
        if(checkFileExists(filename)) {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            localProfile = (UserProfile) in.readObject();
            in.close();
            fileIn.close();
            return localProfile;
        }
        return localProfile;
    }

    /** opens a csv file and returns its contents as an arraylist of strings of each line
     * @param filename : the string of the filename being opened, eg. blablabla.csv (path is appended in function)
     * @throws FileNotFoundException when there is no file at the file path
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
     * @param filename : the string of the filename/path being checked
     * @return boolean true if file exists, false if it doesn't
     */

    public boolean checkFileExists(String filename){
        File tmpDir = new File(filename);
        return tmpDir.exists();
    }

    /**
     * Method to check which users are saved in the profiles folder, adding their names and genders to ArrayLists that are passed in.
     * @param foundUsers  An empty <b>ArrayList&lt;String&gt;</b> of users.
     * @param usersGenders An empty <b>ArrayList&lt;String&gt;</b> of the genders of users.
     */
    public void getExistingUsers(ArrayList<String> foundUsers, ArrayList<String> usersGenders)
    {
        foundUsers.clear();
        usersGenders.clear();
        File folder = new File("./profiles");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    if (getFileExtension(listOfFile).equals(".ser")) {
                        String[] filename = listOfFile.getName().substring(0, listOfFile.getName().length() - 4).split(" - ");
                        if (filename.length == 2) {
                            if (contains(new String[]{"Male", "Female", "Other"}, filename[1])) {
                                foundUsers.add(filename[0]);
                                usersGenders.add(filename[1]);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * helper method for getExistingUsers that checks and returns the extension of a file object
     * @param file the file being checked
     * @return A <b>String</b> of the . + the extension
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

}
