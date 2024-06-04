package org.buildozers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.buildozers.streamapidojo.kata_04.Kata04;
import org.buildozers.streamapidojo.kata_04.Person;
import org.buildozers.streamapidojo.kata_04.Person.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * /!\ DO NOT MODIFY THIS CLASS /!\ 
 */
@Slf4j
class Kata04Test {

    @Test
    @DisplayName("Given a list of persons, when getting the pretty names of, then return only female pretty names.")
    void getFemalePrettyNames() {

        // given
        List<Person> persons = List.of(Person.of("Wayne Bruce", Genre.MALE),
                                       Person.of("Gordon Barbara", Genre.FEMALE),
                                       Person.of("Lane Lois", Genre.FEMALE),
                                       Person.of("Deadman Boston", Genre.UNKNOWN));

        // when
        List <String> result = Kata04.getFemalePrettyNames(persons);

        // log
        result.forEach(log::info);
        
        // then
        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .contains("Barbara Gordon")
                .contains("Lois Lane");
    }

    @Test
    @DisplayName("Given a list of persons, when getting the pretty names of, then return all pretty names but not for Genre.UNDEFINED.")
    void getPrettyNamesExcludingUndefined() {

        // given
        List<Person> persons = List.of(Person.of("Wayne Bruce", Genre.MALE),
                                       Person.of("Gordon Barbara", Genre.FEMALE),
                                       Person.of("Lane Lois", Genre.FEMALE),
                                       Person.of("Deadman Boston", Genre.UNDEFINED));

        // when
        List <String> result = Kata04.getAllPrettyNamesExcludingUndefined(persons);

        // log
        result.forEach(log::info);
        
        // then
        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .contains("Bruce Wayne")
                .contains("Barbara Gordon")
                .contains("Lois Lane");
    }


}