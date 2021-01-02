package com.sample.interview.hackerrank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class BigDecimalTest {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here

//        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
//            @Override
//            public int compare(String a1, String a2) {
//                BigDecimal b1 = new BigDecimal(a1);
//                BigDecimal b2 = new BigDecimal(a2);
//                return b1.compareTo(b2);
//            }
//        }));
        Arrays.sort(s, 0, n, (s1, s2) -> new BigDecimal(s2).compareTo(new BigDecimal(s1)));

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
