package com.example.model.joined;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "employes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String nom;
    @NotBlank private String prenom;
    @Email private String email;
    @PastOrPresent private LocalDate dateEmbauche;

    public Employe() {}

    public Employe(String nom, String prenom, String email, LocalDate dateEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateEmbauche = dateEmbauche;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public LocalDate getDateEmbauche() { return dateEmbauche; }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                '}';
    }
}
