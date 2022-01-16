package com.project.medicumzone.io.enitity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Doctor {

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

    @OneToMany(mappedBy = "doctor",cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<Specialization> specializations = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="clinic_id",nullable = false,referencedColumnName = "clinicId",foreignKey =@ForeignKey(name="clinic_fk"))
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(String name, String surname, Clinic clinic) {
        this.name = name;
        this.surname = surname;
        this.clinic = clinic;
    }

    public Doctor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Doctor(String name, String surname, List<Specialization> specializations) {
        this.name = name;
        this.surname = surname;
        this.specializations = specializations;
    }
}
