package com.aayush209.javapractice.comparablecomparator;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{

    private final int id;
    private final String name;
    private final double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // natural ordering via Comparable
    @Override
    public int compareTo(Employee o) {
        return this.id - o.id; // for ascending order
//        return o.id - this.id; // for descending order
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static Comparator<Employee> AscendingSalaryComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return (int)(e1.salary - e2.salary); // ascending order of salary
        }
    };

    public static Comparator<Employee> DescendingSalaryComparator = (e1, e2) -> {
        return (int)(e2.salary - e1.salary); // descending order of salary
    };
}
