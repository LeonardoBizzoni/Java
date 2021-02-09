package appartamentoVacanza;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgImmobiliare {
    private List<AppartamentoVacanza> list;
    private File f;

    public AgImmobiliare(){
         this.list = new ArrayList<>();
        f = new File("ciao");
    }

    public void aggiungiAp(int nStanze, double distanzaMare, double prezzoMq, double superficieMq, String tipo){
        list.add(new AppartamentoVacanza(nStanze, distanzaMare, prezzoMq, superficieMq, tipo));
    }

    public void stampa(){
        for(AppartamentoVacanza ap : list){
            System.out.print(ap.toString()+"\n");
        }
    }

    public void cercaStampa(){
        for(AppartamentoVacanza ap : list){
            if(ap.getDistanzaMare() < 8){
                System.out.print(ap.toString());
            }
        }
        System.out.println();
    }

    public void salva(){
        try {
            if(!f.exists()){
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f);

            for(AppartamentoVacanza ap : list){
                fw.append(ap.getnStanze()+"_"+ ap.getDistanzaMare()+"_"+ap.getPrezzoMq()+"_"+ ap.getSuperficieMq()+"_"+ ap.getTipo()+"\n");
            }

            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carica(){
        String[] valori;
        try {
            Scanner fr = new Scanner(this.f);

            while(fr.hasNextLine()){
                valori = fr.nextLine().split("_");
                aggiungiAp(Integer.parseInt(valori[0]), Double.parseDouble(valori[1]), Double.parseDouble(valori[2]), Double.parseDouble(valori[3]), valori[4]);
            }

            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
