package com.project.medicumzone.io.enitity;


import com.project.medicumzone.io.id.AppointmentID;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Appointment {

    @EmbeddedId
    private AppointmentID appointmentID;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name= "doctor_id", nullable = false,foreignKey = @ForeignKey(name="appointment_doctor_id_fk"))
    private Doctor doctor;

    @ManyToOne
    @MapsId("appUserId")
    @JoinColumn(name = "app_user_id", nullable = false,foreignKey = @ForeignKey(name="appointment_user_id_fk"))
    private AppUser appUser;

    @ManyToOne
    @MapsId("clinicId")
    @JoinColumn(name = "clinic_id", nullable = false,foreignKey = @ForeignKey(name="appointment_clinic_id_fk"))
    private Clinic clinic;

    private LocalDateTime appointmentDate;
}
