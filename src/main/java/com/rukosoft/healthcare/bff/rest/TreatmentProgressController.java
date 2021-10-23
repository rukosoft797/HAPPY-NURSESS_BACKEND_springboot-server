package com.rukosoft.healthcare.bff.rest;

import com.rukosoft.healthcare.bff.model.TreatmentProgress;
import com.rukosoft.healthcare.bff.repository.TreatmentProgressRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/progress")
public class TreatmentProgressController {
    private final TreatmentProgressRepository treatmentProgressRepository;

    @GetMapping
    public List<TreatmentProgress> findAll(){
        return treatmentProgressRepository.findAll ();
    }
}
