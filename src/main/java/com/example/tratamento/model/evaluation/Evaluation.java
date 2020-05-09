package com.example.tratamento.model.evaluation;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Evaluation {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String medicalAnalysis;
    private Date date;

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

    public String getMedicalAnalysis() {
        return medicalAnalysis;
    }

    public Date getDate() {
        return date;
    }
}
