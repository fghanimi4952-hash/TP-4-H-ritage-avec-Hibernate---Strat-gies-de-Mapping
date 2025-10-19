package com.example.model.singletable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("MOTO")
public class Moto extends Vehicule {
    @NotNull @Min(50) @Max(2000)
    private Integer cylindree;
    private String typeTransmission;

    public Moto() {}
    public Moto(String marque, String modele, LocalDate anneeFabrication, Double prix,
                Integer cylindree, String typeTransmission) {
        super(marque, modele, anneeFabrication, prix);
        this.cylindree = cylindree;
        this.typeTransmission = typeTransmission;
    }

    @Override
    public String toString() {
        return "Moto{" + "id=" + getId() + ", marque='" + getMarque() + '\'' +
                ", modele='" + getModele() + '\'' + ", prix=" + getPrix() +
                ", cylindree=" + cylindree + ", transmission='" + typeTransmission + '\'' + '}';
    }
}
