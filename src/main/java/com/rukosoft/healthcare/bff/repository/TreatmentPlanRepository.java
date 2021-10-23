package com.rukosoft.healthcare.bff.repository;

import com.rukosoft.healthcare.bff.model.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Long> {
}
