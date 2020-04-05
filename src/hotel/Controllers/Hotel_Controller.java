/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controllers;

import hotel.Models.DataObjects.Employee;
import hotel.Models.Hotel_Model;
import hotel.Views.Hotel_View;

/**
 *
 * @author Orics
 */
public class Hotel_Controller extends Controller{
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }
    
    public Hotel_Controller(Employee emp) {
        this.employee = emp;
        
        this.model = new Hotel_Model();
        this.view = new Hotel_View();
        
        this.view.load(model);
        ((Hotel_View)(this.view)).loadEmployee(emp);
    }
    
    
    @Override
    protected void initEvents() {
        
    }
    
}
