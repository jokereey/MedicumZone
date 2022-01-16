package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.Appointment;
import com.project.medicumzone.io.id.AppointmentID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentID> {
}
