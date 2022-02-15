package com.example.javafx;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
import java.io.IOException;

public class patientInfoController {
    @FXML
    private Parent root;
    @FXML
    private Label Genders;

    @FXML
    private Label Email;

    @FXML
    private Button editInfoB;

    @FXML
    private Label Address;

    @FXML
    private Label CellPhone;

    @FXML
    private Label Physician;

    @FXML
    private Label MaritlS;

    @FXML
    private Label Name;

    @FXML
    private Label Ssn;

    @FXML
    private Label Occupation;

    @FXML
    private Label EmergencyCon;

    @FXML
    private Label Employee;

    @FXML
    private Label RelationE;

    @FXML
    private Label HomePhone;

    @FXML
    private Label DOB;

    @FXML
    private Label Pharmacy;

    @FXML
    private Label PhoneNumE;

    @FXML
    private Label PrimaryCare;

    @FXML
    private Label Insurence;

    @FXML
    private Label Age;

    @FXML
    private Label BloodT;

    @FXML
    private Label messageText;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Label welcomeText;

        @FXML
        public void Patientinfo_OnClick(ActionEvent event) throws IOException, SQLException {

            root = FXMLLoader.load(getClass().getResource("patientInfo.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            try
            {
                String username = "a";
                DatabaseConnection connectionClass = new DatabaseConnection();
                Connection connection = connectionClass.getConnection();
                //String sql = "select age, name, address, dob, genders, homephone, cellphone, bloodt, marital, email, ssn, primecare, " +
                //        "physician, pharmacy, emergency, relation, phonenum, insurence, employee, occupation from PatientDetails where username = '" + username + "'";
                String sql = "select * from PatientDetails";
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(sql);
                /*while(queryResult.next())
                {
                    System.out.println(queryResult.getInt(1));
                    Age.setText(String.valueOf(queryResult.getInt(1)));
                    Name.setText(String.valueOf(queryResult.getInt(2)));
                    Address.setText(String.valueOf(queryResult.getInt(3)));
                    DOB.setText(String.valueOf(queryResult.getInt(4)));
                    Genders.setText(String.valueOf(queryResult.getInt(5)));
                    HomePhone.setText(String.valueOf(queryResult.getInt(7)));
                    CellPhone.setText(String.valueOf(queryResult.getInt(8)));
                    BloodT.setText(String.valueOf(queryResult.getInt(9)));
                    MaritlS.setText(String.valueOf(queryResult.getInt(10)));
                    Email.setText(String.valueOf(queryResult.getInt(11)));
                    Ssn.setText(String.valueOf(queryResult.getInt(12)));
                    PrimaryCare.setText(String.valueOf(queryResult.getInt(13)));
                    Physician.setText(String.valueOf(queryResult.getInt(14)));
                    Pharmacy.setText(String.valueOf(queryResult.getInt(15)));
                    EmergencyCon.setText(String.valueOf(queryResult.getInt(16)));
                    RelationE.setText(String.valueOf(queryResult.getInt(17)));
                    PhoneNumE.setText(String.valueOf(queryResult.getInt(18)));
                    Insurence.setText(String.valueOf(queryResult.getInt(19)));
                    Employee.setText(String.valueOf(queryResult.getInt(20)));
                    Occupation.setText(String.valueOf(queryResult.getInt(21)));

                }*/

                while (queryResult.next()) {
                    //if(queryResult.getInt(1) == 1) {

                        Age.setText(String.valueOf(queryResult.getString(1)));
                        Name.setText(String.valueOf(queryResult.getString(2)));
                        Address.setText(String.valueOf(queryResult.getString(3)));
                        DOB.setText(String.valueOf(queryResult.getString(4)));
                        Genders.setText(String.valueOf(queryResult.getString(5)));
                        HomePhone.setText(String.valueOf(queryResult.getString(7)));
                        CellPhone.setText(String.valueOf(queryResult.getString(8)));
                        BloodT.setText(String.valueOf(queryResult.getString(9)));
                        MaritlS.setText(String.valueOf(queryResult.getString(10)));
                        Email.setText(String.valueOf(queryResult.getString(11)));
                        Ssn.setText(String.valueOf(queryResult.getString(12)));
                        PrimaryCare.setText(String.valueOf(queryResult.getString(13)));
                        Physician.setText(String.valueOf(queryResult.getString(14)));
                        Pharmacy.setText(String.valueOf(queryResult.getString(15)));
                        EmergencyCon.setText(String.valueOf(queryResult.getString(16)));
                        RelationE.setText(String.valueOf(queryResult.getString(17)));
                        PhoneNumE.setText(String.valueOf(queryResult.getString(18)));
                        Insurence.setText(String.valueOf(queryResult.getString(19)));
                        Employee.setText(String.valueOf(queryResult.getString(20)));
                        Occupation.setText(String.valueOf(queryResult.getString(21)));


                    //}
                    //else {
                    //    messageText.setText("Wrong Credentials");
                    //    System.out.println("Wrong user name and password!");
                    //}
                }

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        @FXML
        protected void onDoctorInfoButtonClick()
        {
            welcomeText.setText("Doctor Information here");
        }

    @FXML
    protected void onPatientDashButtonClick(ActionEvent event) throws IOException, SQLException
    {
        root = FXMLLoader.load(getClass().getResource("patientPortal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

