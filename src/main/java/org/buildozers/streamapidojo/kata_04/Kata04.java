package org.buildozers.streamapidojo.kata_04;

import java.util.List;
import java.util.function.Predicate;

import org.buildozers.streamapidojo.kata_04.Person.Genre;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata04 {

    /**
     * returns a list of String containing the pretty names of persons with genre FEMALE.
     * The pretty name is the concatenation of the first name and the name of the person.
     *
     * @param persons list of persons
     * @return list of pretty names
     */
    public static List<String> getFemalePrettyNames(List<Person> persons) {
        return persons.stream()
                .filter(isFemale())
                .map(Kata04::prettyName)
                .toList();
    }

    /**
     * returns a list of String containing the pretty names of persons without genre UNDEFINED.
     * The pretty name is the concatenation of the first name and the name of the person.
     * 
     * @param persons list of persons
     * @return list of pretty names
     */
    public static List<String> getAllPrettyNamesExcludingUndefined(List<Person> persons) {
        return persons.stream()
                .filter(Predicate.not(isUndefined()))
                .map(Kata04::prettyName)
                .toList();
    }

    // Custom Predicates
    public static Predicate<Person> isFemale() {
        return person -> Genre.FEMALE.equals(person.getGenre());
    }

    public static Predicate<Person> isUndefined() {
        return person -> Genre.UNDEFINED.equals(person.getGenre());
    }

    // Custom Functions
    public static String prettyName(Person person) {
        return String.join(" ", person.getFirstName(), person.getName());
    }

}
