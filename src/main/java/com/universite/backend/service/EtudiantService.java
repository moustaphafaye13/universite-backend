package com.universite.backend.service;

//package com.universite.backend.service;

import com.universite.backend.model.Etudiant;
import com.universite.backend.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository repository;

    public List<Etudiant> getAll() {
        return repository.findAll();
    }

    public Etudiant getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Etudiant save(Etudiant e) {
        return repository.save(e);
    }

    public Etudiant update(Long id, Etudiant e) {
        Etudiant exist = repository.findById(id).orElse(null);
        if (exist != null) {
            exist.setNom(e.getNom());
            exist.setPrenom(e.getPrenom());
            exist.setIne(e.getIne());
            exist.setDateNaissance(e.getDateNaissance());
            exist.setFormation(e.getFormation());
            exist.setPromo(e.getPromo());
            return repository.save(exist);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}