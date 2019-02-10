package com.nitt.karaens.npsc18;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventActivity extends AppCompatActivity {

    TextView sHead,sDay,sVenue,sStart,sEnd,sDesc;
    ImageView sCal;
    DatabaseReference DbRef;
    LinearLayout sLoc;
    Event e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        String day=getIntent().getStringExtra("day");
        String sno=getIntent().getStringExtra("sno");
        Log.d("testing3",day+sno);

        sHead=findViewById(R.id.sHead);
        sDay=findViewById(R.id.sDay);
        sVenue=findViewById(R.id.sVenue);
        sStart=findViewById(R.id.sStart);
        sEnd=findViewById(R.id.sEnd);
        sDesc=findViewById(R.id.sDesc);
        sCal=findViewById(R.id.sCal);
        sLoc=findViewById(R.id.sLoc);

        DbRef=FirebaseDatabase.getInstance().getReference();

        DbRef.child("events").child(day).child(sno).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                e=dataSnapshot.getValue(Event.class);
                sHead.setText(e.getHeading());
                sVenue.setText(e.getVenue());
                sStart.setText(e.getStartTime());
                sEnd.setText(e.getEndTime());
                sDesc.setText(Html.fromHtml(e.getDesc()));
                sDesc.setMovementMethod(LinkMovementMethod.getInstance());
                sDesc.setClickable(true);
                switch (e.getDay()){
                    case "1":
                        sDay.setText("Day 1 Friday");
                        sCal.setImageDrawable(null);
                        sCal.setBackground(getResources().getDrawable(R.drawable.dec14f));
                        break;
                    case "2":
                        sDay.setText("Day 2 Saturday");
                        sCal.setImageDrawable(null);
                        sCal.setBackground(getResources().getDrawable(R.drawable.dec15f));
                        break;
                    case "3":
                        sDay.setText("Day 3 Sunday");
                        sCal.setImageDrawable(null);
                        sCal.setBackground(getResources().getDrawable(R.drawable.dec16f));
                        break;
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        sLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventActivity.this,MapsActivity.class);
                intent.putExtra("Loc",String.valueOf(e.getVcode()));
                startActivity(intent);
            }
        });
    }
}
