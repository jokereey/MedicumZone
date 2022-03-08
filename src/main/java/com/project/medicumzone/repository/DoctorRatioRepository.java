package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.DoctorRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRatioRepository extends JpaRepository<DoctorRatio,Long> {
}
