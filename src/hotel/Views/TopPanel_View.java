/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Views;

import hotel.Lib.Model;
import hotel.Lib.View;
import java.awt.Color;

/**
 *
 * @author Orics
 */
public class TopPanel_View extends View{

    public TopPanel_View() {
        this.setSize(1366, 70);
        this.setBackground(new Color(0,0,200));
        this.setOpaque(true);
    }
    
    @Override
    public void load(Model model) {
        
    }
    
}
