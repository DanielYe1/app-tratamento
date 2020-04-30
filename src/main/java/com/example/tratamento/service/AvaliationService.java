package com.example.tratamento.service;

import com.example.tratamento.model.avaliation.Avaliation;
import com.example.tratamento.repository.AvaliationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliationService {

    @Autowired
    AvaliationRepository avaliationRepository;

    public Avaliation add(Avaliation avaliation){
        Avaliation inserted = avaliationRepository.insert(avaliation);
        return inserted;
    }

    public boolean delete(String id) {
        boolean exists = avaliationRepository.existsById(id);
        if (exists) {
            avaliationRepository.deleteById(id);
        }
        return exists;
    }

    public boolean update(String id, Avaliation avaliation) {
        boolean exists = avaliationRepository.existsById(id);
        if (exists) {
            avaliation.setId(id);
            avaliationRepository.save(avaliation);

        }
        return exists;
    }

    public Optional<Avaliation> findById(String id) {
        return avaliationRepository.findById(id);
    }

    public List<Avaliation> findAll(){
        return avaliationRepository.findAll();
    }

}
