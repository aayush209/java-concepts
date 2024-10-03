package com.aayush209.javapractice.implementhashmap;

public class OurMapTest {

    public static void main(String[] args) {
        OurMap<Integer, String> ourMap = new OurMap<>();
        ourMap.put(1, "homie2");
        ourMap.put(5, "homie5");
        ourMap.put(4, "homie4");
        ourMap.put(3, "homie3");
        ourMap.put(2, "homie2");
        ourMap.put(8, "homie8");
        ourMap.put(10, "homie10");
        ourMap.put(12, "homie12");

        System.out.println(ourMap.get(1));
        System.out.println(ourMap.get(5));
        System.out.println(ourMap.get(4));
        System.out.println(ourMap.get(3));
        System.out.println(ourMap.get(2));
        System.out.println(ourMap.get(8));

        ourMap.put(8, "homie9");
        System.out.println(ourMap.get(8)); // returns homie9

        ourMap.remove(2);
        System.out.println(ourMap.get(2)); // returns null
    }
}
