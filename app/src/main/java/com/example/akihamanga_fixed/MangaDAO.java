package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class MangaDAO {
    private static String base = "BD5 .0";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public MangaDAO(Context ct) {

        this.accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    // RETOURNE TOUS LES MANGA D'UNE SERIE SELON SON ID ( idSerie )
    public ArrayList<Manga> getLesMangas(long idSerie) {
        Cursor curseur;

        String requete = "select * from Manga m join Serie s on m.idSerie=s.idSerie where s.idSerie="+idSerie+";";
        curseur = accesBD.getReadableDatabase().rawQuery(requete, null);

        return cursorToMangaArrayList(curseur);
    }

    // FONCTION DE RETOUR AVEC LA REQUETE DEMANDEE
    public ArrayList<Manga> cursorToMangaArrayList(Cursor curseur){
        ArrayList<Manga> listeManga = new ArrayList<>();
        long idManga,idSerie;
        int numeroVolume,EAN;


        curseur.moveToFirst();
        while(!curseur.isAfterLast()){
            idManga = curseur.getLong(0);
            numeroVolume = curseur.getInt(1);
            EAN = curseur.getInt(2);
            idSerie = curseur.getLong(3);


            listeManga.add(new Manga(idManga,numeroVolume,EAN,idSerie));
            curseur.moveToNext();
        }
        return listeManga;
    }

}
