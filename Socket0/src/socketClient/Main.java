package socketClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String messaggio;
            Socket socket = new Socket("127.0.0.1", 8001);
            Scanner input = new Scanner(System.in);

            // prende l'output del socket
            PrintWriter data = new PrintWriter(socket.getOutputStream());

            while(true){
                System.out.print("Messaggio da inviare al server: ");

                messaggio = input.nextLine();
                data.println(messaggio);

                if(messaggio.equals("x"))
                    break;

                data.flush(); // invia la string
            }

            data.close(); // chiude l'output stream
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}