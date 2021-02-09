package appartamentoVacanza;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AgImmobiliare ag = new AgImmobiliare();
        Scanner inputStr = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        boolean a = true;

        while(a){
            System.out.print("""
                    1) aggiungi
                    2) stampa
                    3) cerca
                    4) salva
                    5) carica
                    0) esci
                    > 
                    """);

            switch(inputNum.nextInt()){
                case 1:
                    System.out.println("Inserisci quante stanze, prezzo, distanza mare, superficieMq, tipo");
                    ag.aggiungiAp(inputNum.nextInt(), inputNum.nextDouble(), inputNum.nextDouble(), inputNum.nextDouble(), inputStr.nextLine());
                    break;
                case 2:
                    ag.stampa();
                    break;
                case 3:
                    ag.cercaStampa();
                    break;
                case 4:
                    ag.salva();
                    break;
                case 5:
                    ag.carica();
                    break;
                case 0:
                    a = false;
                    break;
            }
        }
    }
}
