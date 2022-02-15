package com.example.mentcare4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientPortalController {

    @FXML
    private TextArea messageArea;
    @FXML
    private TextArea prescriptionArea;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void LoadMessages_OnClick(ActionEvent event) throws IOException, SQLException {
        String patiendid = "4";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO patientlogin VALUES('b', 'b', '1')";
        String sql = "select message from messages where patientID = '" + patiendid + "'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);
        ResultSet queryResult = statement.executeQuery(sql);
        String output = "";
        try
        {
            while (queryResult.next()) {
                output = output + String.valueOf(queryResult.getString(1)) + "\n";
            }
        } catch (Exception e) {
            messageArea.setText("No Messages!");
            e.printStackTrace();
            e.getCause();
        }
        messageArea.setText(output);
    }

    public void LoadPrescription_OnClick(ActionEvent event) throws IOException, SQLException {
        String patiendid = "4";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO patientlogin VALUES('b', 'b', '1')";
        String sql = "select prescription from vitals where patientID = '" + patiendid + "'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);
        ResultSet queryResult = statement.executeQuery(sql);
        String output = "";
        try
        {
            while (queryResult.next()) {
                output = output + String.valueOf(queryResult.getString(1)) + "\n";
            }
        } catch (Exception e) {
            prescriptionArea.setText("No Prescription!");
            e.printStackTrace();
            e.getCause();
        }
        prescriptionArea.setText(output);
    }

    public void ContactInformation_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ContactInformation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void patientPortal_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MessageToDoctor.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Logout_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PatientLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
