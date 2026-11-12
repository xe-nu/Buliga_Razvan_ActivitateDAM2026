package com.example.grind02_claude;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateDate extends AppCompatActivity {

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
        EditText etID = findViewById(R.id.RB_editTextNumber);

        Double[] memorieGB = {8.0, 16.0, 32.0, 64.0, 128.0, 256.0, 512.0};
        ArrayAdapter<Double> memorie = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, memorieGB);
        spinnerMemorie.setAdapter(memorie);

        Button btnIntoarcere = findViewById(R.id.buttonIntoarcere);

        btnIntoarcere.setOnClickListener(v->{
            String nume = etNume.getText().toString().trim();
            if (nume.isEmpty()){
                Toast.makeText(this, R.string.introduceti_un_nume_pentru_telefon, Toast.LENGTH_SHORT).show();
                return;
            }

            double memorieSpinner = (double) spinnerMemorie.getSelectedItem();
            boolean integrareAI = rbAI.isChecked();
            float rating = ratingBar.getRating();
            int id = Integer.parseInt(etID.getText().toString());

            Telefon telefon = new Telefon(id, nume, memorieSpinner, integrareAI, rating);
            Bundle bundle = new Bundle();

            Intent returnIntent = new Intent();
            bundle.putParcelable(Telefon.KEY_TELEFON_NOU, telefon);
            returnIntent.putExtras(bundle);
            setResult(RESULT_OK, returnIntent);

            finish();
        });
    }
}