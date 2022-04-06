package com.example.akihamanga_fixed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailsVolume extends AppCompatActivity {

    private Button b_localiserBoutique, b_chercherEnLigne;
    private ImageView iv_home;
    private ImageView iv_favoris,iv_imageVolumeManga;
    private TextView tv_nombreDeVolumes,tv_nomSerie;
    private MangaDAO manga;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_volume);

        manga = new MangaDAO(this);

        tv_nombreDeVolumes=findViewById(R.id.tv_nombreManga);
        tv_nomSerie=findViewById(R.id.tv_nomSerie);

        Bundle extras = getIntent().getExtras();

        String nomDeLaSerie = extras.getString("nomSerie");
        int nombreDeVolume = extras.getInt("nombreDeVolume");
        int numeroVolume = extras.getInt("numeroVolume");
        int couverture = extras.getInt("couverture");

        tv_nombreDeVolumes.setText("Volume : "+numeroVolume+"/"+nombreDeVolume);
        tv_nomSerie.setText(nomDeLaSerie);

        iv_imageVolumeManga=findViewById(R.id.iv_imageSerie);

        iv_imageVolumeManga.setImageResource(couverture);

        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailsVolume.this, pageUtilisateur.class);
                startActivity(intent);
            }
        });

        iv_favoris = (ImageView) findViewById(R.id.iv_favoris);
        iv_favoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailsVolume.this, pageFavori.class);
                startActivity(intent);
            }
        });

        b_chercherEnLigne = (Button) findViewById(R.id.b_chercherEnLigne);
        b_chercherEnLigne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailsVolume.this, recherche_en_ligne.class);
                startActivity(intent);
            }
        });

        b_localiserBoutique = (Button) findViewById(R.id.b_localiserBoutique);
        b_localiserBoutique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailsVolume.this, geolocalisation.class);
                startActivity(intent);
            }
        });

    }



}