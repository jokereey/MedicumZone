package com.project.medicumzone.repository;

import com.project.medicumzone.model.enitity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long> {


}
