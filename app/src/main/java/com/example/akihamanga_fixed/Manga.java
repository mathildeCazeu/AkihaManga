package com.example.akihamanga_fixed;

public class Manga {
    private long idManga,idSerie;
    private int numeroVolume,EAN;

    public Manga(long idManga, int numeroVolume, int EAN, long idSerie) {
        this.idManga = idManga;
        this.numeroVolume = numeroVolume;
        this.EAN = EAN;
        this.idSerie = idSerie;
    }

    public long getIdManga() {
        return idManga;
    }

    public void setIdManga(long idManga) {
        this.idManga = idManga;
    }

    public int getNumeroVolume() {
        return numeroVolume;
    }

    public void setNumeroVolume(int numeroVolume) {
        this.numeroVolume = numeroVolume;
    }

    public int getEAN() {
        return EAN;
    }

    public void setEAN(int EAN) {
        this.EAN = EAN;
    }

    public long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(long idSerie) {
        this.idSerie = idSerie;
    }
}
