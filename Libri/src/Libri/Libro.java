package Libri;

public class Libro {
    private String titolo;
    private String casaEditrice;
    private double prezzo;
    private int nScaffale;
    private int nPagine;

    public Libro(){}

    public Libro(String titolo, String casaEditrice, double prezzo, int nScaffale, int nPagine){
        this.titolo = titolo;
        this.casaEditrice = casaEditrice;
        this.prezzo = prezzo;
        this.nScaffale = nScaffale;
        this.nPagine = nPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(String casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getnScaffale() {
        return nScaffale;
    }

    public void setnScaffale(int nScaffale) {
        this.nScaffale = nScaffale;
    }

    public int getnPagine() {
        return nPagine;
    }

    public void setnPagine(int nPagine) {
        this.nPagine = nPagine;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", casaEditrice='" + casaEditrice + '\'' +
                ", prezzo=" + prezzo +
                ", nScaffale=" + nScaffale +
                ", nPagine=" + nPagine +
                '}';
    }

    public String toString(boolean isUsed) {
        return "titolo='" + titolo + '\'' +
                ", casaEditrice='" + casaEditrice + '\'' +
                ", prezzo=" + prezzo +
                ", nScaffale=" + nScaffale +
                ", nPagine=" + nPagine;
    }
}
