package com.project.medicumzone.model.enitity;

import com.project.medicumzone.id.SpecializationID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class Specialization {

    @EmbeddedId
    private SpecializationID specializationID;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name="doctor_id",
            foreignKey =@ForeignKey(name="doctor_id_fk")
    )
    private Doctor doctor;

    @ManyToOne
    @MapsId("doctorSpecializationId")
    @JoinColumn(name="doctorSpecialization_id",foreignKey =@ForeignKey(name="specialization_id_fk") )
    private DoctorSpecialization doctorSpecialization;

}
