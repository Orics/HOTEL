/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controllers;

import hotel.Lib.Controller;
import hotel.Models.LeftPanel_Model;
import hotel.Views.LeftPanel_View;

/**
 *
 * @author Orics
 */
public class LeftPanel_Controller extends Controller{

    public LeftPanel_Controller() {
        this.model = new LeftPanel_Model();
        this.view = new LeftPanel_View();
        this.view.load(model);
    }
    
    @Override
    protected void initEvents() {
        
    }
    
}
