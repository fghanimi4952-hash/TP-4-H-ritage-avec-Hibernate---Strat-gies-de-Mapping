package com.example.model.singletable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("VOITURE")
public class Voiture extends Vehicule {
    @NotNull @Min(2) @Max(5)
    private Integer nombrePortes;
    private Boolean climatisation;
    private String typeCarburant;

    public Voiture() {}
    public Voiture(String marque, String modele, LocalDate anneeFabrication, Double prix,
                   Integer nombrePortes, Boolean climatisation, String typeCarburant) {
        super(marque, modele, anneeFabrication, prix);
        this.nombrePortes = nombrePortes;
        this.climatisation = climatisation;
        this.typeCarburant = typeCarburant;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + getId() + ", marque='" + getMarque() + '\'' +
                ", modele='" + getModele() + '\'' + ", prix=" + getPrix() +
                ", portes=" + nombrePortes + ", clim=" + climatisation +
                ", carburant='" + typeCarburant + '\'' + '}';
    }
}
