package org.buildozers.streamapidojo.kata_01;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata01 {

    /**
     * KATA: Refactor this method to use Java Stream API.
     * 
     * @param employees list of employees
     * @return list of employee names in uppercase with only employees aged strictly superior to minExclusiveAge
     */

    public static List<String> getEmployeeNamesInUpperCaseWithAgeStrictlySuperior(List<Employee> employees, int minExclusiveAge) {
        List<String> employeeNames = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > minExclusiveAge) {
                employeeNames.add(employee.getName().toUpperCase());
            }
        }
        return employeeNames;
    }
}
