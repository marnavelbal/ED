/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coviduk;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class CovidUK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinkedList<Person> people = readPeopleFromCSV("./peopleUK.csv");

        // let's print all the person read from CSV file
        for (Person person : people) {
            System.out.println(person);
        }
        

        ControlAccesoCovid cac = new ControlAccesoCovid();

    }

    private static LinkedList<Person> readPeopleFromCSV(String fileName) {
        LinkedList<Person> people = new LinkedList<Person>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.UTF_8)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                String[] attributes = line.split(",");
                int idPerson = Integer.parseInt(attributes[0]);
                String firstName = attributes[1];
                String lastName = attributes[2];
                Person.genderEnum gender = Person.genderEnum.valueOf(attributes[3].toUpperCase());
                int years = Integer.parseInt(attributes[4]);

                Person person = new Person(firstName, lastName, gender, years);

                // adding book into ArrayList
                people.add(person);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(CovidUK.class.getName()).log(Level.SEVERE, null, ex);
        }

        return people;
    }

}
