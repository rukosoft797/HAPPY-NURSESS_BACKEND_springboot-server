package com.rukosoft.healthcare.bff.rest;

import com.rukosoft.healthcare.bff.model.Patient;
import com.rukosoft.healthcare.bff.repository.PatientRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/patients")
public class PatientController {
    private final PatientRepository patientRepository;

    @GetMapping
    public List<Patient> findAll(){
        return patientRepository.findAll ();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById (id);
        if(!optionalPatient.isPresent ()){
            return ResponseEntity.unprocessableEntity ().build ();
        }
        return ResponseEntity.ok (optionalPatient.get ());
    }

    @PostMapping
    public ResponseEntity<Patient> create (@RequestBody Patient patient){
        Patient savedPatient = patientRepository.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}")
                .buildAndExpand (savedPatient.getPatientId ()).toUri ();
        System.out.println (location);
        return ResponseEntity.created (location).body (savedPatient);
    }
}
