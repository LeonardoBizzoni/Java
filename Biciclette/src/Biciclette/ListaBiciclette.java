package Biciclette;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaBiciclette {
    List<Bicicletta> listaBici = new ArrayList<>();

    public ListaBiciclette(){
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

                aggiungiBicicletta(new Bicicletta(marca,modello,prezzo));
            }

            fileInput.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    void aggiungiBicicletta(Bicicletta bici) {
        listaBici.add(bici);
    }

    void cancellaBicicletta(String marca, String modello){
        for (int i=0;i<listaBici.size();i++) {
            if(marca.equals(listaBici.get(i).getMarca()) && modello.equals(listaBici.get(i).getModello())){
                listaBici.remove(i);
            }
        }
    }

    void scontaBicicletta(String marca, String modello, int percentuale){
        for (Bicicletta bici : listaBici) {
            if(marca.equals(bici.getMarca()) && modello.equals(bici.getModello())){
                bici.applicaSconto(percentuale);
            }
        }
    }

    void cercaBicicletta(String marca){
        for (Bicicletta bici : listaBici) {
            if(marca.equals(bici.getMarca())){
                System.out.println("Modello: " + bici.getModello() + "\nPrezzo" + bici.getPrezzo());
            }
        }
    }

    void stampaBiciclette(){
        for (Bicicletta bici : listaBici) {
            System.out.println(bici.toString());
        }
    }

    void updateFile() throws IOException {
        FileWriter fw = null;
        try{
            fw = new FileWriter("bici.txt");
            for (Bicicletta bici : listaBici) {
                fw.write(bici.getMarca() + "," + bici.getModello() + "," + bici.getPrezzo() + "\n");
            }
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (fw != null) {
                fw.close();
            }
        }
    }
}
