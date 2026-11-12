package com.example.grind02_claude;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    ListView listView;
    AdapterTelefoane adapterTelefoane;

    ArrayList<Telefon> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.lv);

        lista = getIntent().getParcelableArrayListExtra(Telefon.KEY_LISTA);;

        adapterTelefoane = new AdapterTelefoane(lista, this, R.layout.item_layout);
        listView.setAdapter(adapterTelefoane);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Telefon t = lista.get(position);
            Toast.makeText(this, t.toString(), Toast.LENGTH_SHORT).show();
        });


        listView.setOnItemLongClickListener((parent, view, position, id) -> {
           Telefon t = lista.get(position);
           t.setMemorieGB(t.getMemorieGB() * 0.9);
           adapterTelefoane.notifyDataSetChanged();
           return true;
        });
    }
}