package com.rukosoft.healthcare.bff.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class TreatmentPlan {
    @Id
    @SequenceGenerator(
            name = "treatment_plan_sequence",
            sequenceName = "treatment_plan_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "treatment_plan_sequence"
    )
    @Column(
            name = "TREATMENT_PLAN_ID",
            updatable = false,
            columnDefinition = "bigint default next value for treatment_plan_sequence"
    )
    private Long treatmentPlanId;

    private  Long patientId;
    private  Long primaryNurseId;
    private  String planName;
    private  int numberOfVisitPlan;
    private  int numberOfVisitDone;
    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private  String frequency;

    private Date startTreatment;
    private Date endTreatment;

}
