package com.cm.blabapiso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class FireBaseUIActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int RC_SING_IN = 123;
    private GoogleSignInClient mGoogleSingInClient;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_ui);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSingInClient = GoogleSignIn.getClient(this, gso);
        // [END config_signin]

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
        com.google.android.gms.common.SignInButton botoninicio= (com.google.android.gms.common.SignInButton)findViewById(R.id.sign_in_button);
        botoninicio.setOnClickListener(this);
    }

    public void singIn(){
        Intent singInIntent = mGoogleSingInClient.getSignInIntent();
        startActivityForResult(singInIntent, RC_SING_IN);
    }

    public void createSignInIntent() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()

        );

        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder().setAvailableProviders(providers).build(), RC_SING_IN);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode ==RC_SING_IN){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            }else{
                //falta por completar el tratamiento de cuando se calcela el inicio de sesion
            }

        }
    }

    public void signOut(){
        AuthUI.getInstance().signOut(this) .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Log.d("LogOut", "LogOut:Success");

                }else{
                    Log.w("LogOut", "LogOut:Failure", task.getException());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        singIn();
    }
}
