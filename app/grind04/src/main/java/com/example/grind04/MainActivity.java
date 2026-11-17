package com.example.grind04;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Incarcator> lista = new ArrayList<>();
    TextView incar;

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

        incar = findViewById(R.id.tvLista);

        Button btnThird = findViewById(R.id.btnThird);

        btnThird.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            intent.putParcelableArrayListExtra(Incarcator.KEY_LISTA, lista);
            startActivityForResult(intent, 67);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 67 && resultCode == RESULT_OK && data != null){
            Incarcator c = data.getParcelableExtra(Incarcator.KEY_INCARCATOR_NOU);
            if(c != null){
                lista.add(c);
                incar.setText(c.toString());
                Toast.makeText(getApplicationContext(), "Incarcatorul adaugat cu succes", Toast.LENGTH_SHORT).show();
            }
        }
    }
}