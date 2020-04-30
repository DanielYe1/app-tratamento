package com.example.tratamento.model.observation;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Observation {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private List<Event> events;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public Observation(String patientId, String doctorId, List<Event> events) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.events = events;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public List<Event> getEvents() {
        return events;
    }
}
