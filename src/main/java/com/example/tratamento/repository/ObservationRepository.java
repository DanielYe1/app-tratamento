package com.example.tratamento.repository;

import com.example.tratamento.model.observation.Observation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends MongoRepository<Observation, String> {
}
