package org.buildozers.streamapidojo.kata_01;

import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata01 {

    /**
     * returns a list of employee names in uppercase with only employees aged strictly superior to minExclusiveAge.
     * 
     * @param employees list of employees
     * @return list of employee names in uppercase with only employees aged strictly superior to minExclusiveAge
     */

    public static List<String> getEmployeeNamesInUpperCaseWithAgeStrictlySuperior(List<Employee> employees, int minExclusiveAge) {
        return employees.stream()
            .filter(e -> e.getAge() > minExclusiveAge)
            .map(e -> e.getName().toUpperCase())
            .toList();
    }
}
