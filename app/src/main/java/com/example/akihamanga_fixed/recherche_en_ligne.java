package com.example.akihamanga_fixed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class recherche_en_ligne extends AppCompatActivity {

    private ImageView iv_home;
    private ImageView iv_favoris;
    private Button b_allerSiteAmazon, b_allerSiteFnac, b_allerSiteMomoxshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_en_ligne);

        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(recherche_en_ligne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        iv_favoris = (ImageView) findViewById(R.id.iv_favoris);
        iv_favoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(recherche_en_ligne.this, pageFavori.class);
                startActivity(intent);
            }
        });

        b_allerSiteAmazon = (Button) findViewById(R.id.b_allerSiteAmazon);
        b_allerSiteAmazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://amzn.to/3LMJyOL"));
                startActivity(viewIntent);
            }
        });

        b_allerSiteFnac = (Button) findViewById(R.id.b_allerSiteFnac);
        b_allerSiteFnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://bit.ly/3uQ8UV6"));
                startActivity(viewIntent);
            }
        });

        b_allerSiteMomoxshop = (Button) findViewById(R.id.b_allerSiteMomoxshop);
        b_allerSiteMomoxshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://bit.ly/3KfgZJG"));
                startActivity(viewIntent);
            }
        });



    }
}