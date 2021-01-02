package com.sample.interview.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommentDetector {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            Pattern comment = Pattern.compile("(//.*)|(?s)(/\\*.*?\\*/)");
            String code = br.lines().collect(Collectors.joining("\n"));
            Matcher commentMatcher = comment.matcher(code);
            while(commentMatcher.find()){
                if(commentMatcher.group(1)!=null){
                    System.out.println(commentMatcher.group(1));
                }
                else{
                    Arrays.stream(commentMatcher.group(2).split("\n")).map(line->line.trim()).forEach(System.out::println);
                }
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
