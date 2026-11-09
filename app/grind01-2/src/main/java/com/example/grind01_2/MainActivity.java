package com.example.grind01_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void openActivity(View view){
        Intent it = new Intent(this, NewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("msg", "Mesajul trimis este 67");
        bundle.putInt("no6", 6);
        bundle.putInt("no7", 7);
        it.putExtras(bundle);
        startActivityForResult(it, 67);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 67 && resultCode == RESULT_OK && data != null){
            String msg = data.getStringExtra("msg");
            int result = data.getIntExtra("result", 0);
            Toast.makeText(this, msg + " " + result, Toast.LENGTH_SHORT).show();
        }
    }
}