/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Views;

import hotel.Models.Model;
import hotel.Lib.TabLabel;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Orics
 */
public class LeftPanel_View extends View{
    private TabLabel overviewLabel;
    private TabLabel bookingLabel;
    private TabLabel checkinLabel;
    private TabLabel checkoutLabel;
    private TabLabel customerLabel;
    private TabLabel statisticLabel;
    private TabLabel regulationLabel;
    
    public LeftPanel_View() {
        this.setSize(200, 768-25-70-10);
        this.setLocation(5, 70+5);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setLayout(null);
        this.setBackground(new Color(246, 246, 246));
        
        this.overviewLabel = new TabLabel("Overview", new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/overview_25px.png")));
        this.overviewLabel.setLocation(1, 1);
        
        this.bookingLabel = new TabLabel("Bookings", new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/booking_25px.png")));
        this.bookingLabel.setLocation(1, 51);
        
        this.checkinLabel = new TabLabel("Check In", new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/checkin_25px.png")));
        this.checkinLabel.setLocation(1, 101);
        
        this.checkoutLabel = new TabLabel("Check Out", new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/checkout_25px.png")));
        this.checkoutLabel.setLocation(1, 151);
        
        this.customerLabel = new TabLabel("Customers", new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/customer_25px.png")));
        this.customerLabel.setLocation(1, 201);
        
        this.statisticLabel = new TabLabel("Statistics", new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/statistic_25px.png")));
        this.statisticLabel.setLocation(1, 251);
        
        this.regulationLabel = new TabLabel("Regulations", new ImageIcon(this.getClass().getResource("/hotel/Assets/Icons/regulation_25px.png")));
        this.regulationLabel.setLocation(1, 301);
        
        this.add(overviewLabel);
        this.add(bookingLabel);
        this.add(checkinLabel);
        this.add(checkoutLabel);
        this.add(customerLabel);
        this.add(statisticLabel);
        this.add(regulationLabel);
    }
    
    @Override
    public void load(Model model) {
        
    }
    
}
