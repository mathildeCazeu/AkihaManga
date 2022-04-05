package com.example.akihamanga_fixed;

import androidx.appcompat.app.AppCompatActivity;

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

public class pageInformation extends AppCompatActivity {

    private ImageView iv_home, iv_favoris, iv_imageSerie;
    private TextView tv_nomSerie, tv_nombreManga, tv_genre1, tv_genre2, tv_synopsis;
    private static long idSerie;
    private SeriesDAO serie;
    private MangaDAO mangas;
    private LinearLayout ll_listeManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_information);

        serie = new SeriesDAO(this);
        mangas = new MangaDAO(this);

        ll_listeManga = findViewById(R.id.ll_pageInformation);
        tv_nomSerie = findViewById(R.id.tv_nomSerie);
        tv_nombreManga = findViewById(R.id.tv_nombreManga);
        tv_genre1 = findViewById(R.id.tv_genre1);
        tv_genre2 = findViewById(R.id.tv_genre2);
        tv_synopsis = findViewById(R.id.tv_synopsis);

        initPageInformation();

        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pageInformation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        iv_favoris = (ImageView) findViewById(R.id.iv_favoris);
        iv_favoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pageInformation.this, pageFavori.class);
                startActivity(intent);
            }
        });

    }

    public void initPageInformation() {
        final Intent demarre = new Intent(getApplicationContext(), detailsVolume.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idSerie = extras.getLong("identifiantSerie");
        }

        tv_nomSerie.setText(serie.getLaSerie(idSerie).getNomSerie().toString());
        tv_nombreManga.setText("Volume disponibles : " + Integer.toString(mangas.getLesMangas(idSerie).size()));
        tv_genre1.setText(serie.getLaSerie(idSerie).getGenre1().toString());
        tv_genre2.setText(serie.getLaSerie(idSerie).getGenre2().toString());

        // SYNOPSIS ET IMAGE A METTRE !!
        //
        //

        LinearLayout layoutManga, layoutImageManga, layoutInformations;
        ImageView imageManga;
        TextView numeroVolume;


        // PLACEMENT DES Volumes
        for (int i = 0; i < mangas.getLesMangas(idSerie).size(); i++) {
            // IMAGE DE LA SERIE
            imageManga = new ImageView(this);
            imageManga.setImageResource(R.drawable.jojopart4tome);
            imageManga.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            // INFORMATIONS DE LA SERIE
            numeroVolume = new TextView(this);
            numeroVolume.setTypeface(null, Typeface.BOLD);
            numeroVolume.setTextSize(16);
            numeroVolume.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            // LAYOUT HORIZONTAL DU VOLUME
            layoutManga = new LinearLayout(this);
            layoutManga.setOrientation(LinearLayout.HORIZONTAL);
            layoutManga.setPadding(0,0,0,50);
            layoutManga.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            // LAYOUT VERTICAL DE L'IMAGE
            layoutImageManga = new LinearLayout(this);
            layoutImageManga.setOrientation(LinearLayout.VERTICAL);
            layoutImageManga.setGravity(Gravity.LEFT | Gravity.START);
            layoutImageManga.setLayoutParams(new LinearLayout.LayoutParams(500, 500));

            // LAYOUT VERTICAL DES INFORMATIONS DU VOLUME
            layoutInformations = new LinearLayout(this);
            layoutInformations.setOrientation(LinearLayout.VERTICAL);
            layoutInformations.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            // INSERTION DES LAYOUT DANS LA LISTE DES SERIES
            ll_listeManga.addView(layoutManga);
            layoutManga.addView(layoutImageManga);
            layoutManga.addView(layoutInformations);

            // INSERTION DE L'IMAGE
            layoutImageManga.addView(imageManga);

            // INSERTION DES INFORMATIONS
            // nom de la série
            numeroVolume.setText("Volume n°"+Integer.toString(mangas.getLesMangas(idSerie).get(i).getNumeroVolume()));
            numeroVolume.setTextColor(Color.BLACK);
            layoutInformations.addView(numeroVolume);


            final int indexManga = i;

            // SI CLIQUE LAYOUT

            layoutManga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // ENVOI identifiant du film dans la base de données à l'activité reservation
                    demarre.putExtra("identifiantManga", mangas.getLesMangas(idSerie).get(indexManga).getIdSerie());
                    // DEMARRAGE de l'activité reservation
                    startActivity(demarre);
                }
            });

        }
    }
}