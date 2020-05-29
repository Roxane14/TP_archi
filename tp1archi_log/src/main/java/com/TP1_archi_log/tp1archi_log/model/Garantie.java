package com.TP1_archi_log.tp1archi_log.model;

public class Garantie {
    private final int id;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getMontant() {
        return montant;
    }

    public String getDescription() {
        return description;
    }

    private final String nom;
    private final int montant;
    private final String description;

    public Garantie(int id, String nom, int montant, String description) {
        this.id = id;
        this.nom = nom;
        this.montant = montant;
        this.description = description;
    }

}
