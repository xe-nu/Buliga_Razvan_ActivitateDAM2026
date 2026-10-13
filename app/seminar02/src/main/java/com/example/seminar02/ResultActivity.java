package com.example.seminar02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    int suma = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        String msg = bundle.getString("msg");
        int no1 = bundle.getInt("no1", 0);
        int no2 = bundle.getInt("no2", 0);
        suma = no1 + no2;

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void sendBack(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("msg", "Message from ResultActivity");
        returnIntent.putExtra("result", suma);

        setResult(RESULT_OK, returnIntent);
        finish();
    }
}