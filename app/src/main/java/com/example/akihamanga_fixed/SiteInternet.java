package com.example.akihamanga_fixed;

public class SiteInternet {
    private long idSite;
    private String nomSite,url;

    public SiteInternet(long idSite, String nomSite, String url) {
        this.idSite = idSite;
        this.nomSite = nomSite;
        this.url = url;
    }

    public long getIdSite() {
        return idSite;
    }

    public void setIdSite(long idSite) {
        this.idSite = idSite;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
