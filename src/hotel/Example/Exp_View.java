/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Example;

import hotel.Bin.Model;
import hotel.Bin.View;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Orics
 */
public class Exp_View extends View{
    private JLabel static_Label;
    private JLabel loaded_Label;
    
    public Exp_View(){
        this.setSize(200,200);
        this.setBackground(Color.YELLOW);
        this.setLayout(null);
        
        // statics
        static_Label = new JLabel("static");
        static_Label.setSize(100,30);
        
        this.add(static_Label);
    }
    
    @Override
    public void load(Model model) {
       Exp_Model m = (Exp_Model) model;
       loaded_Label = new JLabel(m.getData());
       loaded_Label.setSize(100,30);
       loaded_Label.setLocation(0, 100);
       
       this.add(loaded_Label);
    }
    
}
