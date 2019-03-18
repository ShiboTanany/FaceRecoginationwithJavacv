/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author shibo
 */
public class DBConnection {

    private Connection con = null;

    public boolean init() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            try {
                String Database_name = "faceRecogination";
                String Database_user = "root";
                String Database_pass = "root123";
                this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Database_name, Database_user,
                        Database_pass);
            } catch (SQLException e) {

                System.out.println("Error: Database Connection Failed ! Please check the connection Setting");

                return false;

            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

            return false;
        }

        return true;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
}
