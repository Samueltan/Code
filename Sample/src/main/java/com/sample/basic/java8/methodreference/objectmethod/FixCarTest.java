package com.sample.basic.java8.methodreference.objectmethod;

import java.util.function.Consumer;

public class FixCarTest {
    public void execute(
            Car car,
            Consumer<Car> c
    )
    {
        c.accept(car);
    }

    public static void main(String[] args) {
        final Mechanic mechanic = new Mechanic();
        Car car = new Car(8);

        FixCarTest fct = new FixCarTest();

        // Using an anonymous class
        fct.execute(
                car,
                new Consumer<Car>() {
                    public void accept(Car c) {
                        mechanic.fix(c);
                    }
                }
        );

        fct.execute(
                car,
                c -> mechanic.fix(c)
        );

        fct.execute(car, mechanic::fix);
    }
}
