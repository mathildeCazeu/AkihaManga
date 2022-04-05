package com.example.akihamanga_fixed;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialogueBoutonConnexion extends AppCompatDialogFragment {
    private EditText et_username;
    private EditText et_mdp;
    private ExampleDialogListener listener;

    private UtilisateurDAO user;



    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_connexion, null);


        builder.setNeutralButton("Connexion", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                user=new UtilisateurDAO(getContext());

                if(et_username.getText().toString()!="" && et_mdp.getText().toString()!=""){
                    listener.verifConnection(user.verificationConnexion(et_username.getText().toString(),et_mdp.getText().toString()),et_username.getText().toString(),et_mdp.getText().toString());
                }
            }
        });
        et_username = view.findViewById(R.id.et_pseudoInscrire);
        et_mdp = view.findViewById(R.id.et_password);
        builder.setView(view);
        return builder.create();


    }

    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+" a un soucis");
        }
    }

    public interface ExampleDialogListener{
        void verifConnection(Boolean connectionValide,String email, String mdp);
    }


}