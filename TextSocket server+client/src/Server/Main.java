package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);
            String mes;

            while(true){
                System.out.println("In attesa di connesioni");
                Socket socket = serverSocket.accept();
                System.out.printf("Connessione avviata con %s\n", socket.getRemoteSocketAddress());

                // prende l'input stream dal socket
                Scanner data = new Scanner(socket.getInputStream());
                while(true){
                    mes = data.nextLine();
                    if(mes.equals("x"))
                        break;

                    System.out.println(mes);
                }

                socket.close();
                System.out.println("Connessione terminata\n--------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}