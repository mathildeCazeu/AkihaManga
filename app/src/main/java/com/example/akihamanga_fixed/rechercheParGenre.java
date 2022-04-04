package com.example.akihamanga_fixed;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class rechercheParGenre extends AppCompatActivity
{
    private EditText et_rechercherNom;
    private TextView tv_nombreResultat;
    private LinearLayout ll_listeSerie;
    private SeriesDAO series;
    private static String nomGenre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_par_genre);

        et_rechercherNom=findViewById(R.id.et_rechercherNom);
        tv_nombreResultat=findViewById(R.id.tv_nombreResultat);
        ll_listeSerie=findViewById(R.id.ll_listeSerie);
        series = new SeriesDAO(this);

        /** A CORRIGER TAILLE IMAGE **/
        initListeSerie();


    }

    public void initListeSerie(){

        final Intent demarre = new Intent(getApplicationContext(),pageInformation.class);
        // RECUPERATION GENRE SELECTIONNEE
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            nomGenre = extras.getString("nomGenre");
        }

        // CREATION DES OBJETS GRAPHIQUE
        LinearLayout layoutSerie;
        LinearLayout layoutImageSerie;
        LinearLayout layoutInformations;

        ImageView imageSerie;

        TextView nomSerie;
        TextView auteurSerie;

        tv_nombreResultat.setText(Integer.toString(series.getLesSeriesParGenre(nomGenre).size())+" résultats");

        // PLACEMENT DES SERIES
        for (int i = 0 ; i < series.getLesSeriesParGenre(nomGenre).size() ; i++){
            // IMAGE DE LA SERIE
            imageSerie = new ImageView(this);
            imageSerie.setImageResource(R.drawable.jojopart4tome);
            imageSerie.setLayoutParams(new LinearLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, 130));

            // INFORMATIONS DE LA SERIE
            nomSerie=new TextView(this);
            nomSerie.setTypeface(null, Typeface.BOLD);
            nomSerie.setTextSize(16);
            nomSerie.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            auteurSerie=new TextView(this);
            auteurSerie.setTextSize(16);
            auteurSerie.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            // LAYOUT HORIZONTAL DE LA SERIE
            layoutSerie=new LinearLayout(this);
            layoutSerie.setOrientation(LinearLayout.HORIZONTAL);
            layoutSerie.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            // LAYOUT VERTICAL DE L'IMAGE
            layoutImageSerie=new LinearLayout(this);
            layoutImageSerie.setOrientation(LinearLayout.VERTICAL);
            layoutImageSerie.setGravity(Gravity.LEFT | Gravity.START);
            layoutImageSerie.setLayoutParams(new LinearLayout.LayoutParams( 90, LinearLayout.LayoutParams.MATCH_PARENT));

            // LAYOUT VERTICAL DES INFORMATIONS DE LA SERIE
            layoutInformations=new LinearLayout(this);
            layoutInformations.setOrientation(LinearLayout.VERTICAL);
            layoutInformations.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            // INSERTION DES LAYOUT DANS LA LISTE DES SERIES
            ll_listeSerie.addView(layoutSerie);
            layoutSerie.addView(layoutImageSerie);
            layoutSerie.addView(layoutInformations);

            // INSERTION DE L'IMAGE
            layoutImageSerie.addView(imageSerie);

            // INSERTION DES INFORMATIONS
            // nom de la série
            nomSerie.setText(series.getLesSeriesParGenre(nomGenre).get(i).getNomSerie());
            nomSerie.setTextColor(Color.BLACK);
            layoutInformations.addView(nomSerie);

            // auteur de la série
            auteurSerie.setText(series.getLesSeriesParGenre(nomGenre).get(i).getAuteur());
            auteurSerie.setTextColor(Color.BLACK);
            layoutInformations.addView(auteurSerie);

            final int indexFilm=i;

            // SI CLIQUE LAYOUT

            layoutSerie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // ENVOI identifiant du film dans la base de données à l'activité reservation
                    demarre.putExtra("identifiantSerie", series.getLesSeriesParGenre(nomGenre).get(indexFilm).getIdSerie());
                    // DEMARRAGE de l'activité reservation
                    startActivity(demarre);
                }
            });
        }

    }

}
