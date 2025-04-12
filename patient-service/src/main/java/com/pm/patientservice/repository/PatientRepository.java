package com.pm.patientservice.repository;

import com.pm.patientservice.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository  extends JpaRepository<PatientModel, UUID> {
}
