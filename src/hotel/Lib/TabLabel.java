/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Lib;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Orics
 */
public class TabLabel extends JLabel{

    public TabLabel(String text, ImageIcon icon) {
        this.setSize(198, 50);
        this.setOpaque(true);
        this.setText("      "+text);
        this.setIcon(icon); 
        this.setForeground(new Color(80, 80, 80));
        this.setBackground(new Color(246, 246, 246));
        setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),
                        BorderFactory.createEmptyBorder(0,20,0,0))
        );
        
        this.initViewEvents();
    }
    
    private void initViewEvents(){
        this.addMouseListener(new MouseAdapter()  
        {  
            public void mouseEntered(MouseEvent e)  
            {  
                setForeground(Color.BLACK);
                setBackground(new Color(230, 230, 230));
                setSize(200,50);
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(1, 5, 1, 0, new Color(41, 181, 66)),
                        BorderFactory.createEmptyBorder(0,15,0,0))
                );
            }  
        }); 
        
        this.addMouseListener(new MouseAdapter()  
        {  
            public void mouseExited(MouseEvent e)  
            {  
                setForeground(new Color(80, 80, 80));
                setBackground(new Color(246, 246, 246));
                setSize(198,50);
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(200,200,200)),
                        BorderFactory.createEmptyBorder(0,20,0,0))
                );
            }  
        }); 
    }
}
