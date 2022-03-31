package com.project.medicumzone.io.enitity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.medicumzone.io.id.AppointmentID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {

    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "appointment_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @ManyToOne
//    @JoinColumn(name= "doctor_id", nullable = false,foreignKey = @ForeignKey(name="appointment_doctor_id_fk"))
    private Doctor doctor;

    @ManyToOne
//    @JoinColumn(name = "app_user_id", nullable = false,foreignKey = @ForeignKey(name="appointment_user_id_fk"))
    private AppUser appUser;

    @ManyToOne
//    @JoinColumn(name = "clinic_id", nullable = false,foreignKey = @ForeignKey(name="appointment_clinic_id_fk"))
    private Clinic clinic;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime appointmentDate;

    public Appointment(Doctor doctor, AppUser appUser, Clinic clinic, LocalDateTime appointmentDate) {
        this.doctor = doctor;
        this.appUser = appUser;
        this.clinic = clinic;
        this.appointmentDate = appointmentDate;

    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }
}
