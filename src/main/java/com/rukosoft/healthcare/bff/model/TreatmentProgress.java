package com.rukosoft.healthcare.bff.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class TreatmentProgress {
    @Id
    @SequenceGenerator(
            name = "treatment_progress_sequence",
            sequenceName = "treatment_progress_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "treatment_progress_sequence"
    )
    @Column(
            name = "TREATMENT_PROCESS_ID",
            updatable = false,
            columnDefinition = "bigint default next value for treatment_progress_sequence"
    )
    private Long treatmentProgressId;

    private Long treatmentPlanId;
    private  Long patientId;
    private  Long nurseId;
    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private  String procedureName;
    private  int visitNumber;

    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private  String frequency;

    private Date startProcess;
    private Date endProcess;
    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private String status;

    @Column(
            columnDefinition = "VARCHAR(30)"
    )
    private String createBy;

    @Column(
            columnDefinition = "datetime2 default CURRENT_TIMESTAMP"
    )
    private Date createDate;


}
