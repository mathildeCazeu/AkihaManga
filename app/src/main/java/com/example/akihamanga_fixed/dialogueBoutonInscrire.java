package com.example.akihamanga_fixed;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class dialogueBoutonInscrire extends AppCompatDialogFragment {
    private EditText et_emailInscrire;
    private EditText et_mdpInscrire;
    private EditText et_pseudoInscrire;

    public void setEt_pseudo(EditText et_pseudo) { this.et_pseudoInscrire = et_pseudo; }

    public EditText getEt_pseudo() { return et_pseudoInscrire; }

    public EditText getEt_username() {
        return (EditText) et_emailInscrire.getText();
    }

    public void setEt_username(EditText et_username) {
        this.et_emailInscrire = et_username;
    }

    public EditText getEt_mdp() {
        return (EditText) et_mdpInscrire.getText();
    }

    public void setEt_mdp(EditText et_mdp) {
        this.et_mdpInscrire = et_mdp;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_inscription, null);

        et_pseudoInscrire = view.findViewById(R.id.et_pseudoInscrire);
        et_emailInscrire = view.findViewById(R.id.et_emailInscrire);
        et_mdpInscrire = view.findViewById(R.id.et_password);

        builder.setView(view);
        return builder.create();


    }
}