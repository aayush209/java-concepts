package com.aayush209.javapractice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExploringMethods {

    // Non terminal
    // distinct(), filter(), map(), flatMap(), limit()

    // Terminal
    // collect(), max(), min(), forEach(), toArray(), count()
    public static void main(String[] args) {
        //distinct
        List<String> list1 = Arrays.asList("Homie", "Car", "Hill", "Homie", "Homie", "Car", "Homie", "Homie");
        System.out.println(list1.stream().distinct().collect(Collectors.toList()));

        //map, flatMap, filter already done

        //limit
        System.out.println("limit top 5 results : " + list1.stream().limit(5).collect(Collectors.toList()));

        //skip (skips the first n elements in the stream)
        System.out.println("skip first 2 elements after limiting first 5: " + list1.stream().limit(5).skip(2).collect(Collectors.toList()));

        //count()
        System.out.print("count occurrences of the words starting with H : ");
        System.out.println(list1.stream().filter(w -> w.startsWith("H")).count());

        System.out.println("\nmin");
        // min() expects a comparator as an argument
        List<Integer> listNum = Arrays.asList(4, 543, 5, 435, 43, 5, 43, 54, 35, 43, 5, 43, 5, 43);
        int min0 = listNum.stream().min((x, y) -> {return x.compareTo(y);}).get();
        int min1 = listNum.stream().min((x, y) -> {return x - y;}).get();
        int min2 = listNum.stream().min((x, y) -> x - y).get();
        int min3 = listNum.stream().min((x, y) -> Integer.compare(x, y)).get();
        int min4 = listNum.stream().min(Comparator.comparingInt(x -> x)).get();
        int min5 = listNum.stream().min(Integer::compare).get(); //// use this mainly
        // min0 min1 min2 min3 min4 min5 all are same
        System.out.println(min0);
        System.out.println(min1);
        System.out.println(min2);
        System.out.println(min3);
        System.out.println(min4);
        System.out.println(min5);

        System.out.println("\nmax() : ");
        // max() expects a comparator as an argument
        int max0 = listNum.stream().max((x, y) -> {return x.compareTo(y);}).get();
        int max1 = listNum.stream().max((x, y) -> {return x - y;}).get();
        int max2 = listNum.stream().max((x, y) -> x - y).get();
        int max3 = listNum.stream().max((x, y) -> Integer.compare(x, y)).get();
        int max4 = listNum.stream().max(Comparator.comparingInt(x -> x)).get();
        int max5 = listNum.stream().max(Integer::compare).get(); //// use this mainly
        // max0 max1 max2 max3 max4 max5 all are same
        System.out.println(max0);
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
        System.out.println(max4);
        System.out.println(max5);

//
//        //min() comparison on String (experimentation)
//        String min6 = list1.stream().min( (a, b) -> a.compareTo(b)).orElse("-1");
//        String min7 = list1.stream().min(String::compareTo).orElse("-1");
//        // min6 min7 are same
//        System.out.println(min6);
//        System.out.println(min7);

        //toArray()
        Object[] objects = listNum.stream().filter(n -> n % 2 == 0 ).toArray();
//        System.out.println("\ntoArray() : ");
//        for (Object o : objects) {
//            System.out.println(o);
//        }
    }
}
