package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Appointment;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.id.AppointmentID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentID> {

    boolean existsByAppointmentDateAndDoctorAndClinic(LocalDateTime localDateTime, Doctor doctor, Clinic clinic);
}
