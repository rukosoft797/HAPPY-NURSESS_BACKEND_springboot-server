package com.rukosoft.healthcare.bff.rest;

import com.rukosoft.healthcare.bff.model.TreatmentPlan;
import com.rukosoft.healthcare.bff.repository.TreatmentPlanRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/plans")
public class TreatmentPlanController {
    private final TreatmentPlanRepository treatmentPlanRepository;

    @GetMapping
    public List<TreatmentPlan> findAll(){
        return treatmentPlanRepository.findAll ();
    }
}
