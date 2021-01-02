package com.sample.designpattern.visitor.pharmacy;

public class Client {
    public static void main(String[] args) {
        Medicine a = new MedicineA("板蓝根", 11.0);
        Medicine b = new MedicineB("感康", 14.3);

        Prescription prescription = new Prescription();
        prescription.addMedicine(a);
        prescription.addMedicine(b);

        Visitor charger = new Charger();
        charger.setName("张三");

        Visitor workerOfPharmacy = new WorkerOfPharmacy();
        workerOfPharmacy.setName("李四");

        prescription.accept(charger);
        System.out.println("-------------------------------------");
        prescription.accept(workerOfPharmacy);
    }

}