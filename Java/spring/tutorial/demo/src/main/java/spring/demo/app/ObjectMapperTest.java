package spring.demo.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import spring.demo.model.Car;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ObjectMapperTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");

        objectMapper.writeValue(new File("mycar.json"), car);
        System.out.println(objectMapper.writeValueAsString(car));

        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car car2 = objectMapper.readValue(json, Car.class);
        System.out.println(car2);

        Car car3 = objectMapper.readValue(new File("mycar.json"), Car.class);
        System.out.println(car3);

        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> cars = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});
        System.out.println(cars);

        String jsonMap = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, String> map = objectMapper.readValue(json, new TypeReference<Map<String, String>>() {});
        System.out.println(map);
    }
}
