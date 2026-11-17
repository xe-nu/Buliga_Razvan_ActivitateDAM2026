package com.example.grind04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterIncarcator extends BaseAdapter {
    Context ctx;
    ArrayList<Incarcator> lista;
    int resurseLayout;

    public AdapterIncarcator(Context ctx, ArrayList<Incarcator> lista, int resurseLayout) {
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

        TextView ID = view.findViewById(R.id.ID);
        TextView PROD = view.findViewById(R.id.PROD);
        TextView PRET = view.findViewById(R.id.PRET);
        TextView VATI = view.findViewById(R.id.VATI);
        TextView NOU = view.findViewById(R.id.NOU);
        
        Incarcator incarcator = (Incarcator) getItem(position);
        
        ID.setText(String.valueOf(incarcator.getId()));
        PROD.setText(String.valueOf(incarcator.getProducator()));
        PRET.setText(String.valueOf(incarcator.getPret()));
        VATI.setText(String.valueOf(incarcator.getVati()));
        NOU.setText(incarcator.isNou() ? ctx.getString(R.string.da) : ctx.getString(R.string.nu));

        return view;
    }
}
