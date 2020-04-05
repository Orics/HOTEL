/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orics
 */
public class Login_Model extends Model{
    
    public boolean checkLoginInfor(String username, String password){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "select * from Employee where EmpID = ? and Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                return true;
            } 
        } catch (SQLException ex) {
            System.err.println("class:Login_Model  func: checkLoginInfor | Failed query");
        }
        return false;
    }
}
