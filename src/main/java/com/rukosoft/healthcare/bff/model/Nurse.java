package com.rukosoft.healthcare.bff.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/*
    dob: Date;
    created_at: Date;
    updated_at: Date;
    created_by: string;
    updated_by: string;

 */
@Data
@Entity
public class Nurse {
    @Id
    @SequenceGenerator(
            name = "nurse_sequence",
            sequenceName = "nurse_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "nurse_sequence"
    )
    @Column(
            name = "NURSE_ID",
            updatable = false,
            columnDefinition = "bigint default next value for nurse_sequence"
    )
    private Long nurseId;

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

    private Date dob;

    @Column(
            columnDefinition = "int default 0"
    )
    private Integer numberOfPatients;

    @Column(
            columnDefinition = "VARCHAR(30)"
    )
    private String createdBy;

    @Column(
            columnDefinition = "datetime2 default CURRENT_TIMESTAMP"
    )
    private Date createdAt;

    @Column(
            columnDefinition = "VARCHAR(30)"
    )
    private String updatedBy;
    @Column(
            columnDefinition = "datetime2 default CURRENT_TIMESTAMP"
    )
    private Date updatedAt;
}
