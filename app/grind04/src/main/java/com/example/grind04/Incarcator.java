package com.example.grind04;

import android.os.Parcel;
import android.os.Parcelable;

public class Incarcator implements Parcelable {
    protected static String KEY_INCARCATOR_NOU = "INCARCATOR_NOU";
    protected static String KEY_LISTA = "LISTA_INCARCATOARE";
    private int id;
    private String producator;
    private int pret;
    private double vati;
    private boolean nou;


    protected Incarcator(Parcel in) {
        id = in.readInt();
        producator = in.readString();
        pret = in.readInt();
        vati = in.readDouble();
        nou = in.readByte() != 0;
    }

    public Incarcator(int id, String producator, int pret, double vati, boolean nou) {
        this.id = id;
        this.producator = producator;
        this.pret = pret;
        this.vati = vati;
        this.nou = nou;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(producator);
        dest.writeInt(pret);
        dest.writeDouble(vati);
        dest.writeByte((byte) (nou ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Incarcator> CREATOR = new Creator<Incarcator>() {
        @Override
        public Incarcator createFromParcel(Parcel in) {
            return new Incarcator(in);
        }

        @Override
        public Incarcator[] newArray(int size) {
            return new Incarcator[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getProducator() {
        return producator;
    }

    public int getPret() {
        return pret;
    }

    public double getVati() {
        return vati;
    }

    public boolean isNou() {
        return nou;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Incarcator{" +
                "id=" + id +
                ", producator='" + producator + '\'' +
                ", pret=" + pret +
                ", vati=" + vati +
                ", nou=" + nou +
                '}';
    }
}
