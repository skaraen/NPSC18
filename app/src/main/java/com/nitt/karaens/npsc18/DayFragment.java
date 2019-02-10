package com.nitt.karaens.npsc18;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends Fragment{

    ListView eList;
    EventAdapter mAdapter;
    ArrayList<Event> listEvents;

    public DayFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            listEvents= (ArrayList<Event>) getArguments().getSerializable("eventlist");
            Log.d("check","valrec"+String.valueOf(getArguments().getInt("pos")));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        eList=view.findViewById(R.id.eventsList);
        if(listEvents!=null){
            mAdapter=new EventAdapter(getActivity(),R.layout.listitem_layout,listEvents);
            eList.setAdapter(mAdapter);
            /*eList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent= new Intent(getActivity(),EventActivity.class);
                    intent.putExtra("day",listEvents.get(position).getDay());
                    intent.putExtra("sno",listEvents.get(position).getSno());
                    startActivity(intent);
                }
            });*/
        }
        else{
            Toast.makeText(getContext(),"Null list",Toast.LENGTH_LONG).show();
        }
        return view;
    }

}
