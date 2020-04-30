package com.example.tratamento.controller;

import com.example.tratamento.model.instruction.Instruction;
import com.example.tratamento.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instruction")
public class InstructionController {

    @Autowired
    InstructionService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listAll(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveInstruction(@RequestBody Instruction instruction) {
        Instruction added = service.add(instruction);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity searchInstruction(@PathVariable("id") String instructionId) {
        Optional<Instruction> instruction = service.findById(instructionId);
        if (instruction.isPresent()) {
            return new ResponseEntity<Instruction>(instruction.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Instruction>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateInstruction(@PathVariable("id") String id, @RequestBody Instruction instruction) {
        if (service.update(id, instruction)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteInstruction(@PathVariable("id") String instructionId) {
        if (service.delete(instructionId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
