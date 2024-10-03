package com.aayush209.javapractice.implementhashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OurMap <K,V> {

    private List<MapNode<K, V>> bucket; // bucket array
    private int capacity; // length of bucket
    private int size; // number of elements in map
    private final int INITIAL_CAPACITY = 5; // initial length of bucket array

    public OurMap(){
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for(int i = 0; i < capacity; i++){
            bucket.add(null); // initial bucket size is zero and must be made equal to the INITIAL_CAPACITY
        }
    }

    // responsible for calculating hashcode and performing compressing function on hashcode
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode(); // using Object's hashcode method to calc hashcode
        return hashCode % capacity; // comp
    }

    //Get func
    public V get(K key){
        int bucketIndex = getBucketIndex(key); // to get the index
        MapNode<K, V> head = bucket.get(bucketIndex); // to get the head of the Linked List using the bucketIndex

        while(head != null){
            if(head.key.equals(key)){ // == will fail here for strings and custom objects as it compares memory location for them, so use equals
                return head.value;
            }
            head = head.next;
        }

        // if key not found
        return null;
    }


    //Put a key value pair in map
    public void put(K key, V value){
        int bucketIndex = getBucketIndex(key); // to get the index
        MapNode<K, V> head = bucket.get(bucketIndex); // to get the head of the Linked List using the bucketIndex
        MapNode<K, V> headRef = head;

        //case to handle if the key is already present, its value must be updated
        while(head != null){
            if(head.key.equals(key)){ // == will fail
                head.value = value; // override the value
                return;
            }
            head = head.next;
        }
        size++; // increasing size as new element needs to be added to the map

        //case to handle if the key is NOT present, the key-value must be added to the current LL at the index
        MapNode<K, V> newEntry = new MapNode<>(key, value);
        head = headRef; // to get the head of the Linked List using the bucketIndex
        newEntry.next = head; // add the new K-V before the head
        bucket.set(bucketIndex, newEntry);

        // case to handle rehashing when load factor goes beyond 0.75
        double loadFactor = (1.0 * size) / capacity; // (n / b)

        System.out.println("inserting key : " + key);
        System.out.println("Load Factor : " + loadFactor);

        // rehash in case the load factor goes beyond 0.75
        if(loadFactor > 0.75)
            rehash();
    }

    private void rehash() {
        System.out.println("rehashing the buckets");
        List<MapNode<K, V>> temp = bucket; // copy the old bucket array
        bucket = new ArrayList<>();
        capacity = capacity * 2; // double the current capacity to get a new capacity
        for (int i = 0; i < capacity; i++){
            bucket.add(null);
        }
        size = 0;

        // take K, V from the old bucket array and put them into the new bucket array (double in size)
        for (MapNode<K, V> head : temp) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }

        Map<String, Integer> stringIntegerMap = new HashMap<>();
    }

    //remove a key
    public void remove(K key){
        int bucketIndex = getBucketIndex(key); // to get the index
        MapNode<K, V> head = bucket.get(bucketIndex); // to get the head of the Linked List using the bucketIndex

        MapNode<K, V> prev = null;
        //case to handle if the key is already present, its value must be updated
        while(head != null){
            if(head.key.equals(key)){ // == will fail
                if(prev == null)
                    bucket.set(bucketIndex, head.next); // first ele matches the key, skip the first element
                else
                    prev.next = head.next; // skip the head element
                head.next = null; // destroy link of head's next
                size--;
                break;
            }
            prev = head; // move prev to head
            head = head.next; // move head to next
        }
    }

    // inner class
    private static class MapNode<K,V> {
        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
