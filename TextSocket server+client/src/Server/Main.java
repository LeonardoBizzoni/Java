package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);

            while(true){
                System.out.println("In attesa di connesioni");
                Socket socket = serverSocket.accept();
                new Thread(new Listener(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
