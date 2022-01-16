package com.project.medicumzone.io.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Clinic")
@Table(name = "clinic")
@NoArgsConstructor
@Getter
@Setter
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

    @Column(name = "clinic_name", nullable = false)
    private String clinicName;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "zip_code")
    private String zipCode;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="city_id",nullable = false,referencedColumnName = "id",foreignKey =@ForeignKey(name="city_fk"))
    private City city;

    @OneToMany(mappedBy = "clinic",cascade = CascadeType.PERSIST)
    private List<Doctor> availableDoctors = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},mappedBy = "clinic")
    private List<Appointment> appointments = new ArrayList<>();

    public Clinic(String clinicName, String streetName, String zipCode, City city) {
        this.clinicName = clinicName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }
}
