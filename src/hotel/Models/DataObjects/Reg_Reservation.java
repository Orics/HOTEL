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
public class Reg_Reservation {
    private String RegResID;
    private Date ApplyTime;
    private String HoldingDayRate;
    private String HoldingDay;

    public void setRegResID(String RegResID) {
        this.RegResID = RegResID;
    }

    public void setApplyTime(Date ApplyTime) {
        this.ApplyTime = ApplyTime;
    }

    public void setHoldingDayRate(String HoldingDayRate) {
        this.HoldingDayRate = HoldingDayRate;
    }

    public void setHoldingDay(String HoldingDay) {
        this.HoldingDay = HoldingDay;
    }

    public String getRegResID() {
        return RegResID;
    }

    public Date getApplyTime() {
        return ApplyTime;
    }

    public String getHoldingDayRate() {
        return HoldingDayRate;
    }

    public String getHoldingDay() {
        return HoldingDay;
    }
        public static Reg_Reservation getReg_Reservation(String RegResID){
        Reg_Reservation rr = null;        
        try {
            Connection conn = SQLConnection.getConnection();  
            String sql = "select * from Reg_Reservation where RegResID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RegResID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                rr = new Reg_Reservation();
                rr.setRegResID(rs.getString("RegResID"));
                rr.setApplyTime(rs.getDate("ApplyTime"));
                rr.setHoldingDayRate(rs.getString("HoldingDayRate"));
                rr.setHoldingDay(rs.getString("HoldingDay"));
                  
                return rr;
            }  
        } catch (SQLException ex) {
             System.err.println("class:Reg_Reservation  func:getReg_Reservation | error 'rs.next()'");
        }finally{
            try { 
                SQLConnection.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(Reg_Reservation.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                return rr;
            }   
        }  
    }
    
    public String insert(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "{call pro_InsertReg_Reservation(?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setDate(1, this.ApplyTime);
            cstmt.setString(2, this.HoldingDayRate);
            cstmt.setString(3, this.HoldingDay);
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                return rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean update(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "update Reg_Reservation set ApplyTime=?, HoldingDayRate=?, HoldingDay=? Where RegResID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, this.ApplyTime);
            pstmt.setString(2, this.HoldingDayRate);
            pstmt.setString(3, this.HoldingDay);
            pstmt.setString(4, this.RegResID);
            
            
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "delete from Reg_Reservation where RegResID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RegResID);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Reg_Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }   
}
