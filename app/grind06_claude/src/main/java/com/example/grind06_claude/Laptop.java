package com.example.grind06_claude;

import android.os.Parcel;
import android.os.Parcelable;

public class Laptop implements Parcelable {
    protected static String KEY_LAPTOP = "LAPTOP_NOU";
    protected static String KEY_LISTA = "LISTA_LAPTOP";

    private int cod;
    private String model;
    private int ram;
    private Double diagonala;
    private boolean gaming;
    private int stoc;

    protected Laptop(Parcel in) {
        cod = in.readInt();
        model = in.readString();
        ram = in.readInt();
        if (in.readByte() == 0) {
            diagonala = null;
        } else {
            diagonala = in.readDouble();
        }
        gaming = in.readByte() != 0;
        stoc = in.readInt();
    }

    public Laptop(int cod, String model, int ram, Double diagonala, boolean gaming, int stoc) {
        this.cod = cod;
        this.model = model;
        this.ram = ram;
        this.diagonala = diagonala;
        this.gaming = gaming;
        this.stoc = stoc;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cod);
        dest.writeString(model);
        dest.writeInt(ram);
        if (diagonala == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(diagonala);
        }
        dest.writeByte((byte) (gaming ? 1 : 0));
        dest.writeInt(stoc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Laptop> CREATOR = new Creator<Laptop>() {
        @Override
        public Laptop createFromParcel(Parcel in) {
            return new Laptop(in);
        }

        @Override
        public Laptop[] newArray(int size) {
            return new Laptop[size];
        }
    };

    public int getCod() {
        return cod;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public Double getDiagonala() {
        return diagonala;
    }

    public boolean isGaming() {
        return gaming;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
}
