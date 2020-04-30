package com.example.tratamento.controller;

import com.example.tratamento.model.instruction.Action;
import com.example.tratamento.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    ActionService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listAll(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveAction(@RequestBody Action action) {
        Action added = service.add(action);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity searchAction(@PathVariable("id") String actionId) {
        Optional<Action> action = service.findById(actionId);
        if (action.isPresent()) {
            return new ResponseEntity<Action>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Action>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateAction(@PathVariable("id") String id, @RequestBody Action action) {
        if (service.update(id, action)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAction(@PathVariable("id") String actionId) {
        if (service.delete(actionId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
