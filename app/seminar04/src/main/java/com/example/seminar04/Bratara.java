package com.example.seminar04;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Bratara implements Parcelable{
    private String marca;
    private boolean arePietre;
    private String marime;
    private float rating;
    private String material;
    private boolean ajustabila;

    public Bratara(String marca, boolean arePietre, String marime, String material, float rating, boolean ajustabila) {
        this.marca = marca;
        this.arePietre = arePietre;
        this.marime = marime;
        this.rating = rating;
        this.material = material;
        this.ajustabila = ajustabila;
    }


    protected Bratara(Parcel in) {
        marca = in.readString();
        arePietre = in.readByte() != 0;
        marime = in.readString();
        rating = in.readFloat();
        material = in.readString();
        ajustabila = in.readByte() != 0;
    }

    public static final Creator<Bratara> CREATOR = new Creator<Bratara>() {
        @Override
        public Bratara createFromParcel(Parcel in) {
            return new Bratara(in);
        }

        @Override
        public Bratara[] newArray(int size) {
            return new Bratara[size];
        }
    };

    @Override
    public String toString() {
        return "Bratara{" +
                "Marca: '" + marca + '\'' +
                ", Pietre: " + (arePietre ? "Da" : "Nu") +
                ", Marime: '" + marime + '\'' +
                ", Rating: " + rating +
                ", Material: '" + material + '\'' +
                ", Ajustabila: " + (ajustabila ? "Da" : "Nu") +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeByte((byte) (arePietre ? 1 : 0));
        dest.writeString(marime);
        dest.writeFloat(rating);
        dest.writeString(material);
        dest.writeByte((byte) (ajustabila ? 1 : 0));
    }
}
