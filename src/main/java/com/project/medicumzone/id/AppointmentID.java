package com.project.medicumzone.id;

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
public class AppointmentID implements Serializable {

    @Column(name="doctor_id")
    private Long doctorId;

    @Column(name ="client_id")
    private Long clientId;

    @Column(name = "clinic_id")
    private Long clinicId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentID that = (AppointmentID) o;
        return Objects.equals(doctorId, that.doctorId) && Objects.equals(clientId, that.clientId) && Objects.equals(clinicId, that.clinicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, clientId, clinicId);
    }
}
