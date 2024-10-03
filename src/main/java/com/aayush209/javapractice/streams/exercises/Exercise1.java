package com.aayush209.javapractice.streams.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://medium.com/@veenaraofr/java8-interview-questions-1be1668b74e3
public class Exercise1 {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 10, 15, 8, 49, 25, 98, 32, 10};

        //1. Print Even nos from the list
        System.out.print("1. Print Even nos from the list : ");
        Arrays.stream(arr).filter(i -> i % 2 == 0).forEach(System.out::println);

        //2. Find First element in the list
        System.out.print("\n2. Find First element in the list : ");
        Arrays.stream(arr).findFirst().ifPresent(System.out::println);

        //3. Find duplicates in the list
        Set<Integer> set = new HashSet<>();
        System.out.print("\n3. Find duplicates in the list : ");
        Arrays.stream(arr).filter(x -> !set.add(x)).forEach(System.out::println);

        //4. Print nos that starts with 1 from the list
        System.out.println("\n4. Print nos that starts with 1 from the list : ");
        Arrays.stream(arr).mapToObj(String::valueOf).filter(x -> x.startsWith("1")).forEach(System.out::println);

        //5. Find minimum and maximum in the list
        System.out.print("\n5. Find minimum and maximum in the list : \n");
        System.out.println("Min : " + Arrays.stream(arr).min().getAsInt());
        System.out.println("Max : " + Arrays.stream(arr).max().getAsInt());

        //6. Find first non repeated character
//
//        System.out.println("first non repeated character::" +
//                Stream.of(input.split("")).
//                        collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
//                                Collectors.counting())).entrySet().stream().
//                        filter(entry -> entry.getValue() >= 1).
//                        map(entry -> entry.getKey()).findFirst().get());

        //7. Sort the elements in asc and desc
        System.out.println("\n7. Sort the elements in asc : ");
        System.out.println(Arrays.toString(Arrays.stream(arr).sorted().toArray()));
        System.out.println("\n7. Sort the elements in desc : ");
        System.out.println(Arrays.toString(Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::valueOf).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(arr).boxed().sorted((a, b) -> b - a).mapToInt(Integer::valueOf).toArray())); // also gives a descending order

        //8. Perform cube on list elements and filter numbers greater than 50
        System.out.println("\n8. Perform cube on list elements and filter numbers greater than 50 : ");
        System.out.println(Arrays.toString(Arrays.stream(arr).map(i -> i * i * i).filter(i -> i > 50)
                .toArray()));

        //9. To sort an array and then convert the sorted array into Stream
        System.out.println("\n9. To sort an array and then convert the sorted array into Stream : ");
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

        //10. Find unique nos from the list (which has a freq exactly equal to 1)
        System.out.println("\n10. Find unique nos from the list : ");
        List<Integer> list = Arrays.asList(11, 22, 33, 44, 11, 22);
        System.out.println(
                list.stream()
                        .filter(x -> Collections.frequency(list, x) == 1)
                        .collect(Collectors.toList()));

        //seems wrong to me
        //12 . To find only duplicate elements from the String ArrayList
        List<String> list1 = Arrays.asList("abc", "def", "xyz", "mno", "pqr", "def", "xyz", "stu");
        Set<String> set1 = new LinkedHashSet<>();
        System.out.println("\n12 . To find only duplicate elements from the String ArrayList : ");
        list1.stream().filter(s -> set1.add(s)).forEach(System.out::println);

        //13. To print the count of each character in a String
        // revisit this as it is not working
//        String s = "sTring data to Count eaCh charACter";
//        Map<String, Long> countMap = Arrays.stream(s.split("")).
//                map(String::toLowerCase).
//                collect(Collectors.groupingBy(str -> str,
//                        LinkedHashMap::new, Collectors.counting()));
//        System.out.println(countMap);

        //14 . Print odd and Even list
        int[] arr1 = new int[]{1, 2, 4, 6, 7};
        System.out.println("\n14 . Print odd and Even list : ");
        System.out.println(Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.groupingBy(t -> t % 2 == 0 ? "ODD" : "EVEN")));

        //15. Print odd , Even sum
        //review again
        Map<String, Integer> map1 = Arrays.stream(arr1)
                .boxed()// converts int to Integer
                .collect(Collectors.groupingBy(e -> e % 2 == 0 ? "OddSum" : "EvenSum",
                        Collectors.summingInt(Integer::intValue)));
        System.out.println("15. Print odd , Even sum : ");
        System.out.println(map1);
    }
}

