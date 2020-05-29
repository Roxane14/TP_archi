package com.TP1_archi_log.tp1archi_log.model;

public class Garantie {
    private final int id;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String n) {
        this.nom = n;
    }

    public int getMontant() {
        return montant;
    }
    
    public void setMontant(int n) {
        this.montant = n;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription (String n) {
        this.description = n;
    }

    private String nom;
    private int montant;
    private String description;

    public Garantie(int id, String nom, int montant, String description) {
        this.id = id;
        this.nom = nom;
        this.montant = montant;
        this.description = description;
    }

}
