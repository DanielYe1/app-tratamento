package com.example.tratamento.controller;

import com.example.tratamento.model.evaluation.Evaluation;
import com.example.tratamento.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService service;

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
    public ResponseEntity listAllByDoctorId(@PathVariable("id") String doctorId) {
        return new ResponseEntity(service.findAllByDoctorId(doctorId), HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public ResponseEntity listAllByPatientId(@PathVariable("id") String patientId) {
        return new ResponseEntity(service.findAllByPatientId(patientId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation added = service.add(evaluation);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity searchEvaluation(@PathVariable("id") String evaluationId) {
        Optional<Evaluation> evaluation = service.findById(evaluationId);
        if (evaluation.isPresent()) {
            return new ResponseEntity<Evaluation>(evaluation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Evaluation>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateEvaluation(@PathVariable("id") String id, @RequestBody Evaluation evaluation) {
        if (service.update(id, evaluation)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEvaluation(@PathVariable("id") String evaluationId) {
        if (service.delete(evaluationId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
