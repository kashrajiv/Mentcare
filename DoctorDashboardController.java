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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorDashboardController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea appointmentList;
    @FXML
    private TextArea messages;

    public void EnterPatientVitals_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PatientVitalsInput.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MessageToPatient_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MessageToPatient.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ViewPatientVitals_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PatientVitalsDoctorView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void LoadAppointments_OnClick(ActionEvent event) throws IOException, SQLException {
        String doctorId = "5";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        String sql = "select appDate, patientName from appointments where doctorID = '" + doctorId + "'";
        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery(sql);
        String output = "";
        try
        {
            while (queryResult.next()) {
                output = output + "Date: " + String.valueOf(queryResult.getString(1)) + "  -  Patient: " + String.valueOf(queryResult.getString(2)) + "\n";
            }
        } catch (Exception e) {
            appointmentList.setText("No Appointments!");
            e.printStackTrace();
            e.getCause();
        }
        appointmentList.setText(output);
    }

    public void View_OnClick(ActionEvent event) throws IOException, SQLException {
        String doctorId = "5";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        String sql = "select message, patientName from messages where doctorID = '" + doctorId + "'";
        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery(sql);
        String output = "";
        try
        {
            while (queryResult.next()) {
                output = output + "Patient Name: " + String.valueOf(queryResult.getString(2)) + " - " + String.valueOf(queryResult.getString(1)) + "\n";
            }
        } catch (Exception e) {
            messages.setText("No Messages!");
            e.printStackTrace();
            e.getCause();
        }
        messages.setText(output);
    }

    public void Logout_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PatientLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddAppointment_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddAppointment.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
