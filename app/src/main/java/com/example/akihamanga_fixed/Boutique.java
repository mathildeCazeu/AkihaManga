package com.example.akihamanga_fixed;

public class Boutique {
    private long idBoutique;
    private String nom,adresse;

    public Boutique(long idBoutique, String nom, String adresse) {
        this.idBoutique = idBoutique;
        this.nom = nom;
        this.adresse = adresse;
    }

    public long getIdBoutique() {
        return idBoutique;
    }

    public void setIdBoutique(long idBoutique) {
        this.idBoutique = idBoutique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
