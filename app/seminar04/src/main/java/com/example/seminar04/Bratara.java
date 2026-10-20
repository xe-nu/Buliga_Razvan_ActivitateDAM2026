package com.example.seminar04;

import android.os.Parcelable;

public class Bratara{
    private String marca;
    private boolean arePietre;
    private String marime;
    private float notaRating;
    private String material;
    private boolean ajustabila;

    public Bratara(String marca, boolean arePietre, String marime, float notaRating, String material, boolean ajustabila) {
        this.marca = marca;
        this.arePietre = arePietre;
        this.marime = marime;
        this.notaRating = notaRating;
        this.material = material;
        this.ajustabila = ajustabila;
    }
}
