package com.example.mentcare4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.sql.*;

public class PatientLoginController {

    public String userNameGlobal;
    public String patientIDGlobal;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Label messageText;


    public void PatientLogin_OnClick(ActionEvent event) throws IOException, SQLException {
        String userField = userName.getText();
        String passwordField = password.getText();
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO patientlogin VALUES('b', 'b', '1')";
        String sql = "select count(1), patientID, userName from patientlogin where userName = '" + userField + "' AND password = '" + passwordField + "'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);
        ResultSet queryResult = statement.executeQuery(sql);

        try
        {
            while (queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    patientIDGlobal = String.valueOf(queryResult.getInt(2));
                    userNameGlobal = String.valueOf(queryResult.getString(3));
                    root = FXMLLoader.load(getClass().getResource("patientPortal.fxml"));
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

    public void RegisterHere_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void StaffLogin_OnClick(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void PatientLogin_OnClick(ActionEvent event) throws IOException, SQLException {
////        DatabaseConnection connectNow = new DatabaseConnection();
////        Connection connectDB = con.getConnection();
//        //String verifiLogin = "SELECT count(1) FROM patientlogin WHERE firstName = 'Andy' AND lastName = 'Moore'";
//        Connect();
//        System.out.println("Workd");
//        try {
//            pst = con.prepareStatement("insert into patientlogin (firstName,lastName,patientID) values (?,?,?)");
//
//            pst.setString(1, "a");
//            pst.setString(2, "a");
//            pst.setString(3, "1");
//            int status = pst.executeUpdate();
//        } catch(SQLException ex){
//
//        }
//
////        try {
////            Statement statement = connectDB.createStatement();
////            ResultSet queryResult = statement.executeQuery(verifiLogin);
////
////            while(queryResult.next()){
////                if(queryResult.getInt(1) == 1){
////                    System.out.println("Workd");
////                    root = FXMLLoader.load(getClass().getResource("patientPortal.fxml"));
////                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////                    scene = new Scene(root);
////                    stage.setScene(scene);
////                    stage.show();
////                } else {
////                    System.out.println("Didntworkd");
////                }
////            }
////        }catch(Exception e){
////            e.printStackTrace();
////            e.getCause();
////        }
//
////        String userField = userName.getText();
////        String passwordField = password.getText();
////        String user1 = "r";
////        String pass = "r";
////        if (userField.equals(user1) & passwordField.equals(pass)) {
////            root = FXMLLoader.load(getClass().getResource("patientPortal.fxml"));
////            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////            scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        }
//    }
}
