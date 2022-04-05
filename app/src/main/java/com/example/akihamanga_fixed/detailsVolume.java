package com.example.akihamanga_fixed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class detailsVolume extends AppCompatActivity {

    private ImageView iv_home;
    private ImageView iv_favoris;
    private Button b_localiserBoutique, b_chercherEnLigne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_volume);

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


    }



}