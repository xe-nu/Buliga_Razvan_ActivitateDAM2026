package com.example.seminar02;

import android.os.Bundle;
import android.util.Log;

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

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("start", "The app started successfully.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("stop", "The app stopped.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("resume", "The app resumed.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("pause", "The app paused.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("destroy", "The app destroyed.");
    }
}