package com.sample.interview.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String[] input = {
            "Goodbye bye bye world world world",
            "Sam went went to to to his business",
            "Reya is is the the best player in eye eye game",
            "in inthe",
            "Hello hello Ab aB"
        };

        String regex = "\\b(\\w+)( \\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for(String s: input){
            List<String> allMatches = new ArrayList<String>();
            Matcher m = p.matcher(s);
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                allMatches.add(m.group());
                s = s.replaceAll("(?i)" + regex, "$1");
//                s = s.replaceAll(m.group(), m.group(1));
            }
            // Prints the modified sentence.
//            System.out.println(allMatches);
            System.out.println(s);
        }
    }
}
