package com.cm.blabapiso;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class MainActivity extends AppCompatActivity {

    private static final String TAG= "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

<<<<<<< HEAD
=======
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
    public void getProviderData(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){
            for(UserInfo profile : user.getProviderData()){
                String providerId = profile.getProviderId();
                String uid = profile.getUid();
                String name = profile.getDisplayName();
                String email = profile.getEmail();
                Uri photoUrl = profile.getPhotoUrl();
            }
        }
    }


    //Comentario de prueba
>>>>>>> 9856e7292d1b75c84c23f56c9d7b4d98babb02d7

}


