/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Views;

import hotel.Models.Model;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Orics
 */
public class TopPanel_View extends View{
    private JLabel empName;
    private JLabel empRole;
    private JLabel empIcon;
    private JLabel logoIcon;

    public JLabel getEmpName() {
        return empName;
    }

    public JLabel getEmpRole() {
        return empRole;
    }

    public JLabel getEmpIcon() {
        return empIcon;
    }

    public JLabel getLogoIcon() {
        return logoIcon;
    }

    public void setEmpName(JLabel empName) {
        this.empName = empName;
    }

    public void setEmpRole(JLabel empRole) {
        this.empRole = empRole;
    }

    public void setEmpIcon(JLabel empIcon) {
        this.empIcon = empIcon;
    }

    public void setLogoIcon(JLabel logoIcon) {
        this.logoIcon = logoIcon;
    }
    
    public TopPanel_View() {
        this.setSize(1366, 70);
        this.setBackground(new Color(0,0,200));
        this.setOpaque(true);
        this.setLayout(null);
        
        this.logoIcon = new JLabel(new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/logo.png")), SwingUtilities.LEFT);
        this.logoIcon.setSize(200, 30);
        this.logoIcon.setLocation(15, 20);
        //this.logoIcon.setOpaque(true);
        
        this.empName = new JLabel("Nguyen Van A", SwingUtilities.RIGHT);
        this.empName.setForeground(Color.WHITE);
        this.empName.setSize(300,18);
        this.empName.setLocation(990,20);
        
        this.empRole = new JLabel("Manager", SwingUtilities.RIGHT);
        this.empRole.setForeground(Color.WHITE);
        this.empRole.setSize(300,20);
        this.empRole.setLocation(990,33);
        
        this.empIcon = new JLabel(new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/account_40px.png")));
        this.empIcon.setSize(40, 40);
        this.empIcon.setLocation(1300, 15);
        
        this.add(logoIcon);
        this.add(empName);
        this.add(empRole);
        this.add(empIcon);
    }
    
    @Override
    public void load(Model model) {
        
    }
    
}
