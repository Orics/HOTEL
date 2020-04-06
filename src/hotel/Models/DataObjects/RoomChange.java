/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Models.DataObjects;

import hotel.Models.SQLConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class RoomChange {
    private String RoomChangeID;
    private String OldResDetailID;
    private String NewResDetailID;
    private String Reason;

    public String getRoomChangeID() {
        return RoomChangeID;
    }

    public String getOldResDetailID() {
        return OldResDetailID;
    }

    public String getNewResDetailID() {
        return NewResDetailID;
    }

    public String getReason() {
        return Reason;
    }

    public void setRoomChangeID(String RoomChangeID) {
        this.RoomChangeID = RoomChangeID;
    }

    public void setOldResDetailID(String OldResDetailID) {
        this.OldResDetailID = OldResDetailID;
    }

    public void setNewResDetailID(String NewResDetail) {
        this.NewResDetailID = NewResDetailID;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }
    
    public static RoomChange getRoomChange(String RoomChangeID){
        RoomChange rc = null;        
        try {
            Connection conn = SQLConnection.getConnection();  
            String sql = "select * from RoomChange where RoomChangeID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RoomChangeID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                rc = new RoomChange();
                rc.setRoomChangeID(rs.getString("RoomChangeID"));
                rc.setOldResDetailID(rs.getString("OldResDetailID"));
                rc.setNewResDetailID(rs.getString("NewResDetailID"));
                rc.setReason(rs.getString("Reason"));
                return rc;
            }  
        } catch (SQLException ex) {
             System.err.println("class:RoomChange  func:getRoomChange | error 'rs.next()'");
        }finally{
            try { 
                SQLConnection.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomChange.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                return rc;
            }   
        }  
    }
    
    public String insert(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "{call pro_InsertRoomChange(?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setString(1, this.OldResDetailID);
            cstmt.setString(2, this.NewResDetailID);
            cstmt.setString(3, this.Reason);
            
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                return rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomChange.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean update(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "update RoomChange set RoomChangeID=?, OldResDetailID=?, NewResDetailID=?, Reason=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.RoomChangeID);
            pstmt.setString(2, this.OldResDetailID);
            pstmt.setString(3, this.Reason);
            pstmt.setString(4, this.NewResDetailID);

            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomChange.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "delete from RoomChange where RoomChangeID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RoomChangeID);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomChange.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }   
}

