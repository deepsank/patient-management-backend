package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.PatientModel;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) { // Dependency Injection (No need of new keyword
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<PatientModel> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO registerPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email already exists " + patientRequestDTO.getEmail());
        }

        PatientModel newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO modifyPatient(UUID id, PatientRequestDTO patientRequestDTO) {
        PatientModel patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with the ID: " + id));

        /* Method-1- This condition is to not allow anybody else's registered Email ID while modifying. */
//        if(!patient.getEmail().equals(patientRequestDTO.getEmail())){
//            if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
//                throw new EmailAlreadyExistsException("A patient with this email already exists " + patientRequestDTO.getEmail());
//            }
//        }
//        OR
        /* Method-2- This condition is to not allow anybody else's registered Email ID while modifying. */
        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)) {
                throw new EmailAlreadyExistsException("A patient with this email already exists " + patientRequestDTO.getEmail());
            }
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        PatientModel updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }

    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }

}
