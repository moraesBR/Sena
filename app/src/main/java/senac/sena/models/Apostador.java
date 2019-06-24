package senac.sena.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Apostador implements Parcelable {
    ArrayList<Aposta> apostas;
    ArrayList<Integer> qtdNumerosPorAposta;

    public Apostador(ArrayList<Integer> qtdNumerosPorAposta) {
        this.qtdNumerosPorAposta = qtdNumerosPorAposta;
        apostas = new ArrayList<>();
    }

    public ArrayList<Aposta> getApostas() {
        return apostas;
    }

    public ArrayList<Integer> getQtdNumerosPorAposta() {
        return qtdNumerosPorAposta;
    }

    public void setApostas() {
        Aposta novo;
        for (Integer n : this.qtdNumerosPorAposta){
            novo = new Aposta();
            novo.setQtdNumeros(n.intValue());
            novo.setNumeros();
            this.apostas.add(novo);
        }
    }

    public void setQtdNumerosPorAposta(ArrayList<Integer> qtdNumerosPorAposta) {
        this.qtdNumerosPorAposta = qtdNumerosPorAposta;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.apostas);
        dest.writeList(this.qtdNumerosPorAposta);
    }

    protected Apostador(Parcel in) {
        this.apostas = in.createTypedArrayList(Aposta.CREATOR);
        this.qtdNumerosPorAposta = new ArrayList<Integer>();
        in.readList(this.qtdNumerosPorAposta, Integer.class.getClassLoader());
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
