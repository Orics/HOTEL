/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import hotel.Controllers.Hotel_Controller;
import hotel.Controllers.Login_Controller;
import hotel.Lib.InputTextPanel;
import javax.swing.JFrame;

/**
 *
 * @author Orics
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(400,540);
        f.setLocation(0, 0);
        f.getContentPane().setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new Login_Controller().getView());
       // f.getContentPane().add(new TextFieldPanel(Hotel.class.getResource("/hotel/Assets/Icons/user_20px.png"), 40,200, 25, true));
    }
    
}
