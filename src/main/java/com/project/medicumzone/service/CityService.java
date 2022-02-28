package com.project.medicumzone.service;

import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCities(){
        return  cityRepository.findAll();


    }
}
