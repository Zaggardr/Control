package com.example.gestion.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;
    private int quantiteDerniereCommande;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;


    public Produit() {
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setFournisseurId(long id) {
        this.fournisseur.setId(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }



    @Override
    public String toString() {
        return nom ;
    }

    public double calculMontantTotal() {
        double montantTotal = 0;
        List<Produit> produits = new ArrayList<Produit>();
        for( Produit p : produits )
            montantTotal += p.getPrix();

        return montantTotal;
    }

    public int getQuantiteDerniereCommande() {
        return quantiteDerniereCommande;
    }

    public void setQuantiteDerniereCommande(int quantiteDerniereCommande) {
        this.quantiteDerniereCommande = quantiteDerniereCommande;
    }
}

