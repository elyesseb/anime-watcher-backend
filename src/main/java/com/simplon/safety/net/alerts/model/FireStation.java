package com.simplon.safety.net.alerts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@Data
@AllArgsConstructor
@Entity
public class FireStation {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String address;

    private String station;

    public FireStation() {}
}
