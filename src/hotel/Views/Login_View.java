/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Views;

import hotel.Models.Model;
import hotel.Lib.InputTextPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Orics
 */
public class Login_View extends View{
    private JLabel logo;
    private InputTextPanel userInput;
    private InputTextPanel passInput;
    private JButton loginButton;

    public InputTextPanel getUserInput() {
        return userInput;
    }

    public InputTextPanel getPassInput() {
        return passInput;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
    
    
    public Login_View() {
        this.setSize(400, 500);
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setLayout(null);
        
        this.logo = new JLabel(new ImageIcon(getClass().getResource("/hotel/Assets/Icons/loginlogo.png")));
        this.logo.setSize(150,100);
        this.logo.setLocation((this.getWidth() - logo.getWidth())/2 , 100);
        
        this.userInput = new InputTextPanel(
                getClass().getResource("/hotel/Assets/Icons/user_20px.png"), 
                30, 
                200, 
                30, 
                false);
        this.userInput.setLocation((this.getWidth() - userInput.getWidth())/2 - 30/2, 250);
        
        this.passInput = new InputTextPanel(
                getClass().getResource("/hotel/Assets/Icons/password_20px.png"),
                30, 
                200, 
                30, 
                true);
        this.passInput.setLocation((this.getWidth() - passInput.getWidth())/2 - 30/2, 300);
        
        this.loginButton = new JButton("Login");
        this.loginButton.setSize(140, 35);
        this.loginButton.setLocation((this.getWidth() - loginButton.getWidth())/2, 370);
        this.loginButton.setBackground(Color.blue);
        this.loginButton.setForeground(Color.WHITE);
        this.loginButton.setFocusPainted(false);
        
        this.add(logo);
        this.add(userInput);
        this.add(passInput);
        this.add(loginButton);
        
    }
    
    @Override
    public void load(Model model) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
