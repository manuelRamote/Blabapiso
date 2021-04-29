package com.cm.blabapiso;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG= "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkCurrentUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){
            //Completar el tratamiento del usuario
        }
    }

    public void getUserProfile(){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String name = user.getDisplayName();
            String email= user.getEmail();
            Uri photoUrl= user.getPhotoUrl();
            //Verificar que el email es valido
            boolean emailVerified= user.isEmailVerified();
            String uid = user.getUid();
        }

    }


    //Comentario de prueba

    //prueba 2
    //prueba instalacion
}


