package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.PatientValidatorGroup;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name="Patient", description="API for managing patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {  //Dependency Injection
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Fetch all Patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "Register a new Patient")
    public ResponseEntity<PatientResponseDTO> registerPatient(@Validated({Default.class, PatientValidatorGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO newPatientResponseDTO = patientService.registerPatient(patientRequestDTO);
        return ResponseEntity.ok().body(newPatientResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modify an existing Patient")
    public ResponseEntity<PatientResponseDTO> modifyPatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO modifiedPatientResponseDTO = patientService.modifyPatient(id, patientRequestDTO);
        return ResponseEntity.ok().body(modifiedPatientResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing Patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
