package com.aayush209.javapractice.streams.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {
        // int [] array to String [] using Streams
        // Way 1
        int[] arr = new int[]{9, 10, 15, 8, 49, 25, 98, 32, 10};
        String[] strings = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .toArray(x -> new String[x]);
        System.out.println(Arrays.toString(strings));

        // Way 2
        String[] strings2 = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings2));
    }
}

