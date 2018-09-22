package com.sample.designpattern.visitor.pharmacy;

public class Charger extends Visitor{

    public void visit(MedicineA a) {
        System.out.println("划价员：" + name +"给药" + a.getName() +"划价:" + a.getPrice());
    }

    public void visit(MedicineB b) {
        System.out.println("划价员：" + name +"给药" + b.getName() +"划价:" + b.getPrice());
    }

}