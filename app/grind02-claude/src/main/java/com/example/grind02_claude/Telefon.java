package com.example.grind02_claude;

public class Telefon {

    private int idTelefon;
    private String nume;
    private String memorieGB;
    private boolean integrareAI;
    private float rating;

    public Telefon(int idTelefon, String nume, String memorieGB, boolean integrareAI, float rating) {
        this.idTelefon = idTelefon;
        this.nume = nume;
        this.memorieGB = memorieGB;
        this.integrareAI = integrareAI;
        this.rating = rating;
    }

    public int getIdTelefon() {
        return idTelefon;
    }

    public String getNume() {
        return nume;
    }

    public String getMemorieGB() {
        return memorieGB;
    }

    public boolean isIntegrareAI() {
        return integrareAI;
    }

    public float getRating() {
        return rating;
    }
}
