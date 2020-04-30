package com.example.tratamento.controller;

import com.example.tratamento.model.avaliation.Avaliation;
import com.example.tratamento.service.AvaliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/avaliation")
public class AvaliationController {

    @Autowired
    AvaliationService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listAll(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveAvaliation(@RequestBody Avaliation avaliation) {
        Avaliation added = service.add(avaliation);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity searchAvaliation(@PathVariable("id") String avaliationId) {
        Optional<Avaliation> avaliation = service.findById(avaliationId);
        if (avaliation.isPresent()) {
            return new ResponseEntity<Avaliation>(avaliation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Avaliation>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateAvaliation(@PathVariable("id") String id, @RequestBody Avaliation avaliation) {
        if (service.update(id, avaliation)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAvaliation(@PathVariable("id") String avaliationId) {
        if (service.delete(avaliationId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
