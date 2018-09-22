package com.sample.designpattern.bridge;

import com.sample.designpattern.bridge.color.GreenColor;
import com.sample.designpattern.bridge.color.RedColor;
import com.sample.designpattern.bridge.color.YellowColor;
import com.sample.designpattern.bridge.shape.Pentagon;
import com.sample.designpattern.bridge.shape.Shape;
import com.sample.designpattern.bridge.shape.Square;
import com.sample.designpattern.bridge.shape.Triangle;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redTriangle = new Triangle(new RedColor());
        redTriangle.applyColor();

        Shape greenPentagon = new Pentagon(new GreenColor());
        greenPentagon.applyColor();

        Shape yellowSquare = new Square(new YellowColor());
        yellowSquare.applyColor();
    }
}