package com.example.seminar04;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActivitateRetea extends AppCompatActivity {

    private ListView lv;
    private ImagineAdapter adapter;
    private final List<ImaginiDomeniu> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_retea);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv = findViewById(R.id.imagini);

        String[] urlImagini = {
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk36GzGJbNNyFsxBn4PYn-sJYE0-pK8adzncHX1tWS2s5kMQ90kbmC0vVn&s=10",
                "https://cdn-images.farfetch-contents.com/38/83/39/57/38833957_73407589_600.jpg",
                "https://di2ponv0v5otw.cloudfront.net/posts/2024/07/28/66a6a759842dd46e93557b29/l_66a6a828693ff7ac75f44a00.jpeg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQnuHLaoEo327NY_1EtRCABnozEn91keSypwbuAXc_i7kbCk5r5brU0p8&s=10",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSns6hhpw0vBaxVDDK1FPy7p7arkNUrg__-b-IKdpqLU06reL7qSSPFF0&s=10"
        };

        String[] texte = {
                "Chrome Hearts Continuum Bracelet",
                "Chrome Hearts Horn Bracelet",
                "Chrome Hearts Dice Bracelet",
                "Chrome Hearts Multi Cross Bracelet",
                "Chrome Hearts Spines-Cross Bracelet"
        };

        String[] linkuri = {
                "https://www.fashionphile.com/products/chrome-hearts-sterling-silver-cross-bracelet-1762525",
                "https://www.farfetch.com/ro/shopping/women/chrome-hearts-cuban-link-chain-bracelet-item-38833957.aspx",
                "https://bestknowov.click/product_tag/26148861_.html",
                "https://www.ebay.com/itm/236230620845",
                "https://www.therealreal.com/products/jewelry/bracelets/link/chrome-hearts-maltese-cross-link-bracelet-eq1xg"
        };


        lv.setOnItemClickListener((parent, view, position, id) -> {
            Intent it = new Intent(ActivitateRetea.this, ActivitateWeb.class);
            it.putExtra("link", lista.get(position).getLink());
            startActivity(it);
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Bitmap> imagini = new ArrayList<>();
                for (String link : urlImagini) {
                    HttpURLConnection con = null;
                    Bitmap bitmap = null;
                    try {
                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        con.setRequestProperty("User-Agent", "Mozilla/5.0");
                        InputStream is = con.getInputStream();
                        bitmap = BitmapFactory.decodeStream(is);
                        is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            con.disconnect();
                        }
                    }
                    imagini.add(bitmap);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < imagini.size(); i++) {
                            lista.add(new ImaginiDomeniu(texte[i], imagini.get(i), linkuri[i]));
                        }
                        adapter = new ImagineAdapter(lista, ActivitateRetea.this, R.layout.item_imagine);
                        lv.setAdapter(adapter);
                    }
                });
            }
        });
    }
}