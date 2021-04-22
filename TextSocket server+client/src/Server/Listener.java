package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Listener implements Runnable {
    private Socket socket;
    public Listener(Socket socket){
        this.socket = socket;
    }

    public void run(){
        String mes;
        String socketAddress;

        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            System.out.printf("Connessione avviata con %s\n", (socketAddress=String.valueOf(socket.getRemoteSocketAddress())));

            // prende l'input stream dal socket
            Scanner data = new Scanner(socket.getInputStream());
            while(data.hasNextLine()){
                mes = data.nextLine();
                if(mes.equals("")){
                    break;
                }

                printWriter.println(mes);
                printWriter.flush();

                System.out.println(socketAddress + ": " + mes);
            }

            System.out.printf("Connessione con %s terminata\n--------------------------------", socketAddress);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
