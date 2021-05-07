package com.cm.blabapiso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    private static final String TAG= "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);

       // getActionBar().hide();
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


}


