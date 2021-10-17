package com.project.medicumzone.model.enitity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public City(String name) {
        this.name = name;
    }
}
