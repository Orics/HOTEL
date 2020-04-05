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
 * @author Orics
 */
public class Employee {
    private String EmpID;
    private String RoleID;
    private String Password;
    private String EmpName;
    private Date BirthDay;
    private String Gender;
    private String Phone;
    private String Email;

    public String getEmpID() {
        return EmpID;
    }

    public String getRoleID() {
        return RoleID;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmpName() {
        return EmpName;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmpID(String EmpID) {
        this.EmpID = EmpID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public void setBirthDay(Date BirthDay) {
        this.BirthDay = BirthDay;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public static Employee getEmployee(String EmpID){
        Employee e = null;        
        try {
            Connection conn = SQLConnection.getConnection();  
            String sql = "select * from Employee where EmpID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, EmpID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                e = new Employee();
                e.setEmpID(rs.getString("EmpID"));
                e.setRoleID(rs.getString("RoleID"));
                e.setPassword(rs.getString("Password"));
                e.setEmpName(rs.getString("EmpName"));
                e.setBirthDay(rs.getDate("BirthDay"));
                e.setGender(rs.getString("Gender"));
                e.setPhone(rs.getString("Phone"));
                e.setEmail(rs.getString("Email"));     
                return e;
            }  
        } catch (SQLException ex) {
             System.err.println("class:Employee  func:getEmployee | error 'rs.next()'");
        }finally{
            try { 
                SQLConnection.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                return e;
            }   
        }  
    }
    
    public String insert(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "{call pro_InsertEmployee(?,?,?,?,?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setString(1, this.RoleID);
            cstmt.setString(2, this.Password);
            cstmt.setString(3, this.EmpName);
            cstmt.setDate(4, this.BirthDay);
            cstmt.setString(5, this.Gender);
            cstmt.setString(6, this.Phone);
            cstmt.setString(7, this.Email);
            
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                return rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean update(){
        try {
            Connection conn = SQLConnection.getConnection();
            String sql = "update Employee set RoleID=?, Password=?, EmpName=?, BirthDay=?, Gender=?, Phone=?, Phone=? where EmpID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.RoleID);
            pstmt.setString(2, this.Password);
            pstmt.setString(3, this.EmpName);
            pstmt.setDate(4, this.BirthDay);
            pstmt.setString(5, this.Gender);
            pstmt.setString(6, this.Phone);
            pstmt.setString(7, this.Email);
            pstmt.setString(8, this.EmpID);
            
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
            String sql = "delete from Employee where EmpID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, EmpID);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }   
}
