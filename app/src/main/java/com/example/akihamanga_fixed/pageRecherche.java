package com.example.akihamanga_fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class pageRecherche extends AppCompatActivity {

    private EditText et_rechercher;
    private Button b_annuler;
    private ImageView iv_drame,iv_fantaisie,iv_romance,iv_action,iv_horreur,iv_sport;

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
        b_annuler = (Button) findViewById(R.id.b_annuler);
        et_rechercher = (EditText) findViewById(R.id.et_rechercher);

        //LORS DU CLIQUE BOUTON ANNULER
        b_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_rechercher.setText("");
            }
        });

        // LORS D'UNE RECHERCHE PAR NOM
       /* et_rechercher.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus){
                    if(et_rechercher.getText()!=null){
                        final Intent demarre = new Intent(getApplicationContext(),recherche_par_nom.class);
                        demarre.putExtra("nomSerie",et_rechercher.getText().toString());
                        startActivity(demarre);
                    }
                }
            }
        });*/


        //LORS D'UNE RECHERCHE PAR GENRE
        iv_drame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Intent demarre = new Intent(getApplicationContext(),rechercheParGenre.class);
                demarre.putExtra("nomGenre","Drame");
                startActivity(demarre);
            }
        });

        iv_fantaisie.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Intent demarre = new Intent(getApplicationContext(),rechercheParGenre.class);
                demarre.putExtra("nomGenre","Fantaisie");
                startActivity(demarre);
            }
        });

        iv_romance.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Intent demarre = new Intent(getApplicationContext(),rechercheParGenre.class);
                demarre.putExtra("nomGenre","Romance");
                startActivity(demarre);
            }
        });


        iv_action.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Intent demarre = new Intent(getApplicationContext(),rechercheParGenre.class);
                demarre.putExtra("nomGenre","Action");
                startActivity(demarre);
            }
        });

        iv_horreur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Intent demarre = new Intent(getApplicationContext(),rechercheParGenre.class);
                demarre.putExtra("nomGenre","Horreur");
                startActivity(demarre);
            }
        });

        iv_sport.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Intent demarre = new Intent(getApplicationContext(),rechercheParGenre.class);
                demarre.putExtra("nomGenre","Sport");
                startActivity(demarre);
            }
        });

    }
}