/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orics
 */
public class SQLConnection {
    private static String connectString;
    private static String username;
    private static String password;

    public static Connection getConnection(){
        try {
            connectString = "jdbc:sqlserver://localhost\\DESKTOP-R9OBGBB:1433;databaseName=Hotel";
            username = "sa";
            password = "123123";
            return DriverManager.getConnection(connectString, username, password);
        } catch (SQLException ex) {
            System.err.println("Connect Failed");
            return null;
        }
    } 
}