package com.sample.designpattern.visitor.pharmacy;

public class MedicineB extends Medicine{

    public MedicineB(String name, double price) {
        super(name, price);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}