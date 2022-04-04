package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class SiteInternetDAO {
    private static String base = "BD4.0";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public SiteInternetDAO(Context ct) {

        this.accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public ArrayList<SiteInternet> getLesSitesInternet(long idManga){
        Cursor curseur;
        String requete = "select * from SiteInternet s join estDisponible eD on s.idSite=eD.idSite join Manga m on s.idManga=m."+idManga+";";
        curseur = accesBD.getReadableDatabase().rawQuery(requete, null);
        return cursorToSitesArrayList(curseur);
    }

    public ArrayList<SiteInternet> cursorToSitesArrayList(Cursor curseur){
        ArrayList<SiteInternet> listeSitesInternet = new ArrayList<>();
        long idSite;
        String nomSite;
        String url;


        curseur.moveToFirst();
        while(!curseur.isAfterLast()){
            idSite = curseur.getLong(0);
            nomSite = curseur.getString(1);
            url = curseur.getString(2);


            listeSitesInternet.add(new SiteInternet(idSite,nomSite,url));
            curseur.moveToNext();
        }
        return listeSitesInternet;
    }
}
