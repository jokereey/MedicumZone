package com.project.medicumzone.io.enitity;

import com.project.medicumzone.io.id.SpecializationID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
