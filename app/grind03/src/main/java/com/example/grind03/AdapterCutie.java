package com.example.grind03;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


//    Context ctx;
//    List<Cutie> lista;
//    int resurseLayout;
//
//    public AdapterCutie(Context ctx, int resurseLayout, List<Cutie> lista) {
//        this.ctx = ctx;
//        this.resurseLayout = resurseLayout;
//        this.lista = lista;
//    }
//
//    @Override
//    public int getCount() {
//        return lista.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return lista.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(ctx);
//        View view = inflater.inflate(resurseLayout, parent, false);
//
//        TextView cod = view.findViewById(R.id.Cod);
//        TextView culoare = view.findViewById(R.id.Culoare);
//        TextView volum = view.findViewById(R.id.Volum);
//        TextView rating = view.findViewById(R.id.Rating);
//        TextView fragila = view.findViewById(R.id.Fragila);
//
//        Cutie cutie = (Cutie) getItem(position);
//
//        cod.setText(String.valueOf(cutie.getCod()));
//        culoare.setText(String.valueOf(cutie.getCuloare()));
//        volum.setText(String.valueOf(cutie.getVolum()));
//        rating.setText(String.valueOf(cutie.getRating()));
//        fragila.setText(cutie.isFragila() ? ctx.getString(R.string.da) : ctx.getString(R.string.nu));
//
//        return view;
//    }
//}

public class AdapterCutie extends BaseAdapter {
    Context ctx;
    List<Cutie> lista;
    int resurseLayout;

    public AdapterCutie(Context ctx, List<Cutie> lista, int resurseLayout) {
        this.ctx = ctx;
        this.lista = lista;
        this.resurseLayout = resurseLayout;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(resurseLayout, parent, false);

        TextView cod = view.findViewById(R.id.Cod);
        TextView culoare = view.findViewById(R.id.Culoare);
        TextView volum = view.findViewById(R.id.Volum);
        TextView rating = view.findViewById(R.id.Rating);
        TextView fragila = view.findViewById(R.id.Fragila);

        Cutie cutie = (Cutie) getItem(position);

        cod.setText(String.valueOf(cutie.getCod()));
        culoare.setText(String.valueOf(cutie.getCuloare()));
        volum.setText(String.valueOf(cutie.getVolum()));
        rating.setText(String.valueOf(cutie.getRating()));
        fragila.setText(cutie.isFragila() ? ctx.getString(R.string.da) : ctx.getString(R.string.nu));

        return view;
    }
}