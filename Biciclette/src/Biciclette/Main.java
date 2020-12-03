package Biciclette;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner strInput = new Scanner(System.in);
        Scanner numInput = new Scanner(System.in);
        ListaBiciclette lista = new ListaBiciclette();

        int scelta;

        while(true){
            scelta = NegozioBiciclette.menu();

            if(scelta == 0){
                break;
            }
            else if(scelta == 1){
                System.out.print("Inserisci marca, modello, prezzo: ");
                Bicicletta nuovaBici = new Bicicletta(strInput.nextLine(), strInput.nextLine(), numInput.nextDouble());
                lista.aggiungiBicicletta(nuovaBici);

                System.out.println("Bici aggiunta");
            }
            else if(scelta == 2){
                System.out.print("Inserisci marca, modello: ");
                lista.cancellaBicicletta(strInput.nextLine(), strInput.nextLine());
                System.out.println("Bici tolta");
            }
            else if(scelta == 3){
                System.out.print("Inserisci marca, modello, prezzo, sconto: ");
                lista.scontaBicicletta(strInput.nextLine(), strInput.nextLine(), numInput.nextInt());
                System.out.println("Bici scontata");
            }
            else if(scelta == 4){
                System.out.print("Inserisci marca: ");
                lista.cercaBicicletta(strInput.nextLine());
            }
            else if(scelta == 5){
                lista.stampaBiciclette();
            }
        }

        lista.updateFile();
    }

}
