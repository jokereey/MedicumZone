package com.project.medicumzone.ui.controller;

import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;
    @GetMapping
    public List<City> getCities(){

       return cityService.getAllCities();


    }
}
