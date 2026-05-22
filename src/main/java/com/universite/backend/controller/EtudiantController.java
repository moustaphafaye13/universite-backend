package com.universite.backend.controller;

//package com.universite.backend.controller;

import com.universite.backend.model.Etudiant;
import com.universite.backend.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@CrossOrigin("*")
public class EtudiantController {

    @Autowired
    private EtudiantService service;

    @GetMapping
    public List<Etudiant> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Etudiant getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Etudiant add(@RequestBody Etudiant e) {
        return service.save(e);
    }

    @PutMapping("/{id}")
    public Etudiant update(@PathVariable Long id, @RequestBody Etudiant e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}