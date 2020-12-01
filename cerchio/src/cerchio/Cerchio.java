package cerchio;

public class Cerchio {
    public double raggio;

    public double calcolaCirconf(){
        return raggio * 2 * Math.PI;
    }

    public double calcolaArea(){
        return Math.pow(raggio, 2) * Math.PI;
    }
}
