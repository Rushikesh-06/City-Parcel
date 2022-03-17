package com.example.cityparcel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyAccountFragment extends Fragment {

    ImageView profilephoto;
    TextView username,EmailId;
    Button logout;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile,container,false);



        profilephoto = view.findViewById(R.id.profilephoto);
        logout = view.findViewById(R.id.logout);
        username = view.findViewById(R.id.username);
        EmailId = view.findViewById(R.id.emailid);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentuser = firebaseAuth.getCurrentUser();

        if (firebaseAuth != null){

            //set photo from current user
            Glide.with(MyAccountFragment.this).load(currentuser.getPhotoUrl()).into(profilephoto);

            //set name
            username.setText(currentuser.getDisplayName());
            EmailId.setText(currentuser.getEmail());

        }

        googleSignInClient = GoogleSignIn.getClient(getActivity(), GoogleSignInOptions.DEFAULT_SIGN_IN);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            firebaseAuth.signOut();

                            Toast.makeText(getContext(), "LogOut Successfully Done", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getContext(),LogIn_activity.class));
                            getActivity().finish();

                        }

                    }
                });
            }
        });


        return view;


    }
}
