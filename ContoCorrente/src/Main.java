import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner input;
	
	public static void main(String[] args) {
		int scelta, numerocc;
		double soldi;
		boolean operazioneRiuscita = false;
		List<ContoCorrente> conti = new ArrayList<ContoCorrente>();
		
		input = new Scanner(System.in);
			
		while(true) {
			scelta = menu();
			
			if(scelta == 0)
				break;
			else if(scelta == 1) {
				System.out.print("Inserisci nominativo, numero conto, saldo: ");
				conti.add(new ContoCorrente(input.next(), input.nextInt(), input.nextDouble()));
			}
			else if(scelta == 2) {
				System.out.print("Inserisci numerocc: ");
				numerocc = input.nextInt();
				
				for(int i=0;i<conti.size();i++) {
					if(numerocc == conti.get(i).getNumerocc()) {
						do {
							System.out.print("Inserisci somma: ");
							soldi = input.nextDouble();
						}while(soldi <= 0);
						
						conti.get(i).versa(soldi);
						operazioneRiuscita = true;
					}
				}
				
				if(!operazioneRiuscita)
					System.out.println("Il versamento non e' andato a buon fine");
			}
			else if(scelta == 3) {
				System.out.print("Inserisci numerocc: ");
				numerocc = input.nextInt();
				
				for(int i=0;i<conti.size();i++) {
					if(numerocc == conti.get(i).getNumerocc()) {
						do {
							System.out.print("Inserisci somma: ");
							soldi = input.nextDouble();
						}while(soldi <= 0);
						
						conti.get(i).preleva(soldi);
						operazioneRiuscita = true;
					}
				}
				
				if(!operazioneRiuscita)
					System.out.println("Il prelievo non e' andato a buon fine");
			}
			else if(scelta == 4) {
				System.out.print("Inserisci numerocc: ");
				numerocc = input.nextInt();
				
				for(int i=0;i<conti.size();i++) {
					if(numerocc == conti.get(i).getNumerocc()) {
						conti.remove(i);
					}
				}
			}
			else if(scelta == 5) {
				System.out.print("Inserisci numerocc: ");
				numerocc = input.nextInt();
				
				for(int i=0;i<conti.size();i++) {
					if(numerocc == conti.get(i).getNumerocc()) {
						conti.get(i).stampaCC();
					}
				}
			}
		}
	}
	
	static int menu() {
		input = new Scanner(System.in);
		int in;
		
		do {
			System.out.print("1) Creare un nuovo conto\n"
					   + "2) Versare un aumentare su un conto corrente, dato numerocc\n"
					   + "3) Prelevare un aumentare da un conto corrente, dato numerocc\n"
					   + "4) Cancellare un conto corrente, dato numerocc\n"
					   + "5) Stampa tutte le info di un conto corrente dato il numerocc\n"
					   + "0) Esci\n"
					   + "Inserisci scelta: ");
			in = input.nextInt();
		}while(in < 0 || in > 5);
		
		return in;
	}

}
