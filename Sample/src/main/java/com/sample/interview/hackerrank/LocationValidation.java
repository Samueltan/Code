package com.sample.interview.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        Pattern p = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            Matcher m = p.matcher(line);
            while (m.find()){
                cnt++;
            }
        }

        System.out.println(cnt);
    }


}
