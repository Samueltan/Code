package com.sample.exercise;

public class CountItems {
    public static void main(String[] args) {
        String s = "|**|*|***|*|*|*|**";
        int cnt = countItems(s);

        System.out.println(cnt);
    }

    public static int countItems(String s) {
        int count = 0;
        int tmp = 0;
        boolean start = false;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '*') {
                if(start) {
                    tmp++;
                } else {
                    continue;
                }
            }
            if(c == '|') {
                if(start) {
                    count += tmp;
                    tmp = 0;
                } else {
                    start = true;
                }
            }
        }

        return count;
    }
}
