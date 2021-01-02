package com.sample.basic.java8.methodreference.typemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

class Shipment {
    public double calculateWeight() {
        double weight = 0;
        // Calculate weight
        weight = ThreadLocalRandom.current().nextDouble(100);
        return weight;
    }

    public List<Double> calculateOnShipments(
            List<Shipment> l,
            Function<Shipment, Double> f
    )
    {
        List<Double> results = new ArrayList<>();
        for(Shipment s : l) {
            results.add(f.apply(s));
        }
        return results;
    }

    public static void main(String[] args) {
        Shipment shipment = new Shipment();

        List<Shipment> l = new ArrayList<Shipment>();
        l.add(new Shipment());
        l.add(new Shipment());

        // Using an anonymous class
        List<Double> list1 = shipment.calculateOnShipments(
            l,
            new Function<Shipment, Double>() {
                public Double apply(Shipment s) { // The object
                    return s.calculateWeight(); // The method
                }
            }
        );
        System.out.println("Using anonymous class:");
        list1.forEach(System.out::println);
        System.out.println();

        // Using a lambda expression
        List<Double> list2 = shipment.calculateOnShipments(l, s -> s.calculateWeight());
        System.out.println("\nUsing lambda expression:");
        list2.forEach(System.out::println);

        // Using a method reference
        List<Double> list3 = shipment.calculateOnShipments(l, Shipment::calculateWeight);
        System.out.println("\nUsing method reference:");
        list3.forEach(System.out::println);
    }
}