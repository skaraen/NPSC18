package com.nitt.karaens.npsc18;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Day2Frag extends Fragment {

    ArrayList<Event> d2=new ArrayList<>();
    EventAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_day2, container, false);
        ListView listView=rootView.findViewById(R.id.day2List);
        adapter=new EventAdapter(this.getActivity(),R.layout.listitem_layout,getDay2events());
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position=position+1;
                Intent intent=new Intent(getActivity(),EventActivity.class);
                intent.putExtra("day",String.valueOf(2));
                intent.putExtra("sno",String.valueOf(position));
                startActivity(intent);
            }
        });
        return rootView;
    }

    ArrayList<Event> getDay2events(){
        DatabaseReference DbRef = FirebaseDatabase.getInstance().getReference();

        DbRef.child("events").child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()&&d2.size()==0) {
                    for (DataSnapshot ps : dataSnapshot.getChildren()) {
                        Event e = ps.getValue(Event.class);
                        d2.add(e);
                        adapter.notifyDataSetChanged();
                    }
                    Log.d("serser", "Data 2 exists"+String.valueOf(d2.size()));
                } else {
                    Log.d("serser", "Data 2 doesn't exists");                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("serser", "Request Denied 2");
            }
        });

        return d2;
    }
}
