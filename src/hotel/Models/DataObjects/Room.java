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
public class Room {
    private String RoomID;
    private String RoomMumber;
    private String RoomTypeID;
    private String Status;

    public String getRoomID() {
        return RoomID;
    }

    public String getRoomMumber() {
        return RoomMumber;
    }

    public String getRoomTypeID() {
        return RoomTypeID;
    }

    public String getStatus() {
        return Status;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public void setRoomMumber(String RoomMumber) {
        this.RoomMumber = RoomMumber;
    }

    public void setRoomTypeID(String RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public static Room getRoom(String RoomID){
        Room r = null;        
        try {
            Connection conn = SQLConnection.getConnection();  
            String sql = "select * from Room where RoomID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RoomID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                r = new Room();
                r.setRoomID(rs.getString("RoomID"));
                r.setRoomMumber(rs.getString("RoomMumber"));
                r.setRoomTypeID(rs.getString("RoomTypeID"));
                r.setStatus(rs.getString("Status"));    
                return r;
            }  
        } catch (SQLException ex) {
             System.err.println("class:Room  func:getRoom | error 'rs.next()'");
        }finally{
            try { 
                SQLConnection.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                return r;
            }   
        }  
    }
    
    public String insert(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "{call pro_InsertRoom(?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setString(1, this.RoomMumber);
            cstmt.setString(2, this.RoomTypeID);
            cstmt.setString(3, this.Status);

            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                return rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean update(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "update Room set RoomID=?, RoomMumber=?, RoomTypeID=?, Status=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.RoomID);
            pstmt.setString(2, this.RoomMumber);
            pstmt.setString(3, this.RoomTypeID);
            pstmt.setString(4, this.Status);

            
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "delete from Employee where RoomID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RoomID);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }   
}


