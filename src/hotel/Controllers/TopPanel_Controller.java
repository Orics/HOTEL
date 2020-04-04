/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controllers;

import hotel.Lib.Controller;
import hotel.Models.TopPanel_Model;
import hotel.Views.TopPanel_View;

/**
 *
 * @author Orics
 */
public class TopPanel_Controller extends Controller{

    public TopPanel_Controller() {
        this.model = new TopPanel_Model();
        this.view = new TopPanel_View();
        this.view.load(model);
    }
    
    @Override
    protected void initEvents() {
        
    }
    
}
