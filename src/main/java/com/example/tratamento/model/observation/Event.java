package com.example.tratamento.model.observation;

import java.util.Date;
import java.util.List;

public class Event {
    private Date date;
    private List<String> data;
    private String state;

    public Date getDate() {
        return date;
    }

    public List<String> getData() {
        return data;
    }

    public String getState() {
        return state;
    }
}
