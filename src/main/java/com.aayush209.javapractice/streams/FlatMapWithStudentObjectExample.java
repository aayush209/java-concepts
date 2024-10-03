package com.aayush209.javapractice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapWithStudentObjectExample {

    public static void main(String[] args) {
        List<Student> studentsList1 = Arrays.asList(
                new Student("Brad", 11, 'A'),
                new Student("Ariel", 14, 'C'),
                new Student("Gabe", 18, 'B'));

        List<Student> studentsList2 = Arrays.asList(
                new Student("Crompton", 19, 'C'),
                new Student("Bradshaw", 12, 'A'),
                new Student("Steven", 28, 'B'));

        List<List<Student>> studentCommonList = Arrays.asList(studentsList1, studentsList2);

        //print all student names before java8
        System.out.println("print all student names before java8 : ");
        for(List<Student> l : studentCommonList){
            for (Student s : l){
                System.out.print(s.name);
                System.out.print(", ");
            }
        }
        System.out.println();

        //using flatMap
        // map operation is happening for all the x streams and the results of which are flattened by flatMap and collected
        List<String> namesUsingFlatMap = studentCommonList.stream().flatMap(x -> x.stream().map(student -> student.name)).collect(Collectors.toList());
        System.out.println(namesUsingFlatMap );

        // map operation is happening on the flattened Stream and then collected
        System.out.println(studentCommonList.stream().flatMap(x -> x.stream()).map(student -> student.name).collect(Collectors.toList()));

    }
}
