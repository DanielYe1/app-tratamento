package com.example.tratamento.model.instruction;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Instruction {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private List<String> narratives;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public List<String> getNarratives() {
        return narratives;
    }
}
