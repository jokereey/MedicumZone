package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
