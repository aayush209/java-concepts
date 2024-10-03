package com.aayush209.javapractice.comparablecomparator.primitive;

import com.aayush209.javapractice.comparablecomparator.Employee;
import java.util.Arrays;
import java.util.Comparator;
import com.aayush209.javapractice.comparablecomparator.AscendingNameComparator;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 7};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr) + "\n");

        Employee[] employees = new Employee[4];
        employees[0] = new Employee(5, "Albus", 4534.02);
        employees[1] = new Employee(4, "Harry", 14645.21);
        employees[2] = new Employee(1, "Severus", 13539.01);
        employees[3] = new Employee(7, "Alistair", 9615.66);

        Arrays.sort(employees);
        System.out.println("ascending order of id using Comparable : ");
        System.out.println(Arrays.toString(employees) + "\n");

        Arrays.sort(employees, Employee.AscendingSalaryComparator);
        System.out.println("ascending order of salary using Comparator (static inner class) : ");
        System.out.println(Arrays.toString(employees) + "\n");

        Arrays.sort(employees, Employee.DescendingSalaryComparator);
        System.out.println("descending order of salary using Comparator (static inner class using lambda) : ");
        System.out.println(Arrays.toString(employees) + "\n");

        Arrays.sort(employees, new AscendingNameComparator());
        System.out.println("ascending order of name using Comparator implementation in a new class AscendingNameComparator : ");
        System.out.println(Arrays.toString(employees) + "\n");

        //descending order of name using inline comparator as arg2 in Arrays.sort(arr, arg2);
        // statement 1
        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getName().compareTo(e1.getName());
            }
        });
        System.out.println("statement 1 : ");
        System.out.println(Arrays.toString(employees) + "\n");

        //descending order of name using lambda as arg2 in Arrays.sort(arr, arg2);
        // statement 2
        Arrays.sort(employees, (Employee e1, Employee e2) -> e2.getName().compareTo(e1.getName()));
        System.out.println("statement 1 : ");
        System.out.println(Arrays.toString(employees) + "\n");

        //descending order of name using lambda (with no type definitions) as arg2 in Arrays.sort(arr, arg2);
        // statement 3
        Arrays.sort(employees, (e1, e2) -> e2.getName().compareTo(e1.getName()));
        System.out.println("statement 3 : ");
        System.out.println(Arrays.toString(employees) + "\n");

        //statement 1, statement 2 and statement 3 are equivalent and have the same result

        // 2D int array
        int [][] twoLenArr = {{10,16}, {2,8}, {1,6}, {7,12}};
        print2DIntArray(twoLenArr);
//        Arrays.sort(twoLenArr, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(twoLenArr, (a, b) -> Integer.compare(b[1], a[1]));
        System.out.println("After sorting twoLenArr on the basis on 1st Index of each row");
        print2DIntArray(twoLenArr);
        System.out.println();

        twoLenArr = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        print2DIntArray(twoLenArr);
        Arrays.sort(twoLenArr, Comparator.comparingInt(a -> a[1]));
        System.out.println("After sorting twoLenArr on the basis on 1st Index of each row");
        print2DIntArray(twoLenArr);
        System.out.println();

        int [] unsortedArr = {10,66 ,4,546,54 ,654, 6,54 ,654,34,345, 3,756,879,879, 8};
        Arrays.sort(unsortedArr);
        System.out.println(Arrays.toString(unsortedArr));
    }

    public static void print2DIntArray(int[][] arrayToBePrinted){
        for(int[] arr : arrayToBePrinted)
            System.out.println(Arrays.toString(arr));
    }
}