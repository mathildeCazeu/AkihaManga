package com.example.akihamanga_fixed;

public class Utilisateur {
    private String email, nom, prenom, motDePasse;
    private int estAdmin;

    public Utilisateur(String email, String nom, String prenom, String motDePasse, int estAdmin) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.estAdmin = estAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(int estAdmin) {
        this.estAdmin = estAdmin;
    }
}
