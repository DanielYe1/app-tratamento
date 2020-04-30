package com.example.tratamento.service;

import com.example.tratamento.model.instruction.Action;
import com.example.tratamento.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    @Autowired
    ActionRepository actionRepository;

    public Action add(Action action){
        Action inserted = actionRepository.insert(action);
        return inserted;
    }

    public boolean delete(String id) {
        boolean exists = actionRepository.existsById(id);
        if (exists) {
            actionRepository.deleteById(id);
        }
        return exists;
    }

    public boolean update(String id, Action action) {
        boolean exists = actionRepository.existsById(id);
        if (exists) {
            action.setId(id);
            actionRepository.save(action);

        }
        return exists;
    }

    public Optional<Action> findById(String id) {
        return actionRepository.findById(id);
    }

    public List<Action> findAll(){
        return actionRepository.findAll();
    }

}
