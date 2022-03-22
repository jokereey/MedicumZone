package com.project.medicumzone.io.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
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

    @OneToMany(mappedBy = "doctorSpecialization",fetch = FetchType.LAZY)
    private List<Specialization> specializations = new ArrayList<>();

    public DoctorSpecialization(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }
}
