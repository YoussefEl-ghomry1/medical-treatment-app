# Application de Suivi de Traitements Médicaux

## Description
Application JavaFX permettant de gérer le suivi de traitements médicaux
des patients, avec stockage MySQL.

## Structure du projet

- `model/` → Patient.java, Traitement.java
- `dao/` → Database.java (connexion), PatientDAO.java, TraitementDAO.java (CRUD)
- `view/` → MainView.java (interface JavaFX)
- `util/` → ExportUtil.java (export CSV)
- `MedicalTreatmentApp.java` → classe principale

> Note : Les opérations CRUD sont réparties dans PatientDAO et TraitementDAO
> plutôt que dans un seul Database.java, suivant le patron de conception DAO
> pour une meilleure séparation des responsabilités.

## Prérequis

- JDK 17 ou +
- JavaFX SDK 21 ou +
- MySQL (WAMP)
- MySQL Connector/J

## Lancement

1. Créer la base de données : `CREATE DATABASE medical_db;`
2. Configurer les identifiants dans `Database.java`
3. Configurer les VM options :
   --module-path "\path\to\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml
4. Lancer `MedicalTreatmentApp.java`

## Fonctionnalités

- Ajout, modification, suppression de patients
- Gestion des traitements par patient
- Recherche et filtrage
- Export CSV
- Statistiques
- Personnalisation via ColorPicker

## Binôme
- El-ghomry Youssef
- Daoudi Mouad