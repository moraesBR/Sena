package senac.sena.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;
import java.util.TreeSet;

public class Aposta implements Parcelable {
    private TreeSet<Integer> numeros;
    private int qtdNumeros;

    public Aposta(){
    }

    public TreeSet<Integer> getNumeros() {
        return numeros;
    }

    public int getQtdNumeros() {
        return qtdNumeros;
    }

    public void setQtdNumeros(int qtdNumeros) {
        this.qtdNumeros = qtdNumeros;
    }

    public void setNumeros(){
        numeros = new TreeSet<>();

        Random gen = new Random();
        while(qtdNumeros > 0){
            if(numeros.add(Integer.valueOf(gen.nextInt(60) + 1)))
                qtdNumeros--;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.numeros);
        dest.writeInt(this.qtdNumeros);
    }

    protected Aposta(Parcel in) {
        this.numeros = (TreeSet<Integer>) in.readSerializable();
        this.qtdNumeros = in.readInt();
    }

    public static final Creator<Aposta> CREATOR = new Creator<Aposta>() {
        @Override
        public Aposta createFromParcel(Parcel source) {
            return new Aposta(source);
        }

        @Override
        public Aposta[] newArray(int size) {
            return new Aposta[size];
        }
    };
}
