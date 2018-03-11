/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import impl.Person;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public interface Handler {
    
    public ArrayList<Person> addPersons();
   
    public int isAdultCount();
    
}
