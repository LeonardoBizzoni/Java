package Biciclette;

import java.util.ArrayList;
import java.util.List;

public class ListaBiciclette {
    List<Bicicletta> listaBici = new ArrayList<Bicicletta>();

    void aggiungiBicicletta(Bicicletta bici){
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
}
