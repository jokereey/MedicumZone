package com.project.medicumzone.io.enitity;

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

    private String clinicName;
    private String streetName;
    private String zipCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="city_id",nullable = false,referencedColumnName = "id",foreignKey =@ForeignKey(name="city_fk"))
    private City city;

    @OneToMany(mappedBy = "clinic",cascade = CascadeType.PERSIST)
    private List<Doctor> availableDoctors = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},mappedBy = "clinic")
    private List<Appointment> appointments = new ArrayList<>();

    public Clinic(String streetName, String zipCode, City city) {
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }

}
