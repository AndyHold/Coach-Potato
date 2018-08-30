package seng202.team10.Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import seng202.team10.GUI.CreateProfileControl;
import seng202.team10.GUI.LoginControl;

public class GUIController extends Application {

    private FXMLLoader loginLoader;
    private Scene loginScene;
    private FXMLLoader createProfileLoader;
    private Scene createProfileScene;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadAllScenes();
        primaryStage.setTitle("Coach Potato");
        primaryStage.setScene(loginScene);
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

    public void launchLoginScene() throws Exception {
        primaryStage.setScene(loginScene);
    }

//    public void launchProfileScene() {
//
//    }

    public void launchCreateProfileScene() throws Exception {
        createProfileLoader.getController();
        primaryStage.setScene(createProfileScene);
    }

    public void loadAllScenes() throws Exception{
        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
        Parent root = loginLoader.load();
        LoginControl loginControl = loginLoader.getController();
        loginControl.setApp(this);
        loginScene = new Scene(root, 800, 400);

        createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        GridPane gridPane = createProfileLoader.load();
        CreateProfileControl createProfileControl = createProfileLoader.getController();
        createProfileControl.setApp(this);
        createProfileControl.setUpScene();
        createProfileScene = new Scene(gridPane, 800, 400);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
