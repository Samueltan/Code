package com.sample.interview.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressRegexChecker {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "1050:0:0a:0:5:600:300c:326b",
            "1050:0:0a:0:5:600:300c:326a",
            "1050:0:0a:0:5:600:300c:326c",
            "1051:0:0a:0:5:600:300c:326b",
            "22.131.113.64",
            "22.131.113.164",
            "255.131.111.64",
            "253.131.111.64",
            "1050:10:0:0a:5:600:300c:326b",
            "1050:10:0:0a:5:600:300c:326a",
            "1050:10:0:0a:5:600:300c:326c",
            "1051:10:0:0a:5:600:300c:326b",
            "22.2.113.61",
            "22.2.113.162",
            "255.2.111.63",
            "253.2.111.69",
            "1050:10aa:0:0:15:600:300c:326b",
            "1050:10:0aa:10:5:600:300c:326a",
            "1050:10:10:0aa:5:600:300c:326c",
            "1051:110:0:0:5aa:600:300c:326b",
            "22.21.113.64",
            "22.2.113.164",
            "253.21.111.64",
            "253.5.111.64",
            "1050:10c:0:0:15:a600:300c:326k",
            "1050:10d:0:0:15:a600:300c:326g",
            "1050:10e:0:0:15:a600:300c:326h",
            "1050:10f:0:0:15:a600:300c:326i",
            "122.211.113.364",
            "122.212.113.3164",
            "215.213.111.464",
            "213.214.111.564",
            "444.444.444.444 not an ip address",
            "1234 not an ipv4 Address",
            "1111.1.1.1 Not an IPv5 Address"
        );
        String regexIpv4 = "^(([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$";
        String regexIpv6 = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
        Pattern p1 = Pattern.compile(regexIpv4);
        Pattern p2 = Pattern.compile(regexIpv6);
        for(String line: list) {
            Matcher m1 = p1.matcher(line);
            Matcher m2 = p2.matcher(line);
            if (m1.find()) {
                System.out.println("IPv4: " + line);
                continue;
            }
            if (m2.find()) {
                System.out.println("IPv6: " + line);
                continue;
            }
            System.out.println("Neither");
        }

    }
}
