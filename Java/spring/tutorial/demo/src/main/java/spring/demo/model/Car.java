package spring.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Car {
    private String color;
    private String type;

    public Car() {
    }

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }
}
