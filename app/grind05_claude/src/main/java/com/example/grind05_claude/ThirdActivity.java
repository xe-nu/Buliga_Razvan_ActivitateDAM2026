package com.example.grind05_claude;

import android.os.Bundle;
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
    AdapterBiciclete adapterBiciclete;
    ArrayList<Bicicleta> lista;

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
        lista = getIntent().getParcelableArrayListExtra(Bicicleta.KEY_LISTA);
        adapterBiciclete = new AdapterBiciclete(getApplicationContext(), lista, R.layout.item_layout);
        lv.setAdapter(adapterBiciclete);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Bicicleta b = lista.get(position);
            Toast.makeText(getApplicationContext(), b.toString(), Toast.LENGTH_SHORT).show();
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            Bicicleta b = lista.get(position);
            b.setPret(b.getPret() * 2);
            adapterBiciclete.notifyDataSetChanged();
            return true;
        });
    }
}