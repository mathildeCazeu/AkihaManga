package com.example.akihamanga_fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button b_seconnecter;
    private TextView tf_textView42;

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

        tf_textView42 = (TextView) findViewById(R.id.textView42);
    }

    public void openConnexion()
    {
        dialogueBoutonConnexion dialogue = new dialogueBoutonConnexion();
        dialogue.show(getSupportFragmentManager(), "");
    }
}