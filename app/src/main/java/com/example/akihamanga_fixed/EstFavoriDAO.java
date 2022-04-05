package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.Cursor;

public class EstFavoriDAO {

        private static String base = "BD6.0";
        private static int version = 1;
        private BdSQLiteOpenHelper accesBD;

        public EstFavoriDAO(Context ct) {

            this.accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
        }

        // PERMET DE RENVOYER LA LISTE DES SERIES FAVORIS SELON L'EMAIL D'UN UTILISATEUR
        public void ajouterFavori(String email,long idSerie){
            accesBD.getWritableDatabase().execSQL("insert into EstFavori values("+idSerie+",'"+email+"')",null);
        }

    // PERMET DE RENVOYER LA LISTE DES SERIES FAVORIS SELON L'EMAIL D'UN UTILISATEUR
    public void supprimerFavori(String email,long idSerie){
        accesBD.getWritableDatabase().execSQL("delete * from EstFavori where idSerie="+idSerie+" and email='"+email+"';",null);
    }

}

