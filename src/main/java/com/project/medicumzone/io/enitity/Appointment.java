package com.project.medicumzone.io.enitity;


import com.project.medicumzone.io.id.AppointmentID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
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

    @MapsId("appointmentDate")
    private LocalDateTime appointmentDate;

    public Appointment(Doctor doctor, AppUser appUser, Clinic clinic, LocalDateTime appointmentDate) {
        this.doctor = doctor;
        this.appUser = appUser;
        this.clinic = clinic;
        this.appointmentDate = appointmentDate;
        this.appointmentID = new AppointmentID(doctor.getId(),appUser.getId(),clinic.getClinicId(),appointmentDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentID, that.appointmentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentID);
    }
}
