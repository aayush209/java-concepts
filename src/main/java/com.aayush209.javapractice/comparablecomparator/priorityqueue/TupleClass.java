package com.aayush209.javapractice.comparablecomparator.priorityqueue;

public class TupleClass implements Comparable<TupleClass>{

    private String name;
    private int id;

    public TupleClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TupleClass{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(TupleClass o) {
        return (this.name).compareTo(o.name); // ascending order of name
//        return (o.name).compareTo(this.name); // descending order of name


    }
}
