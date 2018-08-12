package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
@Configuration
public class DemoApplication {

	@RequestMapping("hello")
	public String hello() {
		return "Hello world! I am back.";
	}

    @RequestMapping("/user")
    public Map getUsers() {
        Map map = new HashMap<>();
        map.put("name","fangxiao");
        map.put("age","15");
        return map;
    }

	@Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
	    return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

	public static void main(String[] args) {
		SpringApplication springApp = new SpringApplication(DemoApplication.class);
		springApp.setBannerMode(Banner.Mode.OFF);
		springApp.run(args);
	}
}
