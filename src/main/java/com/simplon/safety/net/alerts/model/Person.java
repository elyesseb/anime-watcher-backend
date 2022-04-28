package com.simplon.safety.net.alerts.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@Data
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String zip;

    private String phone;

    private String email;

    @OneToOne
    @JoinColumn(referencedColumnName = "id" , name = "record_fk")
    private MedicalRecord medicalRecord;

    @Enumerated
    private Role role;

    public Person() {}

}
