/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controllers;

import hotel.Models.DataObjects.Employee;
import hotel.Models.SQLConnection;
import hotel.Models.Login_Model;
import hotel.Views.Login_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Orics
 */
public class Login_Controller extends Controller{

    public Login_Controller() {
        this.model = new Login_Model();
        this.view = new Login_View();
        initEvents();
    }
    
    @Override
    protected void initEvents() {
        Login_View loginView = (Login_View) this.view;
        Login_Model loginModel = (Login_Model) this.model;
        
        loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            
            //login action
            public void actionPerformed(ActionEvent e) {
                String user = loginView.getUserInput().getText();
                String pass = loginView.getPassInput().getText();
                
                Employee emp = Employee.getEmployee(user);
                
                if(loginModel.checkLoginInfor(user, pass)){
                    System.out.println("login OK");
                    JFrame f = new JFrame();
                    f.setSize(1366, 768);
                    f.getContentPane().setLayout(null);
                    f.setLocationRelativeTo(null);
                    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    f.setVisible(true);
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    f.getContentPane().add(new Hotel_Controller(emp).getView());
                    
                    //close login windown
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(loginView);
                    topFrame.setVisible(false);
                    
                }else{
                    System.out.println("login Fail");
                }
            }
        });
        
    }
    
}
