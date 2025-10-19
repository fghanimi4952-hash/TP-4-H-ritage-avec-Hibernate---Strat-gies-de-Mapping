package com.example.model.singletable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehicules")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_vehicule", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String marque;
    @NotBlank private String modele;
    @NotNull @PastOrPresent private LocalDate anneeFabrication;
    @NotNull @Positive private Double prix;

    public Vehicule() {}
    public Vehicule(String marque, String modele, LocalDate anneeFabrication, Double prix) {
        this.marque = marque;
        this.modele = modele;
        this.anneeFabrication = anneeFabrication;
        this.prix = prix;
    }

    public Long getId() { return id; }
    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public LocalDate getAnneeFabrication() { return anneeFabrication; }
    public Double getPrix() { return prix; }

    @Override
    public String toString() {
        return "Vehicule{" + "id=" + id + ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' + ", anneeFabrication=" + anneeFabrication +
                ", prix=" + prix + '}';
    }
}
