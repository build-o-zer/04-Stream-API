package org.buildozers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.buildozers.streamapidojo.kata_01.Employee;
import org.buildozers.streamapidojo.kata_01.Kata01;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * /!\ DO NOT MODIFY THIS CLASS /!\ 
 */
@Slf4j
class Kata01Test {

    @Test
    @DisplayName("Given a list of employees, when getting the names of employees aged strictly superior to 30, then return the names in uppercase.")
    void getEmployeeNamesInUpperCaseWithAgeStrictlySuperiorTest() {
        // given
        List<Employee> employees = List.of(
            new Employee("Alice", 25),
            new Employee("Bob", 30),
            new Employee("Charlie", 35),
            new Employee("David", 40)
        );

        // when
        List<String> employeeNames = Kata01.getEmployeeNamesInUpperCaseWithAgeStrictlySuperior(employees, 30);

        // log
        employeeNames.forEach(log::info);

        // then
        assertThat(employeeNames).containsExactly("CHARLIE", "DAVID");
    }
}