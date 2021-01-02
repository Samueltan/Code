package com.sample.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountAudiable {
    public static void main(String[] args) {
        List<String> rel = new ArrayList<>();
        rel.add("1100");
        rel.add("1110");
        rel.add("0110");
        rel.add("0001");
        System.out.println(countAudiable(rel));
    }

    public static int countAudiable(List<String> relations) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<relations.size(); i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            char[] cs = relations.get(i).toCharArray();
            for(int j=0; j<cs.length; j++) {
                if(cs[j] == '1') {
                    set.add(j);
                }
            }
            list.add(set);
        }

        System.out.println(list);
        List<Set<Integer>> res = mergeSet(list);
        System.out.println(res);

        return res.size();
    }

    public static List<Set<Integer>> mergeSet(List<Set<Integer>> sets) {
        for(int i=0; i<sets.size() - 1; i++) {
            Set<Integer> cur = sets.get(i);
            Set<Integer> next = sets.get(i+1);
            for(Integer e : cur) {
                if(next.contains(e)) {
                    sets.get(i+1).addAll(sets.get(i));
                    sets.set(i, null);
                    break;
                }
            }
        }

        sets = sets.stream().filter(e -> e != null).collect(Collectors.toList());
        return sets;
    }
}
