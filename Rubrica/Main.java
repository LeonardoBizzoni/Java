import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Rubrica rub = new Rubrica();

        String in;
        while(true){
            do{
                System.out.println("1) Aggiungi con\n2) Rimouvi con\n3) Cerca con\n4) Stampa rubrica");
                in = input.nextInt();
            }while(in < 1 || in > 4);

            if(in == 1){
                System.out.print("Inserisci nome, cognome e numero di telefono ");
                rub.aggiungiContatto(input.next(), input.next(), input.next());
            }
            else if(in == 2){
                System.out.print("Inserisci nome, cognome");
                rub.rimuoviContatto(input.next(), input.next());
            }
            else if(in == 3){
                System.out.print("Inserisci nome, cognome");
                rub.cerca(input.next(), input.next());
            }
            else if(in == 3){
                System.out.println(rub.toString());
            }
        }
    }
}
