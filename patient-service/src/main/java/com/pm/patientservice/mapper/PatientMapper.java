package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.PatientModel;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(PatientModel patientModel) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patientModel.getId().toString());
        patientResponseDTO.setName(patientModel.getName());
        patientResponseDTO.setAddress(patientModel.getAddress());
        patientResponseDTO.setEmail(patientModel.getEmail());
        patientResponseDTO.setDateOfBirth(patientModel.getDateOfBirth().toString());

        return patientResponseDTO;
    }

    public static PatientModel toModel(PatientRequestDTO patientRequestDTO) {
        PatientModel patient = new PatientModel();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;
    }
}
