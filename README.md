# Bibliogest - Projet évalué n°2

## Participants

1. Francis Hêche

2. Normand Paratte

## Descriptif du projet

Création d'une application permettant de gérer une bibliothèque de livres.

L'application va rechercher les informations d'un livre dans l'API Goodreads (https://www.goodreads.com/api/) et permet de se créer une bibliothèque personnelle.

Cette bibliothèque permet d'afficher diverses informations sur des livres et d'y ajouter une note et un commentaire personnels.


## Livrables

### Sources

Toutes les sources sont disponibles dans le repository du projet.



## Outils utilisés

**- IDE :** IntelliJ IDEA (+GlassFish 5.0.0)

**- API ** : Goodreads ()

**- VCS** : Git, GitHub

**- Navigateurs internet** : Google Chrome, Mozilla Firefox

### Utilisation de Github :

- Chaque tâche à réaliser dans l'application correspond à une issue dans GitHub

- Les issues sont regroupées par catégories selon les labels suivants :

-- administratif

-- bug

-- documentation

-- fonctionnalité

-- optimisation

-- tests

## Architecture logiciel
### Découpage de l'application
Le pattern MVC est utilisé pour le découpage de l'application (packages).
Cependant, ce pattern est originellement créé uniquement pour la partie Vue/IHM d’une application. Mais ce dernier s’applique maintenant souvent dans le découpage de l’application comme dans ce projet même si ce n’est pas son idée de base.

La partie vue n'existe pas dans le cas de notre projet car utilisant une WEB-APP, toute la gestion de la vue (IHM) se situe directement dans le dossier web se situant à la racine du projet.

### Gestion de la persistance
Afin de gérer la persistance des données, des mocks de persistances ont été mis en place. Ceci permettant de pouvoir faire des tests sur notre application sans devoir remettre des données à chaques fois que l'on relance l'application.

A noter que dans le futur, cette gestion via des mocks devrait être remplacée par un autre moyen de persistance tel qu'une base de données.
Ceci n'étant pas compris dans cette évaluation, ce remplacement ne sera donc pas effectué au sein de ce projet.

## Eléments manquants ou incomplets
