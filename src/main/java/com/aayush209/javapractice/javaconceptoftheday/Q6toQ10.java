package com.aayush209.javapractice.javaconceptoftheday;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q6toQ10 {

    //https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
    public static void main(String[] args) {
        List<Employee> employeeList = MockData.getData();
        //Query 3.6 : Count the number of employees in each department
        Map<String, Long> countOfEmployeesInEachDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("countOfEmployeesInEachDepartment : " + countOfEmployeesInEachDepartment);

        //Query 3.7 : What is the average salary of each department
        Map<String, Double> averageSalaryDepartmentWise = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("averageSalaryDepartmentWise : " + averageSalaryDepartmentWise);

        //Query 3.8 a) : Get the details of the youngest employee
        Employee youngestEmployee = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
        System.out.println("youngestEmployee : " + youngestEmployee);

        //Query 3.8 b) : Get the details of the youngest male employee in the product development department
        Employee youngestMaleEmployeeInProductDevelopment = employeeList.stream()
                .filter(employee -> employee.getGender().equals("Male") && employee.getDepartment().equals("Product Development"))
                .min(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
        System.out.println("youngestMaleEmployeeInProductDevelopment : " + youngestMaleEmployeeInProductDevelopment);

        //Query 3.9 : Who has the most working experience in the organization
        // my attempt (better approach)
        Employee employeeWithMostWorkingExperience = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .orElse(null);
        System.out.println("employeeWithMostWorkingExperience : " + employeeWithMostWorkingExperience);

        Employee employeeWithMostWorkingExperience2ndAttempt = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .findFirst()
                .orElse(null);
        System.out.println("employeeWithMostWorkingExperience2ndAttempt : " + employeeWithMostWorkingExperience2ndAttempt);

        //Query 3.10 : How many male and female employees are there in the sales and marketing team
        Map<String, Long> salesAndMarketingCount = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(salesAndMarketingCount);
    }
}
