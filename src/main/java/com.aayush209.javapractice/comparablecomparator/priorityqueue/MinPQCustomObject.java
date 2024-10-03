package com.aayush209.javapractice.comparablecomparator.priorityqueue;

import java.util.PriorityQueue;

public class MinPQCustomObject {

    public static void main(String[] args) {
        PriorityQueue<TupleClass> pqN = new PriorityQueue<>(); // check compareTo method of Tuple class, it is implemented to sort by name in asc order
        //PriorityQueue<TupleClass> pqN = new PriorityQueue<>((n1, n2) -> (n1.getName()).compareTo(n2.getName()));
        //PriorityQueue<TupleClass> pqN = new PriorityQueue<>(Comparator.comparing(TupleClass::getName));

        pqN.add(new TupleClass("Seoul", 34));
        pqN.add(new TupleClass("Ape", 24));
        pqN.add(new TupleClass("Cross", 14));
        pqN.add(new TupleClass("Clob", 55));
        pqN.add(new TupleClass("Home", 35));
        pqN.add(new TupleClass("Kite", 12));

        while (!pqN.isEmpty()){
            TupleClass obj = pqN.poll();
            System.out.print(obj.toString());
            System.out.print(", ");
        }

        PriorityQueue<TupleClass> pqId = new PriorityQueue<>((n1, n2) -> (n1.getId() - n2.getId()));
//        PriorityQueue<TupleClass> pqId = new PriorityQueue<>(Comparator.comparing(TupleClass::getId));
//        PriorityQueue<TupleClass> pqId = new PriorityQueue<>(Comparator.comparingInt(TupleClass::getId));

        pqId.add(new TupleClass("Seoul", 34));
        pqId.add(new TupleClass("Ape", 24));
        pqId.add(new TupleClass("Cross", 14));
        pqId.add(new TupleClass("Clob", 55));
        pqId.add(new TupleClass("Home", 35));
        pqId.add(new TupleClass("Kite", 12));

        while (!pqId.isEmpty()){
            TupleClass obj = pqId.poll();
            System.out.print(obj.toString());
            System.out.print(", ");
        }
    }
}
