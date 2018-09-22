package com.sample.designpattern.bridge.shape;

import com.sample.designpattern.bridge.color.Color;

public class Square extends Shape{

    public Square(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Square filled with color ");
        color.applyColor();
    }

}