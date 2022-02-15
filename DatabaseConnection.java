package com.example.mentcare4;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "mentcare";
        String databaseUser = "ra";
        String databasePassword = "ra";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }
        return databaseLink;
    }
}
