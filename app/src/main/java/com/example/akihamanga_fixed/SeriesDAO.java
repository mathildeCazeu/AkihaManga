package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class SeriesDAO {
    private static String base = "BD";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public SeriesDAO(Context ct) {

        this.accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }
    // RETOURNE LES SERIES FAVORITES SELON L'email utilisateur ( son identifiant )
    public ArrayList<Series> getLesSeriesFavorites(long email){
        Cursor curseur;
        String requete = "select * from Serie s join EstFavori eF on s.idSerie=eF.idSerie join Utilisateur u on eF.email='u."+email+"';";
        curseur = accesBD.getReadableDatabase().rawQuery(requete, null);
        return cursorToSeriesArrayList(curseur);
    }

    // RETOURNE LES SERIES SELON LE PREMIER GENRE
    public ArrayList<Series> getLesSeriesParPremierGenre(String genre1){
        Cursor curseur;
        String requete = "select * from Serie where genre1='"+genre1+"';";
        curseur = accesBD.getReadableDatabase().rawQuery(requete, null);
        return cursorToSeriesArrayList(curseur);
    }


    // RETOURNE LES SERIES SELON LE PREMIER ET SECOND GENRE
    public ArrayList<Series> getLesSeriesParGenres(String genre1,String genre2){
        Cursor curseur;
        String requete = "select * from Serie where genre1='"+genre1+"' and genre2='"+genre2+"';";
        curseur = accesBD.getReadableDatabase().rawQuery(requete, null);
        return cursorToSeriesArrayList(curseur);
    }

    // RETOURNE LES SERIES SELON LE TEXTE ENTRER DANS LA BARRE DE RECHERCHE AVEC UNE MARGE D'ERREUR D'UN SEULE CARACTERE ( ne teint pas en compte les majuscules )
    public ArrayList<Series> getLesSeriesParNom(String nomEntree) {
        Cursor curseur;
        if (nomEntree.length() == 1) {
            String requete = "select * from Serie where nomSerie='"+nomEntree+"%';";
            curseur = accesBD.getReadableDatabase().rawQuery(requete, null);
        } else {
            String requete = "select * from Serie where nomSerie='"+nomEntree.substring(0,nomEntree.length()-2)+"%';";
            curseur = accesBD.getReadableDatabase().rawQuery(requete, null);
        }
        return cursorToSeriesArrayList(curseur);
    }

    // FONCTION DE RETOUR AVEC LA REQUETE DEMANDEE
    public ArrayList<Series> cursorToSeriesArrayList(Cursor curseur){
        ArrayList<Series> listeSeries = new ArrayList<>();
        long idSerie;
        String nomSerie;
        String auteur;
        String editeur;
        String genre1;
        String genre2;


        curseur.moveToFirst();
        while(!curseur.isAfterLast()){
            idSerie = curseur.getLong(0);
            nomSerie = curseur.getString(1);
            auteur = curseur.getString(2);
            editeur = curseur.getString(3);
            genre1 = curseur.getString(4);
            genre2 = curseur.getString(5);


            listeSeries.add(new Series(idSerie,nomSerie,auteur,editeur,genre1,genre2));
            curseur.moveToNext();
        }
        return listeSeries;
    }

}
