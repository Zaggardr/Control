package com.example.gestion.controllers;

import com.example.gestion.models.Fournisseur;
import com.example.gestion.models.Produit;
import com.example.gestion.repositories.FournisseurRepository;
import com.example.gestion.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping("fournisseurs/produits/{id}")
    public String geetProduits(@PathVariable("id") Long id, Model model) {
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);

        return "produits";

    }
    @GetMapping("/newp")
    public String showPage(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        model.addAttribute("fournisseurs", fournisseurRepository.findAll());
        return "add-produit";
    }
    @PostMapping("/newpp")
    public String addProduit(@Validated Produit produit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return"add-produit";
        }

        produitRepository.save(produit);


        return "index";
    }

}
