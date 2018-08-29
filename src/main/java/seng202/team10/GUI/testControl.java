package seng202.team10.GUI;

import javafx.fxml.FXML;

import java.awt.*;

public class testControl {

    @FXML
    Button button;

    @FXML
    public void doThing() {
        button.setLabel("A thing happened.");
    }
}
