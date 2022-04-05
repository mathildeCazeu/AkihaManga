package com.example.akihamanga_fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class pageUtilisateur extends AppCompatActivity {
    private ImageView iv_recherche;
    private SeriesDAO serie;
    private LinearLayout ll_listeSeriesFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_utilisateur);

        // INITIALISATIONS
        ll_listeSeriesFavorites=findViewById(R.id.ll_listeSeriesFavoris);

        serie=new SeriesDAO(this);

        String email;

        Bundle extras = getIntent().getExtras();
        email = extras.getString("utilisateurEmail");

        // FONCTIONS
        iv_recherche = (ImageView) findViewById(R.id.imageView26); //Appel de l'image view 26 -> image de loupe
        iv_recherche.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final Intent demarre = new Intent(getApplicationContext(),pageRecherche.class);
                demarre.putExtra("utilisateurEmail",email);
                startActivity(demarre);
            }
        });


        initListeFavoris(email);


        ll_listeSeriesFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent demarre = new Intent(getApplicationContext(),pageFavori.class);
                demarre.putExtra("identifiantEmail",email);
                startActivity(demarre);
            }
        });



    }
    public void initListeFavoris(String email){

        final Intent demarre = new Intent(getApplicationContext(),pageFavori.class);


        // CREATION DES OBJETS GRAPHIQUE
        LinearLayout layoutSerie;

        ImageView imageSerie;

        TextView nomSerie;

        // VERIF SI NOMBRE DE SERIE INFERIEUR A TROIS
        int nombreDeTours=serie.getLesSeriesFavorites(email).size();

        if (serie.getLesSeriesFavorites(email).size()>2){
            nombreDeTours=3;
        }
        Log.d(Integer.toString(nombreDeTours), "initListeFavoris: ");

        // PLACEMENT DES SERIES
        for (int i = 0 ; i < nombreDeTours ; i++){
            // IMAGE DE LA SERIE
            imageSerie = new ImageView(this);
            imageSerie.setImageResource(R.drawable.jojopart4tome);
            imageSerie.setLayoutParams(new LinearLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, 140));

            // INFORMATIONS DE LA SERIE
            nomSerie=new TextView(this);
            nomSerie.setTypeface(null, Typeface.BOLD);
            nomSerie.setTextSize(5);
            nomSerie.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            // LAYOUT VERTICAL DE LA SERIE
            layoutSerie=new LinearLayout(this);
            layoutSerie.setOrientation(LinearLayout.VERTICAL);
            layoutSerie.setPadding(20,0,0,0);
            layoutSerie.setLayoutParams(new LinearLayout.LayoutParams( 100, LinearLayout.LayoutParams.MATCH_PARENT));

            // INSERTION DES LAYOUT DANS LA LISTE DES SERIES
            ll_listeSeriesFavorites.addView(layoutSerie);

            // INSERTION DE L'IMAGE
            layoutSerie.addView(imageSerie);

            // INSERTION DES INFORMATIONS
            // nom de la série
            nomSerie.setText(serie.getLesSeriesFavorites(email).get(i).getNomSerie().toString());
            nomSerie.setTextColor(Color.BLACK);
            layoutSerie.addView(nomSerie);

        }
    }
}