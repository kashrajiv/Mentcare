package com.example.mentcare4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterPageController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField patientID;

    public void Register_OnClick(ActionEvent event) throws IOException, SQLException {
        String userField = userName.getText();
        String passwordField = password.getText();
        String firstNameField = firstName.getText();
        String lastNameField = lastName.getText();
        String patientIDField = patientID.getText();
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();
        String sql = "INSERT INTO patientlogin (`firstName`, `lastName`, `patientID`, `userName`, `password`) VALUES('"+ firstNameField + "', '" + lastNameField + "', '"+ patientIDField + "', '" + userField + "', '" + passwordField +"')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        root = FXMLLoader.load(getClass().getResource("PatientLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
