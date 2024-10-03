package com.aayush209.javapractice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirst {

    public static void main(String[] args) {
        int[] arr = new int[]{9,10,15,8,49,25,98,32,10};
        System.out.print("print line 1 : ");
        Arrays.stream(arr).findFirst().ifPresent(System.out::println);

        List<Integer> integers = Arrays.asList(9, 10, 15, 8, 49, 25, 98, 32, 10);
        Optional<Integer> first = integers.stream().findFirst();
        System.out.print("print line 2 : ");
        System.out.println(first.get());

        List<Integer> integers2 = new ArrayList<>();
        System.out.print("print line 3 : ");
        System.out.println(integers2.stream().findFirst()); // prints Optional.empty

        System.out.print("print line 4 : ");
        integers2.stream().findFirst().ifPresent(System.out::println); // doesn't print anything as findFirst() returns an Optional.empty
    }
}
