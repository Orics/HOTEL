/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Example;

import javax.swing.JFrame;

/**
 *
 * @author Orics
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(300,400);
        f.getContentPane().setLayout(null);
        f.setVisible(true);
        
        
        f.getContentPane().add(new Exp_Controller().getView());
        
    }
    
}
