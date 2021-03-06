package com.example.akihamanga_fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements dialogueBoutonConnexion.ExampleDialogListener {

    private Button b_seconnecter;
    private ImageView iv_recherche;
    private ImageView iv_favoris;
    private Button b_inscription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*b_inscription = (Button) findViewById(R.id.b_inscription);
        b_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInscription();
            }
        });*/


        iv_favoris = (ImageView) findViewById(R.id.iv_favoris);
        iv_favoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pageFavori.class);
                startActivity(intent);
            }
        });

        b_seconnecter = (Button) findViewById(R.id.b_seconnecter);
        b_seconnecter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                openConnexion();
            }
        });

        iv_recherche = (ImageView) findViewById(R.id.imageView26); //Appel de l'image view 26 -> image de loupe
        iv_recherche.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, pageRecherche.class);
                startActivity(intent);
            }
        });

    }

    //POPUP connexion
    public void openConnexion()
    {
        dialogueBoutonConnexion dialogue = new dialogueBoutonConnexion();
        dialogue.show(getSupportFragmentManager(), "");
    }

    public void openInscription()
    {
        dialogueBoutonInscrire dialogue = new dialogueBoutonInscrire();
        dialogue.show(getSupportFragmentManager(), "");
    }


    @Override
    public void verifConnection(Boolean connectionValide,String email, String mdp) {
        if (connectionValide==true){
            final Intent demarre = new Intent(getApplicationContext(),pageUtilisateur.class);
            demarre.putExtra("utilisateurEmail",email);
            startActivity(demarre);
        }
    }
}