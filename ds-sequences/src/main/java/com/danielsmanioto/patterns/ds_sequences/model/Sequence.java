package com.danielsmanioto.patterns.ds_sequences.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"sequence\"")
public class Sequence {
    @Id
    private String name;

    private long value;

    public Sequence() {}

    public Sequence(String name, long value) {
        this.name = name;
        this.value = value;
    }

    // getters e setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }
}
