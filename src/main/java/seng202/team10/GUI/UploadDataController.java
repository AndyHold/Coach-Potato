package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import seng202.team10.Control.GUIController;

import java.awt.*;

public class UploadDataController {

    private GUIController app;


    @FXML
    private TextField filePathTextField;


    @FXML
    private Button browseButton;


    @FXML
    private Button uploadButton;


    @FXML
    private TableView manualDataTableView;


    @FXML
    private TableColumn dateColumn;


    @FXML
    private TableColumn timeColumn;


    @FXML
    private TableColumn heartRateColumn;


    @FXML
    private TableColumn latitudeColumn;


    @FXML
    private TableColumn longitudeColumn;


    @FXML
    private TableColumn elevationColumn;


    @FXML
    private Button submitDataButton;


    @FXML
    private TextField activityNameTextField;


    @FXML
    private ComboBox intensityComboBox;


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene()
    {

        //Set the values in the intensity ComboBox
        ObservableList<String> intensities = FXCollections.observableArrayList();
        intensities.add("Low");
        intensities.add("Medium");
        intensities.add("High");
        intensityComboBox.setItems(intensities);
        intensityComboBox.setVisibleRowCount(3);

    }


    @FXML
    public void uploadData()
    {
        //
    }


    @FXML
    public void submitData()
    {
        //
    }


    @FXML
    public void browse()
    {
        //
    }
}
