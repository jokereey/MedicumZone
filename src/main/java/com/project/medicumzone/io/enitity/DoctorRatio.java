package com.project.medicumzone.io.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class DoctorRatio implements Serializable {

    @Id
    @SequenceGenerator(
            name = "ratio_sequence",
            sequenceName = "ratio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "ratio_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long ratioId;

    @NotNull
    private double ratioValue;

    @NotNull
    private String comment;

    private Long ratedBy;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id",foreignKey =@ForeignKey(name="ratio_id_fk"))
    @JsonIgnore
    private Doctor doctor;

}
