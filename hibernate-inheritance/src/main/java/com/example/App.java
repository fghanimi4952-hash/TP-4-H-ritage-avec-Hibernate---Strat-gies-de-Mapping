package com.example;

import com.example.model.singletable.*;
import com.example.model.joined.*;
import com.example.model.tableperclass.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-inheritance");

        try {
            System.out.println("\n=== TEST SINGLE_TABLE ===");
            testSingleTable(emf);

            System.out.println("\n=== TEST JOINED ===");
            testJoined(emf);

            System.out.println("\n=== TEST TABLE_PER_CLASS ===");
            testTablePerClass(emf);

        } finally {
            emf.close();
        }
    }

    private static void testSingleTable(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Voiture v1 = new Voiture("Renault", "Clio", LocalDate.of(2020,5,15),15000.0,5,true,"Essence");
        Moto m1 = new Moto("Honda", "CBR", LocalDate.of(2021,7,20),12000.0,600,"Manuelle");

        em.persist(v1);
        em.persist(m1);

        em.getTransaction().commit();
        System.out.println("SINGLE_TABLE : véhicules enregistrés.");

        List<Vehicule> vehicules = em.createQuery("FROM Vehicule", Vehicule.class).getResultList();
        vehicules.forEach(System.out::println);
        em.close();
    }

    private static void testJoined(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Developpeur d1 = new Developpeur("Sophie", "Martin", "sophie@ex.com", LocalDate.of(2020,3,10),
                "Java", "Backend", 3);
        Manager m1 = new Manager("Pierre", "Dubois", "pierre@ex.com", LocalDate.of(2018,7,20),
                "IT", 10, 5000.0);

        em.persist(d1);
        em.persist(m1);
        em.getTransaction().commit();
        System.out.println("JOINED : employés enregistrés.");

        List<Employe> employes = em.createQuery("FROM Employe", Employe.class).getResultList();
        employes.forEach(System.out::println);
        em.close();
    }

    private static void testTablePerClass(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Livre l1 = new Livre("Harry Potter", 19.99, "Roman magique",
                "J.K. Rowling", "978-2070643028", 800, "Gallimard");
        Electronique e1 = new Electronique("iPhone 15", 1200.0, "Téléphone haut de gamme",
                "Apple", "15 Pro", 24, "256Go");

        em.persist(l1);
        em.persist(e1);
        em.getTransaction().commit();
        System.out.println("TABLE_PER_CLASS : produits enregistrés.");

        List<Produit> produits = em.createQuery("FROM Produit", Produit.class).getResultList();
        produits.forEach(System.out::println);
        em.close();
    }
}
