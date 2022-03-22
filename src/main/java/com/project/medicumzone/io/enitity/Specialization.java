package com.project.medicumzone.io.enitity;

import com.project.medicumzone.io.id.SpecializationID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {

    @EmbeddedId
    private SpecializationID specializationID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctorId")
    @JoinColumn(name="doctor_id",
            foreignKey =@ForeignKey(name="doctor_id_fk")
    )
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("doctorSpecializationId")
    @JoinColumn(name="doctorSpecialization_id",foreignKey =@ForeignKey(name="specialization_id_fk") )
    private DoctorSpecialization doctorSpecialization;

    public Specialization(Doctor doctor, DoctorSpecialization doctorSpecialization) {
        this.doctor = doctor;
        this.doctorSpecialization = doctorSpecialization;
    }

    public Specialization(SpecializationID specializationID) {
        this.specializationID = specializationID;
    }

    public void setSpecializationID(SpecializationID specializationID) {
        this.specializationID = specializationID;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public SpecializationID getSpecializationID() {
        return specializationID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public DoctorSpecialization getDoctorSpecialization() {
        return doctorSpecialization;
    }
}
