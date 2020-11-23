package com.sample.interview;

import java.util.Arrays;
import java.util.List;

public class FindInstances {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(25,23,1,2,3,76,80);
        int res = finalInstances(2, input);

        System.out.println(res);
    }

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        // Write your code here
        int orig = instances;
        boolean skip = false;
        int skipIndex = 0;
        // 25,23,1,2,3,76,80
        for(int i=0; i< averageUtil.size(); i++) {
            int cur = averageUtil.get(i);
            if (!skip) {
                if(cur < 25) {
                    orig = orig / 2;
                    skip = true;
                } else if(cur >= 25 && cur <= 60) {
                    skip = false;
                    continue;
                } else {
                    orig = 2 * orig;
                    skip = true;
                }
            } else {
                if(skipIndex < 3) {
                    skipIndex++;
                } else {
                    skip = false;
                    skipIndex = 0;
                }
            }
        }

        return orig;
    }

}