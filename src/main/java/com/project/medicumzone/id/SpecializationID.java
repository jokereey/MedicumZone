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
public class SpecializationID implements Serializable {
    @Column(name="doctor_specialization_id")
    private Long doctorSpecializationId;
    @Column(name="doctor_id")
    private Long doctorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecializationID that = (SpecializationID) o;
        return Objects.equals(doctorSpecializationId, that.doctorSpecializationId) && Objects.equals(doctorId, that.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorSpecializationId, doctorId);
    }
}
