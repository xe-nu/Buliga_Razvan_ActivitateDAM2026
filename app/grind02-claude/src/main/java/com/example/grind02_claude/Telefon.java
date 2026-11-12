package com.example.grind02_claude;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Telefon implements Parcelable {

    public static final String KEY_TELEFON_NOU = "TELEFON_NOU";
    public static final String KEY_LISTA = "LISTA_TELEFOANE";
    private int idTelefon;
    private String nume;
    private double memorieGB;
    private boolean integrareAI;
    private float rating;


    protected Telefon(Parcel in) {
        idTelefon = in.readInt();
        nume = in.readString();
        memorieGB = in.readDouble();
        integrareAI = in.readByte() != 0;
        rating = in.readFloat();
    }

    public Telefon(int idTelefon, String nume, double memorieGB, boolean integrareAI, float rating) {
        this.idTelefon = idTelefon;
        this.nume = nume;
        this.memorieGB = memorieGB;
        this.integrareAI = integrareAI;
        this.rating = rating;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idTelefon);
        dest.writeString(nume);
        dest.writeDouble(memorieGB);
        dest.writeByte((byte) (integrareAI ? 1 : 0));
        dest.writeFloat(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Telefon> CREATOR = new Creator<Telefon>() {
        @Override
        public Telefon createFromParcel(Parcel in) {
            return new Telefon(in);
        }

        @Override
        public Telefon[] newArray(int size) {
            return new Telefon[size];
        }
    };

    public int getIdTelefon() {
        return idTelefon;
    }

    public String getNume() {
        return nume;
    }

    public double getMemorieGB() {
        return memorieGB;
    }

    public boolean isIntegrareAI() {
        return integrareAI;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "idTelefon=" + idTelefon +
                ", nume='" + nume + '\'' +
                ", memorieGB=" + memorieGB +
                ", integrareAI=" + integrareAI +
                ", rating=" + rating +
                '}';
    }

    public void setMemorieGB(double memorieGB) {
        this.memorieGB = memorieGB;
    }
}
