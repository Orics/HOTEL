/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controllers;

import hotel.Views.View;
import hotel.Models.Model;

/**
 *
 * @author Orics
 */
public abstract class Controller {
    protected View view;
    protected Model model;

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }
    
    public Controller(){
        
    }
    
    protected abstract void initEvents();
}
