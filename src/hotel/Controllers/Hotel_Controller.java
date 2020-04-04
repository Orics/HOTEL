/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controllers;

import hotel.Lib.Controller;
import hotel.Models.Hotel_Model;
import hotel.Views.Hotel_View;

/**
 *
 * @author Orics
 */
public class Hotel_Controller extends Controller{

    public Hotel_Controller() {
        this.model = new Hotel_Model();
        this.view = new Hotel_View();
        this.view.load(model);
    }
    
    
    @Override
    protected void initEvents() {
        
    }
    
}
