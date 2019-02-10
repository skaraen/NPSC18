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


public class Day1Frag extends Fragment {

    ArrayList<Event> d1 = new ArrayList<>();
    EventAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_day1, container, false);
        ListView listView=rootView.findViewById(R.id.day1List);
        adapter=new EventAdapter(this.getActivity(),R.layout.listitem_layout,getDay1events());
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position=position+1;
                Intent intent=new Intent(getActivity(),EventActivity.class);
                intent.putExtra("day",String.valueOf(1));
                intent.putExtra("sno",String.valueOf(position));
                startActivity(intent);
            }
        });
        return rootView;
    }

    ArrayList<Event> getDay1events(){
        DatabaseReference DbRef = FirebaseDatabase.getInstance().getReference();

        DbRef.child("events").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()&&d1.size()==0) {
                    for (DataSnapshot ps : dataSnapshot.getChildren()) {
                        Event e = ps.getValue(Event.class);
                        d1.add(e);
                        adapter.notifyDataSetChanged();
                    }
                    Log.d("serser", "Data 1 exists"+String.valueOf(d1.size()));
                } else {
                    Log.d("serser", "Data 1 doesn't exists");                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("serser", "Request Denied 1");
            }
        });

        return d1;
    }


}
