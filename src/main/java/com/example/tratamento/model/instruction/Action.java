package com.example.tratamento.model.instruction;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Action {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String instructionId;
    private Date date;
    private String information;

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public Date getDate() {
        return date;
    }

    public String getInformation() {
        return information;
    }

    public void setId(String id) {
        this.id = id;
    }
}
