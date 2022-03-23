package com.example.akihamanga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button b_seconnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_seconnecter = (Button) findViewById(R.id.b_seconnecter);
        b_seconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConnexion();
            }
        });
    }

    public void openConnexion()
    {
        dialogueBoutonConnexion dialogue = new dialogueBoutonConnexion();
        dialogue.show(getSupportFragmentManager(), "");
    }
}