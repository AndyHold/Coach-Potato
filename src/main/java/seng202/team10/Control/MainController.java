package seng202.team10.Control;

public class MainController {

//    private ArrayList<UserProfile> users;
//    private UserProfile currentUser;
//    private Parser parser;
//    private GUIController guiController;
//    private FileWriter dataWriter = new FileWriter();
//    private FileReader dataReader = new FileReader();
//
//    public MainController() {
//
//    }
//
//    public void runGUIController() {
//        guiController = new GUIController();
//        guiController.setMainController(this);
////        guiController.start();
//
//    }
//
//    private void runApplication() {
//        runGUIController();
////        if(!dataReader.checkFileExists("./profiles")){
////            dataWriter.createProfileFolder();
////        }
////        users = dataReader.getExistingUsers();
////
////
////        // not sure, but should save active profile upon closing?
////        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
////            public void run() {
////                dataWriter.saveProfile(currentUser);
////            }
////        }, "Shutdown-thread"));
//    }
//
//    public void saveData() {
//        dataWriter.saveProfile(currentUser);
//    }
//
//    public void loadData() {
//        dataReader.loadExistingProfile(currentUser.getName());
//    }
//
//    public static void main(String[] args){
//        MainController app = new MainController();
//        app.runApplication();
//
//
//
//    }
//
//    public void setCurrentUser(UserProfile currentUser) {
//        this.currentUser = currentUser;
//    }
//
//    public UserProfile getCurrentUser() {
//        return currentUser;
//    }
}
