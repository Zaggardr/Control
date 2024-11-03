
package com.example.gestion.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private float montantTotal;


    @ManyToOne
    private Fournisseur fournisseur;

    @ManyToMany
    private List<Produit> produits;


    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(float montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }


    public void calculateMontantTotal() {
        if (produits != null) {
            this.montantTotal = (float) produits.stream()
                    .mapToDouble(Produit::getPrix)
                    .sum();
        }
    }

}
