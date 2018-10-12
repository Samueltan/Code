package com.sample.interview.priceline;

public class StringReverser {
    public static void main(String[] args) {
        String s = "I-am-a-student";

        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        String[] arr = s.split("-");

        String s2 = String.join("_", arr);
        System.out.println(s2);

        int len = arr.length;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++) {
            sb.append(arr[len - i -1]);
            if(i<len-1) {
                sb.append("~");
            }
        }
        return sb.toString();
    }
}
