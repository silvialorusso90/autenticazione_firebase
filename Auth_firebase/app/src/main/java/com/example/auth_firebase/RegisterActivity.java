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

public class RegisterActivity extends AppCompatActivity {

    EditText mConfermaPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mConfermaPassword = (EditText)findViewById(R.id.etRegPassConf);
    }

    public void btnRegistratiClick(View view) {

        Log.d("RegisterActivity", "Button Registrati clicked");
    }

    public void tvLoginClick(View view) {
        Log.d("RegisterActivity", "TextView Login clicked");

        Intent intent2 = new Intent(this, LoginActivity.class);
        startActivity(intent2);
    }

    private boolean nomeValido(String nome){
        if (nome.length() > 3)
            return true;
        else
            return false;
    }

    private boolean emailValida(String email){
        return email.contains("@");
    }

    private boolean pwValida(String password){
        String confermaPassword = mConfermaPassword.getText().toString();
        return confermaPassword.equals(password) && password.length() == 8;

    }
}
