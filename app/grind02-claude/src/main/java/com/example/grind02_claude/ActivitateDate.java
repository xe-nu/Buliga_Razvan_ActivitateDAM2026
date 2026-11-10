package com.example.grind02_claude;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActivitateDate extends AppCompatActivity {

    ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_date);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etNume = findViewById(R.id.BR_editTextText);
        Spinner spinnerMemorie = findViewById(R.id.Buliga_Razvan_spinnerMemorie);
        RadioButton rbAI = findViewById(R.id.Buliga_Razvan_radioButton);
        RatingBar ratingBar = findViewById(R.id.RB_ratingBar);

        String[] memorieGB = {"8", "16", "32", "64", "128", "256", "512"};
        ArrayAdapter<String> memorie = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, memorieGB);
        spinnerMemorie.setAdapter(memorie);

        Button btnIntoarcere = findViewById(R.id.buttonIntoarcere);

        btnIntoarcere.setOnClickListener(v->{
            String nume = etNume.getText().toString().trim();
            if (nume.isEmpty()){
                Toast.makeText(this, "Introduceti un nume pentru telefon", Toast.LENGTH_SHORT).show();
                return;
            }

            String memorieSpinner = spinnerMemorie.getSelectedItem().toString();
            boolean integrareAI = rbAI.isChecked();
            float rating = ratingBar.getRating();

            Telefon telefon = new Telefon(nume, memorieSpinner, integrareAI, rating);

            Bundle bundle = new Bundle();

            Intent returnIntent = new Intent();

        });
    }
}