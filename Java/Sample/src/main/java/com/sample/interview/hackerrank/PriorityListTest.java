package com.sample.interview.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * Create the Student2 and Priorities2 classes here.
 */
class Student2 implements Comparable<Student2>{
    String name;
    double cgpa;
    int id;

    Student2(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() { return name;}
    public double getCGPA() { return cgpa;}
    public int getID() {return id;}

    public String toString() { return "name: " + name + " cgpa: " + cgpa + " id: " + id + "\n";}

//    @Override
    public int compareTo(Student2 s) {
        int res = Double.compare(s.getCGPA(), this.getCGPA());
        if (res != 0) return res;

        res = this.getName().compareTo(s.getName());
        if (res != 0) return res;

        return this.getID() - s.getID();
    }
}

class Priorities2 {
    TreeSet<Student2> pq;

    Priorities2() {
        pq = new TreeSet<>();
    }

    public List<Student2> getStudent2s(List<String> events) {
        for(String e : events) {
            if (e.equals("SERVED")){
                System.out.println("Remove -> " + pq.pollFirst());
                System.out.println(pq);
            } else {
                String[] enterParts = e.split(" ");
                String name = enterParts[1];
                double cgpa = Double.parseDouble(enterParts[2]);
                int id = Integer.parseInt(enterParts[3]);
                pq.add(new Student2(name, cgpa, id));
                System.out.println(pq);
            }
        }

        List<Student2> result = new ArrayList<>();
        for(Student2 s : pq) {
            result.add(s);
        }
        return result;
    }
}

public class PriorityListTest {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities2 Priorities2 = new Priorities2();

    public static void main(String[] args) {
        List<String> events = Arrays.asList(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );

        List<Student2> Student2s = Priorities2.getStudent2s(events);

        if (Student2s.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student2 st: Student2s) {
                System.out.println(st.getName());
            }
        }
    }
}