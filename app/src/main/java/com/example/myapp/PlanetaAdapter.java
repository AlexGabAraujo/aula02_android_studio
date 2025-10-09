package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    Context mContext;
    int layoutResourceId;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.layoutResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){}
    LayoutInflater inflater = LayoutInflater.from
}
