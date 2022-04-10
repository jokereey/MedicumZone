package com.project.medicumzone.io.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Clinic")
@Table(name = "clinic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Clinic {
    @Id
    @SequenceGenerator(
            name = "clinic_sequence",
            sequenceName = "clinic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "clinic_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long clinicId;

    @NotBlank
    @Column(name = "clinic_name", nullable = false)
    private String clinicName;

    @NotBlank
    @Column(name = "street_name")
    private String streetName;

    @NotBlank
    @Column(name = "zip_code")
    private String zipCode;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="city_id",nullable = false,referencedColumnName = "id",foreignKey =@ForeignKey(name="city_fk"))
    private City city;

    @OneToMany(mappedBy = "clinic",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private List<Doctor> availableDoctors = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},mappedBy = "clinic")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DoctorSchedule> doctorSchedules = new ArrayList();

    @Column(name = "start")
    private Integer openHour;

    @Column(name ="close")
    private Integer closeHour;

    //todo: implement clinic open hours

    public Clinic(String clinicName, String streetName, String zipCode, City city) {
        this.clinicName = clinicName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Clinic(Long clinicId, String clinicName, Integer openHour, Integer closeHour) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    public Clinic(String clinicName, String streetName, String zipCode, City city, List<Doctor> availableDoctors, List<Appointment> appointments, int openHour, int closeHour) {
        this.clinicName = clinicName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.availableDoctors = availableDoctors;
        this.appointments = appointments;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    public Clinic(String clinicName, String streetName, String zipCode, City city, int openHour, int closeHour) {
        this.clinicName = clinicName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(clinicId, clinic.clinicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clinicId);
    }
}
