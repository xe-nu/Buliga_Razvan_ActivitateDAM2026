package com.example.seminar04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivitatePreluare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate_preluare);

        EditText etMarca = findViewById(R.id.etMarca);
        Spinner spinner = findViewById(R.id.spinner);
        RadioGroup rgMarime = findViewById(R.id.rgMarime);
        CheckBox cbPietre = findViewById(R.id.cbPietre);
        Switch switchAjustabila = findViewById(R.id.switchAjustabila);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        String[] materiale = {"Aur", "Argint", "Piele", "Otel Inoxidabil"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, materiale);
        spinner.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String marca = etMarca.getText().toString().trim();
            if (marca.isEmpty()) {
                Toast.makeText(this, "Introduceti marca", Toast.LENGTH_SHORT).show();
                return;
            }


            String material = spinner.getSelectedItem().toString();
            boolean arePietre = cbPietre.isChecked();
            boolean ajustabila = switchAjustabila.isChecked();
            float rating = ratingBar.getRating();

            int selectedId = rgMarime.getCheckedRadioButtonId();
            RadioButton rbSelectat = findViewById(selectedId);
            String marime = rbSelectat != null ? rbSelectat.getText().toString() : "M";
            Bratara brataraNoua = new Bratara(marca, arePietre, marime, material, rating, ajustabila);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("BRATARA_NOUA", brataraNoua.toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}