package com.example.tratamento.repository;

import com.example.tratamento.model.evaluation.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends MongoRepository<Evaluation, String> {
    List<Evaluation> findAllByPatientId(String patientId);
    List<Evaluation> findAllByDoctorId(String doctorId);
}
