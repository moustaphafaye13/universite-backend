package com.universite.backend.repository;

//package com.universite.backend.repository;

import com.universite.backend.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}