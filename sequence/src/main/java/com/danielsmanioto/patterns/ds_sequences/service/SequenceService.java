package com.danielsmanioto.patterns.ds_sequences.service;


import com.danielsmanioto.patterns.ds_sequences.model.Sequence;
import com.danielsmanioto.patterns.ds_sequences.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SequenceService {

    @Autowired
    private SequenceRepository repository;

    @Transactional
    public synchronized long getNext(String name) {
        Sequence seq = repository.findById(name).orElse(new Sequence(name, 0));
        long next = seq.getValue() + 1;
        seq.setValue(next);
        repository.save(seq);
        return next;
    }
}