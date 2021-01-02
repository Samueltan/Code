package com.sample.interview.hackerrank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    String name;
    double cgpa;
    int id;

    Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() { return name;}
    public double getCGPA() { return cgpa;}
    public int getID() {return id;}

    public String toString() { return "name: " + name + " cgpa: " + cgpa + " id: " + id + "\n";}
}

class Priorities {
    PriorityQueue<Student> pq;

    Priorities() {
        Comparator<Student> comparator = Comparator.comparing(Student::getCGPA).reversed()
            .thenComparing(Student::getName)
            .thenComparing(Student::getID);
        pq = new PriorityQueue<Student>(comparator);
    }

    public List<Student> getStudents(List<String> events) {
        List<Student> result = new ArrayList<>();
        for(String e : events) {
            if (e.equals("SERVED")){
                pq.poll();
            } else {
                String[] enterParts = e.split(" ");
                String name = enterParts[1];
                double cgpa = Double.parseDouble(enterParts[2]);
                int id = Integer.parseInt(enterParts[3]);
                pq.add(new Student(name, cgpa, id));
            }
        }

        int len = pq.size();
        for(int i=0; i<len; i++) {
            Student s = pq.poll();
            if(s != null) {
                result.add(s);
            }
        }
        return result;
    }
}

public class PriorityQueueTest {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

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

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}