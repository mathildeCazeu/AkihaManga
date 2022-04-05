package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class UtilisateurDAO {
    private static String base = "BD5.0";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public UtilisateurDAO(Context ct) {

        this.accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    // PERMET DE VERIFIER LES IDENTIFIANTS SAISIES
    public boolean verificationConnexion(String email,String mdp){
        boolean identificationBon=false;
        Cursor curseur;

        curseur = accesBD.getReadableDatabase().rawQuery("select * from Utilisateur where email='"+email+"' and motDePasse='"+mdp+"';",null);
        if (curseur.getCount()>0){
            curseur.moveToFirst();
            identificationBon=true;
        }
        return identificationBon;
    }

    // RENVOYER L'UTILISATEUR CONNECTE
    public Utilisateur getUtilisateur(String email){
        Utilisateur user=null;
        Cursor curseur;

        curseur = accesBD.getReadableDatabase().rawQuery("select * from Utilisateur where email="+email+";",null);
        if (curseur.getCount()>0){
            curseur.moveToFirst();
            user=new Utilisateur(curseur.getString(0), curseur.getString(1), curseur.getString(2), curseur.getString(3), curseur.getInt(4) );
        }
        return user;
    }
}