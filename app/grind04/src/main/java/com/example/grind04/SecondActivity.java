package com.example.grind04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<String> lista = new ArrayList<>();

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
//           int ID = Integer.parseInt(etID.getText().toString().trim());
//           String Producator = etProd.getText().toString().trim();
//           int Pret = Integer.parseInt(etPret.getText().toString().trim());
//           Double Vat = (Double) spinnerVati.getSelectedItem();
//           Boolean Nou = rbNou.isChecked();
//           Intent returnIntent = new Intent();
//           Bundle bundle = new Bundle();
//           Incarcator i = new Incarcator(ID, Producator, Pret, Vat, Nou);
//           bundle.putParcelable(Incarcator.KEY_INCARCATOR_NOU, i);
//           returnIntent.putExtras(bundle);
//           setResult(RESULT_OK, returnIntent);
//           finish();

        EditText etID = findViewById(R.id.Buliga_Razvan_ID);
        EditText etProd = findViewById(R.id.Buliga_Razvan_Producator);
        EditText etPret = findViewById(R.id.Buliga_Razvan_Pret);
        Spinner spinnerVati = findViewById(R.id.Buliga_Razvan_Vati);
        RadioButton rbNou = findViewById(R.id.Buliga_Razvan_Nou);

        Double[] vati = {30.0, 50.0, 80.0, 120.0};
        ArrayAdapter<Double> Vati = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, vati);
        spinnerVati.setAdapter(Vati);

        Button btnSalvare = findViewById(R.id.btnSalvare);
        btnSalvare.setOnClickListener(v->{
            int ID = Integer.parseInt(etID.getText().toString().trim());
            String PROD = etProd.getText().toString().trim();
            int PRET = Integer.parseInt(etPret.getText().toString().trim());
            Double VATI = (Double) spinnerVati.getSelectedItem();
            Boolean NOU = rbNou.isChecked();

            Intent returnIntent = new Intent();
            Bundle bundle = new Bundle();
            Incarcator i = new Incarcator(ID, PROD, PRET, VATI, NOU);
            bundle.putParcelable(Incarcator.KEY_INCARCATOR_NOU, i);
            returnIntent.putExtras(bundle);
            setResult(RESULT_OK, returnIntent);
            finish();
        });
    }
}