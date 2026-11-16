package com.example.grind_nebunie_rau_de_tot;

import android.os.Parcel;
import android.os.Parcelable;

public class Tableta implements Parcelable {
    protected static String KEY_TABLETA_NOUA = "TABLETA_NOUA";
    protected static String KEY_LISTA_TABLETE = "LISTA_TABLETE";
    private int idTableta;
    private String model;
    private double spatiuMemorie;
    private boolean integrareAI;


    protected Tableta(Parcel in) {
        idTableta = in.readInt();
        model = in.readString();
        spatiuMemorie = in.readDouble();
        integrareAI = in.readByte() != 0;
    }

    public Tableta(int idTableta, String model, double spatiuMemorie, boolean integrareAI) {
        this.idTableta = idTableta;
        this.model = model;
        this.spatiuMemorie = spatiuMemorie;
        this.integrareAI = integrareAI;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idTableta);
        dest.writeString(model);
        dest.writeDouble(spatiuMemorie);
        dest.writeByte((byte) (integrareAI ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tableta> CREATOR = new Creator<Tableta>() {
        @Override
        public Tableta createFromParcel(Parcel in) {
            return new Tableta(in);
        }

        @Override
        public Tableta[] newArray(int size) {
            return new Tableta[size];
        }
    };

    @Override
    public String toString() {
        return "Tableta{" +
                "idTableta=" + idTableta +
                ", model='" + model + '\'' +
                ", spatiuMemorie=" + spatiuMemorie +
                ", integrareAI=" + integrareAI +
                '}';
    }

    public int getIdTableta() {
        return idTableta;
    }

    public String getModel() {
        return model;
    }

    public double getSpatiuMemorie() {
        return spatiuMemorie;
    }

    public boolean isIntegrareAI() {
        return integrareAI;
    }

    public void setSpatiuMemorie(double spatiuMemorie) {
        this.spatiuMemorie = spatiuMemorie;
    }
}
