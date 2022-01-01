package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.DoctorSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization,Long> {
}
