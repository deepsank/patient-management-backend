package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.PatientModel;

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
}
