package com.rukosoft.healthcare.bff.repository;

import com.rukosoft.healthcare.bff.model.TreatmentProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentProgressRepository extends JpaRepository<TreatmentProgress, Long> {
}
