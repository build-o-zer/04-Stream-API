package org.buildozers.streamapidojo.kata_04;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Getter
@ToString
@Builder
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class Person {

    private final String name;
    private final String firstName;
    private final Genre genre;

    public enum Genre {
        MALE, FEMALE, UNKNOWN, UNDEFINED, MIXED
    }

    /**
     * build a Person object from a full name : [Name] [FirstName].
     * Example : "Doe John" -> Person(name="Doe", firstName="John")
     * 
     * @param fullName full name, starting with the name and followed by the first name
     * @return a Person object
     */
    public static Person of(String fullName, Genre genre) {
        String[] fullNameSplitted = fullName.split(" ");
        return Person.builder().name(fullNameSplitted[0]).firstName(fullNameSplitted[1]).genre(genre).build();
    }   
}
