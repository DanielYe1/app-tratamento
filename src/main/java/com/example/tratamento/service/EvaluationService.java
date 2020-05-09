package com.example.tratamento.service;

import com.example.tratamento.model.evaluation.Evaluation;
import com.example.tratamento.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {

    @Autowired
    EvaluationRepository evaluationRepository;

    public Evaluation add(Evaluation evaluation){
        Evaluation inserted = evaluationRepository.insert(evaluation);
        return inserted;
    }

    public boolean delete(String id) {
        boolean exists = evaluationRepository.existsById(id);
        if (exists) {
            evaluationRepository.deleteById(id);
        }
        return exists;
    }

    public boolean update(String id, Evaluation evaluation) {
        boolean exists = evaluationRepository.existsById(id);
        if (exists) {
            evaluation.setId(id);
            evaluationRepository.save(evaluation);

        }
        return exists;
    }

    public Optional<Evaluation> findById(String id) {
        return evaluationRepository.findById(id);
    }

    public List<Evaluation> findAll(){
        return evaluationRepository.findAll();
    }

}
