package com.example.grind05_claude;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterBiciclete extends BaseAdapter {
    Context ctx;
    ArrayList<Bicicleta> lista;
    int resurseLayout;

    public AdapterBiciclete(Context ctx, ArrayList<Bicicleta> lista, int resurseLayout) {
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

        TextView Serie = view.findViewById(R.id.Serie);
        TextView Marca = view.findViewById(R.id.Marca);
        TextView Pret = view.findViewById(R.id.Pret);
        TextView Diametru = view.findViewById(R.id.Diametru);
        TextView Electrica = view.findViewById(R.id.Electrica);
        TextView Rating = view.findViewById(R.id.Rating);

        Bicicleta bicicleta = (Bicicleta) getItem(position);

        Serie.setText(String.valueOf(bicicleta.getSerie()));
        Marca.setText(String.valueOf(bicicleta.getMarca()));
        Pret.setText(String.valueOf(bicicleta.getPret()));
        Diametru.setText(String.valueOf(bicicleta.getDiametruRoata()));
        Electrica.setText(bicicleta.isElectrica() ? ctx.getString(R.string.da) : ctx.getString(R.string.nu));
        Rating.setText(String.valueOf(bicicleta.getRating()));

        return view;
    }
}
