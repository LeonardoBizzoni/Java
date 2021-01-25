package Libri;

public class LibroUsato extends Libro{
    private int anniUtilizzo;
    private int percSconto;
    private double sconto;

    public LibroUsato(){}
    public LibroUsato(String titolo, String casaEditrice, double prezzo, int nScaffale, int nPagine, int anniUtilizzo, int percSconto){
        super(titolo, casaEditrice, prezzo, nScaffale, nPagine);
        this.anniUtilizzo = anniUtilizzo;
        this.percSconto = percSconto;
    }

    public void applicaSconto(){
        this.sconto = super.getPrezzo() * percSconto / 100.f;
        super.setPrezzo(super.getPrezzo()-this.sconto);
    }

    public int getAnniUtilizzo() {
        return anniUtilizzo;
    }

    public void setAnniUtilizzo(int anniUtilizzo) {
        this.anniUtilizzo = anniUtilizzo;
    }

    public int getPercSconto() {
        return percSconto;
    }

    public void setPercSconto(int percSconto) {
        this.percSconto = percSconto;
    }

    public double getSconto() {
        return sconto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    @Override
    public String toString() {
        return "LibroUsato{" + super.toString(true) +
                "anniUtilizzo=" + anniUtilizzo +
                ", percSconto=" + percSconto +
                ", sconto=" + sconto +
                "};";
    }
}
