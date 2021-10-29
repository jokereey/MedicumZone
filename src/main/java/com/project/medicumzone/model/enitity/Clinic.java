package com.project.medicumzone.model.enitity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Clinic")
@Table(name = "clinic")
public class Clinic {
    @Id
    private Long clinicId;
    private City city;
}
