package com.example.grind_nebunie_rau_de_tot;

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

    ListView lv;
    ArrayList<Tableta> lista;
    AdapterTablete adapterTablete;

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

        lv = findViewById(R.id.lstV);
        lista = getIntent().getParcelableArrayListExtra(Tableta.KEY_LISTA_TABLETE);
        adapterTablete = new AdapterTablete(this, lista, R.layout.item_layout);
        lv.setAdapter(adapterTablete);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Tableta t = lista.get(position);
            Toast.makeText(this, t.toString(), Toast.LENGTH_SHORT).show();
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
           Tableta t = lista.get(position);
           t.setSpatiuMemorie(t.getSpatiuMemorie() * 0.9);
           adapterTablete.notifyDataSetChanged();
           return true;
        });
    }
}