package com.example.akihamanga_fixed;

public class Series {
    private long idSerie;
    private String nomSerie,auteur,editeur,genre1,genre2;

    public Series(long idSerie, String nomSerie, String auteur, String editeur, String genre1, String genre2) {
        this.idSerie = idSerie;
        this.nomSerie = nomSerie;
        this.auteur = auteur;
        this.editeur = editeur;
        this.genre1 = genre1;
        this.genre2 = genre2;
    }

    public long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(long idSerie) {
        this.idSerie = idSerie;
    }

    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }
}
