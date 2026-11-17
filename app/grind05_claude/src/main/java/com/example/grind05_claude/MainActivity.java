package com.example.grind05_claude;

import android.content.Intent;
import android.os.Bundle;
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

    ArrayList<Bicicleta> lista = new ArrayList<>();
    TextView tvLista;

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

        btnSecond.setOnClickListener(v->{
           Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
           startActivityForResult(intent, 67);
        });

        tvLista = findViewById(R.id.tvLista);

        Button btnThird = findViewById(R.id.btnThird);
        btnThird.setOnClickListener(v->{
           Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
           intent.putParcelableArrayListExtra(Bicicleta.KEY_LISTA, lista);
           startActivityForResult(intent, 67);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 67 && resultCode == RESULT_OK && data != null){
            Bicicleta bicicleta = data.getParcelableExtra(Bicicleta.KEY_BICICLETA);
            if(bicicleta != null) {
                lista.add(bicicleta);
                tvLista.setText(bicicleta.toString());
                Toast.makeText(getApplicationContext(), "Bicicleta a fost adaugata cu succes!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}