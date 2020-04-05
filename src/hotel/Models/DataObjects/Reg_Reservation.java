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
    private String RegRes;
    private Date ApplyTime;
    private String HoldingDateRate;
    private String HoldingDay;

    public void setRegRes(String RegRes) {
        this.RegRes = RegRes;
    }

    public void setApplyTime(Date ApplyTime) {
        this.ApplyTime = ApplyTime;
    }

    public void setHoldingDateRate(String HoldingDateRate) {
        this.HoldingDateRate = HoldingDateRate;
    }

    public void setHoldingDay(String HoldingDay) {
        this.HoldingDay = HoldingDay;
    }

    public String getRegRes() {
        return RegRes;
    }

    public Date getApplyTime() {
        return ApplyTime;
    }

    public String getHoldingDateRate() {
        return HoldingDateRate;
    }

    public String getHoldingDay() {
        return HoldingDay;
    }
        public static Reg_Reservation getReg_Reservation(String RegRes){
        Reg_Reservation rr = null;        
        try {
            Connection conn = SQLConnection.getConnection();  
            String sql = "select * from Reg_Reservation where RegRes = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RegRes);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                rr = new Reg_Reservation();
                rr.setRegRes(rs.getString("RegRes"));
                rr.setApplyTime(rs.getDate("ApplyTime"));
                rr.setHoldingDateRate(rs.getString("HoldingDateRate"));
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
            cstmt.setString(2, this.HoldingDateRate);
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
            String sql = "update Reg_Reservation set RegRes=?, ApplyTime=?, HoldingDayRate=?, HoldingDay=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, this.ApplyTime);
            pstmt.setString(2, this.HoldingDateRate);
            pstmt.setString(3, this.HoldingDay);
            pstmt.setString(4, this.RegRes);
            
            
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
            String sql = "delete from Reg_Reservation where RegRes=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, RegRes);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Reg_Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }   
}
