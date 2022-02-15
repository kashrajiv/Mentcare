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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientVitalsViewController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label height;
    @FXML
    private Label weight;
    @FXML
    private Label temperature;
    @FXML
    private Label bloodpressure;
    @FXML
    private Label notes;
    @FXML
    private Label prescription;

    public void Load_OnClick(ActionEvent event) throws IOException, SQLException {
        String patiendid = "4";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO patientlogin VALUES('b', 'b', '1')";
        String sql = "select height, weight, bodytemperature, bloodpressure, notes, prescription from vitals where patientID = '" + patiendid + "'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);
        ResultSet queryResult = statement.executeQuery(sql);
        //String output = "";
        try
        {
            while (queryResult.next()) {
                //output = output + String.valueOf(queryResult.getString(1)) + "\n";
                height.setText(queryResult.getString(1));
                weight.setText(queryResult.getString(2));
                temperature.setText(queryResult.getString(3));
                bloodpressure.setText(queryResult.getString(4));
                notes.setText(queryResult.getString(5));
                prescription.setText(queryResult.getString(6));
            }
        } catch (Exception e) {
            //prescriptionArea.setText("No Prescription!");
            e.printStackTrace();
            e.getCause();
        }
        //prescriptionArea.setText(output);
    }

    public void Back_OnClick(ActionEvent event) throws IOException, SQLException {

        root = FXMLLoader.load(getClass().getResource("DoctorDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
