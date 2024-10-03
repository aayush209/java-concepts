package com.aayush209.javapractice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicExamples {

    public static void main(String[] args) {
        // 1. Write a Java program to calculate the average of a list of integers using streams.
        List<Integer> list1 = Arrays.asList(1,2,5,4,4,34,35,4,54,5,634,2,34,32,32,4);
        double average1 = list1.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println("average1 : " + average1);

        // 2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        List<String> list2 = Arrays.asList("homie", "chime", "floor", "Clamp");
        list2.stream().map(String::toLowerCase).forEach(e -> System.out.print(e + ","));
        System.out.println();
        list2.stream().map(String::toUpperCase).forEach(e -> System.out.print(e + ","));
        System.out.println();

        // 3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        List<Integer> list3 = Arrays.asList(1,2,5,4,4,34,33, 17, 19, 54,5,634,2,34,32,4);
        int sumEven = list3.stream().filter(e -> e % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sumEven);
        int sumOdd = list3.stream().filter(e -> e % 2 == 1).mapToInt(Integer::intValue).sum();
        System.out.println(sumOdd);

        // 4. Write a Java program to remove all duplicate elements from a list using streams
        // and sort them in descending order
        List<Integer> list4 = Arrays.asList(1,2,5,4,4,34,33, 17, 19, 54,5,634,2,34,32,4);
//        List<Integer> distinctList4 = list4.stream().distinct().sorted().collect(Collectors.toList()); // for ascending list
        List<Integer> distinctList4 = list4.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(distinctList4);

        // 5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.
        List<String> list5 = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown", "Beige", "Grey");
        Character startingLetter = 'G';
        long countG = list5.stream().filter(e -> e.startsWith(String.valueOf(startingLetter))).count();
        System.out.println(countG);
        Character startingL = 'B';
        long countB = list5.stream().filter(e -> e.startsWith(String.valueOf(startingL))).count();
        System.out.println(countB);

        // 6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        List<String> list6 = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown", "Beige", "Grey");
        List<String> ascOrder = list6.stream().sorted().collect(Collectors.toList());
        System.out.println(ascOrder);
        List<String> descOrder = list6.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(descOrder);

        // 7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
        List<Integer> list7 = Arrays.asList(1, 2, 5, 4, 4, 34, 33, 17, 19, 54, 5, 634, 2, 34, 32, 4);
//        List<Integer> list7 = new ArrayList<>(); // using this list, the answer of the below statement will be Optional.empty
//        List<Integer> list7 = null; // using this list, the answer of the below statement will be NullPointerException
//        Optional<Integer> max = list7.stream().max(Integer::compare); // using this will print Optional[634], you need to unwrap int from optional
        Integer max = list7.stream().max(Integer::compare).orElse(0);
        System.out.println("max : " + max);
        Integer min = list7.stream().min(Integer::compare).orElse(0);
        System.out.println("min : " + min);

        // 8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        List<Integer> list8 = Arrays.asList(1, 2, 5, 4, 4, 34, 33, 17, 19, 54, 5, 634, 2, 34, 32, 4);

        Integer secondMin = list8.stream().distinct().sorted().skip(1).findFirst().orElse(null);
        System.out.println("secondMin : " + secondMin);

        // another not so good way
        List<Integer> secondMinNotSoGoodWay = list8.stream().distinct().sorted().limit(2).sorted(Comparator.reverseOrder()).limit(1).collect(Collectors.toList());
        System.out.println("secondMinNotSoGoodWay : " + secondMinNotSoGoodWay);

        Integer secondMax = list8.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("secondMax : " + secondMax);

        // another not so good way
        List<Integer> secondMaxNotSoGoodWay = list8.stream().distinct().sorted(Comparator.reverseOrder()).limit(2).sorted().limit(1).collect(Collectors.toList());
        System.out.println("secondMaxNotSoGoodWay : " + secondMaxNotSoGoodWay);
    }

}
