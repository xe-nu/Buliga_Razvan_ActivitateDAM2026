package com.example.seminar04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImagineAdapter extends BaseAdapter {

    private List<ImaginiDomeniu> lista;
    private Context ctx;
    private int resurseLayout;

    public ImagineAdapter(List<ImaginiDomeniu> lista, Context ctx, int resurseLayout) {
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
        ImageView imageView = view.findViewById(R.id.imagine);
        TextView imgTextView = view.findViewById(R.id.descriere);

        ImaginiDomeniu item = lista.get(position);
        imageView.setImageBitmap(item.getImagine());
        imgTextView.setText(item.getTextAfisat());

        return view;
    }
}
