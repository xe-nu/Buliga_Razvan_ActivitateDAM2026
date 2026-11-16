package com.example.grind03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Cutie> lista;
    AdapterCutie adapterCutie;

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

        lv = findViewById(R.id.Buliga_Razvan_Lv);
        lista = getIntent().getParcelableArrayListExtra(Cutie.KEY_LISTA);
        adapterCutie = new AdapterCutie(this, lista, R.layout.item_layout);
        lv.setAdapter(adapterCutie);

        lv.setOnItemClickListener((parent, view, position, id) -> {
           Cutie c = lista.get(position);
           Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show();
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            Cutie c = lista.get(position);
            c.setVolum(c.getVolum() * 1.1);
            adapterCutie.notifyDataSetChanged();
            return true;
        });
    }
}