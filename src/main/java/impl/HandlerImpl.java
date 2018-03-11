/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import java.util.ArrayList;
import Interface.Handler;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class HandlerImpl implements Handler {

    private ArrayList<Person> persons;
    PersonData pd = new PersonData();

    /*
        Add persons using the PersonData class.
     */
    @Override
    public ArrayList<Person> addPersons() {
        try {
            pd.addData();
        } catch (IOException ex) {
            Logger.getLogger(HandlerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        persons = pd.getPersons();
        return persons;
    }

    /*
        Count up all persons that is 18 or above.
     */
    @Override
    public int isAdultCount() {
        try {
            pd.addData();
        } catch (IOException ex) {
            Logger.getLogger(HandlerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        persons = pd.getPersons();
        for (Person p : persons) {
            if (p.getAge() >= 18) {
                count++;
            }
        }
        return count;
    }
}
