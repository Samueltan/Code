package com.tutorialspoint.config.java;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SpellChecker {
    public SpellChecker() {
//        System.out.println("Inside SpellChecker constructor.");
    }

    public void checkSpelling() {
        System.out.println("Inside checkSpelling.");
    }
}