package com.example.seminar_json;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherActivity extends AppCompatActivity {

    EditText etCity;
    Spinner spinnerZile;
    Button btnCauta;
    TextView tvRezultat;
    String apiKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCity = findViewById(R.id.etCity);
        spinnerZile = findViewById(R.id.spinnerZile);
        btnCauta = findViewById(R.id.btnCauta);
        tvRezultat = findViewById(R.id.tvRezultat);

        String[] optiuni = {"1 zi", "5 zile"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, optiuni);
        spinnerZile.setAdapter(adapter);

        btnCauta.setOnClickListener(v -> {
            String oras = etCity.getText().toString().trim();
            String metoda = spinnerZile.getSelectedItemPosition() == 0 ? "1day" : "5day";

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    String rezultat = "";

                    try {
                        String json = citeste("https://dataservice.accuweather.com/locations/v1/cities/search?apikey="
                                + apiKey + "&q=" + URLEncoder.encode(oras, "UTF-8"));

                        JSONArray orase = new JSONArray(json);
                        String cheie = orase.getJSONObject(0).getString("Key");
                        json = citeste ("https://dataservice.accuweather.com/forecasts/v1/daily/" + metoda + "/" +
                                cheie + "?apikey=" + apiKey + "&metric=true");

                        JSONObject obiect = new JSONObject(json);
                        JSONArray zile = obiect.getJSONArray("DailyForecasts");
                        for ( int i = 0; i < zile.length(); i++ ){
                            JSONObject zi = zile.getJSONObject(i);
                            JSONObject temperatura = zi.getJSONObject("Temperature");
                            double min = temperatura.getJSONObject("Minimum").getDouble("Value");
                            double max = temperatura.getJSONObject("Maximum").getDouble("Value");
                            rezultat += zi.getString("Date").substring(0, 10) + " : min " + min + " ; max " + max + "\n";
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        rezultat = "Eroare";
                    }

                    String text = rezultat;
                    handler.post(new Runnable() {
                        @Override

                        public void run() {
                            tvRezultat.setText(text);
                        }
                    });
                }
            });
        });
    }

    private String citeste(String adresa) throws IOException {
        URL url = new URL(adresa);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linie;
        while ((linie = reader.readLine()) != null) {
            sb.append(linie);
        }
        reader.close();
        con.disconnect();
        return sb.toString();
    }
}