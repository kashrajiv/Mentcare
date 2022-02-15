package com.example.mentcare4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffLoginController {
    public String StaffIDGlobal;
    public String staffuserNameGlobal;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField userName1;
    @FXML
    private TextField password1;
    @FXML
    private Label messageText;

    public void StaffLogin_OnClick(ActionEvent event) throws IOException, SQLException {
        String userField = userName1.getText();
        String passwordField = password1.getText();
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO patientlogin VALUES('b', 'b', '1')";
        String sql = "select count(1), staffID, userName from stafflogin where userName = '" + userField + "' AND password = '" + passwordField + "'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);
        ResultSet queryResult = statement.executeQuery(sql);

        try
        {
            while (queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    StaffIDGlobal = String.valueOf(queryResult.getInt(2));
                    staffuserNameGlobal = String.valueOf(queryResult.getString(3));
                    root = FXMLLoader.load(getClass().getResource("DoctorDashboard.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    messageText.setText("Wrong Credentials");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
