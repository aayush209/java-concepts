package com.aayush209.javapractice.comparablecomparator.collections;

import com.aayush209.javapractice.comparablecomparator.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.aayush209.javapractice.comparablecomparator.AscendingNameComparator;

public class Main {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(5, 4, 1, 7));
        Collections.sort(arr);
        System.out.println("ascending order : ");
        System.out.println(arr + "\n");

        Collections.sort(arr, Collections.reverseOrder());
        System.out.println("descending order using Collections.reverseOrder(): ");
        System.out.println(arr + "\n");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(5, "Albus", 4534.02));
        employees.add(new Employee(4, "Harry", 14645.21));
        employees.add(new Employee(1, "Severus", 13539.01));
        employees.add(new Employee(7, "Alistair", 9615.66));

        Collections.sort(employees);
        System.out.println("ascending order of id using Comparable : "); // see compareTo method of employee class
        System.out.println(employees + "\n");

        Collections.sort(employees, Collections.reverseOrder());
        System.out.println("descending order of id using Comparable and Collections.reverseOrder() : ");
        System.out.println(employees + "\n");

        Collections.sort(employees, Employee.AscendingSalaryComparator);
        System.out.println("ascending order of salary using Comparator (static inner class) : ");
        System.out.println(employees + "\n");

        Collections.sort(employees, Employee.DescendingSalaryComparator);
        System.out.println("descending order of salary using Comparator (static inner class using lambda) : ");
        System.out.println(employees + "\n");

        Collections.sort(employees, new AscendingNameComparator());
        System.out.println("ascending order of name using Comparator implementation in a new class AscendingNameComparator : ");
        System.out.println(employees + "\n");

        //ascending order of name using inline comparator as arg2 in Collections.sort(arr, arg2);
        // statement 1 (i)
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

        System.out.println("statement 1 (i) : ");
        System.out.println(employees + "\n");

        //descending order of name using inline comparator as arg2 in Collections.sort(arr, arg2);
        // statement 1 (ii)
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getName().compareTo(e1.getName());
            }
        });

        System.out.println("statement 1 (ii) : ");
        System.out.println(employees + "\n");

        //ascending order of name using lambda as arg2 in Collections.sort(arr, arg2);
        // statement 2 (i)
        Collections.sort(employees, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("statement 2 (i) : ");
        System.out.println(employees + "\n");

        //descending order of name using lambda as arg2 in Arrays.sort(arr, arg2);
        // statement 2
        Collections.sort(employees, (Employee e1, Employee e2) -> e2.getName().compareTo(e1.getName()));
        System.out.println("statement 2 (ii) : ");
        System.out.println(employees + "\n");

        //ascending order of name using lambda (with no type definitions) as arg2 in Arrays.sort(arr, arg2);
        // statement 3 (i)
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("statement 3 (i) : ");
        System.out.println(employees + "\n");

        //descending order of name using lambda (with no type definitions) as arg2 in Arrays.sort(arr, arg2);
        // statement 3 (ii)
        Collections.sort(employees, (e1, e2) -> e2.getName().compareTo(e1.getName()));
        System.out.println("statement 3 (ii) : ");
        System.out.println(employees + "\n");

        //statement 1 (i), statement 2 (i) and statement 3 (i) are equivalent and have the same result
        //statement 1 (ii), statement 2 (ii) and statement 3 (ii) are equivalent and have the same result

    }
}