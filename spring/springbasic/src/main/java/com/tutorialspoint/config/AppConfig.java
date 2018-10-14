package com.tutorialspoint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.tutorialspoint")
public class AppConfig {
    /**
     * All the below @Bean definitions could be removed if @ComponentScan is used and all beans are
     * marked with proper annotations (@Component, @Controller, @Service, etc.)
     */
//    @Bean
//    public HelloWorld helloWorld(){
//        return new HelloWorld();
//    }
//
//    @Bean
//    public TextEditor textEditor(){
//        return new TextEditor(spellChecker());
//    }
//
//    @Bean
//    public SpellChecker spellChecker(){
//        return new SpellChecker();
//    }
//
//    @Bean
//    public CStartEventHandler cStartEventHandler() {
//        return new CStartEventHandler();
//    }
//
//    @Bean
//    public CStopEventHandler cStopEventHandler() {
//        return new CStopEventHandler();
//    }
}
