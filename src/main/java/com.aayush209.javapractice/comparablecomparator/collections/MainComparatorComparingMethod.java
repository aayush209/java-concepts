package com.aayush209.javapractice.comparablecomparator.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.aayush209.javapractice.comparablecomparator.Employee;

public class MainComparatorComparingMethod {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(5, "Albus", 4534.02));
        employees.add(new Employee(4, "Harry", 14645.21));
        employees.add(new Employee(1, "Severus", 13539.01));
        employees.add(new Employee(7, "Alistair", 9615.66));

        // Using Comparator.comparing
        // For ascending order
        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getName, (s1, s2) -> {
                            return s1.compareTo(s2);
                        })
        );

        System.out.println("ascending order of names using Comparator.comparing : ");
        System.out.println(employees + "\n");

        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getName, Comparator.naturalOrder())
        );

        System.out.println("ascending order of names using Comparator.naturalOrder(): ");
        System.out.println(employees + "\n");

        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("ascending order of names using Comparator.comparing(lambda): ");
        System.out.println(employees + "\n");

        // For descending order
        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getName, (s1, s2) -> {
                            return s2.compareTo(s1);
                        })
        );

        System.out.println("descending order using Comparator.comparing : ");
        System.out.println(employees + "\n");

        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getName, Comparator.reverseOrder())
        );

        System.out.println("descending order using Comparator.reverseOrder() : ");
        System.out.println(employees + "\n");

        Collections.sort(employees, Comparator.comparing(Employee::getName).reversed());
        System.out.println("descending order of names using Comparator.comparing reversed(): ");
        System.out.println(employees + "\n");

        // Ascending order for id
        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getId, (s1, s2) -> {
                            return s1 - s2;
                        })
        );

        System.out.println("ascending order of Id using Comparator.comparing : ");
        System.out.println(employees + "\n");

        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getId, (s1, s2) -> s1 - s2)
        );

        System.out.println("ascending order of Id using Comparator.comparing : ");
        System.out.println(employees + "\n");

        Collections.sort(employees,
                Comparator.comparingInt(Employee::getId));

        System.out.println("ascending order of Id using Comparator.comparingInt : ");
        System.out.println(employees + "\n");

        // Descending order for id
        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getId, (s1, s2) -> {
                            return s2 - s1;
                        })
        );

        System.out.println("descending order of Id using Comparator.comparing : ");
        System.out.println(employees + "\n");

        Collections.sort(employees,
                Comparator.comparing(
                        Employee::getId, (s1, s2) -> s2 - s1)
        );

        System.out.println("descending order of Id using Comparator.comparing lambda : ");
        System.out.println(employees + "\n");

        Collections.sort(employees,
                Comparator.comparingInt(Employee::getId).reversed());

        System.out.println("descending order of Id using Comparator.comparingInt reversed: ");
        System.out.println(employees + "\n");
    }
}
