package clock;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Clock clock = new Clock();
        Thread tClock = new Thread(clock);
        Scanner input = new Scanner(System.in);

        System.out.println("Premi invio per fermare e ripartire il tempo");
        input.nextLine();
        tClock.start();

        for(int i=0; true; i++){
            input.nextLine();

            if(i%2==0){
                tClock.interrupt();
                tClock = new Thread(clock);
            }
            else
                tClock.start();
        }
    }
}
