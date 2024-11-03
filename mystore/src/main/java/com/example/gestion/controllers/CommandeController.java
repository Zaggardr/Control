
package com.example.gestion.controllers;

import com.example.gestion.models.Commande;
import com.example.gestion.models.Produit;
import com.example.gestion.repositories.CommandeRepository;
import com.example.gestion.repositories.FournisseurRepository;
import com.example.gestion.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
public class CommandeController {
    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping("/")
    public String getindex(Model model) {
        List<Commande> commandes = commandeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("commandes", commandes);
        model.addAttribute("produits", produitRepository.findAll());
        return "index";
    }

    @GetMapping("/commandes")
    public String listeCommandes(Model model) {
        List<Commande> commandes = commandeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("commandes", commandes);
        return "commandes";
    }

//new commande
    @GetMapping("/newc")
    public String showCreate(Model model) {
        Commande commande = new Commande();
        model.addAttribute("commande", commande);
        model.addAttribute("produits", produitRepository.findAll());
        model.addAttribute("fournisseurs",fournisseurRepository.findAll());
        return "add-commande";
    }

    @PostMapping("/newcc")
    public String addCommande(@Validated Commande commande, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-commande";
        }
        commandeRepository.save(commande);
        commande.calculateMontantTotal();
        model.addAttribute("commande", commande);

        return"commandes";
    }

    @GetMapping("commandes/delete")
    public String deleteCommande(@RequestParam long id) {
        try {
            Commande commande = commandeRepository.findById(id).orElse(null);
            commandeRepository.delete(commande);

        } catch (Exception e) {
            e.getMessage();
        }

        return"commandes";
    }


}
