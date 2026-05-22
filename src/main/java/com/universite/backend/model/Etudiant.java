package com.universite.backend.model;

//package com.universite.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ine;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String formation;
    private String promo;
}