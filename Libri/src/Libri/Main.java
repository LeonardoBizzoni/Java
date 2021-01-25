package Libri;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);

        System.out.println("titolo, casa editrice, prezzo, scaffale, pagine");
        Libro libro = new Libro(inputString.nextLine(),inputString.nextLine(), inputInt.nextDouble(), inputInt.nextInt(), inputInt.nextInt());
        System.out.println(libro.toString());

        System.out.println("titolo, casa editrice, prezzo, scaffale, pagine, anni in uso, percentuale sconto");
        LibroUsato libroUsato = new LibroUsato(inputString.nextLine(), inputString.nextLine(), inputInt.nextDouble(), inputInt.nextInt(), inputInt.nextInt(), inputInt.nextInt(), inputInt.nextInt());
        libroUsato.applicaSconto();
        System.out.println(libroUsato.toString());
    }
}
