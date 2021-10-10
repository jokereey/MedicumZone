package com.project.medicumzone.controller;

import com.project.medicumzone.model.enitity.City;
import com.project.medicumzone.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CityController {

    private final CityService cityService;
    @GetMapping(path ="/api/cities")
    public List<City> getCities(){
        return cityService.getAllCities();
    }
}
