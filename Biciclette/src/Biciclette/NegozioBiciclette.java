package Biciclette;

import java.util.Scanner;

public class NegozioBiciclette {
    public static int menu(){
        Scanner input = new Scanner(System.in);
        System.out.print("1) Aggiungere una bici\n" +
                         "2) Cancellare una bici\n" +
                         "3) Scontare una bici\n" +
                         "4) Cerca una bici\n" +
                         "5) Stampa tutte le bici\n" +
                         "0) Uscire\n" +
                         "Inserisci scelta: ");

        return input.nextInt();
    }
}
