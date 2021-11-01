package com.project.medicumzone.model.enitity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class DoctorSpecialization {
    @Id
    @SequenceGenerator(
            name = "doc_spec_sequence",
            sequenceName = "doc_spec_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "doc_spec_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "doctorSpecialization",cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<Specialization> specializations = new ArrayList<>();

    public DoctorSpecialization(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
