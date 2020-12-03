package Biciclette;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaBiciclette {
    List<Bicicletta> listaBici = new ArrayList<>();

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

    void updateFile(Bicicletta bici) throws IOException {
        FileWriter fw = null;
        try{
            fw = new FileWriter("bici.txt",true);
            fw.write(bici.getMarca() + "," + bici.getModello() + "," + bici.getPrezzo() + "\n");
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
