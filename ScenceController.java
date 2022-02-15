package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ScenceController {
    @FXML
    private Label welcomeText;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /*public  void switchScene1(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("patientPortal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    public  void switchScene2(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("patientInfo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onDoctorInfoButtonClick()
    {
        welcomeText.setText("Doctor Information here");
    }
}
