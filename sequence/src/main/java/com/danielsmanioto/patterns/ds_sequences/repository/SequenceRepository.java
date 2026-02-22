package com.danielsmanioto.patterns.ds_sequences.repository;


import com.danielsmanioto.patterns.ds_sequences.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRepository extends JpaRepository<Sequence, String> {}