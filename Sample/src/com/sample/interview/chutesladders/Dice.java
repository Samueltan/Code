package com.sample.interview.chutesladders;

import java.util.Random;

public class Dice {
    public static int go() {
        return new Random().nextInt(6) + 1;
    }
}
