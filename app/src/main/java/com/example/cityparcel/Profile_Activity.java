package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

import java.util.List;

public class Profile_Activity extends AppCompatActivity {
    ImageView profilephoto;
//    TextView username,EmailId;
    Button logout;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;
    TextView tv_username,tv_phoneno,tv_birthdate,tv_anniversarydate,tv_userid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        profilephoto = findViewById(R.id.profilephoto);
//        EmailId = findViewById(R.id.emailid);
        logout = findViewById(R.id.logout);
        tv_username = findViewById(R.id.tv_username);
        tv_phoneno = findViewById(R.id.tv_phoneno);
        tv_birthdate = findViewById(R.id.tv_birthdate);
        tv_anniversarydate = findViewById(R.id.tv_anniversarydate);
        tv_userid = findViewById(R.id.tv_userid);

        SharedPreferences preferences = getSharedPreferences("CityParcel", MODE_PRIVATE);

        // Create DataBase SQLite
        Database database =new Database(Profile_Activity.this);
        ContentValues values = new ContentValues();
        values.put("username",preferences.getString("str_username","{}"));
        values.put("phoneno",preferences.getString("str_phoenno","{}"));
        values.put("birthdate",preferences.getString("Birthdate","{}"));
        values.put("anniversarydate",preferences.getString("AnniversaryDate","{}"));

        database.insertValue(values);
        database.close();

       /* tv_username.setText(preferences.getString("str_username","{}"));
        tv_phoneno.setText(preferences.getString("str_phoenno","{}"));
        tv_birthdate.setText(preferences.getString("Birthdate","{}"));
        tv_anniversarydate.setText(preferences.getString("AnniversaryDate","{}"));
*/

        //get values from database

        List<DBuserdetails> userlist = database.getAllValue();
        for (int i = 0; i < userlist.size(); i++) {
            tv_userid.setText(userlist.get(i).getId());
            tv_username.setText(userlist.get(i).getUsername());
            tv_phoneno.setText(userlist.get(i).getPhoneno());
            tv_birthdate.setText(userlist.get(i).getBirthdate());
            tv_anniversarydate.setText(userlist.get(i).getAnniversarydate());
        }






       /* //Google Login Set Date  From Google at user profile

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

        }*/

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