package com.example.grind02_claude;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Telefon> lista = new ArrayList<>();
    TextView tvTelefoane;


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

        Button buttonAD = findViewById(R.id.buttonAD);
        buttonAD.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivitateDate.class);
            startActivityForResult(intent, 67);
        });


        tvTelefoane = findViewById(R.id.textViewTelefoane);

        Button btn3rd = findViewById(R.id.btn3rd);
        btn3rd.setOnClickListener(v->{
           Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
           intent.putParcelableArrayListExtra(Telefon.KEY_LISTA, lista);
           startActivityForResult(intent, 67);
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 67 && resultCode == RESULT_OK && data != null){

            Telefon telefon = data.getParcelableExtra(Telefon.KEY_TELEFON_NOU);
            if (telefon != null){
                lista.add(telefon);
                tvTelefoane.setText(telefon.toString());
                Toast.makeText(this, R.string.telefonul_a_fost_adaugat_cu_succes, Toast.LENGTH_SHORT).show();
            }
        }
    }
}