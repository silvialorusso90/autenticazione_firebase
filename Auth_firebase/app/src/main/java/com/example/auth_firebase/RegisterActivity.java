package com.example.auth_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText mConfermaPassword;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //verifica se l'utente esiste
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this, "Utente già loggato.", Toast.LENGTH_SHORT).show();

        //aggiorna l'interfaccia utente
        //updateUI(currentUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mConfermaPassword = (EditText)findViewById(R.id.etRegPassConf);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }

    public void btnRegistratiClick(View view) {

        Log.d("RegisterActivity", "Button Registrati clicked");
    }

    public void tvLoginClick(View view) {
        Log.d("RegisterActivity", "TextView Login clicked");

        Intent intent2 = new Intent(this, LoginActivity.class);
        startActivity(intent2);
    }

    //il nome deve avere almeno 3 lettere
    private boolean nomeValido(String nome){
        if (nome.length() > 2)
            return true;
        else
            return false;
    }

    //l'email deve contenere il carattere @
    private boolean emailValida(String email){
        return email.contains("@");
    }

    //la password deve avere 8 lettere
    private boolean pwValida(String password){
        String confermaPassword = mConfermaPassword.getText().toString();
        return confermaPassword.equals(password) && password.length() == 8;

    }
}
