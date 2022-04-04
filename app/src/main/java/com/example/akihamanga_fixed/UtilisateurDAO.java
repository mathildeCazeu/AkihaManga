package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class UtilisateurDAO {
    private static String base = "BD2.0";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public UtilisateurDAO(Context ct) {

        this.accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    // PERMET LORS DE LA CONNEXION DE RECUPERER L'UTILISATEUR AVEC LE MEME EMAIL ENTRER, IL FAUDRAT ENSUITE VERIFIER LE MDP DE L'UTILISATEUR RENVOYER DANS LA FONCTION
    public Utilisateur getUtilisateur(String email){
        Utilisateur lUtilisateur = null;
        Cursor curseur;

        curseur = accesBD.getReadableDatabase().rawQuery("select * from Utilisateur where email="+email+";",null);
        if (curseur.getCount()>0){
            curseur.moveToFirst();
            lUtilisateur = new Utilisateur(email, curseur.getString(1),curseur.getString(2),curseur.getString(3),curseur.getInt(4));
        }
        return lUtilisateur;
    }
}
