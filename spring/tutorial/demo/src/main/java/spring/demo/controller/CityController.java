package spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.demo.model.City;
import spring.demo.service.ICityService;

import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    ICityService cityService;

    @RequestMapping(path="/")
    public String index() {
        return "index";
    }

    @RequestMapping(path="/getCities", produces="application/json; charset=UTF-8")
    @ResponseBody
    public List<City> findCities() {
        return cityService.findAll();
    }
}
