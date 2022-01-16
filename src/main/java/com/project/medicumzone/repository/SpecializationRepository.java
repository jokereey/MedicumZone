package com.project.medicumzone.repository;

import com.project.medicumzone.io.id.SpecializationID;
import com.project.medicumzone.io.enitity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository  extends JpaRepository<Specialization, SpecializationID> {
}
