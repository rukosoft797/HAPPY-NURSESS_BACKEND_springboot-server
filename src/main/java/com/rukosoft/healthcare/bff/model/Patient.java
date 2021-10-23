package com.rukosoft.healthcare.bff.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Patient {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    @Column(
            name = "PATIENT_ID",
            updatable = false,
            columnDefinition = "bigint default next value for patient_sequence"
    )
    private Long patientId;

    @Column(
            name = "first_name",
            columnDefinition = "VARCHAR(40)"
    )
    private String firstName;


    @Column(
            name = "last_name",
            columnDefinition = "VARCHAR(40)"
    )
    private String lastName;

    private Date DOB;

    private Long primaryNurseId;
}
