package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyApp {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://db:5432/mydatabase";
        String user = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT version()")) {

            if (rs.next()) {
                System.out.println("Connected to PostgreSQL, version: " + rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

