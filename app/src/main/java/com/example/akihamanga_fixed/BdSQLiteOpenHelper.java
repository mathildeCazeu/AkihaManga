package com.example.akihamanga_fixed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper {
    public BdSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    // TABLES
    private String table_utilisateur = "create table Utilisateur ("+"email TEXT PRIMARY KEY,"+"nom TEXT NOT NULL,"+"prenom TEXT NOT NULL,"
            +"motDePasse TEXT NOT NULL,"+"estAdmin INTEGER);";

    private String table_boutique = "create table Boutique ("+"idBoutique INTEGER PRIMARY KEY,"+"nom TEXT NOT NULL,"+"latitute DOUBLE NOT NULL,"+"longitude DOUBLE NOT NULL);";

    private String table_siteInternet = "create table SiteInternet ("+"idSite INTEGER PRIMARY KEY,"+"nomSite TEXT NOT NULL,"+"url TEXT NOT NULL);";

    private String table_serie = "create table Serie ("+"idSerie INTEGER PRIMARY KEY,"+"nomSerie TEXT NOT NULL,"+"auteur TEXT NOT NULL,"
            +"editeur TEXT NOT NULL,"+"genre1 TEXT NOT NULL,"+"genre2 TEXT NOT NULL,"+"couverture TEXT NOT NULL);";

    private String table_manga = "create table Manga ("+"idManga INTEGER PRIMARY KEY,"+"numeroVolume TEXT NOT NULL,"+"EAN TEXT NOT NULL,"+"couverture TEXT NOT NULL," +"idSerie INTEGER NOT NULL,"
            +"FOREIGN KEY (idSerie) references Serie (idSerie));";

    // TABLE D'ASSOCIATION
    private String table_estFavori = "create table EstFavori ("+"idSerie INTEGER,"+"email TEXT,"+"PRIMARY KEY (idSerie, email),"
            +"FOREIGN KEY (idSerie) REFERENCES Serie (idSerie),"+"FOREIGN KEY (email) REFERENCES Utilisateur (email));";

    private String getTable_estDispoPhysique = "create table EstDispoPhysique ("+"idManga INTEGER,"+"idBoutique INTEGER,"+"PRIMARY KEY (idManga, idBoutique),"
            +"FOREIGN KEY (idManga) REFERENCES Manga (idManga),"+"FOREIGN KEY (idBoutique) REFERENCES Boutique (idBoutique));";

    private String table_estDispoEnLigne = "create table EstDispoEnLigne ("+"idManga INTEGER,"+"idSite INTEGER,"+"PRIMARY KEY (idManga, idSite),"
            +"FOREIGN KEY (idManga) REFERENCES Manga (idManga),"+"FOREIGN KEY (idSite) REFERENCES SiteInternet (idSite));";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATION TABLES
        db.execSQL(table_utilisateur);
        db.execSQL(table_boutique);
        db.execSQL(table_siteInternet);
        db.execSQL(table_serie);
        db.execSQL(table_manga);
        db.execSQL(table_estFavori);
        db.execSQL(table_estDispoEnLigne);
        db.execSQL(getTable_estDispoPhysique);

        // INSERTION TUPLES DANS LA TABLE Utilisateur
        db.execSQL("insert into Utilisateur values('enzof2003@gmail.com','Flamand','Enzo','enzof2003',1);");
        db.execSQL("insert into Utilisateur values('madiane.gonnel@gmail.com','Gonnel','Madiane','madiane.gonnel',1);");
        db.execSQL("insert into Utilisateur values('tristangoncalves@gmail.com','Goncalves','Tristan','tristangoncalves',1);");
        db.execSQL("insert into Utilisateur values('mathildecazenave1@gmail.com','Cazenave','Mathilde','mathildecazenave1',1);");
        db.execSQL("insert into Utilisateur values('random@gmail.com','Random','Xamier','random',0);");


        // INSERTION TUPLES DANS LA TABLE Boutique
        db.execSQL("insert into Boutique values(1,'FnacBayonne',43.486612,-1.490712);");
        db.execSQL("insert into Boutique values(2,'Librairie Gribouille',43.489706,-1.475897);");
        db.execSQL("insert into Boutique values(3,'Cultura Amentzendo',43.480692,-1.443639);");

        // INSERTION TUPLES DANS LA TABLE SiteInternet
        db.execSQL("insert into SiteInternet values(1,'Fnac','https://www.fnac.com/');");
        db.execSQL("insert into SiteInternet values(2,'Amazon','https://www.amazon.fr/');");
        db.execSQL("insert into SiteInternet values(3,'Cultura','https://www.cultura.com/');");

        // INSERTION TUPLE DANS LA TABLE SERIE
        db.execSQL("insert into Serie values(1,'JoJos Bizarre Adventure','Hirohiko Araki','Shūeisha','Action','Drame','jojopart1tome');");
        db.execSQL("insert into Serie values(2,'Lovely Complex','Aya Nakahara','Shūeisha','Romance','Comedie','lovelycomplextome1');");
        db.execSQL("insert into Serie values(3,'One Piece','Eiichirō Oda','Shūeisha','Action','Comedie','onepiecetome');");

        /** AJOUT DE MATHILDE DANS LA BD **/
        db.execSQL("insert into Serie values(4,'Dragon Ball','Toriyama Akira','Shūeisha','Action','Comédie','dragonballtome1');");
        db.execSQL("insert into Serie values(5,'Naruto','Kishimoto Masashi','Shūeisha','Action','Comédie','narutotome1');");
        db.execSQL("insert into Serie values(6,'Demon Slayer','Gotoge Koyoharu','Shūeisha','Action','Fantaisie','demonslayertome');");
        db.execSQL("insert into Serie values(7,'L attaque des Titans','Isayama Hajime','Kodansha','Action','Horreur','snktome');");
        db.execSQL("insert into Serie values(8,'Fullmetal Alchemist','Arakawa Hiromu','Square Enix','Action','Drame','fmatome1');");
        db.execSQL("insert into Serie values(9,'Hunter x Hunter','Togashi Yoshihiro','Shūeisha','Action','Fantaisie','hxhtome1');");
        db.execSQL("insert into Serie values(10,'Fairy Tail','Mashima Hiro','Kodansha','Action','Fantaisie','fairytailtome1');");
        db.execSQL("insert into Serie values(11,'My Hero Academia','Horikoshi Kohei','Shūeisha','Action','Fantaisie','mhatome1');");
        db.execSQL("insert into Serie values(12,'Prince du Tennis','Konomi Takeshi','Shūeisha','Sport','Action','princetennistome');");
        db.execSQL("insert into Serie values(13,'Jujutsu Kaisen','Akutami Gege','Shūeisha','Action','Drame','jujutsukaisentome1');");
        db.execSQL("insert into Serie values(14,'Haikyu!!','Furudate Haruichi','Shūeisha','Sport','Drame','haikyutome1');");






        // INSERTION TUPLE DANS LA TABLE MANGA
        // One Piece ( à insert tous les autres tomes )
        db.execSQL("insert into Manga values(1,1,9782723433358,'onepiecetome',3);");
        db.execSQL("insert into Manga values(2,2,9782723489898,'onepiecetome2',3);");

        // JJBA
        db.execSQL("insert into Manga values(101,1,9782756061030,'jojopart1tome',1);");
        db.execSQL("insert into Manga values(102,2,9782756061818,'jojopart1tome2',1);");

        // Lovely Complex
        db.execSQL("insert into Manga values(201,1,9782756005478,'lovelycomplextome1',2);");
        db.execSQL("insert into Manga values(202,2,9782756006819,'lovelycomplextome2',2);");

        // ABSENCE DES INSERT DE LA TABLE EstFavori car ces derniers doit,se faire de façon dynamique de même que les utilisateurs

        // INSERTION TUPLE DANS LA TABLE EstDispoPhysique
        // Lovely Complex T01 dans la boutique FnacBayonne
        db.execSQL("insert into EstDispoPhysique values(201,1);");
        // JJBA T02 dans la boutique Librairie Gribouille
        db.execSQL("insert into EstDispoPhysique values(102,2);");

        // INSERTION TUPLE DANS LA TABLE EstDispoEnLigne
        // Lovely Complex T01 sur le site fnac / amazon / cultura
        db.execSQL("insert into EstDispoEnLigne values(201,1);");
        db.execSQL("insert into EstDispoEnLigne values(201,2);");
        db.execSQL("insert into EstDispoEnLigne values(201,3);");
        // JJBA T01/T02 sur le site fnac / amazon / cultura
        db.execSQL("insert into EstDispoEnLigne values(101,1);");
        db.execSQL("insert into EstDispoEnLigne values(101,2);");
        db.execSQL("insert into EstDispoEnLigne values(101,3);");
        db.execSQL("insert into EstDispoEnLigne values(102,1);");
        db.execSQL("insert into EstDispoEnLigne values(102,2);");
        db.execSQL("insert into EstDispoEnLigne values(102,3);");
        // One Piece T01 sur le site fnac
        db.execSQL("insert into EstDispoEnLigne values(1,1);");
        // One Piece T01/T02 sur le site Amazon
        db.execSQL("insert into EstDispoEnLigne values(1,2);");
        db.execSQL("insert into EstDispoEnLigne values(2,2);");
        // One Piece T02 sur le site Cultura
        db.execSQL("insert into EstDispoEnLigne values(1,3);");

        // INSERTION DANS LA TABLE FAVORIS
        db.execSQL("insert into EstFavori values(1,'enzof2003@gmail.com');");
        db.execSQL("insert into EstFavori values(4,'enzof2003@gmail.com');");
        db.execSQL("insert into EstFavori values(5,'enzof2003@gmail.com');");
        db.execSQL("insert into EstFavori values(7,'enzof2003@gmail.com');");

        db.execSQL("insert into EstFavori values(1,'madiane.gonnel@gmail.com');");

        db.execSQL("insert into EstFavori values(4,'tristangoncalves@gmail.com');");
        db.execSQL("insert into EstFavori values(2,'tristangoncalves@gmail.com');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}