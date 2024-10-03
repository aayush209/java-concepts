package com.aayush209.javapractice.comparablecomparator.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinPQIntegerAndString {

    public static void main(String[] args) {
        PriorityQueue<Integer> pqI = new PriorityQueue<>(); // min pq by default
        //PriorityQueue<Integer> pqI = new PriorityQueue<>((n1, n2) -> (n1 - n2));
        //PriorityQueue<Integer> pqI = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        //PriorityQueue<Integer> pqI = new PriorityQueue<>(Comparator.naturalOrder());
        pqI.add(34);
        pqI.add(3325);
        pqI.add(64);
        pqI.add(14);
        pqI.add(354);
        pqI.add(534);

        while (!pqI.isEmpty()){
            System.out.print(pqI.poll());
            System.out.print(", ");
        }

        System.out.println();

//        PriorityQueue<String> pqS = new PriorityQueue<>(); // min pq by default
        //PriorityQueue<String> pqS = new PriorityQueue<>((s1, s2) -> s1.compareTo(s2));
        PriorityQueue<String> pqS = new PriorityQueue<>(Comparator.naturalOrder());
        pqS.add("vgsjvdja");
        pqS.add("sjvdja");
        pqS.add("gsjvdja");
        pqS.add("dja");
        pqS.add("vdja");
        pqS.add("dja");

        while (!pqS.isEmpty()){
            System.out.print(pqS.poll());
            System.out.print(",");
        }

    }
}
