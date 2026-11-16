package com.example.grind_nebunie_rau_de_tot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        EditText EtID = findViewById(R.id.Buliga_Razvan_ID);
        EditText EtModel = findViewById(R.id.Buliga_Razvan_Model);
        CheckBox CbAI = findViewById(R.id.Buliga_Razvan_AI);
        Spinner SpinnerMemorie = findViewById(R.id.Buliga_Razvan_Memorie);

        Double[] Memorii = {128.0, 256.0, 512.0, 1024.0};
        ArrayAdapter<Double> Memorie = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, Memorii);
        SpinnerMemorie.setAdapter(Memorie);

        Button btnSalvare = findViewById(R.id.Buliga_Razvan_Salvare);

        btnSalvare.setOnClickListener(v->{
            int ID = Integer.parseInt(EtID.getText().toString());
            String Model = EtModel.getText().toString().trim();
            Boolean AI = CbAI.isChecked();
            Double Memorie_ = (Double) SpinnerMemorie.getSelectedItem();

            Intent returnIntent = new Intent();
            Tableta tableta = new Tableta(ID, Model, Memorie_, AI);
            Bundle bundle = new Bundle();

            bundle.putParcelable(Tableta.KEY_TABLETA_NOUA, tableta);
            returnIntent.putExtras(bundle);
            setResult(RESULT_OK, returnIntent);

            finish();
        });



    }
}