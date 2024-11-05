# Gestion des Commandes et des Fournisseurs

Ce projet est une application web de gestion des commandes et des fournisseurs, réalisée avec *Spring Boot, **Thymeleaf, et **Bootstrap*.

## Description

L'application permet de :
- Créer, afficher et gérer les fournisseurs ainsi que leurs produits associés.
- Enregistrer et visualiser les commandes passées auprès des fournisseurs.
  
### Objectifs
L'application facilite la gestion des commandes passées à différents fournisseurs, chaque commande contenant un ou plusieurs produits.

## Fonctionnalités Principales

- *Gestion des Fournisseurs* : Ajouter, afficher, modifier, et supprimer des fournisseurs.
- *Gestion des Produits* : Ajouter de nouveaux produits pour chaque fournisseur.
- *Gestion des Commandes* : Créer, visualiser, et gérer les commandes passées auprès des fournisseurs.
## Structure du Projet

Le projet suit l'architecture MVC (Modèle-Vue-Contrôleur) avec :
- *Entities* : Contient les classes Fournisseur, Produit, et Commande.
- *Repositories* : Interfaces pour accéder aux données via JPA.
- *Controllers* : Contrôleurs gérant les requêtes pour chaque entité.
- *Templates Thymeleaf* : Pages HTML pour les opérations CRUD.

## Installation et Exécution

### Prérequis
- Java JDK 17+
- Maven
- IntelliJ IDEA ou un autre IDE compatible avec Spring Boot
## Endpoints Principaux
/fournisseurs : Liste des fournisseurs
/produits : Liste des produits et création de nouveaux produits
/commandes : Liste des commandes et création de nouvelles commandes
## Technologies Utilisées
Spring Boot - Framework principal
Spring Data JPA - Accès aux données
Thymeleaf - Moteur de template pour les vues
Bootstrap - Pour le style et la mise en forme
H2 Database - Base de données en mémoire pour le développement et les tests
## Structure des Pages
Liste des Fournisseurs : Affiche tous les fournisseurs, avec des options pour ajouter, modifier ou supprimer un fournisseur.
Détail du Fournisseur : Affiche les produits associés à un fournisseur et permet d’ajouter de nouveaux produits.
Liste des Commandes : Affiche toutes les commandes, avec des options pour créer une nouvelle commande.
## vidéo
https://github.com/user-attachments/assets/32e64183-8d5d-4e3c-92e1-1e5d15488590
## Auteurs
Zaggar Driss - Développeur principal
