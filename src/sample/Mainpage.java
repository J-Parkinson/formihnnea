package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Mainpage  implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void navigateToSettings(ActionEvent event) throws IOException {
        Parent settingsParent = FXMLLoader.load(getClass().getResource("mainpage.fxml"));

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(new Scene(settingsParent));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
