/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public class PersonData {

    private final ArrayList<Person> persons;
    private final ArrayList<String> data;

    public PersonData() {
        this.persons = new ArrayList();
        this.data = new ArrayList();
    }

    /**
     *
     * @throws IOException
     */
    public void addData() throws IOException {
        getDataFromFile();
        for (int i = 0; i < data.size() - 1; i = i + 3) {
            persons.add(new Person(data.get(i), data.get(i + 1), Integer.parseInt(data.get(i + 2))));
        }
    }

    /**
     * @return @throws FileNotFoundException
     * @throws IOException
     *
     * Reads from file persons.txt under ...\2SemesterEksamen\target\classes
     */
    private ArrayList<String> getDataFromFile() throws FileNotFoundException, IOException {
        String filePath = HandlerImpl.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "persons.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String[] placeHolder;
        String text;
        while ((text = reader.readLine()) != null) {
            placeHolder = text.split(",");
            for (String string : placeHolder) {
                data.add(string);
            }
        }
        return data;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
}
