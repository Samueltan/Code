package com.sample.interview.hackerrank;

import java.security.*;

public class MD5Digest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String message = "HelloWorld";
        MessageDigest md = MessageDigest.getInstance("MD5");

        //Passing data to the created MessageDigest Object
        md.update(message.getBytes());

        //Compute the message digest
        byte[] digest = md.digest();

        System.out.println();
        for (int i = 0;i<digest.length;i++) {
            System.out.printf("%02x", digest[i]);
        }
    }
}