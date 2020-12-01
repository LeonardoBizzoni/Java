
public class Pacchetto {
	private String destinazione;
	private double costopg;

	public Pacchetto(String dest, double c) {
		destinazione = dest.toLowerCase();
		costopg = c;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public double getCostopg() {
		return costopg;
	}

	public void setCostopg(double costopg) {
		this.costopg = costopg;
	}
}
