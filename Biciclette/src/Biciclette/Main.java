package Biciclette;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static ListaBiciclette lista = new ListaBiciclette();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        inzializzaBici();

        int scelta;

        while(true){
            scelta = NegozioBiciclette.menu();

            if(scelta == 0){
                break;
            }
            else if(scelta == 1){
                System.out.print("Inserisci marca, modello, prezzo: ");
                Bicicletta nuovaBici = new Bicicletta(input.nextLine(), input.nextLine(), input.nextDouble());
                lista.aggiungiBicicletta(nuovaBici);

                System.out.println("Bici aggiunta");
            }
            else if(scelta == 2){
                System.out.print("Inserisci marca, modello: ");
                lista.cancellaBicicletta(input.nextLine(), input.nextLine());
                System.out.println("Bici tolta");
            }
            else if(scelta == 3){
                System.out.print("Inserisci marca, modello, prezzo, sconto: ");
                lista.scontaBicicletta(input.nextLine(), input.nextLine(), input.nextInt());
                System.out.println("Bici scontata");
            }
            else if(scelta == 4){
                System.out.print("Inserisci marca: ");
                lista.cercaBicicletta(input.nextLine());
            }
            else if(scelta == 5){
                lista.stampaBiciclette();
            }
        }

        lista.updateFile();
    }

    private static void inzializzaBici() {
        try{
            // Controlla se il file esiste
            File biciVecchie = new File("bici.txt");
            if(!biciVecchie.canRead()){
                biciVecchie.createNewFile();
            }

            // Roba per leggere
            Scanner fileInput = new Scanner(biciVecchie);
            String riga, marca,modello;
            String[] comp;
            double prezzo;

            // Comincia a leggere riga per riga
            while(fileInput.hasNextLine()){
                riga = fileInput.nextLine();
                comp = riga.split(",");

                marca = comp[0];
                modello = comp[1];
                prezzo = Double.parseDouble(comp[2]);

                lista.aggiungiBicicletta(new Bicicletta(marca,modello,prezzo));
            }

            fileInput.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
