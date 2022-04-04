package com.example.akihamanga_fixed;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class recherche_par_nom extends AppCompatActivity {

    private ImageView iv_home;
    private ImageView iv_favoris;
    private ImageView iv_recherche;
    private static String nomRecherche;
    private TextView tv_nombreResultatParNom, tv_rechercheUtilisateur;
    private LinearLayout ll_listeSerieParNom;
    private String nomSerie;
    private SeriesDAO series;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_par_nom);
        tv_nombreResultatParNom = findViewById(R.id.tv_nombreResultatParNom);
        tv_rechercheUtilisateur = findViewById(R.id.tv_rechercheUtilisateur);
        ll_listeSerieParNom = findViewById(R.id.ll_listeSerieParNom);

        series = new SeriesDAO(this);

        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(recherche_par_nom.this, MainActivity.class);
                startActivity(intent);
            }
        });

        iv_favoris = (ImageView) findViewById(R.id.iv_favoris);
        iv_favoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(recherche_par_nom.this, pageFavori.class);
                startActivity(intent);
            }
        });

        /*iv_recherche = (ImageView) findViewById(R.id.imageView26); //Appel de l'image view 26 -> image de loupe
        iv_recherche.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(recherche_par_nom.this, pageRecherche.class);
                startActivity(intent);
            }
        });*/


        initListeSerie();


    }

    public void initListeSerie() {

        final Intent demarre = new Intent(getApplicationContext(), pageInformation.class);
        // RECUPERATION NOM RECHERCHEE
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nomRecherche = extras.getString("nomSerie");
        }

        tv_rechercheUtilisateur.setText(nomRecherche);

        // CREATION DES OBJETS GRAPHIQUE
        LinearLayout layoutSerie;
        LinearLayout layoutImageSerie;
        LinearLayout layoutInformations;

        ImageView imageSerie;

        TextView nomSerie;
        TextView auteurSerie;

        tv_nombreResultatParNom.setText(Integer.toString(series.getLesSeriesParNom(nomRecherche).size()) + " résultats");

        // PLACEMENT DES SERIES
        for (int i = 0; i < series.getLesSeriesParNom(nomRecherche).size(); i++) {
            // IMAGE DE LA SERIE
            imageSerie = new ImageView(this);
            imageSerie.setImageResource(R.drawable.jojopart4tome);
            imageSerie.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            // INFORMATIONS DE LA SERIE
            nomSerie = new TextView(this);
            nomSerie.setTypeface(null, Typeface.BOLD);
            nomSerie.setTextSize(18);
            nomSerie.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            auteurSerie = new TextView(this);
            auteurSerie.setTextSize(14);
            auteurSerie.setPadding(15, 15, 0, 0);
            auteurSerie.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            // LAYOUT HORIZONTAL DE LA SERIE
            layoutSerie = new LinearLayout(this);
            layoutSerie.setOrientation(LinearLayout.HORIZONTAL);
            layoutSerie.setPadding(0, 0, 0, 50);
            layoutSerie.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            // LAYOUT VERTICAL DE L'IMAGE
            layoutImageSerie = new LinearLayout(this);
            layoutImageSerie.setOrientation(LinearLayout.VERTICAL);
            layoutImageSerie.setGravity(Gravity.LEFT | Gravity.START);
            layoutImageSerie.setLayoutParams(new LinearLayout.LayoutParams(500, 500));

            // LAYOUT VERTICAL DES INFORMATIONS DE LA SERIE
            layoutInformations = new LinearLayout(this);
            layoutInformations.setOrientation(LinearLayout.VERTICAL);
            layoutInformations.setPadding(0, 50, 0, 0);
            layoutInformations.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            // INSERTION DES LAYOUT DANS LA LISTE DES SERIES
            ll_listeSerieParNom.addView(layoutSerie);
            layoutSerie.addView(layoutImageSerie);
            layoutSerie.addView(layoutInformations);

            // INSERTION DE L'IMAGE
            layoutImageSerie.addView(imageSerie);

            // INSERTION DES INFORMATIONS
            // nom de la série
            nomSerie.setText(series.getLesSeriesParNom(nomRecherche).get(i).getNomSerie());
            nomSerie.setTextColor(Color.BLACK);
            layoutInformations.addView(nomSerie);

            // auteur de la série
            auteurSerie.setText(series.getLesSeriesParNom(nomRecherche).get(i).getAuteur());
            auteurSerie.setTextColor(Color.BLACK);
            layoutInformations.addView(auteurSerie);

            final int indexSerie = i;

            // SI CLIQUE LAYOUT

            layoutSerie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // ENVOI identifiant du film dans la base de données à l'activité reservation
                    demarre.putExtra("identifiantSerie", series.getLesSeriesParNom(nomRecherche).get(indexSerie).getIdSerie());
                    // DEMARRAGE de l'activité reservation
                    startActivity(demarre);
                }
            });


        }

    }
}
