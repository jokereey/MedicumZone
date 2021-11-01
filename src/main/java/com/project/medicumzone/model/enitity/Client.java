package com.project.medicumzone.model.enitity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "client_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    private String name;

    private String surname;

    private String phoneNumber;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},mappedBy = "client")
    private List<Appointment> appointments = new ArrayList<>();

    public Client(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

}
