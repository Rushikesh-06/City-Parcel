package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_Activity extends AppCompatActivity {
    ImageView profilephoto;
    TextView username,EmailId;
    Button logout;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilephoto = findViewById(R.id.profilephoto);
        logout = findViewById(R.id.logout);
        username = findViewById(R.id.username);
        EmailId = findViewById(R.id.emailid);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentuser = firebaseAuth.getCurrentUser();


        String str_username = currentuser.getDisplayName();
        String str_email = currentuser.getEmail();
        Uri photourl = currentuser.getPhotoUrl();

        if (firebaseAuth != null){

            //set photo from current user
            Glide.with(Profile_Activity.this).load(photourl).into(profilephoto);

            //set name
            username.setText(str_username);
            EmailId.setText(str_email);

        }

        googleSignInClient = GoogleSignIn.getClient(Profile_Activity.this, GoogleSignInOptions.DEFAULT_SIGN_IN);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            firebaseAuth.signOut();

                            Toast.makeText(Profile_Activity.this, "LogOut Successfully Done", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                });
            }
        });


    }
}