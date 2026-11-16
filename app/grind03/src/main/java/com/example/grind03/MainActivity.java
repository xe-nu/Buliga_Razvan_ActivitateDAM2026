package com.example.grind03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cutie> lista = new ArrayList<>();
    TextView tvUltimaCutie;

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

        Button btnSecond = findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, 67);
        });

        tvUltimaCutie = findViewById(R.id.tvUltimaCutie);

        Button btnThird = findViewById(R.id.btnThird);
        btnThird.setOnClickListener(v->{
           Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
           intent.putParcelableArrayListExtra(Cutie.KEY_LISTA, lista);
           startActivityForResult(intent, 67);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 67 && resultCode == RESULT_OK && data != null){
            Cutie cutie = data.getParcelableExtra(Cutie.KEY_CUTIE_NOUA);
            if (cutie != null){
                lista.add(cutie);
                tvUltimaCutie.setText(cutie.toString());
                Toast.makeText(this, R.string.cutia_a_fost_adaugata_cu_succes, Toast.LENGTH_SHORT).show();
            }
        }
    }
}