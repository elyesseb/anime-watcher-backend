package com.simplon.safety.net.alerts.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ufhopla
 * on 27/04/2022.
 */

@Data
@AllArgsConstructor
@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String birthdate;

    @ElementCollection
    private List<String> medications = new ArrayList<>();

    @ElementCollection
    private List<String> allergies = new ArrayList<>();

    public MedicalRecord() {
    }

}
