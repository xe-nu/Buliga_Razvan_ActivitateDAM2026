package com.example.seminar04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BratariAdapter extends BaseAdapter {

    private List<Bratara> bratari = null;

    private Context ctx;

    private int resurseLayout;

    public BratariAdapter(List<Bratara> bratari, Context ctx, int resurseLayout){
        this.bratari = bratari;
        this.ctx = ctx;
        this.resurseLayout = resurseLayout;
    }

    @Override
    public int getCount() {
        return bratari.size();
    }

    @Override
    public Object getItem(int position) {
        return bratari.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resurseLayout, parent, false);

        TextView marca = view.findViewById(R.id.marca);
        TextView arePietre = view.findViewById(R.id.arePietre);
        TextView marime = view.findViewById(R.id.marime);
        TextView rating = view.findViewById(R.id.rating);
        TextView material = view.findViewById(R.id.material);
        TextView ajustabila = view.findViewById(R.id.ajustabila);

        Bratara bratara = (Bratara)getItem(position);

        marca.setText(bratara.getMarca());
        arePietre.setText(bratara.getArePietre() ? "Da" : "Nu");
        marime.setText(bratara.getMarime());
        rating.setText(String.valueOf(bratara.getRating()));
        material.setText(bratara.getMaterial());
        ajustabila.setText(bratara.isAjustabila() ? "Da" : "Nu");

        return view;
    }
}
