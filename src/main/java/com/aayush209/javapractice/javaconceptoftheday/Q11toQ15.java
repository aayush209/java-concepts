package com.aayush209.javapractice.javaconceptoftheday;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Q11toQ15 {

    //https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
    public static void main(String[] args) {
        List<Employee> employeeList = MockData.getData();
        //Query 3.11 : What is the average salary of male and female employees?
        Map<String, Double> averageSalaryMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("averageSalaryMap : " + averageSalaryMap);

        //Query 3.12 : List down the names of all employees in each department?
        Map<String, List<Employee>> departmentEmployeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        for(Entry<String, List<Employee>> entry : departmentEmployeeMap.entrySet()){
            System.out.print("Employees in " + entry.getKey() +  " Department : " );
            for (Employee e : entry.getValue()) {
                System.out.print(e.getName());
                System.out.print(", ");
            }
            System.out.println();
            System.out.println("----------------------------");
        }

        //Query 3.13 : What is the average salary and total salary of the whole organization?
        employeeList.stream()
                .map(Employee::getSalary)
                .mapToDouble(Double::doubleValue)
                .average()
                .ifPresent(x -> System.out.println("Average Salary : " + x));

        System.out.println("Total salary : "+ employeeList.stream()
                .map(Employee::getSalary)
                .mapToDouble(Double::doubleValue)
                .sum());

        DoubleSummaryStatistics employeeStats = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("average salary from Collectors.summarizingDouble : " + employeeStats.getAverage());
        System.out.println("Total salary from Collectors.summarizingDouble : " + employeeStats.getSum());
        System.out.println("Max salary from Collectors.summarizingDouble : " + employeeStats.getMax());
        System.out.println("Min salary from Collectors.summarizingDouble : " + employeeStats.getMin());
        System.out.println("Number of elements from Collectors.summarizingDouble : " + employeeStats.getCount());

        //Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<String, List<Employee>> classifyingOnTheBasisOfAge = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getAge() <= 25 ? "LessThanOrEqualTo25" : "MoreThan25"));

        for(Entry<String, List<Employee>> entry : classifyingOnTheBasisOfAge.entrySet()){
            System.out.print(entry.getKey() + " : " );
            for (Employee e : entry.getValue()){
                System.out.print(e.getName());
                System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println("\n");

        //better way
        Map<Boolean, List<Employee>> classifyingOnTheBasisOfAgeBetterWay = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() <= 25));
        for(Entry<Boolean, List<Employee>> entry : classifyingOnTheBasisOfAgeBetterWay.entrySet()){
            if(entry.getKey()){
                System.out.print("LessThanOrEqualTo25 : ");
            }else {
                System.out.print("MoreThan25 : ");
            }

            for (Employee e : entry.getValue()){
                System.out.print(e.getName());
                System.out.print(", ");
            }
            System.out.println();
        }
        //Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Employee oldestEmployee = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .get();
        System.out.println("oldestEmployee Name : " + oldestEmployee.getName());
        System.out.println("oldestEmployee Age : " + oldestEmployee.getAge());
        System.out.println("oldestEmployee Department : " + oldestEmployee.getDepartment());
    }
}
