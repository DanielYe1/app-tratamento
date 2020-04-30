package com.example.tratamento.service;

import com.example.tratamento.model.instruction.Instruction;
import com.example.tratamento.repository.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructionService {

    @Autowired
    InstructionRepository instructionRepository;

    public Instruction add(Instruction instruction){
        Instruction inserted = instructionRepository.insert(instruction);
        return inserted;
    }

    public boolean delete(String id) {
        boolean exists = instructionRepository.existsById(id);
        if (exists) {
            instructionRepository.deleteById(id);
        }
        return exists;
    }

    public boolean update(String id, Instruction instruction) {
        boolean exists = instructionRepository.existsById(id);
        if (exists) {
            instruction.setId(id);
            instructionRepository.save(instruction);

        }
        return exists;
    }

    public Optional<Instruction> findById(String id) {
        return instructionRepository.findById(id);
    }

    public List<Instruction> findAll(){
        return instructionRepository.findAll();
    }

}
