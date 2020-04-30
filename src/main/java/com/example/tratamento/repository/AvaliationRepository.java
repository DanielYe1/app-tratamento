package com.example.tratamento.repository;

import com.example.tratamento.model.avaliation.Avaliation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliationRepository extends MongoRepository<Avaliation, String> {
}
