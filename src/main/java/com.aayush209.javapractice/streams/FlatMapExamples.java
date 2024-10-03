package com.aayush209.javapractice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExamples {

    public static void main(String[] args) {
        //flatmap map is used for flattening of elements
        // i.e. when the ele is a complex object (object inside an object)

        //map returns a Stream of objects
        //flatMap returns a Stream of Stream of objects

        //map example
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list1Collected = list1.stream()
                .map(e -> e + 5)
                .collect(Collectors.toList());
        System.out.println(list1Collected);

        //flatMap example
        List<List<Integer>> list2 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> list2Flattened = list2.stream().flatMap(x -> x.stream().map(e -> e + 5)).collect(Collectors.toList());
        System.out.println(list2Flattened);

        // reading data from list of list was done via 2 nested for loops
        List<List<String>> list3 = Arrays.asList(
                Arrays.asList("Golum", "Stronk", "Dwight"),
                Arrays.asList("Rodney", "Wayne", "Ryan"),
                Arrays.asList("Victor", "Capro", "Schnar")
        );

        List<String> namesStartingWithS = list3.stream().flatMap(x -> x.stream().filter(n -> n.startsWith("S"))).collect(Collectors.toList());
        System.out.println("namesStartingWithS : " + namesStartingWithS);

        List<String> namesStartingWithROrCOrD = list3.stream()
                .flatMap(x -> x.stream().filter(n -> n.startsWith("R") || n.startsWith("C") || n.startsWith("D")))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("namesStartingWithROrCOrD sorted in reverseOrder: " + namesStartingWithROrCOrD);
    }
}
