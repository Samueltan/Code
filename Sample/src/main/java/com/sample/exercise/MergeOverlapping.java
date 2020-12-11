package com.sample.exercise;

import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlapping {
    public static void  main(String[] args) {
        ArrayList<Pair> intervals = new ArrayList<>();
        intervals.add(new Pair(1, 4));
        intervals.add(new Pair(2, 5));
        intervals.add(new Pair(8, 19));
        intervals.add(new Pair(7, 11));

        System.out.println(intervals);

        System.out.println(merge(intervals));
    }

    public static ArrayList<Pair> merge(ArrayList<Pair> pairs) {
        Collections.sort(pairs, (p1, p2) -> p1.getStart() - p2.getStart());
//        System.out.println(pairs);
        int start = pairs.get(0).getStart();
        int end = pairs.get(0).getEnd();
        ArrayList<Pair> res = new ArrayList<>();

        for(int i=1; i<pairs.size(); i++) {
            Pair cur = pairs.get(i);
            if (cur.getStart() < end) {
                end = cur.getEnd();
            } else {
                res.add(new Pair(start, end));
                start = cur.getStart();
                end = cur.getEnd();
            }
        }
        res.add(new Pair(start, end));

        return res;
    }

}

class Pair{
    private int start;
    private int end;

    public Pair(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return ("(" + start + ", " + end + ")");
    }
}
