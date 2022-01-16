package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    @Query(value = "SELECT c FROM City c WHERE c.name = ?1")
    Optional<City> selectCityByName(String cityName);
}
