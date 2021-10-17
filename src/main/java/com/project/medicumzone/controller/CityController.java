package com.project.medicumzone.controller;

import com.project.medicumzone.model.enitity.City;
import com.project.medicumzone.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CityController {

    private final CityService cityService;
    @GetMapping(path ="/api/cities")
    public List<City> getCities(){

       return cityService.getAllCities();


    }
}
