/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Lib;

import java.awt.Color;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Orics
 */
public class InputTextPanel extends JPanel{
    private JLabel label;
    private JTextField textField;
    private JPasswordField passField;
    
    public InputTextPanel(String labelText, int labelWidth, int textFieldWidth, int height, boolean isPassword) {
        this.setSize(labelWidth + textFieldWidth, height);
        this.setOpaque(true);
        this.setLayout(null);
        
        this.label = new JLabel(labelText);
        this.label.setSize(labelWidth, height);
        this.label.setLocation(0, 0);
        
        this.add(label);
        
        if(!isPassword){
            this.textField = new JTextField();
            this.textField.setSize(textFieldWidth, height);
            this.textField.setBorder(BorderFactory.createCompoundBorder( 
                            BorderFactory.createLineBorder(Color.GRAY, 1),
                            BorderFactory.createEmptyBorder(0,10,0,10)
            ));
            this.textField.setLocation(labelWidth, 0);
            this.add(textField);
        }
        else{
            this.passField = new JPasswordField();
            this.passField.setSize(textFieldWidth, height);
            this.passField.setBorder(BorderFactory.createCompoundBorder( 
                            BorderFactory.createLineBorder(Color.GRAY, 1),
                            BorderFactory.createEmptyBorder(0,10,0,10)
            ));
            this.passField.setLocation(labelWidth, 0);
            this.add(passField);
        }
        
    }
    
    public InputTextPanel(URL iconUrl, int labelWidth, int textFieldWidth, int height, boolean isPassword) {
        this.setSize(labelWidth + textFieldWidth, height);
        this.setLayout(null);
        this.setOpaque(false);
        
        this.label = new JLabel(new ImageIcon(iconUrl), SwingUtilities.LEFT);
        this.label.setSize(labelWidth, height);
        this.label.setLocation(0, 0);
        
        this.add(label);
        
        if(!isPassword){
            this.textField = new JTextField();
            this.textField.setSize(textFieldWidth, height);
            this.textField.setBorder(BorderFactory.createCompoundBorder( 
                            BorderFactory.createLineBorder(Color.GRAY, 1),
                            BorderFactory.createEmptyBorder(0,10,0,10)
            ));
            this.textField.setLocation(labelWidth, 0);
            this.add(textField);
        }
        else{
            this.passField = new JPasswordField();
            this.passField.setSize(textFieldWidth, height);
            this.passField.setBorder(BorderFactory.createCompoundBorder( 
                            BorderFactory.createLineBorder(Color.GRAY, 1),
                            BorderFactory.createEmptyBorder(0,10,0,10)
            ));
            this.passField.setLocation(labelWidth, 0);
            this.add(passField);
        }
    }
    
    public void setText(String text){
        if(textField != null)
            textField.setText(text);
        if(passField != null)
            passField.setText(text);
    }
    
    public String getText(){
        if(textField != null)
            return textField.getText();
        if(passField != null)
            return String.valueOf(passField.getPassword());
        return null;
    }
    
}
