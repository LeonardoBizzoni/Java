package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<InetAddress> socketList = new ArrayList<>();

    public static void main(String[] args) {
        Socket client;

        try {
            ServerSocket serverSocket = new ServerSocket(8001);

            while (true) {
                client = serverSocket.accept();

                // se l'indirizzo del client non è nella lista invia la lista di file e chiedi il nome del file da inviare
                // aggiunge l'indirizzo del client alla lista di indirizzi noti
                // se l'indirizzo del client è già nella lista allora chiedi il nome del file da inviare
                if (!socketList.contains(client.getInetAddress())) {
                    socketList.add(client.getInetAddress());
                    new Thread(new Listener(client)).start();
                } else
                    new Thread(new Listener2(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendFile(Socket client) throws IOException {
        int data;
        Scanner clientInput = new Scanner(client.getInputStream());
        DataOutputStream sender = new DataOutputStream(client.getOutputStream());
        FileInputStream fileReader;

        try {
            // riceve il nome del file da mandare
            while(!clientInput.hasNextLine())
                Thread.sleep(1000);
            fileReader = new FileInputStream("Files/" + clientInput.nextLine());

            // invia il file
            do {
                sender.write(data = fileReader.read());
            } while (data != -1);

        } catch (FileNotFoundException e) {
            // se il nome del file non è nella lista rimuovi l'indirizzo del client dalla lista
            // il client ha chiuso la GUI
            socketList.remove(client.getInetAddress());
            System.out.println("indirizzo rimosso");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        client.close();
    }
}

