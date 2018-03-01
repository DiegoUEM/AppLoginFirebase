package com.example.a21608838.apploginfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //1 paso crear el FirebaseAuth
    private FirebaseAuth mFirebaseAuth;
    //2 Paso creamos el RC_Sing_In con el valor1
    public static final int RC_SIGN_IN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1 paso de el main creamos FirebaseAuth para firebase
        mFirebaseAuth = FirebaseAuth.getInstance();
    }
        //2 paso dentro del main firebase registro, Creamos un metodo para el registro firebase

    public void registarse(View v){
        startActivityForResult(
                AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                .setTheme(R.style.AppTheme)
                .build(), RC_SIGN_IN);
    }
        //3 paso dentro del main Creamos el metodo on activity result, con estos pasos junto con los anteriores
        //ya tendremos la funcion de registrar usuario (Recordad enlacer enn el onClick el metodo registarse,
        //obviamente en el boton Registrase firebase)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed, check response for error code
                // ...
            } } }

}
