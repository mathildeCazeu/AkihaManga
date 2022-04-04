package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class BoutiqueDAO {
    private static String base = "BD4.0";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public BoutiqueDAO(Context ct) {

        this.accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    // A FAIRE AVEC MATHILDE POUR S'ACCORDER SUR QUOI RENVOYER POUR LA GEOLOC ( surement en parametres : idManga, coordx,xoordy et retourner la liste des boutiques)
}
