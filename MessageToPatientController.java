package com.example.mentcare4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MessageToPatientController {
    @FXML
    private TextArea messageAreaP;
    @FXML
    private TextField patientName;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void Send_OnClick(ActionEvent event) throws IOException, SQLException {
        String message = messageAreaP.getText();
        String patientID = "4";
        String doctorID = "5";
        String patientNameField = patientName.getText();
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO messages VALUES('" + patientID + "', '" + message + "', '" + doctorID + "', '" + patientNameField + "')";
        //String sql = "select count(1) from patientlogin where firstName = '" + userField + "' AND lastName = '" + passwordField + "'";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //ResultSet queryResult = statement.executeQuery(sql);
        root = FXMLLoader.load(getClass().getResource("DoctorDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void Back_OnClick(ActionEvent event) throws IOException, SQLException {

        root = FXMLLoader.load(getClass().getResource("DoctorDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void ViewPatientVitals_OnClick(ActionEvent event) throws IOException, SQLException {

        root = FXMLLoader.load(getClass().getResource("PatientVitalsDoctorView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
