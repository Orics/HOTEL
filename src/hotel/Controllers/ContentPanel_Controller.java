/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controllers;

import hotel.Lib.Controller;
import hotel.Models.ContentPanel_Model;
import hotel.Views.ContentPanel_View;

/**
 *
 * @author Orics
 */
public class ContentPanel_Controller extends Controller{

    public ContentPanel_Controller() {
        this.model = new ContentPanel_Model();
        this.view = new ContentPanel_View();
        this.view.load(model);
    }
    
    @Override
    protected void initEvents() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
