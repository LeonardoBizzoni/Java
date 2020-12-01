import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Pacchetto[] destinazioni = 
			{ 
				new Pacchetto("Atene", 110), 
				new Pacchetto("Parigi", 120),
				new Pacchetto("Roma", 130), 
				new Pacchetto("Vienna", 140) 
			};
		Catalogo catalogo = new Catalogo();
		Scanner input = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);

		String dest;
		int nPersone, nGiorni;
		double costoTot;

		for (int i = 0; i < destinazioni.length; i++) {
			catalogo.addPacchetto(destinazioni[i], i);
		}

		while (true) {
			do {
				System.out.print("Inserisci destinazione: ");
				dest = inputString.nextLine().toLowerCase();
			} while (catalogo.dammiCU(dest) == 0);

			do {
				System.out.print("Inserisci numero di persone: ");
				nPersone = input.nextInt();
			} while (nPersone <= 0);

			do {
				System.out.print("Inserisci numero di giorni: ");
				nGiorni = input.nextInt();
			} while (nGiorni <= 0);

			costoTot = catalogo.calcolaCostoEffettivo(catalogo.dammiCU(dest) * nPersone * nGiorni);

			System.out.println("Costo: " + costoTot + "\tSconto: " + catalogo.getSconto());
			
			System.out.print("Continuare? (Y/n)");
			if(inputString.nextLine().toLowerCase().compareTo("n") == 0)
				break;
		}
		
		input.close();
		inputString.close();
	}

}
