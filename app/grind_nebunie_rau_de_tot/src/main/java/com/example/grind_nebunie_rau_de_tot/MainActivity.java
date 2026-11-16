package com.example.grind_nebunie_rau_de_tot;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Tableta> lista = new ArrayList<>();

    TextView tvTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button SecondBtn = findViewById(R.id.btnSecond);
        SecondBtn.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, 67);
        });

        tvTab = findViewById(R.id.textView2);

        Button ThirdBtn = findViewById(R.id.btnThird);
        ThirdBtn.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            intent.putParcelableArrayListExtra(Tableta.KEY_LISTA_TABLETE, lista);
            startActivityForResult(intent, 67);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 67 && resultCode == RESULT_OK && data != null){
            Tableta tableta = data.getParcelableExtra(Tableta.KEY_TABLETA_NOUA);
            if (tableta != null){
                lista.add(tableta);
                tvTab.setText(tableta.toString());
                Toast.makeText(this, R.string.tableta_a_fost_adaugata_cu_succes, Toast.LENGTH_SHORT).show();
            }
        }

    }
}