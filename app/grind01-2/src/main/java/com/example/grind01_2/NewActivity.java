package com.example.grind01_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewActivity extends AppCompatActivity {

    int suma = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        String msg = bundle.getString("msg");
        int no6 = bundle.getInt("no6", 0);
        int no7 = bundle.getInt("no7", 0);
        suma = no6 + no7;

        Toast.makeText(this, msg + " Suma: " + suma, Toast.LENGTH_SHORT).show();
        TextView textViewMesaj = findViewById(R.id.textViewMesaj);
        textViewMesaj.setText(msg + " Suma: " + suma);
    }

    public void sendBack(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("msg", "Raspuns din NewActivity");
        returnIntent.putExtra("result", suma);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}