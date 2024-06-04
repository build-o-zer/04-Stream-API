package org.buildozers.streamapidojo.kata_04;

import java.util.ArrayList;
import java.util.List;
import org.buildozers.streamapidojo.kata_04.Person.Genre;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata04 {

    /**
     * KATA: Refactor this method to use Java Stream API.
     * 
     * returns a list of String containing the pretty names of persons with genre FEMALE.
     * The pretty name is the concatenation of the first name and the name of the person.
     *
     * @param persons list of persons
     * @return list of pretty names
     */
    public static List<String> getFemalePrettyNames(List<Person> persons) {
        List<String> femalePrettyNames = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGenre().equals(Genre.FEMALE)) {
                femalePrettyNames.add(person.getFirstName() + " " + person.getName());
            }
        }
        return femalePrettyNames;
    }


    /**
     * KATA: Refactor this method to use Java Stream API.
     * 
     * returns a list of String containing the pretty names of persons without genre UNDEFINED.
     * The pretty name is the concatenation of the first name and the name of the person.
     * 
     * @param persons list of persons
     * @return list of pretty names
     */
    public static List<String> getAllPrettyNamesExcludingUndefined(List<Person> persons) {
        List<String> allPrettyNames = new ArrayList<>();
        for (Person person : persons) {
            if (!person.getGenre().equals(Genre.UNDEFINED)) {
                allPrettyNames.add(person.getFirstName() + " " + person.getName());
            }
        }
        return allPrettyNames;
    }

}
