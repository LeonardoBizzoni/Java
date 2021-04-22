package Thread3;

import java.util.Scanner;

public class InputListener implements Runnable{
    private Scanner input;

    public InputListener(){
        input = new Scanner(System.in);
    }

    public void run(){
        input.nextLine();
        System.exit(0);
    }
}
