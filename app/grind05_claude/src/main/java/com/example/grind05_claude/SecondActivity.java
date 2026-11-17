package com.example.grind05_claude;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etSerie = findViewById(R.id.Buliga_Razvan_Serie);
        EditText etMarca = findViewById(R.id.Buliga_Razvan_Marca);
        EditText etPret = findViewById(R.id.Buliga_Razvan_Pret);
        Spinner spinnerDiametre = findViewById(R.id.Buliga_Razvan_Diametre);
        CheckBox cbElectrica = findViewById(R.id.Buliga_Razvan_Electrica);
        RatingBar rbBicicleta = findViewById(R.id.Buliga_Razvan_Rating);

        Double[] diam = {20.0, 24.0, 26.0, 27.5, 29.0};
        ArrayAdapter<Double> Diametre = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, diam);
        spinnerDiametre.setAdapter(Diametre);


        Button btnSalvare = findViewById(R.id.Buliga_Razvan_Salvare);

        btnSalvare.setOnClickListener(v->{
           Intent returnIntent = new Intent();
           Bundle bundle = new Bundle();

           int Serie = Integer.parseInt(etSerie.getText().toString().trim());
           String Marca = etMarca.getText().toString().trim();
           int Pret = Integer.parseInt(etPret.getText().toString().trim());
           Double Diametru = (Double) spinnerDiametre.getSelectedItem();
           boolean Electrica = cbElectrica.isChecked();
           float Rating = rbBicicleta.getRating();

           Bicicleta b = new Bicicleta(Serie, Marca, Diametru, Electrica, Rating, Pret);
           bundle.putParcelable(Bicicleta.KEY_BICICLETA, b);
           returnIntent.putExtras(bundle);
           setResult(RESULT_OK, returnIntent);
           finish();

        });
    }
}