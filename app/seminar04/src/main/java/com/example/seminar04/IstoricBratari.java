package com.example.seminar04;

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

public class IstoricBratari extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Bratara> listaBratari;
    private BratariAdapter adapter;
    private int idModificat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_istoric_bratari);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        listaBratari = getIntent().getParcelableArrayListExtra("LISTA_BRATARI");

        if (listaBratari == null) {
            listaBratari = new ArrayList<>();
        }

        adapter = new BratariAdapter(listaBratari, this, R.layout.item_layout);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentModifica = new Intent(getApplicationContext(), ActivitatePreluare.class);
                intentModifica.putExtra("MODIFICA_BRATARA", listaBratari.get(position));
                idModificat = position;
                startActivityForResult(intentModifica, 1);
            }
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            listaBratari.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Bratara stearsa", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Bratara brataraModificata = data.getParcelableExtra("BRATARA_MODIFICATA");
            if (brataraModificata == null) {
                brataraModificata = data.getParcelableExtra("BRATARA_NOUA");
            }
            if (brataraModificata != null) {
                listaBratari.set(idModificat, brataraModificata);
                adapter.notifyDataSetChanged();
            }
        }
    }
}