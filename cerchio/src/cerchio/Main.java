package cerchio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Cerchio[] cerchi = new Cerchio[10];
	    for (int i=0;i<cerchi.length;i++){
	        cerchi[i] = new Cerchio();
        }
	    Scanner input = new Scanner(System.in);

	    int quantiCerchi;
	    double raggio;

	    do{
            System.out.print("Quanti cerchi: ");
            quantiCerchi = input.nextInt();

            for(int i=0;i<quantiCerchi;i++){
                System.out.print("Inserisci raggio: ");
                cerchi[i].raggio = input.nextDouble();
                System.out.println("Circonf: " + cerchi[i].calcolaCirconf() + "\nArea: " + cerchi[i].calcolaArea());
            }
        }while(quantiCerchi >= 10 || quantiCerchi <= 0);
    }
}
