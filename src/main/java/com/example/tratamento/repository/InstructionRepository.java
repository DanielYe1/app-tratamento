package com.example.tratamento.repository;

import com.example.tratamento.model.instruction.Instruction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends MongoRepository<Instruction, String> {
}
