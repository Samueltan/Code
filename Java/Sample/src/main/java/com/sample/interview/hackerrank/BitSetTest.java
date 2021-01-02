package com.sample.interview.hackerrank;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BitSetTest {
    public static void main(String[] args) {
        int N = 5;
        BitSet[] bitSets = new BitSet[]{new BitSet(N), new BitSet(N)};
        String[] operations = {
            "AND 1 2",
            "SET 1 4",
            "FLIP 2 2",
            "OR 2 1"
        };

        Map<String, BiConsumer<Integer, Integer>> map = new HashMap<>();
        map.put("AND", (i1, i2) -> bitSets[i1-1].and(bitSets[i2-1]));
        map.put("OR", (i1, i2) -> bitSets[i1-1].or(bitSets[i2-1]));
        map.put("XOR", (i1, i2) -> bitSets[i1-1].xor(bitSets[i2-1]));
        map.put("SET", (i1, i2) -> bitSets[i1-1].set(i2));
        map.put("FLIP", (i1, i2) -> bitSets[i1-1].flip(i2));

        for(String operation : operations) {
            String[] action = operation.split(" ");
            String operand = action[0];
            int op1 = Integer.parseInt(action[1]);
            int op2 = Integer.parseInt(action[2]);

            map.get(operand).accept(op1, op2);

            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }
}
