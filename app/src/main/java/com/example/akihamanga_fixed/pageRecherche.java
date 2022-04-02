package com.example.akihamanga_fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class pageRecherche extends AppCompatActivity {
    private ImageView iv_drame;
    private ImageView iv_fantaisie;
    private ImageView iv_romance;
    private ImageView iv_action;
    private ImageView iv_horreur;
    private ImageView iv_sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_recherche);

        iv_drame = (ImageView) findViewById(R.id.iv_drame);
        iv_fantaisie = (ImageView) findViewById(R.id.iv_fantaisie);
        iv_romance = (ImageView) findViewById(R.id.iv_romance);
        iv_action = (ImageView) findViewById(R.id.iv_action);
        iv_horreur = (ImageView) findViewById(R.id.iv_horreur);
        iv_sport = (ImageView) findViewById(R.id.iv_sport);

        iv_drame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });
    }
}