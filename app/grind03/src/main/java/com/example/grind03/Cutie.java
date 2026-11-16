package com.example.grind03;

import android.os.Parcel;
import android.os.Parcelable;

public class Cutie implements Parcelable {
    protected static String KEY_CUTIE_NOUA = "CUTIE_NOUA";
    protected static String KEY_LISTA = "LISTA_CUTII";
    private int cod;
    private String culoare;
    private double volum;
    private boolean fragila;
    private float rating;

    protected Cutie(Parcel in) {
        cod = in.readInt();
        culoare = in.readString();
        volum = in.readDouble();
        fragila = in.readByte() != 0;
        rating = in.readFloat();
    }

    public Cutie(int cod, String culoare, double volum, boolean fragila, float rating) {
        this.cod = cod;
        this.culoare = culoare;
        this.volum = volum;
        this.fragila = fragila;
        this.rating = rating;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cod);
        dest.writeString(culoare);
        dest.writeDouble(volum);
        dest.writeByte((byte) (fragila ? 1 : 0));
        dest.writeFloat(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cutie> CREATOR = new Creator<Cutie>() {
        @Override
        public Cutie createFromParcel(Parcel in) {
            return new Cutie(in);
        }

        @Override
        public Cutie[] newArray(int size) {
            return new Cutie[size];
        }
    };

    public int getCod() {
        return cod;
    }

    public String getCuloare() {
        return culoare;
    }

    public double getVolum() {
        return volum;
    }

    public boolean isFragila() {
        return fragila;
    }

    public float getRating() {
        return rating;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    @Override
    public String toString() {
        return "Cutie{" +
                "cod=" + cod +
                ", culoare='" + culoare + '\'' +
                ", volum=" + volum +
                ", fragila=" + fragila +
                ", rating=" + rating +
                '}';
    }
}
