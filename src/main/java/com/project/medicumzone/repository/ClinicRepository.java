package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long> {
    Optional<Clinic> findClinicByClinicNameEquals(String clinicName);
}
