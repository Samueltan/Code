package com.sample.designpattern.visitor.pharmacy;

public class WorkerOfPharmacy extends Visitor{

    public void visit(MedicineA a) {
        System.out.println("药房工作者：" + name + "拿药 ：" + a.getName());
    }

    public void visit(MedicineB b) {
        System.out.println("药房工作者：" + name + "拿药 ：" + b.getName());
    }

}