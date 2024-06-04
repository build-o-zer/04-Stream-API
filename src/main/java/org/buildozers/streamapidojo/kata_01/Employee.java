package org.buildozers.streamapidojo.kata_01;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Employee {

    private final String name;
    private final int age;

}

