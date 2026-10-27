package com.example.seminar04;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD = 100;
    private final ArrayList<Bratara> listaBratari = new ArrayList<>();
    private TextView tvRezultat;

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

        Button btnAdauga = findViewById(R.id.buttonActivitatePreluare);
        tvRezultat = findViewById(R.id.tvRezultat);

        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivitatePreluare.class);
            startActivityForResult(intent, REQUEST_CODE_ADD);
        });

        Button btnIstoricBratari = findViewById(R.id.btnIstoricBratari);
        btnIstoricBratari.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, IstoricBratari.class);
            intent.putParcelableArrayListExtra("LISTA_BRATARI",  listaBratari);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK && data != null) {
            Bratara bratara = data.getParcelableExtra("BRATARA_NOUA");

            if (bratara != null) {
                tvRezultat.setText(bratara.toString());
                Toast.makeText(this, "Bratara adauga cu succes!", Toast.LENGTH_SHORT).show();
            } else {
                String brataraText = data.getStringExtra("BRATARA_NOUA");
                if (brataraText != null) {
                    tvRezultat.setText(brataraText.toString());
                    Toast.makeText(this, "Bratara adaugata cu succes!", Toast.LENGTH_SHORT).show();
                }
            }

            listaBratari.add(bratara);
            tvRezultat.setText("Total: " + listaBratari.size());
            Toast.makeText(this, "Obiect salvat lista", Toast.LENGTH_SHORT).show();
        }
    }

}