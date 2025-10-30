package com.danielsmanioto.patterns.ds_sequences.controller;

import com.danielsmanioto.patterns.ds_sequences.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sequences")
public class SequenceController {

    @Autowired
    private SequenceService service;

    @PostMapping("/{name}/next")
    public long getNext(@PathVariable String name) {
        return service.getNext(name);
    }
}
