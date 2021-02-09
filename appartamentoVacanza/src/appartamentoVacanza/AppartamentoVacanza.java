package appartamentoVacanza;

public class AppartamentoVacanza {
    private int nStanze;
    private double distanzaMare;
    private double prezzoMq;
    private double superficieMq;
    private String tipo;

    public AppartamentoVacanza(){}
    public AppartamentoVacanza(int nStanze, double distanzaMare, double prezzoMq, double superficieMq, String tipo){
        this.nStanze = nStanze;
        this.distanzaMare = distanzaMare;
        this.prezzoMq = prezzoMq;
        this.superficieMq = superficieMq;
        this.tipo = tipo;
    }

    public int getnStanze() {
        return nStanze;
    }

    public void setnStanze(int nStanze) {
        this.nStanze = nStanze;
    }

    public double getDistanzaMare() {
        return distanzaMare;
    }

    public void setDistanzaMare(double distanzaMare) {
        this.distanzaMare = distanzaMare;
    }

    public double getPrezzoMq() {
        return prezzoMq;
    }

    public void setPrezzoMq(double prezzoMq) {
        this.prezzoMq = prezzoMq;
    }

    public double getSuperficieMq() {
        return superficieMq;
    }

    public void setSuperficieMq(double superficieMq) {
        this.superficieMq = superficieMq;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "AppartamentoVacanza{" +
                "nStanze=" + nStanze +
                ", distanzaMare=" + distanzaMare +
                ", prezzoMq=" + prezzoMq +
                ", superficieMq=" + superficieMq +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
