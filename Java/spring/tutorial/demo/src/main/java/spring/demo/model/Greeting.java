package spring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Greeting {
    @Getter private final long id;
    @Getter private final String content;
}
