package com.nitt.karaens.npsc18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEventActivity extends AppCompatActivity {

    EditText eDay,eSno,eHead,eVenue,eStart,eEnd,eDesc,eCode;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        eDay=findViewById(R.id.eDay);
        eVenue=findViewById(R.id.eVenue);
        eHead=findViewById(R.id.eHead);
        eSno=findViewById(R.id.eSno);
        eStart=findViewById(R.id.eStart);
        eEnd=findViewById(R.id.eEnd);
        eDesc=findViewById(R.id.eDesc);
        eCode=findViewById(R.id.eCode);
        bt=findViewById(R.id.btadd);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eDay.getText()!=null&&eSno.getText()!=null&&eHead.getText()!=null&&eVenue.getText()!=null&&eStart.getText()!=null&&
                        eEnd.getText()!=null&&eDesc.getText()!=null&&eCode.getText()!=null){
                    Event event=new Event(eDay.getText().toString(),eSno.getText().toString(),eHead.getText().toString(),
                                          eVenue.getText().toString(),eStart.getText().toString(),
                                          eEnd.getText().toString(),eDesc.getText().toString(),
                                          eCode.getText().toString());
                    DatabaseReference DbRef=FirebaseDatabase.getInstance().getReference();
                    DbRef.child("events").child(event.getDay()).child(event.getSno()).setValue(event);
                    Toast.makeText(AddEventActivity.this,"Event Added!",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(AddEventActivity.this,AdminActivity.class));
                }
            }
        });


    }
}
