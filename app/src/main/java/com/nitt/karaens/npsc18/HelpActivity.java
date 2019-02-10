package com.nitt.karaens.npsc18;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HelpActivity extends AppCompatActivity {

    LinearLayout hHos,hAmbulance,hHelp;
    DatabaseReference DbRef=FirebaseDatabase.getInstance().getReference();
    String phno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        hHos=findViewById(R.id.hHospitality);
        hAmbulance=findViewById(R.id.hAmbulance);
        hHelp=findViewById(R.id.hHelp);

        hHos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbRef.child("helpline").child("Hospitality").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            phno=dataSnapshot.getValue(String.class);
                            callNumber();
                        }
                        else
                            Toast.makeText(HelpActivity.this,"Number not available as of now. Please try again later",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(HelpActivity.this,"Number not available as of now. Please try again later",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        hAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbRef.child("helpline").child("Ambulance").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            phno=dataSnapshot.getValue(String.class);
                            callNumber();
                        }
                        else
                            Toast.makeText(HelpActivity.this,"Number not available as of now. Please try again later",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(HelpActivity.this,"Number not available as of now. Please try again later",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        hHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbRef.child("helpline").child("Help Desk").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            phno=dataSnapshot.getValue(String.class);
                            callNumber();
                        }
                        else
                            Toast.makeText(HelpActivity.this,"Number not available as of now. Please try again later",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(HelpActivity.this,"Number not available as of now. Please try again later",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }

    void callNumber(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phno));
        startActivity(intent);
    }
}
