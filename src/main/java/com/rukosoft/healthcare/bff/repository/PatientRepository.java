package com.rukosoft.healthcare.bff.repository;

import com.rukosoft.healthcare.bff.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
