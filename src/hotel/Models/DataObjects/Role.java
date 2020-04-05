/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Models.DataObjects;

import hotel.Models.SQLConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Role {
    private String RoleID;
    private String RoleName;

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public String getRoleID() {
        return RoleID;
    }

    public String getRoleName() {
        return RoleName;
    }
        public static Role getRole(String RoleID){
        Role r = null;        
        try {
            Connection conn = SQLConnection.getConnection();  
            String sql = "select * from Role where RoleID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RoleID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                r = new Role();
                r.setRoleID(rs.getString("RoleID"));
                r.setRoleName(rs.getString("RoleName"));
    
                return r;
            }  
        } catch (SQLException ex) {
             System.err.println("class:Role  func:getRole | error 'rs.next()'");
        }finally{
            try { 
                SQLConnection.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                return r;
            }   
        }  
    }
    
    public String insert(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "{call pro_InsertRole(?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setString(1, this.RoleName);
            
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                return rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean update(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "update Role set RoleID=?, RoleName=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.RoleID);
            pstmt.setString(2, this.RoleName);

          
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "delete from Role where RoleID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RoleID);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }  
}
