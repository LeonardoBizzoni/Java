package Server;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);
            Socket client;
            List<InetAddress> socketList = new ArrayList<>();

            while (true) {
                client = serverSocket.accept();
                if(!socketList.contains(client.getInetAddress()))
                    new Thread(new Listener(client)).start();
                else
                    new Thread(new Listener2(client)).start();

                socketList.add(client.getInetAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendFile(Socket client){
        FileInputStream fileReader;
        Scanner clientInput;
        int data;

        try {
            clientInput = new Scanner(client.getInputStream());
            DataOutputStream sender = new DataOutputStream(client.getOutputStream());

            // riceve il nome del file da mandare
            fileReader = new FileInputStream("Files/" + clientInput.nextLine());

            // invia il file
            do {
                sender.write((data = fileReader.read()));
            } while (data != -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
