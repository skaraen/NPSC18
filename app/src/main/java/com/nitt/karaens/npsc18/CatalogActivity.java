package com.nitt.karaens.npsc18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CatalogActivity extends AppCompatActivity {

    TextView cName,cAbout,cSchedule,cHelpline,cLogout,cHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        cName=findViewById(R.id.cName);
        cAbout=findViewById(R.id.cAbout);
        cSchedule=findViewById(R.id.cSchedule);
        cHelpline=findViewById(R.id.cHelp);
        cLogout=findViewById(R.id.cLogout);
        cHello=findViewById(R.id.cHello);

        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            DatabaseReference DbRef=FirebaseDatabase.getInstance().getReference();
            DbRef.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    cHello.setText("Hello,");
                    cName.startAnimation(AnimationUtils.loadAnimation(CatalogActivity.this,android.R.anim.fade_in));
                    if(dataSnapshot.exists()){
                        User user=dataSnapshot.getValue(User.class);
                        cName.setText(user.getName());
                        cName.startAnimation(AnimationUtils.loadAnimation(CatalogActivity.this,android.R.anim.fade_in));
                    }
                    else
                        Log.d("tag","not exists");
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("tag","not exists");
                }
            });

        }
        else{
            startActivity(new Intent(CatalogActivity.this,LoginActivity.class));
        }

        cAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CatalogActivity.this,AboutActivity.class));
            }
        });
        cSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CatalogActivity.this,ScheduleActivity.class));
            }
        });
        cHelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CatalogActivity.this,HelpActivity.class));
            }
        });
        cLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
                editor.putInt("state",0);
                editor.apply();
                startActivity(new Intent(CatalogActivity.this,LoginActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Press \"Logout\" to exit",Toast.LENGTH_LONG).show();
    }
}
