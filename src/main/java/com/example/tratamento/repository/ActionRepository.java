package com.example.tratamento.repository;

import com.example.tratamento.model.instruction.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends MongoRepository<Action, String> {
}
