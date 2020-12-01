package Biciclette;

public class Bicicletta {
    private String marca;
    private String modello;
    private double prezzo;

    public Bicicletta(String marca, String modello, double prezzo){
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void applicaSconto(int percentuale){
        prezzo -= (double)prezzo*percentuale/100;
    }

    @Override
    public String toString() {
        return "Bicicletta{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
