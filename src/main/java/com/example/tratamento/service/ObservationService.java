package com.example.tratamento.service;

import com.example.tratamento.model.observation.Observation;
import com.example.tratamento.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;

    public Observation add(Observation observation){
        Observation inserted = observationRepository.insert(observation);
        return inserted;
    }

    public boolean delete(String id) {
        boolean exists = observationRepository.existsById(id);
        if (exists) {
            observationRepository.deleteById(id);
        }
        return exists;
    }

    public boolean update(String id, Observation observation) {
        boolean exists = observationRepository.existsById(id);
        if (exists) {
            observation.setId(id);
            observationRepository.save(observation);

        }
        return exists;
    }

    public Optional<Observation> findById(String id) {
        return observationRepository.findById(id);
    }

    public List<Observation> findAll(){
        return observationRepository.findAll();
    }

}
