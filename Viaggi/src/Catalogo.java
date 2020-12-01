
public class Catalogo {
	private Pacchetto[] catalogo;
	private double sconto;

	public Catalogo() {
		catalogo = new Pacchetto[4];
	}

	public void addPacchetto(Pacchetto p, int i) {
		catalogo[i] = p;
	}

	public double dammiCU(String dest) {
		for (int i = 0; i < catalogo.length; i++) {
			if (catalogo[i].getDestinazione().compareTo(dest) == 0) {
				return catalogo[i].getCostopg();
			}
		}

		return 0;
	}

	public double calcolaCostoEffettivo(double costoTot) {
		sconto = costoTot > 2800 ? (double) costoTot * 16 / 100 : 0;
		return costoTot > 2800 ? costoTot - sconto : costoTot;
	}

	public double getSconto() {
		return sconto;
	}
}
