package com.sample.interview.hackerrank;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DetectHtmlTest {
    public static void main(String[] args) {
        String[] lines = {
                "<div class=\"portal\" role=\"navigation\" id='p-navigation'>",
                "</li>"
        };
        Pattern p1 = Pattern.compile("<([^<> /]+)( ([^<> ]+)=[^<>]+)*>");
        Pattern p2 = Pattern.compile(" ([^<>=]+)=[\"\'][^\"\']*[\"\']");

        Map<String, Set<String>> map = new TreeMap<>();
        for (int i = 0; i < lines.length; i++) {
//            System.out.println(i);
            Matcher m1 = p1.matcher(lines[i]);
            while (m1.find()) {
                String tag = m1.group(1);
                System.out.println("tag: " + tag);
                Set<String> set = (map.containsKey(tag)) ? map.get(tag) : new TreeSet<>();
                String attrDetails = m1.group(2);
                if (attrDetails != null) {
                    System.out.println("attrDetails: <" + attrDetails + ">");
                    Matcher m2 = p2.matcher(attrDetails);
                    while (m2.find()) {
                        String attr = m2.group(1);
//                        System.out.println("attr: <" + attr + ">");
                        set.add(attr);
                    }
                }
                map.put(tag, set);
            }
        }

        for (Map.Entry<String, Set<String>> e : map.entrySet()) {
            String attrList = e.getValue().stream()
                    .collect(Collectors.joining(","));
            System.out.println(e.getKey() + ":" + attrList);
        }
    }
}
