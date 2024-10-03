package com.aayush209.javapractice.javaconceptoftheday;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1toQ5 {

    //https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
    public static void main(String[] args) {

        /*
        * Sample way of using groupingBy
        * List<Integer> l = Arrays.asList(99, 3, 213, 22, 3, 4, 23, 3, 22, 3, 2, 3, 2, 32, 31);
        * Map<String, List<Integer>> collect1 = l.stream()
        *        .collect(Collectors.groupingBy(a -> a % 2 == 0 ? "EVEN" : "ODDBOIS"));
        *
        * System.out.println(collect1);
        */

        List<Employee> employeeList = MockData.getData();


        /*
        This will take first five employees from the list and will bucket them on the basis of gender
        Map<String, List<Employee>> collect = employeeList.stream().limit(5)
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(collect);*/

        /*
         Query 3.1 : How many male and female employees are there in the organization

         For queries such as above where you need to group the input elements,
         use the Collectors.groupingBy() method. In this query, we use Collectors.groupingBy() method
         which takes two arguments.
         We pass Employee::getGender as first argument which groups the input elements based on gender
         and Collectors.counting() as second argument which counts the number of entries in each group.
         */

        Map<String, Long> noOfMaleAndFemaleEmployees=
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(noOfMaleAndFemaleEmployees);

        // Query 3.2 : Print the name of all departments in the organization
        List<String> departments = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(departments);

        // Query 3.3 : What is the average age of male and female employees?
        Map<String, Double> averageAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

        System.out.println(averageAge);
/*
        for(Map.Entry<String, Double> entry : averageAge.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
*/

        // Query 3.4 : Get the details of highest paid employee in the organization?
        //method 1 (I wrote it @aayush)
        // need to sort by highest to the lowest salary and take the first ele
        employeeList.stream()
                .sorted((x, y) -> (int) y.getSalary() - (int) x.getSalary())
                .findFirst()
                .ifPresent(System.out::println);

        // Method 2
        /*Employee employeeWHighestSalaryMethod2 = employeeList.stream()
                .collect(Collectors.maxBy((x, y) -> (int) x.getSalary() - (int) y.getSalary()))
                .get(); // we can replace get() by orElse(null); to remove the
                        // 'Optional.get()' without 'isPresent()'  warning

        System.out.println("employeeWHighestSalaryMethod2 : " + employeeWHighestSalaryMethod2);
        */

        //method 3 use this one
        Employee employeeWHighestSalary = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

        System.out.println("employeeWHighestSalary : " + employeeWHighestSalary);

        // Query 3.5 : Get the names of all employees who have joined after 2015?
        List<String> namesOfEmployeesWhoJoinedAfter2015 = employeeList.stream()
                .filter(x -> x.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("namesOfEmployeesWhoJoinedAfter2015 : " + namesOfEmployeesWhoJoinedAfter2015);
    }
}
