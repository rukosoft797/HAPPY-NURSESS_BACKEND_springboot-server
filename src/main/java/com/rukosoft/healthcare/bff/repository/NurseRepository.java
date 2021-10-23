package com.rukosoft.healthcare.bff.repository;

import com.rukosoft.healthcare.bff.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
