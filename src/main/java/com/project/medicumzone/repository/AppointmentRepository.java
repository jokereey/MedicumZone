package com.project.medicumzone.repository;

import com.project.medicumzone.model.enitity.Appointment;
import com.project.medicumzone.id.AppointmentID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentID> {
}
