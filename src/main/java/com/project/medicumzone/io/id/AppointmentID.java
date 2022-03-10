package com.project.medicumzone.io.id;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AppointmentID implements Serializable {

    @Column(name="doctor_id")
    private Long doctorId;

    @Column(name ="appUser_id")
    private Long appUserId;

    @Column(name = "clinic_id")
    private Long clinicId;


}
