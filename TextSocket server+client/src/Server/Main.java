package Server;

import java.io.PrintWriter;
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
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                System.out.printf("Connessione avviata con %s\n", socket.getRemoteSocketAddress());

                // prende l'input stream dal socket
                Scanner data = new Scanner(socket.getInputStream());
                while(true){
                    mes = data.nextLine();
                    if(mes.equals("")){
                        break;
                    }

                    printWriter.println(mes);
                    printWriter.flush();

                    System.out.println(mes);
                }

                printWriter.close();
                socket.close();
                System.out.println("Connessione terminata\n--------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
