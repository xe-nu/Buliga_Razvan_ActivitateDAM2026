package com.example.seminar02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
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

    public void openActivity(View view) {
        Intent it = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("msg", "New message - from Activity");
        bundle.putInt("no1", 6);
        bundle.putInt("no2", 7);
        it.putExtras(bundle);

        startActivityForResult(it, 100);
    }

    protected void onActivityResult(int requestCode, int returnCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, returnCode, data);
        if (requestCode == 100 && returnCode == RESULT_OK && data != null) {
            String msg = data.getStringExtra("msg");
            int result = data.getIntExtra("result", 0);
            Toast.makeText(this, msg + " " + result, Toast.LENGTH_SHORT).show();
        }
    }
}