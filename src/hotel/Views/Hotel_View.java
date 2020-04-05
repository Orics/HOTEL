/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Views;

import hotel.Models.Model;
import hotel.Controllers.ContentPanel_Controller;
import hotel.Controllers.LeftPanel_Controller;
import hotel.Controllers.TopPanel_Controller;
import hotel.Models.DataObjects.Employee;
import java.awt.Color;

/**
 *
 * @author Orics
 */
public class Hotel_View extends View{
    private TopPanel_View topPanelView;
    private LeftPanel_View leftPanelView;
    private ContentPanel_View contentPanel_View;
    
    public Hotel_View() {
        this.setSize(1366, 768);
        this.setLayout(null);
        
        this.topPanelView = (TopPanel_View) new TopPanel_Controller().getView();
        this.leftPanelView = (LeftPanel_View) new LeftPanel_Controller().getView();
        this.contentPanel_View = (ContentPanel_View) new ContentPanel_Controller().getView();
        
        this.add(topPanelView);
        this.add(leftPanelView);
        this.add(contentPanel_View);
    }
    
    @Override
    public void load(Model model) {
        
    }
    
    public void loadEmployee(Employee emp){
        this.topPanelView.getEmpName().setText(emp.getEmpName());
        this.topPanelView.getEmpRole().setText(emp.getRoleID());
    }
}
