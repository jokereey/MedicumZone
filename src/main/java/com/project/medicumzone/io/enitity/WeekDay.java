package com.project.medicumzone.io.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class WeekDay implements Serializable {
    @Id
    @SequenceGenerator(
            name = "weekday_sequence",
            sequenceName = "weekday_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "weekday_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(name = "day")
    private String dayName;

    public WeekDay(String dayName) {
        this.dayName = dayName;
    }
}
