package com.project.medicumzone.model.enitity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class City {
    @Id
    private Long id;
    private String name;
}
