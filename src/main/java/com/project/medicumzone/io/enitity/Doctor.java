package com.project.medicumzone.io.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Doctor implements Serializable {

    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "doctor_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String name;
    private String surname;

    @OneToMany(targetEntity = Specialization.class, fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH})
    List<Specialization> specializations = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name="clinic_id",nullable = false,referencedColumnName = "clinicId",foreignKey =@ForeignKey(name="clinic_fk"))
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor",cascade = {CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor")
    @Fetch(FetchMode.SUBSELECT)
    private List<DoctorRatio> ratios = new ArrayList<>();

    @OneToMany(orphanRemoval = true,targetEntity = DoctorSchedule.class,fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<DoctorSchedule> clinicSchedules=  new HashSet<>();

    public Doctor(String name, String surname, Clinic clinic) {
        this.name = name;
        this.surname = surname;
        this.clinic = clinic;
    }

    public Doctor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id);
    }

    public Doctor(String name, String surname, List<Specialization> specializations, Clinic clinic) {
        this.name = name;
        this.surname = surname;
        this.specializations = specializations;
        this.clinic = clinic;
    }

    public Doctor(String name, String surname, List<Specialization> specializations, Clinic clinic, List<Appointment> appointments, List<DoctorRatio> ratios, Set<DoctorSchedule> clinicSchedules) {
        this.name = name;
        this.surname = surname;
        this.specializations = specializations;
        this.clinic = clinic;
        this.appointments = appointments;
        this.ratios = ratios;
        this.clinicSchedules = clinicSchedules;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
