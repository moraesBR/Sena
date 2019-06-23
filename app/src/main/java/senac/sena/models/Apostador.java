package senac.sena.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Apostador implements Parcelable {
    ArrayList<Aposta> apostas;
    int qtdApostas;
    int qtdNumerosPorAposta;

    public Apostador() {
        apostas = new ArrayList<>();
    }
    public ArrayList<Aposta> getApostas() {
        return apostas;
    }

    public int getQtdApostas() {
        return qtdApostas;
    }

    public int getQtdNumerosPorAposta() {
        return qtdNumerosPorAposta;
    }

    public void setApostas(){
        Aposta novo;
        for (int i = 0; i < this.qtdApostas; i++) {
            novo = new Aposta();
            novo.setQtdNumeros(this.qtdNumerosPorAposta);
            novo.setNumeros();
            this.apostas.add(novo);
        }
    }

    public void setQtdApostas(int qtdApostas) {
        this.qtdApostas = qtdApostas;
    }

    public void setQtdNumerosPorAposta(int qtdNumerosPorAposta) {
        this.qtdNumerosPorAposta = qtdNumerosPorAposta;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.apostas);
        dest.writeInt(this.qtdApostas);
        dest.writeInt(this.qtdNumerosPorAposta);
    }


    protected Apostador(Parcel in) {
        this.apostas = in.createTypedArrayList(Aposta.CREATOR);
        this.qtdApostas = in.readInt();
        this.qtdNumerosPorAposta = in.readInt();
    }

    public static final Creator<Apostador> CREATOR = new Creator<Apostador>() {
        @Override
        public Apostador createFromParcel(Parcel source) {
            return new Apostador(source);
        }

        @Override
        public Apostador[] newArray(int size) {
            return new Apostador[size];
        }
    };
}
