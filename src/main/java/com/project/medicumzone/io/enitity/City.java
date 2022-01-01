package com.project.medicumzone.io.enitity;

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
public class City {
    @Id

    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "city_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String name;
    @OneToMany(mappedBy = "city",cascade = CascadeType.PERSIST,fetch =FetchType.EAGER)
    private List<Clinic> clinics = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

}
