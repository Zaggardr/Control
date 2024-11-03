
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FournisseurController {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public FournisseurController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/fournisseurs")
    public String detailFournisseur( Model model) {
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        model.addAttribute("fournisseurs", fournisseurs);
        return "fournisseurs";
    }


//delete
    @GetMapping("fournisseurs/delete")
    public String deleteFournisseur(@RequestParam long id) {
        try {
            Fournisseur fournisseur = fournisseurRepository.findById(id).orElse(null);
            fournisseurRepository.delete(fournisseur);

        } catch (Exception e) {
            e.getMessage();
        }

        return"fournisseurs";
    }
    //new fournisseur
    @GetMapping("fournisseurs/new")
    public String showCreatePage(Model model) {
        Fournisseur fournisseur = new Fournisseur();
        model.addAttribute("fournisseur", fournisseur);
        return "add-fournisseur";
    }
    @PostMapping("fournisseurs/new")
    public String addFournisseur(@Validated Fournisseur fournisseur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return"add-fournisseur";
        }

        fournisseurRepository.save(fournisseur);
        return"fournisseurs";
    }



    @GetMapping("produits/delete")
    public String deleteProduit(@RequestParam long id) {
        try {
            Produit produit = produitRepository.findById(id).orElse(null);
            produitRepository.delete(produit);

        } catch (Exception e) {
            e.getMessage();
        }

        return"produits";
    }



}
