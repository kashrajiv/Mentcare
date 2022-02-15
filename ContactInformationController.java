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

public class ContactInformationController {

    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField age;
    @FXML
    private TextField dob;
    @FXML
    private TextField sex;
    @FXML
    private TextField address;
    @FXML
    private TextField homenumber;
    @FXML
    private TextField cellphone;
    @FXML
    private TextField bloodgroup;
    @FXML
    private TextField maritalstatus;
    @FXML
    private TextField emailid;
    @FXML
    private TextField ssn;
    @FXML
    private TextField primarycareprovider;
    @FXML
    private TextField referingphysician;
    @FXML
    private TextField preferedpharmacy;
    @FXML
    private TextField emergencycontact;
    @FXML
    private TextField relationship;
    @FXML
    private TextField phone;
    @FXML
    private TextField insurance;
    @FXML
    private TextField employer;
    @FXML
    private TextField occupation;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void LoadData_OnClick(ActionEvent event) throws IOException, SQLException {
        String patientid = "4";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO patientlogin VALUES('b', 'b', '1')";
        //String sql = "select firstName, lastName from patientlogin where patientID = '" + patientid + "'";
        String sql = "SELECT `firstName`, `lastName`, `patientID`, `userName`, `password`, `age`, `dob`, `sex`, `address`, `homeNumber`, `cellPhone`, `bloodGroup`, `maritalStatus`, `ssn`, `primaryCareProvider`, `refferingPhysician`, `prefferedPharmacy`, `emergencyContact`, `relationship`, `phone`, `insurance`, `employer`, `occupation`, `email` FROM `patientlogin` WHERE patientID = '"+ patientid + "'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);
        ResultSet queryResult = statement.executeQuery(sql);

        try
        {
            while (queryResult.next()) {
                fname.setText(queryResult.getString(1));
                lname.setText(queryResult.getString(2));
                age.setText(queryResult.getString(6));
                dob.setText(queryResult.getString(7));
                sex.setText(queryResult.getString(8));
                address.setText(queryResult.getString(9));
                homenumber.setText(queryResult.getString(10));
                cellphone.setText(queryResult.getString(11));
                bloodgroup.setText(queryResult.getString(12));
                maritalstatus.setText(queryResult.getString(13));
                emailid.setText(queryResult.getString(24));
                ssn.setText(queryResult.getString(14));
                primarycareprovider.setText(queryResult.getString(15));
                referingphysician.setText(queryResult.getString(16));
                preferedpharmacy.setText(queryResult.getString(17));
                emergencycontact.setText(queryResult.getString(18));
                relationship.setText(queryResult.getString(19));
                phone.setText(queryResult.getString(20));
                insurance.setText(queryResult.getString(21));
                employer.setText(queryResult.getString(22));
                occupation.setText(queryResult.getString(23));


            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void Back_OnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("patientPortal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*public void Edit_OnClick(ActionEvent event) throws IOException, SQLException {
        String heightField = Height.getText();
        String weightField = Weight.getText();
        String bodyTemperatureField = Temperature.getText();
        String bloodPressureField = Bloodpressure.getText();
        String prescriptionField = Prescription.getText();
        String patientIDField = pid.getText();
        String notesField = Notes.getText();
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO patientlogin VALUES('" + fname.getText() + "', '" + lname.getText() + "', '" + fname.getText() + "', '" + fname.getText() + "', '" + fname.getText() + "', '" + fname.getText() + "', '" + fname.getText() + "', '" + fname.getText() + "', '\" + fname.getText() + \"', '\" + fname.getText() + \"', '\" + fname.getText() + \"', '\" + fname.getText() + \"', '\" + fname.getText() + \"', '\" + fname.getText() + \"')";
        //String sql = "select count(1) from patientlogin where firstName = '" + userField + "' AND lastName = '" + passwordField + "'";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //ResultSet queryResult = statement.executeQuery(sql);

    }*/
}
