/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Views;

import hotel.Lib.Model;
import hotel.Lib.View;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Orics
 */
public class ContentPanel_View extends View{

    public ContentPanel_View() {
        this.setSize(1366-200-10-5, 768-25-70-10);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setLayout(null);
        this.setLocation(200+10, 70+5);
    }
    
    @Override
    public void load(Model model) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
