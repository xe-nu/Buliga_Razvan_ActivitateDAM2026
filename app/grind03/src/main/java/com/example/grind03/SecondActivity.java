package com.example.grind03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<Cutie> lista = new ArrayList<>();

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

        EditText etCod = findViewById(R.id.Buliga_Razvan_etCod);
        EditText etCuloare = findViewById(R.id.Buliga_Razvan_etCuloare);
        Switch swFragil = findViewById(R.id.Buliga_Razvan_Fragil);
        RatingBar rbCutie = findViewById(R.id.Buliga_Razvan_Rating);
        Spinner spinnerVolum = findViewById(R.id.Buliga_Razvan_Volum);

        Double[] volume = {5.0, 10.0, 15.0, 20.0, 25.0, 50.0};
        ArrayAdapter<Double> Volume = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, volume);
        spinnerVolum.setAdapter(Volume);

        Button btnSalvare = findViewById(R.id.Buliga_Razvan_btnSalvare);

        btnSalvare.setOnClickListener(v->{
            int Cod = Integer.parseInt(etCod.getText().toString().trim());
            String Culoare = etCuloare.getText().toString().trim();
            Boolean Fragil = swFragil.isChecked();
            float Rating = rbCutie.getRating();
            Double Volum = (Double) spinnerVolum.getSelectedItem();


            Cutie cutie = new Cutie(Cod, Culoare, Volum, Fragil, Rating);
            Bundle bundle = new Bundle();
            bundle.putParcelable(Cutie.KEY_CUTIE_NOUA, cutie);
            Intent returnIntent = new Intent();
            returnIntent.putExtras(bundle);

            setResult(RESULT_OK, returnIntent);
            finish();
        });

    }
}