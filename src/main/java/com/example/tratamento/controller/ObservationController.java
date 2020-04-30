package com.example.tratamento.controller;

import com.example.tratamento.model.observation.Observation;
import com.example.tratamento.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/observation")
public class ObservationController {

    @Autowired
    ObservationService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listAll(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveObservation(@RequestBody Observation observation) {
        Observation added = service.add(observation);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity searchObservation(@PathVariable("id") String observationId) {
        Optional<Observation> observation = service.findById(observationId);
        if (observation.isPresent()) {
            return new ResponseEntity<Observation>(observation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Observation>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateObservation(@PathVariable("id") String id, @RequestBody Observation observation) {
        if (service.update(id, observation)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteObservation(@PathVariable("id") String observationId) {
        if (service.delete(observationId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
