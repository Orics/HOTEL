/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import hotel.Models.DataObjects.Employee;

/**
 *
 * @author Orics
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee e = Employee.getEmployee("10000");
        e.insert();
    }
    
}
