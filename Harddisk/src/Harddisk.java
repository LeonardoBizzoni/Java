import java.util.Scanner;

public class Harddisk {
	private final int PUNTI_RPM = 1;
	private final int PUNTI_TACCESSO = -200;
	private final int PUNTI_CAPACITA = 500;

	private Scanner input;

	private String marca;
	private double taccesso;
    private int capacita;
	private int rpm;
	private double punteggio;

	void leggiDati() {
		input = new Scanner(System.in);

		System.out.print("Inserisci marca: ");
		marca = input.next();

		System.out.print("Inserisci tempo di accesso(ms): ");
		taccesso = input.nextDouble();

		System.out.print("Inserisci capacita(GB): ");
		capacita = input.nextInt();

		System.out.print("Inserisci rpm: ");
		rpm = input.nextInt();
	}

	void calcolaPunteggio() {
		punteggio = PUNTI_RPM * rpm + PUNTI_TACCESSO * taccesso + PUNTI_CAPACITA * capacita;
	}

	public void stampaInfo() {
		System.out.println("Harddisk [marca=" + marca + ", taccesso=" + taccesso + ", capacita=" + capacita
				+ ", rpm=" + rpm + "]");
	}

	public double getPunteggio() {
		return punteggio;
	}
}
