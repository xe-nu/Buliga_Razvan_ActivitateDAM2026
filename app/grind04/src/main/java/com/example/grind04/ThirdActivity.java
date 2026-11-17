package com.example.grind04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Incarcator> lista;
    AdapterIncarcator adapterIncarcator;

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

        lv = findViewById(R.id.lv);
        lista = getIntent().getParcelableArrayListExtra(Incarcator.KEY_LISTA);
        adapterIncarcator = new AdapterIncarcator(this, lista, R.layout.item_layout);
        lv.setAdapter(adapterIncarcator);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Incarcator incarcator = lista.get(position);
            Toast.makeText(this, incarcator.toString(), Toast.LENGTH_SHORT).show();
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            Incarcator incarcator = lista.get(position);
            incarcator.setPret(incarcator.getPret() * 2);
            adapterIncarcator.notify();
            return true;
        });
    }
}