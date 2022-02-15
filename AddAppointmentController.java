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

public class AddAppointmentController {
    @FXML
    private TextField date;
    @FXML
    private TextField patientName;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void Back_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DoctorDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddAppointment_OnClick(ActionEvent event) throws IOException, SQLException {
        String dateField = date.getText();
        String patientNameField = patientName.getText();
        String doctorID = "5";
        String patientID = "4";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();
        String sql = "INSERT INTO appointments (`appDate`, `doctorID`, `patientID`, `patientName`) VALUES('"+ dateField + "', '" + doctorID + "', '"+ patientID + "', '" + patientNameField + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        root = FXMLLoader.load(getClass().getResource("DoctorDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
