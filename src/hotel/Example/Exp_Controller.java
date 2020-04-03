/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Example;

import hotel.Bin.Controller;

/**
 *
 * @author Orics
 */
public class Exp_Controller extends Controller{

    public Exp_Controller() {
        this.view = new Exp_View();
        this.model = new Exp_Model();
        this.view.load(model);
    }
    
    @Override
    protected void initEvents() {
        // create for Controls
    }
    
}
