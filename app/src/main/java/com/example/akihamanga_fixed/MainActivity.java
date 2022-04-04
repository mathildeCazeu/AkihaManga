package com.example.akihamanga_fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button b_seconnecter;
    private ImageView iv_recherche;
    private ImageView iv_favoris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        // Initialisations
        final Intent demarre = new Intent(getApplicationContext(),pageUtilisateur.class);

        UtilisateurDAO user;
        Button b_connection,b_inscription;

        user=new UtilisateurDAO(this);
        b_connection=findViewById(R.id.b_connection);
        b_inscription=findViewById(R.id.b_inscription);

        b_connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogue.getEt_username()!=null && dialogue.getEt_mdp()!=null){
                    if(user.verificationConnexion(dialogue.getEt_username().toString(),dialogue.getEt_mdp().toString())==true){
                        // ENVOI identifiant du film dans la base de données à l'activité reservation
                        demarre.putExtra("identifiantsUtilisateur", dialogue.getEt_username().toString());
                        // DEMARRAGE de l'activité reservation
                        startActivity(demarre);
                    }
                }
            }
        });
    }
}