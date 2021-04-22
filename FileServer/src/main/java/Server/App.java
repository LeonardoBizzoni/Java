package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class App
{
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8001);

            while(true){
                new Thread(new Listener(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
