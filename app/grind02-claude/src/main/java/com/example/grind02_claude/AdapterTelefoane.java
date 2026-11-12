package com.example.grind02_claude;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterTelefoane extends BaseAdapter {

    List<Telefon> lista;
    Context ctx;
    int resurseLayout;

    public AdapterTelefoane(List<Telefon> lista, Context ctx, int resurseLayout) {
        this.lista = lista;
        this.ctx = ctx;
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

        TextView id = view.findViewById(R.id.id);
        TextView nume = view.findViewById(R.id.nume);
        TextView memorie = view.findViewById(R.id.memorie);
        TextView integrareAI = view.findViewById(R.id.integrareAI);
        TextView rating = view.findViewById(R.id.rating);

        Telefon telefon = (Telefon) getItem(position);

        id.setText(String.valueOf(telefon.getIdTelefon()));
        nume.setText(telefon.getNume());
        memorie.setText(String.valueOf(telefon.getMemorieGB()));
        integrareAI.setText(telefon.isIntegrareAI() ? ctx.getString(R.string.da) : ctx.getString(R.string.nu));
        rating.setText(String.valueOf(telefon.getRating()));

        return view;
    }
}
