package com.example.akihamanga_fixed;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialogueBoutonConnexion extends AppCompatDialogFragment {
    private EditText et_username;
    private EditText et_mdp;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_connexion, null);

        et_username = view.findViewById(R.id.et_username);
        et_mdp = view.findViewById(R.id.et_password);
        builder.setView(view);
        return builder.create();
    }
}