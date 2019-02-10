package com.nitt.karaens.npsc18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends ArrayAdapter<Event> {

    int mResource;
    Context mContext;
    TextView sTime,sHead,sVenue;

    public EventAdapter(@NonNull Context context, int resource, @NonNull List<Event> objects) {
        super(context, resource, objects);
        mResource = resource;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(mContext);
        if(convertView==null){
            convertView=inflater.inflate(mResource,parent,false);
        }

        sHead=convertView.findViewById(R.id.heading);
        sVenue=convertView.findViewById(R.id.venue);
        sTime=convertView.findViewById(R.id.startTime);

        sHead.setText(getItem(position).getHeading());
        sTime.setText(getItem(position).getStartTime());
        sVenue.setText(getItem(position).getVenue());

        Log.d("serser","viewset "+String.valueOf(position));

        return convertView;
    }
}
