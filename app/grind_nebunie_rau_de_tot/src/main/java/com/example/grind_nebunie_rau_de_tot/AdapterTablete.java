package com.example.grind_nebunie_rau_de_tot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterTablete extends BaseAdapter {

    Context ctx;
    List<Tableta> lista;
    int resurseLayout;

    public AdapterTablete(Context ctx, List<Tableta> lista, int resurseLayout) {
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
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resurseLayout, parent, false);

        TextView id = view.findViewById(R.id.ID);
        TextView model = view.findViewById(R.id.Model);
        TextView memorie = view.findViewById(R.id.Memorie);
        TextView ai = view.findViewById(R.id.AI);

        Tableta tableta = (Tableta) getItem(position);

        id.setText(String.valueOf(tableta.getIdTableta()));
        model.setText(String.valueOf(tableta.getModel()));
        memorie.setText(String.valueOf(tableta.getSpatiuMemorie()));
        ai.setText(tableta.isIntegrareAI() ? ctx.getString(R.string.Da) : ctx.getString(R.string.Nu));

        return view;
    }
}
