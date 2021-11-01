package com.project.medicumzone.model.enitity;


import com.project.medicumzone.id.AppointmentID;

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
    @MapsId("clientId")
    @JoinColumn(name = "client_id", nullable = false,foreignKey = @ForeignKey(name="appointment_client_id_fk"))
    private Client client;

    @ManyToOne
    @MapsId("clinicId")
    @JoinColumn(name = "clinic_id", nullable = false,foreignKey = @ForeignKey(name="appointment_clinic_id_fk"))
    private Clinic clinic;

    private LocalDateTime dateTime;
}
