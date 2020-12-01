package Biciclette;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
        ListaBiciclette lista = new ListaBiciclette();

        int scelta;

        while(true){
            scelta = NegozioBiciclette.menu();

            if(scelta == 0){
                break;
            }
            else if(scelta == 1){
                System.out.print("Inserisci marca, modello, prezzo: ");
                lista.aggiungiBicicletta(new Bicicletta(input.next(), input.next(), input.nextDouble()));
                System.out.println("Bici aggiunta");
            }
            else if(scelta == 2){
                System.out.print("Inserisci marca, modello: ");
                lista.cancellaBicicletta(input.next(), input.next());
                System.out.println("Bici tolta");
            }
            else if(scelta == 3){
                System.out.print("Inserisci marca, modello, prezzo, sconto: ");
                lista.scontaBicicletta(input.next(), input.next(), input.nextInt());
                System.out.println("Bici scontata");
            }
            else if(scelta == 4){
                System.out.print("Inserisci marca: ");
                lista.cercaBicicletta(input.next());
            }
            else if(scelta == 5){
                lista.stampaBiciclette();
            }
	    }
    }
}
