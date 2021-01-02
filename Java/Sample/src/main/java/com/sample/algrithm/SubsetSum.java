package com.sample.algrithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetSum {
    final static int SUM_VALUE = 11;
    public static void main(String[] args) {
        Integer[] arr = {8, 2, 1, 3};
        SubsetResult result = findSubsetSum(arr, SUM_VALUE);

//        for(ArrayList<Integer> sumset : result) {
//            System.out.print("(");
//            for(Integer i : sumset) {
//                System.out.print(i + " ");
//            }
//            System.out.println(")");
//        }
    }

    public static SubsetResult findSubsetSum(Integer[] arr, int expectedSum) {
        SubsetResult result = new SubsetResult();
        int len = arr.length;

        if(0 == len) {
            return result;
        }

        if(1 == len) {
            ArrayList<Integer> list = new ArrayList<>();
            if(arr[0] == expectedSum && expectedSum != SUM_VALUE) {
                list.add(expectedSum);
                result.getCurrentMatchResult().add(list);
            }

            if(arr[0] == SUM_VALUE) {
                list.add(SUM_VALUE);
                result.getFinalMatchResult().add(list);
            }

            return result;
        }

        if(2 == len) {
            ArrayList<Integer> list = new ArrayList<>();

            if((arr[0] == expectedSum || arr[1] == expectedSum)  && expectedSum != SUM_VALUE) {
                list.add(expectedSum);
                result.getCurrentMatchResult().add(list);
            }

            if(arr[0] == SUM_VALUE || arr[1] == SUM_VALUE) {
                list.add(SUM_VALUE);
                result.getFinalMatchResult().add(list);
            }

            int sum = arr[0] + arr[1];
            if(sum == expectedSum  && expectedSum != SUM_VALUE) {
                list.add(arr[0]);
                list.add(arr[1]);
                result.getCurrentMatchResult().add(list);
            }

            if(sum == SUM_VALUE ) {
                list.add(arr[0]);
                list.add(arr[1]);
                result.getFinalMatchResult().add(list);
            }
            return result;
        }

        int current = arr[0];
        expectedSum = expectedSum - current;

        ArrayList<Integer> currentMatch = new ArrayList<>();

        SubsetResult result1 = new SubsetResult();
        SubsetResult result2 = new SubsetResult();

        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));
        arrayList.remove(0);
        Integer[] newArray = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);

        result1 = findSubsetSum(newArray, SUM_VALUE);
        for(ArrayList<Integer> list : result1.getFinalMatchResult()) {
            result.getFinalMatchResult().add(list);
        }

        result2 = findSubsetSum(newArray, expectedSum);
        for(ArrayList<Integer> list : result2.getCurrentMatchResult()) {
            list.add(current);
            result.getCurrentMatchResult().add(list);
        }

        System.out.println(result.toString());
        return result;
    }

    static class SubsetResult {
        HashSet<ArrayList<Integer>> currentMatchResult;
        HashSet<ArrayList<Integer>> finalMatchResult;


        public SubsetResult(
        ) {
            currentMatchResult = new HashSet<>();
            finalMatchResult = new HashSet<>();
        }

        public HashSet<ArrayList<Integer>> getCurrentMatchResult() {
            return currentMatchResult;
        }

        public void setCurrentMatchResult(HashSet<ArrayList<Integer>> currentMatchResult) {
            this.currentMatchResult = currentMatchResult;
        }

        public HashSet<ArrayList<Integer>> getFinalMatchResult() {
            return finalMatchResult;
        }

        public void setFinalMatchResult(HashSet<ArrayList<Integer>> finalMatchResult) {
            this.finalMatchResult = finalMatchResult;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer("currentMatchResult: ");
            for (ArrayList<Integer> list : currentMatchResult) {
                for (Integer i : list) {
                    sb.append(i + " ");
                }
                sb.append(", ");
            }
            sb.append("\nfinalMatchResult: ");
            for (ArrayList<Integer> list : finalMatchResult) {
                for (Integer i : list) {
                    sb.append(i + " ");
                }
                sb.append(", ");
            }
            return sb.toString();
        }
    }
}
