package com.example.grind05_claude;

import android.os.Parcel;
import android.os.Parcelable;

public class Bicicleta implements Parcelable {
    protected static String KEY_BICICLETA = "BICICLETA_NOUA";
    protected static String KEY_LISTA = "LISTA_NOUA";

    private int serie;
    private String marca;
    private double diametruRoata;
    private boolean electrica;
    private float rating;
    private int pret;

    protected Bicicleta(Parcel in) {
        KEY_BICICLETA = in.readString();
        KEY_LISTA = in.readString();
        serie = in.readInt();
        marca = in.readString();
        diametruRoata = in.readDouble();
        electrica = in.readByte() != 0;
        rating = in.readFloat();
        pret = in.readInt();
    }

    public Bicicleta(int serie, String marca, double diametruRoata, boolean electrica, float rating, int pret) {
        this.serie = serie;
        this.marca = marca;
        this.diametruRoata = diametruRoata;
        this.electrica = electrica;
        this.rating = rating;
        this.pret = pret;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(KEY_BICICLETA);
        dest.writeString(KEY_LISTA);
        dest.writeInt(serie);
        dest.writeString(marca);
        dest.writeDouble(diametruRoata);
        dest.writeByte((byte) (electrica ? 1 : 0));
        dest.writeFloat(rating);
        dest.writeInt(pret);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Bicicleta> CREATOR = new Creator<Bicicleta>() {
        @Override
        public Bicicleta createFromParcel(Parcel in) {
            return new Bicicleta(in);
        }

        @Override
        public Bicicleta[] newArray(int size) {
            return new Bicicleta[size];
        }
    };

    public int getSerie() {
        return serie;
    }

    public String getMarca() {
        return marca;
    }

    public double getDiametruRoata() {
        return diametruRoata;
    }

    public boolean isElectrica() {
        return electrica;
    }

    public float getRating() {
        return rating;
    }

    public int getPret() {
        return pret;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "serie=" + serie +
                ", marca='" + marca + '\'' +
                ", diametruRoata=" + diametruRoata +
                ", electrica=" + electrica +
                ", rating=" + rating +
                ", pret=" + pret +
                '}';
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}
